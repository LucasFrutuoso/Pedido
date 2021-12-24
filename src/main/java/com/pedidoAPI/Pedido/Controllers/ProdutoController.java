package com.pedidoAPI.Pedido.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.pedidoAPI.Pedido.Dto.DtoProdutoResponse;
import com.pedidoAPI.Pedido.Dto.ProdutoDto;
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
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProdutoController {

    @Autowired
    public ProdutoRepository repoProduct;
    @Autowired
    public PedidoRepository repoPedido;

    @GetMapping
    public ResponseEntity<?> buscarProduto() {
        List<Produto> consultarProduto = repoProduct.findAll();
        List<ProdutoDto> adicionarDto = new ArrayList<>();

        for (Produto produtoDtoADD : consultarProduto) {
            ProdutoDto prodDTO = new ProdutoDto();
            prodDTO.setNome(produtoDtoADD.getNome());
            prodDTO.setValorUnitario(produtoDtoADD.getValorUnitario());
            adicionarDto.add(prodDTO);
        }

        return ResponseEntity.ok().body(adicionarDto);

    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> porId(@PathVariable int id) {
        return repoProduct.findById(id);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> novoProduto(@RequestBody @Valid ProdutoDto DtoProduto) {

        Produto produto = new Produto();
      
        produto.setNome(DtoProduto.getNome());
        produto.setValorUnitario(DtoProduto.getValorUnitario());
        repoProduct.save(produto); 

        
        DtoProdutoResponse response = new DtoProdutoResponse();
        response.setId(produto.getId());
        response.setNome(produto.getNome());
        response.setValorUnitario(produto.getValorUnitario());

        return ResponseEntity.ok().body(response);

    }

}
