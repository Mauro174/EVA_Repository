package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.VideollamadaDTO;
import pe.edu.upc.demoeva.entities.Videollamada;
import pe.edu.upc.demoeva.repositories.UsuarioRepository;
import pe.edu.upc.demoeva.servicesinterfaces.IVideollamadaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/videollamadas")

public class VideollamadaController {
    @Autowired
    private IVideollamadaService service;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping
    public List<VideollamadaDTO> listar(){
        return service.listar().stream().map(ent -> {
            ModelMapper m = new ModelMapper();
            VideollamadaDTO dto = m.map(ent, VideollamadaDTO.class);
            if (ent.getId() != null) dto.setId(ent.getId().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody VideollamadaDTO dto){
        ModelMapper m = new ModelMapper();
        Videollamada ent = m.map(dto, Videollamada.class);

        service.guardar(ent);
    }
}
