package servicios.uno.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicios.uno.model.Bitacora;
import servicios.uno.model.Genero;
import servicios.uno.model.Pelicula;
import servicios.uno.repository.BitacoraRepository;
import servicios.uno.repository.PeliculasRepository;
import servicios.uno.utils.Response;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class PeliculasService {
    @Autowired
    private PeliculasRepository repository;
    @Autowired
    private BitacoraRepository bitacoraRepository;

    @Autowired
    private ObjectMapper ObjectMapper;
    @Transactional(readOnly = true)
    public Response<List<Pelicula>> getAll() throws SQLException {
        return new Response<>(this.repository.findAllByOrderByCreadaEnDesc(), false, 200, "Correcto");
    }

    @Transactional(readOnly = true)
    public Response<Pelicula> getById(Long id) throws SQLException {
        return new Response<>(this.repository.findById(id).orElse(null), false, 200, "Correcto");
    }

    @Transactional(readOnly = true)
    public Response<List<Pelicula>> queryMethod(String director, String fechaInicio, String fechaFin, Genero genero) throws SQLException {
        if (genero != null && director != null && fechaInicio != null && fechaFin != null) {
            return new Response<>(this.repository.findByDirectorContainsAndCreadaEnBetweenAndGeneroOrderByCreadaEnDesc(director, fechaInicio, fechaFin, genero), false, 200, "Correcto");
        } else if (genero != null && director != null) {
            return new Response<>(this.repository.findByDirectorContainsAndGeneroOrderByCreadaEnDesc(director, genero), false, 200, "Correcto");
        } else if (genero != null && fechaInicio != null && fechaFin != null) {
            return new Response<>(this.repository.findByCreadaEnBetweenAndGeneroOrderByCreadaEnDesc(fechaInicio, fechaFin, genero), false, 200, "Correcto");
        } else if (director != null && fechaInicio != null && fechaFin != null) {
            return new Response<>(this.repository.findByDirectorContainsAndCreadaEnBetweenOrderByCreadaEnDesc(director, fechaInicio, fechaFin), false, 200, "Correcto");
        } else if (genero != null) {
            return new Response<>(this.repository.findByGeneroOrderByCreadaEnDesc(genero), false, 200, "Correcto");
        } else if (director != null) {
            return new Response<>(this.repository.findByDirectorContainsOrderByCreadaEnDesc(director), false, 200, "Correcto");
        } else if (fechaInicio != null && fechaFin != null) {
            return new Response<>(this.repository.findByCreadaEnBetweenOrderByCreadaEnDesc(fechaInicio, fechaFin), false, 200, "Correcto");
        } else {
            return new Response<>(this.repository.findAll(), false, 200, "Correcto");
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pelicula> save(Pelicula pelicula) throws SQLException, JsonProcessingException {
        pelicula.setCreadaEn(new java.sql.Date(new java.util.Date().getTime()).toString());


        return new Response<>(this.repository.save(pelicula), false, 200, "Correcto");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pelicula> update(Pelicula pelicula) throws SQLException {
        return new Response<>(this.repository.save(pelicula), false, 200, "Correcto");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pelicula> delete(Long id) throws SQLException {
        this.repository.deleteById(id);
        return new Response<>(null, false, 200, "Correcto");
    }


    
}
