package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demoeva.entities.Conversacion;

public interface ConversacionRepository extends JpaRepository<Conversacion, Long> { }
