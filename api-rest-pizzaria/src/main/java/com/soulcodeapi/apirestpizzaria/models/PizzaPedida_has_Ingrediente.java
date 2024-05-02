package com.soulcodeapi.apirestpizzaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PizzaPedida_has_Ingrediente")
public class PizzaPedida_has_Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pizza_pedida_id")
    private PizzaPedida pizzaPedida;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PizzaPedida getPizzaPedida() {
        return pizzaPedida;
    }

    public void setPizzaPedida(PizzaPedida pizzaPedida) {
        this.pizzaPedida = pizzaPedida;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}
