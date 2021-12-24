package com.pedidoAPI.Pedido.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoPedidoResponse {

    private int id;
    private double valor;
    private String nomePagador;
    private String telefonePagador;
    private String enderecoEntrega;
    private String dataCriacao;
}
