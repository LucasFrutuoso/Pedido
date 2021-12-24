package com.pedidoAPI.Pedido.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private int id;
    private String nome;
    private double valorUnitario;

    
}
