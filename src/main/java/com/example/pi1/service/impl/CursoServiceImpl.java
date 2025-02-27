package com.example.pi1.service.impl;

import com.example.pi1.model.Curso;
import com.example.pi1.repository.CursoRepository;
import com.example.pi1.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Curso> findByFechaInicioBetween(LocalDate startDate, LocalDate endDate) {
        return cursoRepository.findByFechaInicioBetween(startDate, endDate);
    }

    @Override
    public List<Curso> findByNombreCursoContainingIgnoreCase(String nombreCurso) {
        return cursoRepository.findByNombreCursoContainingIgnoreCase(nombreCurso);
    }

    @Override
    public boolean existsByNombreCurso(String nombreCurso) {
        return cursoRepository.existsByNombreCurso(nombreCurso);
    }
}