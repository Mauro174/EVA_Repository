package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demoeva.entities.Familiar;

public interface FamiliarRepository extends JpaRepository<Familiar, Long> { }