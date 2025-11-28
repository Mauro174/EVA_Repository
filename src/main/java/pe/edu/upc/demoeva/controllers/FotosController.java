package pe.edu.upc.demoeva.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeva.dtos.CantidadFotosDTO;
import pe.edu.upc.demoeva.dtos.FotosDTO;
import pe.edu.upc.demoeva.entities.Fotos;
import pe.edu.upc.demoeva.servicesinterfaces.FotoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fotos")
public class FotosController {
    @Autowired
    private FotoService fS;

    @GetMapping("/lista")
    public List<FotosDTO> listar() {
        return fS.listar().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, FotosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/prueba")
    public void insertar(@RequestBody FotosDTO dto) {
        ModelMapper m = new ModelMapper();
        Fotos f = m.map(dto, Fotos.class);
        fS.insertar(f);
    }

    @PutMapping
    public void modificar(@RequestBody FotosDTO dto) {
        ModelMapper m = new ModelMapper();
        Fotos f = m.map(dto, Fotos.class);
        fS.update(f);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        fS.delete(id);
    }

    @GetMapping("/mayorfotos")
    public List<CantidadFotosDTO> mayorfotos() {
        List<CantidadFotosDTO> dtoList = new ArrayList<>();
        List<String[]> filaList = fS.MasFotos();
        for(String[] columna:filaList){
            CantidadFotosDTO dto2 = new CantidadFotosDTO();
            dto2.setUsuario(columna[0]);
            dto2.setCantidad(Integer.parseInt(columna[1]));
            dtoList.add(dto2);
        }
        return dtoList;
    }
}
