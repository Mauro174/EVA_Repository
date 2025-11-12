package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.Familiar;
import java.util.List;

public interface IFamiliarService {
    Familiar guardar(Familiar f);
    List<Familiar> listar();
}
