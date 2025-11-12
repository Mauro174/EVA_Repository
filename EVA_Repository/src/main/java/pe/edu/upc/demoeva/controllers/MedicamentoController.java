package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.MedicamentoDTOInsert;
import pe.edu.upc.demoeva.dtos.MedicamentoDTOList;
import pe.edu.upc.demoeva.entities.Medicamento;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IMedicamentoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private IMedicamentoService service;

    @Autowired
    private UsuarioRepository usuarioRepo; // para resolver FK

    @GetMapping
    public List<MedicamentoDTOList> listar(){
        return service.listar().stream().map(ent -> {
            ModelMapper m = new ModelMapper();
            MedicamentoDTOList dto = m.map(ent, MedicamentoDTOList.class);
            //if (ent.getUsuario() != null) dto.setUsuarioId(ent.getUsuario().getIdUsuario());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody MedicamentoDTOInsert dto){
        ModelMapper m = new ModelMapper();
        Medicamento ent = m.map(dto, Medicamento.class);

       // if (dto.getUsuarioId() == null) throw new RuntimeException("usuarioId es requerido");
        //Usuario u = usuarioRepo.findById(dto.getUsuarioId())
        //        .orElseThrow(() -> new RuntimeException("Usuario no existe"));
        //ent.setUsuario(u);

        service.guardar(ent);
    }
}
