package com.pedidoAPI.Pedido.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private double valor;

    private String nomePagador;
    private String telefonePagador;
    private String enderecoEntrega;
    private String dataCriacao;

    @OneToOne
    public StatusPedido status;

    @OneToMany
    public List<Produto> produto;

}
