package com.l2.packaging.service;

import static com.l2.packaging.mapper.PedidoMapper.toPedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.l2.packaging.dto.PedidoPayloadDto;
import com.l2.packaging.mapper.PedidoMapper;
import com.l2.packaging.mapper.ProdutoMapper;
import com.l2.packaging.model.Caixa;
import com.l2.packaging.model.Pedido;
import com.l2.packaging.model.Produto;
import com.l2.packaging.model.TipoCaixa;
import com.l2.packaging.repository.PedidoRepository;
import com.l2.packaging.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service

public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public PedidoPayloadDto createPedido(PedidoPayloadDto pedidosDto) {
        List<Pedido> pedidoList = new ArrayList<>();
        pedidosDto.pedidos().forEach((pedidoDto) -> {
            var produtos = pedidoDto.produtos().stream()
                    .map(ProdutoMapper::toProduct).toList();
            produtos = produtoRepository.saveAll(produtos);
            var pedido = toPedido(pedidoDto);
            pedido = findCaixas(produtos, pedido);
            pedidoList.add(pedido);

        });
        var listPedidoDto = pedidoRepository.saveAll(pedidoList).stream().map(PedidoMapper::toPedidoDto)
                .toList();
        return new PedidoPayloadDto(listPedidoDto);
    }

    private Pedido findCaixas(List<Produto> produtos, Pedido pedido) {
        var caixaMap = new HashMap<TipoCaixa, Caixa>();

        for (Produto produto : produtos) {
            var dimensoes = produto.getDimensoes();
            var tipoCaixa = TipoCaixa.findCaixa(
                    dimensoes.getAltura(),
                    dimensoes.getLargura(),
                    dimensoes.getComprimento());

            if (tipoCaixa != null) {
                var caixa = caixaMap.computeIfAbsent(tipoCaixa, key -> {
                    var c = new Caixa();
                    c.setTipoCaixa(key);
                    c.setPedido(pedido);
                    return c;
                });
                caixa.getProdutos().add(produto);
            } else {
                var caixa = new Caixa();
                caixa.setObservacao("Produto não cabe em nenhuma caixa disponível.");
                caixa.setPedido(pedido);
                caixa.getProdutos().add(produto);
                pedido.getCaixas().add(caixa);
            }
        }

        pedido.getCaixas().addAll(caixaMap.values());

        return pedido;
    }

}
