package com.l2.packaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l2.packaging.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    // List<Produto> findAllByProdutoId(Iterable<String> produtoId);
}
