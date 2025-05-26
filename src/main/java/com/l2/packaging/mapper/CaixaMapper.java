package com.l2.packaging.mapper;

import java.util.Optional;

import com.l2.packaging.dto.CaixaDto;
import com.l2.packaging.model.Caixa;
import com.l2.packaging.model.Produto;
import com.l2.packaging.model.TipoCaixa;

public class CaixaMapper {
    public static CaixaDto toCaixaDto(Caixa caixa) {
        var produtosDto = caixa.getProdutos()
                .stream()
                .map(Produto::getId)
                .toList();
        var descricao = Optional.ofNullable(caixa.getTipoCaixa())
                .map(TipoCaixa::getDescricao)
                .orElse(null);
        var caixaDto = new CaixaDto(descricao, caixa.getObservacao(), produtosDto);
        return caixaDto;
    }
}
