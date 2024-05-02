package com.soulcodeapi.apirestpizzaria.models;

import jakarta.persistence.*;

@Entity
@Table(name="Fornada")
public class Fornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int numFornada;

    @Column
    private int quantidadePizzas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumFornada() {
        return numFornada;
    }

    public void setNumFornada(int numFornada) {
        this.numFornada = numFornada;
    }

    public int getQuantidadePizzas() {
        return quantidadePizzas;
    }

    public void setQuantidadePizzas(int quantidadePizzas) {
        this.quantidadePizzas = quantidadePizzas;
    }
}
