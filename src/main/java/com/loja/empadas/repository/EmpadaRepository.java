package com.loja.empadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loja.empadas.model.Empada;

public interface EmpadaRepository extends JpaRepository<Empada, Long> {
}