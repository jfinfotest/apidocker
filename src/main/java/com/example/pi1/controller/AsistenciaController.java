package com.example.pi1.controller;

import com.example.pi1.model.Asistencia;
import com.example.pi1.model.Curso;
import com.example.pi1.model.Estudiante;
import com.example.pi1.service.AsistenciaService;
import com.example.pi1.service.CursoService;
import com.example.pi1.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    @Autowired
    private final AsistenciaService asistenciaService;
    @Autowired
    private final EstudianteService estudianteService;
    @Autowired
    private final CursoService cursoService;

    public AsistenciaController(AsistenciaService asistenciaService,
                               EstudianteService estudianteService,
                               CursoService cursoService) {
        this.asistenciaService = asistenciaService;
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<Asistencia>> getAllAsistencias() {
        return ResponseEntity.ok(asistenciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable Long id) {
        return asistenciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<Asistencia>> getAsistenciasByEstudiante(@PathVariable Long estudianteId) {
        return estudianteService.findById(estudianteId)
                .map(estudiante -> ResponseEntity.ok(asistenciaService.findByEstudiante(estudiante)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Asistencia>> getAsistenciasByCurso(@PathVariable Long cursoId) {
        return cursoService.findById(cursoId)
                .map(curso -> ResponseEntity.ok(asistenciaService.findByCurso(curso)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Asistencia>> getAsistenciasByFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(asistenciaService.findByFechaAsistencia(fecha));
    }

    @GetMapping("/estudiante/{estudianteId}/curso/{cursoId}")
    public ResponseEntity<List<Asistencia>> getAsistenciasByEstudianteAndCurso(
            @PathVariable Long estudianteId,
            @PathVariable Long cursoId) {
        return estudianteService.findById(estudianteId)
                .flatMap(estudiante -> cursoService.findById(cursoId)
                        .map(curso -> ResponseEntity.ok(asistenciaService.findByEstudianteAndCurso(estudiante, curso))))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiante/{estudianteId}/fecha")
    public ResponseEntity<List<Asistencia>> getAsistenciasByEstudianteAndFecha(
            @PathVariable Long estudianteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return estudianteService.findById(estudianteId)
                .map(estudiante -> ResponseEntity.ok(
                        asistenciaService.findByEstudianteAndFechaAsistenciaBetween(estudiante, fechaInicio, fechaFin)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{cursoId}/fecha")
    public ResponseEntity<List<Asistencia>> getAsistenciasByCursoAndFecha(
            @PathVariable Long cursoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return cursoService.findById(cursoId)
                .map(curso -> ResponseEntity.ok(
                        asistenciaService.findByCursoAndFechaAsistenciaBetween(curso, fechaInicio, fechaFin)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asistencia> createAsistencia(@RequestBody Asistencia asistencia) {
        return ResponseEntity.ok(asistenciaService.save(asistencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> updateAsistencia(@PathVariable Long id, @RequestBody Asistencia asistencia) {
        return asistenciaService.findById(id)
                .map(existingAsistencia -> {
                    asistencia.setId(id);
                    return ResponseEntity.ok(asistenciaService.save(asistencia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable Long id) {
        if (!asistenciaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        asistenciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}