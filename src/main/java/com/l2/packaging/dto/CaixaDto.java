package com.l2.packaging.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CaixaDto(
        @JsonProperty("caixa_id") String tipoCaixa,
        @JsonInclude(JsonInclude.Include.NON_NULL) String observacao,
        List<String> produtos) {
}
