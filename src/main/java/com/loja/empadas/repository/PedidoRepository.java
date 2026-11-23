package com.loja.empadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loja.empadas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}