package com.pedidoAPI.Pedido.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntitiesDto {

    int id;
    private double valor;
    private String nomePagador;
    private String telefonePagador;
    private String enderecoEntrega;
    private String dataCriacao;

    List<Integer> produtos;
}
