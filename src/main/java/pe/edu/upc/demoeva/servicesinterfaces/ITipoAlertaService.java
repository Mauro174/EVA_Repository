package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.TipoAlerta;
import java.util.List;

public interface ITipoAlertaService {
    List<TipoAlerta> listar();
    TipoAlerta obtenerPorId(Long id);
    TipoAlerta guardar(TipoAlerta tipoAlerta);
    TipoAlerta actualizar(Long id, TipoAlerta tipoAlerta);
    void eliminar(Long id);

    List<TipoAlerta> buscarPorNombre(String nombre);
    List<TipoAlerta> buscarPorNivel(String nivel);
    List<Object[]> contarAlertasPorTipo();
    List<Object[]> tiposMasFrecuentes();
}