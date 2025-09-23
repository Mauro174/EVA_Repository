package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demoeva.entities.TipoAlerta;

public interface TipoAlertaRepository extends JpaRepository<TipoAlerta, Long> { }