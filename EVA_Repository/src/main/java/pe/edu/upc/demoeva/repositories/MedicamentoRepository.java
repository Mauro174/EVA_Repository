package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demoeva.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> { }
