package servicios.uno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servicios.uno.model.Genero;
import servicios.uno.model.Pelicula;

import java.util.List;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula,Long> {



    List<Pelicula> findByDirectorContainsAndCreadaEnBetweenAndGeneroOrderByCreadaEnDesc(String director, String fechaInicio, String fechaFin, Genero genero);
    List<Pelicula> findByDirectorContainsOrderByCreadaEnDesc(String director);
    List<Pelicula> findByCreadaEnBetweenOrderByCreadaEnDesc(String fechaInicio, String fechaFin);

    List<Pelicula> findByDirectorContainsAndGeneroOrderByCreadaEnDesc(String director, Genero genero);

    List<Pelicula> findByDirectorContainsAndCreadaEnBetweenOrderByCreadaEnDesc(String director, String fechaInicio, String fechaFin);

    List<Pelicula> findByCreadaEnBetweenAndGeneroOrderByCreadaEnDesc(String fechaInicio, String fechaFin, Genero genero);

    List<Pelicula> findByGeneroOrderByCreadaEnDesc(Genero genero);


    List<Pelicula> findAllByOrderByCreadaEnDesc();


}
