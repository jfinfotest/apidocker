package com.example.pi1.service;

import com.example.pi1.model.Curso;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
    List<Curso> findByFechaInicioBetween(LocalDate startDate, LocalDate endDate);
    List<Curso> findByNombreCursoContainingIgnoreCase(String nombreCurso);
    boolean existsByNombreCurso(String nombreCurso);
}