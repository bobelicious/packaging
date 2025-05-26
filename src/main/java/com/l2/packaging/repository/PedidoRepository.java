package com.l2.packaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l2.packaging.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}