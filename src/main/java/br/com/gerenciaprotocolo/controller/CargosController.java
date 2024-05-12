package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Cargos;
import br.com.gerenciaprotocolo.service.CargosService;

@RestController
@RequestMapping("/api/cargos")
public class CargosController {
    
    @Autowired()
    private CargosService cargoService;

    @GetMapping()
    public List<Cargos> getAllCargos(){
        return cargoService.findAll();
    }

    @GetMapping("/{id}")
    public Cargos getById(@PathVariable Long id){
        return cargoService.findById(id);
    }

    @PostMapping()
    public Cargos createCargo(@RequestBody Cargos cargpDetails){
        return cargoService.createCargos(cargpDetails);
    }

    @PutMapping("/{id}")
    public Cargos updateCargo(@PathVariable Long id,@RequestBody Cargos cargoDetails){
        return cargoService.updateCargos(id, cargoDetails);
    }

    @PutMapping("/{idCargo}/{idFuncionario}")
    public Cargos removeFuncionario(@PathVariable Long idCargo,@PathVariable Long idFuncionario){
        return cargoService.removeFuncionario(idFuncionario, idCargo);
    }

    @DeleteMapping("/{id}")
    public Cargos removeCargo(@PathVariable Long id){
        return cargoService.deleteCargo(id);
    }

}
