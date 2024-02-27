package servicios.uno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicios.uno.model.Genero;
import servicios.uno.repository.GeneroRepository;
import servicios.uno.utils.Response;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class GeneroService {
    @Autowired
    private GeneroRepository repository;
    @Transactional(readOnly = true)
    public Response<List<Genero>> getAll() throws SQLException {
        return new Response<>(this.repository.findAll(), false, 200, "Correcto");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Genero> save(Genero genero) throws SQLException {
        return new Response<>(this.repository.save(genero), false, 200, "Correcto");
    }

    @Transactional(readOnly = true)
    public Response<Genero> getById(Long id) throws SQLException {
        return new Response<>(this.repository.findById(id).orElse(null), false, 200, "Correcto");
    }

}
