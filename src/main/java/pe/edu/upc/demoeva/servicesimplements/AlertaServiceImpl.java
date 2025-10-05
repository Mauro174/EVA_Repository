package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.Alerta;
import pe.edu.upc.demoeva.repositories.AlertaRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IAlertaService;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlertaServiceImpl implements IAlertaService {

    @Autowired
    private AlertaRepository repo;

    @Override
    public List<Alerta> listar() {
        return repo.findAll();
    }

    @Override
    public Alerta guardar(Alerta alerta) {
        return repo.save(alerta);
    }

    @Override
    public Alerta obtenerPorId(Long id) {
        Optional<Alerta> optional = repo.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Alerta> buscarPorTipo(Long tipoId) {
        return repo.findByTipo(tipoId);
    }

    @Override
    public List<Alerta> buscarPorUsuario(Long usuarioId) {
        return repo.findByUsuario(usuarioId);
    }

    @Override
    public List<Object[]> contarAlertasPorTipo() {
        return repo.countAlertasPorTipo();
    }

    @Override
    public List<Alerta> buscarEmergenciasRecientes(OffsetDateTime desde) {
        return repo.findAlertasEmergenciaRecientes(desde);
    }
}
