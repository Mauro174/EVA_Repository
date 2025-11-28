package pe.edu.upc.demoeva.servicesinterfaces;
import java.time.OffsetDateTime;
import pe.edu.upc.demoeva.entities.Alerta;
import java.util.List;

public interface IAlertaService {
    List<Alerta> listar();
    Alerta guardar(Alerta alerta);
    Alerta obtenerPorId(Long id);
    void eliminar(Long id);

    List<Alerta> buscarPorTipo(Long tipoId);             // HU-08
    List<Alerta> buscarPorUsuario(Long usuarioId);       // HU-11
    List<Object[]> contarAlertasPorTipo();               // Query complejo auxiliar
    List<Alerta> buscarEmergenciasRecientes(OffsetDateTime desde); // HU-26
}