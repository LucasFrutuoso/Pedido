package com.pedidoAPI.Pedido.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.pedidoAPI.Pedido.Dto.DtoPedidoResponse;
import com.pedidoAPI.Pedido.Dto.PedidoEntitiesDto;
import com.pedidoAPI.Pedido.Entities.PedidoEntities;
import com.pedidoAPI.Pedido.Entities.Produto;
import com.pedidoAPI.Pedido.Repositories.PedidoRepository;
import com.pedidoAPI.Pedido.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    public PedidoRepository repoPedidos;
    @Autowired
    public ProdutoRepository repoProduto;

    @GetMapping
    public ResponseEntity<?> buscarPedido() {
        List<PedidoEntities> consultarPedido = repoPedidos.findAll();
        List<PedidoEntitiesDto> adicionarPedido = new ArrayList<>();

        for (PedidoEntities pedidoDtoADD : consultarPedido) {
            PedidoEntitiesDto pedidoDTO = new PedidoEntitiesDto();
            pedidoDTO.setDataCriacao(pedidoDtoADD.getDataCriacao());
            pedidoDTO.setEnderecoEntrega(pedidoDtoADD.getEnderecoEntrega());
            pedidoDTO.setNomePagador(pedidoDtoADD.getNomePagador());
            pedidoDTO.setTelefonePagador(pedidoDtoADD.getTelefonePagador());
            pedidoDTO.setValor(pedidoDtoADD.getValor());
            adicionarPedido.add(pedidoDTO);

        }
        return ResponseEntity.ok().body(adicionarPedido);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> porId(@PathVariable int id) {
        PedidoEntities pedidos = repoPedidos.findById(id).orElse(null);

        DtoPedidoResponse response = new DtoPedidoResponse();
        response.setId(pedidos.getId());
        response.setNomePagador(pedidos.getNomePagador());
        response.setDataCriacao(pedidos.getDataCriacao());
        response.setEnderecoEntrega(pedidos.getEnderecoEntrega());
        response.setTelefonePagador(pedidos.getTelefonePagador());

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> novoPedido(@RequestBody @Valid PedidoEntitiesDto DtoPedi) {

        PedidoEntities pedidos = new PedidoEntities();
        pedidos.setTelefonePagador(DtoPedi.getTelefonePagador());
        pedidos.setEnderecoEntrega(DtoPedi.getEnderecoEntrega());
        pedidos.setDataCriacao(DtoPedi.getDataCriacao());
        pedidos.setNomePagador(DtoPedi.getNomePagador());

        repoPedidos.save(pedidos);

        for (Integer p : DtoPedi.getProdutos()) {

         Produto produtoLista = repoProduto.findById(p).orElse(null);
         produtoLista.setPedido(pedidos);
         repoProduto.save(produtoLista);
        }


        DtoPedidoResponse response = new DtoPedidoResponse();
        response.setId(pedidos.getId());
        response.setNomePagador(pedidos.getNomePagador());
        response.setDataCriacao(pedidos.getDataCriacao());
        response.setEnderecoEntrega(pedidos.getEnderecoEntrega());
        response.setTelefonePagador(pedidos.getTelefonePagador());

        return ResponseEntity.ok().body(response);

    }
}
