package com.loja.empadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loja.empadas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}