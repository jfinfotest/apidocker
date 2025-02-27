package com.example.pi1.repository;

import com.example.pi1.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByFechaInicioBetween(LocalDate startDate, LocalDate endDate);
    List<Curso> findByNombreCursoContainingIgnoreCase(String nombreCurso);
    boolean existsByNombreCurso(String nombreCurso);
}