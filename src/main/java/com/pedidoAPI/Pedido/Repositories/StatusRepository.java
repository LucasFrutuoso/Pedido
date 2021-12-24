package com.pedidoAPI.Pedido.Repositories;

import com.pedidoAPI.Pedido.Entities.StatusPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusPedido, Integer> {
    
}
