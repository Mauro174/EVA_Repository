package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.Medicamento;
import java.util.List;

public interface IMedicamentoService {
    Medicamento guardar(Medicamento m);
    List<Medicamento> listar();
}
