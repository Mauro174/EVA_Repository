package pe.edu.upc.demoeva.servicesinterfaces;
import pe.edu.upc.demoeva.entities.Fotos;

import java.util.List;

public interface FotoService {
    public void insertar(Fotos f);
    public List<Fotos> listar();
    public void update(Fotos f);
    public void delete(Long id);
}
