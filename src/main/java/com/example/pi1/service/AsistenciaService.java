package com.example.pi1.service;

import com.example.pi1.model.Asistencia;
import com.example.pi1.model.Curso;
import com.example.pi1.model.Estudiante;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AsistenciaService {
    List<Asistencia> findAll();
    Optional<Asistencia> findById(Long id);
    Asistencia save(Asistencia asistencia);
    void deleteById(Long id);
    List<Asistencia> findByEstudiante(Estudiante estudiante);
    List<Asistencia> findByCurso(Curso curso);
    List<Asistencia> findByFechaAsistencia(LocalDate fecha);
    List<Asistencia> findByEstudianteAndCurso(Estudiante estudiante, Curso curso);
    List<Asistencia> findByEstudianteAndFechaAsistenciaBetween(Estudiante estudiante, LocalDate fechaInicio, LocalDate fechaFin);
    List<Asistencia> findByCursoAndFechaAsistenciaBetween(Curso curso, LocalDate fechaInicio, LocalDate fechaFin);
}