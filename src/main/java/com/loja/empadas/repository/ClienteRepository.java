package com.loja.empadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loja.empadas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}