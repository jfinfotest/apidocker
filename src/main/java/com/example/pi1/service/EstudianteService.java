package com.example.pi1.service;

import com.example.pi1.model.Estudiante;
import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    List<Estudiante> findAll();
    Optional<Estudiante> findById(Long id);
    Optional<Estudiante> findByEmail(String email);
    Estudiante save(Estudiante estudiante);
    void deleteById(Long id);
    boolean existsByEmail(String email);
}