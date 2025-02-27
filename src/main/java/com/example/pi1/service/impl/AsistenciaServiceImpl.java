package com.example.pi1.service.impl;

import com.example.pi1.model.Asistencia;
import com.example.pi1.model.Curso;
import com.example.pi1.model.Estudiante;
import com.example.pi1.repository.AsistenciaRepository;
import com.example.pi1.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    private final AsistenciaRepository asistenciaRepository;

    public AsistenciaServiceImpl(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }

    @Override
    public List<Asistencia> findAll() {
        return asistenciaRepository.findAll();
    }

    @Override
    public Optional<Asistencia> findById(Long id) {
        return asistenciaRepository.findById(id);
    }

    @Override
    public Asistencia save(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public void deleteById(Long id) {
        asistenciaRepository.deleteById(id);
    }

    @Override
    public List<Asistencia> findByEstudiante(Estudiante estudiante) {
        return asistenciaRepository.findByEstudiante(estudiante);
    }

    @Override
    public List<Asistencia> findByCurso(Curso curso) {
        return asistenciaRepository.findByCurso(curso);
    }

    @Override
    public List<Asistencia> findByFechaAsistencia(LocalDate fecha) {
        return asistenciaRepository.findByFechaAsistencia(fecha);
    }

    @Override
    public List<Asistencia> findByEstudianteAndCurso(Estudiante estudiante, Curso curso) {
        return asistenciaRepository.findByEstudianteAndCurso(estudiante, curso);
    }

    @Override
    public List<Asistencia> findByEstudianteAndFechaAsistenciaBetween(Estudiante estudiante, LocalDate fechaInicio, LocalDate fechaFin) {
        return asistenciaRepository.findByEstudianteAndFechaAsistenciaBetween(estudiante, fechaInicio, fechaFin);
    }

    @Override
    public List<Asistencia> findByCursoAndFechaAsistenciaBetween(Curso curso, LocalDate fechaInicio, LocalDate fechaFin) {
        return asistenciaRepository.findByCursoAndFechaAsistenciaBetween(curso, fechaInicio, fechaFin);
    }
}