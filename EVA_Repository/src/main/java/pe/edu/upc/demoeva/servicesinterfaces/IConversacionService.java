package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.Conversacion;
import java.util.List;

public interface IConversacionService {
    Conversacion guardar(Conversacion c);
    List<Conversacion> listar();
}
