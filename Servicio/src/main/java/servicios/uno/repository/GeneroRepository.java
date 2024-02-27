package servicios.uno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servicios.uno.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero,Long> {
}
