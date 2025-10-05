package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoeva.entities.TipoAlerta;
import java.util.List;

public interface TipoAlertaRepository extends JpaRepository<TipoAlerta, Long> {

    @Query("SELECT t FROM TipoAlerta t WHERE LOWER(t.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<TipoAlerta> findByNombre(@Param("nombre") String nombre);

    @Query("SELECT t FROM TipoAlerta t WHERE t.nivel = :nivel")
    List<TipoAlerta> findByNivel(@Param("nivel") String nivel);

    @Query("SELECT t.nombre, COUNT(a) FROM TipoAlerta t LEFT JOIN Alerta a ON a.tipo.id = t.id GROUP BY t.nombre")
    List<Object[]> countAlertasPorTipo();

    @Query("SELECT t.nombre, COUNT(a) AS total FROM TipoAlerta t LEFT JOIN Alerta a ON a.tipo.id = t.id GROUP BY t.nombre ORDER BY total DESC")
    List<Object[]> tiposMasFrecuentes();

}
