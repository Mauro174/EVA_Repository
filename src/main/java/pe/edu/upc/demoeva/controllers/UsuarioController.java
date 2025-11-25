package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.CantidadMedicamentosDTO;
import pe.edu.upc.demoeva.dtos.CantidadRelacionesDTO;
import pe.edu.upc.demoeva.dtos.UsuarioDTO;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.servicesinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UsuarioDTO>listar(){
        return service.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

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

    //se consulta buscarEmail?emailUsuario=ejemplo@upc.edu.pe
    @GetMapping("/buscarEmail")
    public ResponseEntity<?> buscarEmail(@RequestParam String emailUsuario) {
        List<Usuario> usuarios = service.buscarUsuario(emailUsuario);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios con correo: " + emailUsuario);
        }

        List<UsuarioDTO> listaDTO = usuarios.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/cantidadRelaciones")
    public ResponseEntity<?> obtenerCantidadRelaciones() {
        List<CantidadRelacionesDTO> listaDTO=new ArrayList<>();
        List<String[]> fila = service.cantidadDeRelaciones();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros" );
        }

        for(String[] columna:fila){
            CantidadRelacionesDTO dto=new CantidadRelacionesDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setTipoRelacion(columna[1]);
            dto.setCantidad(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }
    //@PreAuthorize("hasAnyAuthority('ADMIN','PACIENTE')")
    @GetMapping("/cantidadMedicamentos")
    public ResponseEntity<?> obtenerCantidadMedicamentos() {
        List<CantidadMedicamentosDTO> listaDTO=new ArrayList<>();
        List<String[]> fila = service.cantidadDeMedicamentos();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros" );
        }

        for(String[] columna:fila){
            CantidadMedicamentosDTO dto=new CantidadMedicamentosDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setMedicamentosActivos(Integer.parseInt(columna[1]));
            dto.setMedicamentosInactivos(Integer.parseInt(columna[2]));
            dto.setCantidadMedicamentos(Integer.parseInt(columna[3]));
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }


}
