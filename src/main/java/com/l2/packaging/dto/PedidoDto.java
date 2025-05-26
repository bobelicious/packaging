package com.l2.packaging.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public record PedidoDto(
                @JsonProperty("pedido_id") Long pedidoId,
                @JsonProperty(namespace = "dimensoes", access = Access.WRITE_ONLY) List<ProdutoDto> produtos,
                List<CaixaDto> caixas) {

}
