package servicios.uno.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import servicios.uno.model.Genero;
import servicios.uno.model.Pelicula;
import servicios.uno.repository.GeneroRepository;


import org.springframework.beans.factory.annotation.Autowired;
import servicios.uno.repository.PeliculasRepository;

@Configuration
public class AppConfig {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PeliculasRepository peliculasRepository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PostConstruct
    public void init() {
        //INSERT INTO peliculas.generos (nombre) VALUES ('Terror'); INSERT INTO peliculas.generos (nombre) VALUES ('Suspenso'); INSERT INTO peliculas.generos (nombre) VALUES ('Ficción'); INSERT INTO peliculas.generos (nombre) VALUES ('Documental'); INSERT INTO peliculas.generos (nombre) VALUES ('Drama'); INSERT INTO peliculas.generos (nombre) VALUES ('Comedia'); INSERT INTO peliculas.generos (nombre) VALUES ('Romance');
        if (generoRepository.count() == 0) {
            generoRepository.save(new Genero(null,"Terror"));
            generoRepository.save(new Genero(null,"Suspenso"));
            generoRepository.save(new Genero(null,"Ficción"));
            generoRepository.save(new Genero(null,"Documental"));
            generoRepository.save(new Genero(null,"Drama"));
            generoRepository.save(new Genero(null,"Comedia"));
            generoRepository.save(new Genero(null,"Romance"));
        }
    }
}