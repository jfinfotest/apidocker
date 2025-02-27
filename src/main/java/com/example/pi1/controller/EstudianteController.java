package com.example.pi1.controller;

import com.example.pi1.model.Estudiante;
import com.example.pi1.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {

    @Autowired
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getAllEstudiantes() {
        return ResponseEntity.ok(estudianteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        return estudianteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Estudiante> getEstudianteByEmail(@PathVariable String email) {
        return estudianteService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        if (estudianteService.existsByEmail(estudiante.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Estudiante savedEstudiante = estudianteService.save(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return estudianteService.findById(id)
                .map(existingEstudiante -> {
                    estudiante.setId(id);
                    return ResponseEntity.ok(estudianteService.save(estudiante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        if (!estudianteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estudianteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}