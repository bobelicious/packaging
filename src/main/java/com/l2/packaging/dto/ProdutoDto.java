package com.l2.packaging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.l2.packaging.model.Dimensoes;

import jakarta.transaction.Transactional;

@Transactional
public record ProdutoDto(
                @JsonProperty("produto_id") String produtoId,
                @JsonProperty(namespace = "dimensoes", access = Access.WRITE_ONLY) Dimensoes dimensoes) {
}