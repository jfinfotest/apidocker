package com.example.pi1.repository;

import com.example.pi1.model.Asistencia;
import com.example.pi1.model.Curso;
import com.example.pi1.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    List<Asistencia> findByEstudiante(Estudiante estudiante);
    List<Asistencia> findByCurso(Curso curso);
    List<Asistencia> findByFechaAsistencia(LocalDate fecha);
    List<Asistencia> findByEstudianteAndCurso(Estudiante estudiante, Curso curso);
    List<Asistencia> findByEstudianteAndFechaAsistenciaBetween(Estudiante estudiante, LocalDate fechaInicio, LocalDate fechaFin);
    List<Asistencia> findByCursoAndFechaAsistenciaBetween(Curso curso, LocalDate fechaInicio, LocalDate fechaFin);
}