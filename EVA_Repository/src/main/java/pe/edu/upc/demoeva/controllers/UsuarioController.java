package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.UsuarioDTO;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.servicesinterfaces.IUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;
    //public UsuarioController(IUsuarioService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario insertar(@RequestBody Usuario u) { return service.insertar(u); }

    @GetMapping
    public List<Usuario> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario soft = service.ListId(id);
        if (soft == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(soft, UsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario s = service.ListId(id);
        if (s == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario s = m.map(dto, Usuario.class);

        // Validación de fecha
        //if (s.getPurchaseDate().isAfter(LocalDate.now())) {
        //    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        //            .body("La fecha de registro no puede ser futura. Valor recibido: " + s.getPurchaseDate());
        //}

        // Validación de existencia
        Usuario existente = service.ListId(s.getIdUsuario());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + s.getIdUsuario());
        }

        // Actualización si pasa validaciones
        service.update(s);
        return ResponseEntity.ok("Registro con ID " + s.getIdUsuario() + " modificado correctamente.");
    }
}
