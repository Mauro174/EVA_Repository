package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeva.entities.Alerta;
import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    @Query("SELECT a FROM Alerta a WHERE a.tipo.id = :tipoId")
    List<Alerta> findByTipo(@Param("tipoId") Long tipoId);
    //HU-08

    @Query("SELECT a FROM Alerta a WHERE a.usuario.idUsuario = :usuarioId")
    List<Alerta> findByUsuario(@Param("usuarioId") Long usuarioId);
    //HU-11

    @Query("SELECT a.tipo.nombre, COUNT(a) FROM Alerta a GROUP BY a.tipo.nombre")
    List<Object[]> countAlertasPorTipo();
    //complejo

    @Query("SELECT a FROM Alerta a WHERE a.nivel = 'Emergencia' AND a.creada >= :desde")
    List<Alerta> findAlertasEmergenciaRecientes(@Param("desde") OffsetDateTime desde);
    //HU-26
}
