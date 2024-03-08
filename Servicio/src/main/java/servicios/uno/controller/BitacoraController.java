package servicios.uno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import servicios.uno.model.Bitacora;
import servicios.uno.service.BitacoraService;
import servicios.uno.utils.Response;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/bitacora")
@CrossOrigin(origins = "http://localhost:5173")  // Especifica el origen permitido
public class BitacoraController {

    @Autowired
    BitacoraService service;

    @GetMapping("/{id}")
    public Response<Bitacora> getById(@PathVariable String id) throws SQLException {
        return service.getById(id);
    }

    @PostMapping
    public Response<Bitacora> save(@RequestBody Bitacora bitacora) throws SQLException {
        return service.save(bitacora);
    }

    @GetMapping("/")
    public Response<List<Bitacora>> getAll() throws SQLException {
        return service.getAll();
    }
}