package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.FamiliarAdulto;
import pe.edu.upc.demoeva.repositories.FamiliarAdultoRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IFamiliarAdultoService;

import java.util.List;

@Service
public class FamiliarAdultoServiceImpl implements IFamiliarAdultoService{
    private final FamiliarAdultoRepository repo;
    public FamiliarAdultoServiceImpl(FamiliarAdultoRepository repo) { this.repo = repo; }
    public FamiliarAdulto guardar(FamiliarAdulto fa) { return repo.save(fa); }
    public List<FamiliarAdulto> listar() { return repo.findAll(); }
}
