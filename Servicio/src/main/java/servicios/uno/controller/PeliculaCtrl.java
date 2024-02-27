package servicios.uno.controller;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import servicios.uno.model.Pelicula;
import servicios.uno.service.PeliculasService;
import servicios.uno.utils.Response;


@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "http://localhost:5173")  // Especifica el origen permitido
public class PeliculaCtrl {

    @Autowired
    PeliculasService service;

    @GetMapping
    public Response<List<Pelicula>> getAllPeliculas() throws SQLException {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Response<Pelicula> getById(@PathVariable Long id) throws SQLException {
        return service.getById(id);
    }

    @PostMapping("/query")
    public Response<List<Pelicula>> queryMethod(@RequestBody QueryDto queryDto) throws SQLException {
        return service.queryMethod(queryDto.getDirector(), queryDto.getFechaInicio(), queryDto.getFechaFin(), queryDto.getGenero());
    }


    @PostMapping
    public Response<Pelicula> save(@RequestBody Pelicula pelicula) throws SQLException, JsonProcessingException {
        return service.save(pelicula);
    }

    @PutMapping
    public Response<Pelicula> update(@RequestBody Pelicula pelicula) throws SQLException {
        return service.update(pelicula);
    }

    @DeleteMapping("/{id}")
    public Response<Pelicula> delete(@PathVariable Long id) throws SQLException {
        return service.delete(id);
    }
}

