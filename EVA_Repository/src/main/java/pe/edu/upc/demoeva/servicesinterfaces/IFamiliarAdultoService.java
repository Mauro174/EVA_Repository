package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.FamiliarAdulto;
import java.util.List;

public interface IFamiliarAdultoService {
    FamiliarAdulto guardar(FamiliarAdulto fa);
    List<FamiliarAdulto> listar();
}
