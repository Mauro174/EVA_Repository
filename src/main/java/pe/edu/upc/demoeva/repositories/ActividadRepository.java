package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeva.entities.Actividad;
import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    @Query("SELECT a FROM Actividad a WHERE a.tipo = :tipo")
    List<Actividad> findByTipo(@Param("tipo") String tipo);
    //simple

    @Query("SELECT a FROM Actividad a WHERE a.usuario.idUsuario = :usuarioId")
    List<Actividad> findByUsuario(@Param("usuarioId") Long usuarioId);
    //HU-24 simple

    @Query("SELECT a.tipo, COUNT(a) FROM Actividad a GROUP BY a.tipo")
    List<Object[]> countActividadesPorTipo();
    //complejo

    @Query("SELECT a FROM Actividad a WHERE a.ocurrioEn BETWEEN :inicio AND :fin")
    List<Actividad> findByRangoFechas(@Param("inicio") OffsetDateTime inicio, @Param("fin") OffsetDateTime fin);
    //HU-22 complejo
}


