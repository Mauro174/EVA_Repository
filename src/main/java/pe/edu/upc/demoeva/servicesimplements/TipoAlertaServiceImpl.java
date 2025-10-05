package pe.edu.upc.demoeva.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeva.entities.TipoAlerta;
import pe.edu.upc.demoeva.repositories.TipoAlertaRepository;
import pe.edu.upc.demoeva.servicesinterfaces.ITipoAlertaService;

import java.util.List;

@Service
public class TipoAlertaServiceImpl implements ITipoAlertaService {

    @Autowired
    private TipoAlertaRepository tipoAlertaRepository;

    @Override
    public List<TipoAlerta> listar() {
        return tipoAlertaRepository.findAll();
    }

    @Override
    public TipoAlerta obtenerPorId(Long id) {
        return tipoAlertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de alerta no encontrado"));
    }

    @Override
    public TipoAlerta guardar(TipoAlerta tipoAlerta) {
        return tipoAlertaRepository.save(tipoAlerta);
    }

    @Override
    public TipoAlerta actualizar(Long id, TipoAlerta tipoAlerta) {
        TipoAlerta existente = tipoAlertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de alerta no encontrado"));

        existente.setCodigo(tipoAlerta.getCodigo());
        existente.setNombr(tipoAlerta.getNombr());
        existente.setDescri(tipoAlerta.getDescri());

        return tipoAlertaRepository.save(existente);
    }


    @Override
    public void eliminar(Long id) {
        tipoAlertaRepository.deleteById(id);
    }

    @Override
    public List<TipoAlerta> buscarPorNombre(String nombre) {
        return tipoAlertaRepository.findByNombre(nombre);
    }

    @Override
    public List<TipoAlerta> buscarPorNivel(String nivel) {
        return tipoAlertaRepository.findByNivel(nivel);
    }

    @Override
    public List<Object[]> contarAlertasPorTipo() {
        return tipoAlertaRepository.countAlertasPorTipo();
    }

    @Override
    public List<Object[]> tiposMasFrecuentes() {
        return tipoAlertaRepository.tiposMasFrecuentes();
    }
}
