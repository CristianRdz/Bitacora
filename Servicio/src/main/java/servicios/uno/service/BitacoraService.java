package servicios.uno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicios.uno.model.Bitacora;
import servicios.uno.repository.BitacoraRepository;
import servicios.uno.utils.Response;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class BitacoraService {
    @Autowired
    private BitacoraRepository repository;

    @Transactional(readOnly = true)
    public Response<Bitacora> getById(String id) throws SQLException {
        return new Response<>(this.repository.findById(id).orElse(null), false, 200, "Correcto");
    }
    @Transactional(readOnly = true)
    public Response<List<Bitacora>> getAll() throws SQLException {
        return new Response<>(this.repository.findAll(), false, 200, "Correcto");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Bitacora> save(Bitacora bitacora) throws SQLException {
        return new Response<>(this.repository.save(bitacora), false, 200, "Correcto");
    }

}