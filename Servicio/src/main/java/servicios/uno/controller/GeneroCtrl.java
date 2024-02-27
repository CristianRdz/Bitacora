package servicios.uno.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import servicios.uno.model.Genero;
import servicios.uno.service.GeneroService;
import servicios.uno.utils.Response;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin(origins = "http://localhost:5173")  // Especifica el origen permitido
public class GeneroCtrl {

    @Autowired
    GeneroService service;

    @GetMapping (value = "/", produces = "application/json")
    public Response<List<Genero>> getAllGenero() throws SQLException {
        return service.getAll();
    }
}
