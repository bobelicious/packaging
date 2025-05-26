package com.l2.packaging.mapper;

import com.l2.packaging.dto.ProdutoDto;
import com.l2.packaging.model.Produto;

public class ProdutoMapper {
    public static ProdutoDto toProductDto(Produto produto) {
        return new ProdutoDto(produto.getId(), produto.getDimensoes());
    }

    public static Produto toProduct(ProdutoDto produtoDto) {
        return new Produto(produtoDto.produtoId(), produtoDto.dimensoes());
    }
}
