package servicios.uno.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import servicios.uno.model.Bitacora;
import servicios.uno.repository.BitacoraRepository;
import servicios.uno.service.BitacoraService;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@Component
public class BitacoraFilter extends OncePerRequestFilter {

    @Autowired
    private BitacoraRepository bitacoraRepository;
    @Autowired
    private ObjectMapper ObjectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest(request);
        MultiReadHttpServletResponse multiReadResponse = new MultiReadHttpServletResponse(response);
        filterChain.doFilter(multiReadRequest, multiReadResponse);
        String body = multiReadRequest.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        String responseBody = new String(multiReadResponse.getContentAsByteArray(), response.getCharacterEncoding());
        ObjectNode jsonNode = ObjectMapper.createObjectNode();
        Bitacora bitacora = new Bitacora();
        String token = request.getHeader("Authorization");
        if (token != null) {
            token = token.replace("Bearer ", "");
        }
        bitacora.setMethod(request.getMethod());
        bitacora.setRequestUri(request.getRequestURI());
        bitacora.setIp(request.getRemoteAddr());
        bitacora.setUserAgent(request.getHeader("User-Agent"));
        bitacora.setStatus(response.getStatus());
        jsonNode.put("token", token);
        try {
            jsonNode.set("body", ObjectMapper.readTree(body));
        } catch (JsonProcessingException e) {
            jsonNode.put("body", "Invalid JSON");
        }
        // colocamos lo que le dio de response
        try {
            jsonNode.set("response", ObjectMapper.readTree(responseBody));
        } catch (JsonProcessingException e) {
            jsonNode.put("response", "Invalid JSON");
        }
        JsonNode node = ObjectMapper.valueToTree(jsonNode);
        bitacora.setData(node);
        bitacora.setCreatedAt(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis())));
        multiReadResponse.copyBodyToResponse();
        try {
            if (request.getMethod().equals(HttpMethod.PUT.name()) || request.getMethod().equals(HttpMethod.POST.name()) || request.getMethod().equals(HttpMethod.DELETE.name())) {
                bitacoraRepository.save(bitacora);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
