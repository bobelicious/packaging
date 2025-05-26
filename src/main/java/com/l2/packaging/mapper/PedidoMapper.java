package com.l2.packaging.mapper;

import com.l2.packaging.dto.PedidoDto;
import com.l2.packaging.model.Pedido;

public class PedidoMapper {
    public static PedidoDto toPedidoDto(Pedido pedido) {
        var caixasDto = pedido.getCaixas().stream().map(CaixaMapper::toCaixaDto).toList();
        var produtosDto = pedido.getCaixas().stream()
                .flatMap(caixa -> caixa.getProdutos().stream()
                        .map(ProdutoMapper::toProductDto))
                .toList();
        return new PedidoDto(pedido.getId(), produtosDto, caixasDto);
    }

    public static Pedido toPedido(PedidoDto pedidoDto) {
        var pedido = new Pedido();
        pedido.setId(pedidoDto.pedidoId());
        return pedido;
    }

}
