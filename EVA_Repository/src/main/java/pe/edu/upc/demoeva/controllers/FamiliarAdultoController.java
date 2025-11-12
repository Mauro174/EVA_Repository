package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.FamiliarAdultoDTOInsert;
import pe.edu.upc.demoeva.dtos.FamiliarAdultoDTOList;
import pe.edu.upc.demoeva.dtos.FamiliarDTOInsert;
import pe.edu.upc.demoeva.dtos.FamiliarDTOList;
import pe.edu.upc.demoeva.entities.Familiar;
import pe.edu.upc.demoeva.entities.FamiliarAdulto;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IFamiliarAdultoService;
import pe.edu.upc.demoeva.servicesinterfaces.IFamiliarService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/familiaradultos")

public class FamiliarAdultoController {
    @Autowired
    private IFamiliarAdultoService service;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping
    public List<FamiliarAdultoDTOList> listar(){
        return service.listar().stream().map(ent -> {
            ModelMapper m = new ModelMapper();
            FamiliarAdultoDTOList dto = m.map(ent, FamiliarAdultoDTOList.class);
            if (ent.getId() != null) dto.setId(ent.getId().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody FamiliarAdultoDTOInsert dto){
        ModelMapper m = new ModelMapper();
        FamiliarAdulto ent = m.map(dto, FamiliarAdulto.class);

        service.guardar(ent);
    }
}
