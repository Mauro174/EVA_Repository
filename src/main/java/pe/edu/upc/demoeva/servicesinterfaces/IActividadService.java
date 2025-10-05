package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.dtos.ActividadDTOInsert;
import pe.edu.upc.demoeva.dtos.ActividadDTOList;

import java.time.OffsetDateTime;
import java.util.List;

public interface IActividadService {
    List<ActividadDTOList> listar();
    ActividadDTOList obtenerPorId(Long id);
    ActividadDTOList registrar(ActividadDTOInsert dto);
    ActividadDTOList actualizar(Long id, ActividadDTOInsert dto);
    void eliminar(Long id);

    List<ActividadDTOList> buscarPorTipo(String tipo);
    List<ActividadDTOList> buscarPorUsuario(Long usuarioId);
    List<Object[]> contarActividadesPorTipo();
    List<ActividadDTOList> buscarPorRangoFechas(OffsetDateTime inicio, OffsetDateTime fin);
}
