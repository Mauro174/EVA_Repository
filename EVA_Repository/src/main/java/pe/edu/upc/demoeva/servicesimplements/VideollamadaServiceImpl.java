package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.Videollamada;
import pe.edu.upc.demoeva.repositories.VideollamadaRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IVideollamadaService;

import java.util.List;

@Service
public class VideollamadaServiceImpl implements IVideollamadaService {
    private final VideollamadaRepository repo;
    public VideollamadaServiceImpl(VideollamadaRepository repo) { this.repo = repo; }

    @Override public Videollamada insertar(Videollamada v) { return repo.save(v); }
    @Override public List<Videollamada> listar() { return repo.findAll(); }

    @Override
    public Videollamada ListId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Videollamada videollamada) {
        repo.save(videollamada);
    }
}
