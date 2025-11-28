package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.TipoAlertaDTOInsert;
import pe.edu.upc.demoeva.dtos.TipoAlertaDTOList;
import pe.edu.upc.demoeva.entities.TipoAlerta;
import pe.edu.upc.demoeva.servicesinterfaces.ITipoAlertaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo-alertas")
public class TipoAlertaController {

    @Autowired
    private ITipoAlertaService service;

    @GetMapping
    public List<TipoAlerta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public TipoAlerta obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public TipoAlerta registrar(@RequestBody TipoAlerta tipoAlerta) {
        return service.guardar(tipoAlerta);
    }

    @PutMapping("/{id}")
    public TipoAlerta actualizar(@PathVariable Long id, @RequestBody TipoAlerta tipoAlerta) {
        return service.actualizar(id, tipoAlerta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public List<TipoAlerta> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar/nivel/{nivel}")
    public List<TipoAlerta> buscarPorNivel(@PathVariable String nivel) {
        return service.buscarPorNivel(nivel);
    }

    @GetMapping("/estadisticas/por-tipo")
    public List<Object[]> contarAlertasPorTipo() {
        return service.contarAlertasPorTipo();
    }

    @GetMapping("/estadisticas/mas-frecuentes")
    public List<Object[]> tiposMasFrecuentes() {
        return service.tiposMasFrecuentes();
    }
}
