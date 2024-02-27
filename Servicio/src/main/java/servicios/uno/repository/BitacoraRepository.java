package servicios.uno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servicios.uno.model.Bitacora;

public interface BitacoraRepository extends JpaRepository<Bitacora, String> {
}