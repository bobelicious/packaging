package com.l2.packaging.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Dimensoes {

    @Column(name = "altura")
    private int altura;

    @Column(name = "largura")
    private int largura;

    @Column(name = "comprimento")
    private int comprimento;
}
