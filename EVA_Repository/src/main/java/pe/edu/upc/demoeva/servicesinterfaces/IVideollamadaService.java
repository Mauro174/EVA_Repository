package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.Videollamada;
import java.util.List;

public interface IVideollamadaService {
    Videollamada insertar(Videollamada v);
    List<Videollamada> listar();
    public Videollamada ListId(int id);
    public void delete(int id);
    public void update(Videollamada videollamada);
}
