package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Departamento;
import br.com.gerenciaprotocolo.service.DepartamentoService;
 
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoService.findAll();
    }

    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.saveDepartamento(departamento);
    }

    @GetMapping("/{id}")
    public Departamento getDepartamentoById(@PathVariable Long id) {
        return departamentoService.findById(id);
    }

    @PutMapping("/{id}")
    public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamentoDetails) {
        return departamentoService.updatedDepartamento(id, departamentoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartamento(@PathVariable Long id) {
        departamentoService.deleteByID(id);
    }
}
