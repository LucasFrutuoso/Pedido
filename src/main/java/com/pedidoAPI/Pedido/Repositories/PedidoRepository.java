package com.pedidoAPI.Pedido.Repositories;

import com.pedidoAPI.Pedido.Entities.PedidoEntities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntities, Integer> {
    
}
