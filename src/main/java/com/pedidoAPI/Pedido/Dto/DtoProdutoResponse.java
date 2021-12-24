package com.pedidoAPI.Pedido.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoProdutoResponse {

    
    private int id;
    private String nome;
    private double valorUnitario;

   
}
