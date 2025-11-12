package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.Familiar;
import pe.edu.upc.demoeva.repositories.FamiliarRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IFamiliarService;

import java.util.List;

@Service
public class FamiliarServiceImpl implements IFamiliarService {
    private final FamiliarRepository repo;
    public FamiliarServiceImpl(FamiliarRepository repo) { this.repo = repo; }
    public Familiar guardar(Familiar f) { return repo.save(f); }
    public List<Familiar> listar() { return repo.findAll(); }
}
