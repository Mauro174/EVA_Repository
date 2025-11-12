package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.FamiliarDTOInsert;
import pe.edu.upc.demoeva.dtos.FamiliarDTOList;
import pe.edu.upc.demoeva.entities.Familiar;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IFamiliarService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/familiares")

public class FamiliarController {
    @Autowired
    private IFamiliarService service;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping
    public List<FamiliarDTOList> listar(){
        return service.listar().stream().map(ent -> {
            ModelMapper m = new ModelMapper();
            FamiliarDTOList dto = m.map(ent, FamiliarDTOList.class);
            if (ent.getUsuario() != null) dto.setUsuarioId(ent.getUsuario().getIdUsuario());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody FamiliarDTOInsert dto){
        ModelMapper m = new ModelMapper();
        Familiar ent = m.map(dto, Familiar.class);

        service.guardar(ent);
    }
}
