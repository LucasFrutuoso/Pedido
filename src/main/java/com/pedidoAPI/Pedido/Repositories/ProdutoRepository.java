package com.pedidoAPI.Pedido.Repositories;

import com.pedidoAPI.Pedido.Entities.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
}
