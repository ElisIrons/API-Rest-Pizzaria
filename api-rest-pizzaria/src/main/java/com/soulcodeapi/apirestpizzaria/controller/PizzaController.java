package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Pizza;
import com.soulcodeapi.apirestpizzaria.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @RequestMapping(value = "/cadpizza", method = RequestMethod.POST)
    public List<Pizza> save() {
        List<Pizza> pizzas = new ArrayList<>();

        Pizza pizza1 = new Pizza();
        pizza1.setNome("Pizza de Calabresa");
        pizza1.setPrecoBase(23.90);
        pizza1.setPersonalizada(false);
        pizzaRepository.save(pizza1);

        Pizza pizza2 = new Pizza();
        pizza2.setNome("Pizza de Portuguesa");
        pizza2.setPrecoBase(28.90);
        pizza2.setPersonalizada(true);
        pizzaRepository.save(pizza2);

        return pizzas;
    }

    @RequestMapping(value = "/mostrarpizza/{id}", method = RequestMethod.GET)
    public Pizza findById(@PathVariable long id) {
        Optional<Pizza> resultado = this.pizzaRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Pizza não encontrada");
        } else {
            return resultado.get();
        }
    }

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    @RequestMapping(value = "/editarpizza/{id}", method = RequestMethod.PUT)
    public Pizza updateById(@PathVariable long id, @RequestBody Pizza pizza) {
        this.findById(id);
        pizza.setId(id);
        pizza = this.pizzaRepository.save(pizza);
        return pizza;
    }

    @RequestMapping(value = "/excluirpizza/{id}", method = RequestMethod.DELETE)
    public Pizza deleteById(@PathVariable long id) {
        Pizza pizza = findById(id);
        this.pizzaRepository.deleteById(id);
        return pizza;
    }
}

