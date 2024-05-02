package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Ingrediente;
import com.soulcodeapi.apirestpizzaria.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @RequestMapping(value = "/cadingrediente", method = RequestMethod.POST)
    public List<Ingrediente> save() {
        List<Ingrediente>ingredientes = new ArrayList<>();

        Ingrediente catupiry = new Ingrediente();
        catupiry.setNome("Catupiry");
        catupiry.setPreco(6.99);
        ingredienteRepository.save(catupiry);

        Ingrediente cheddar = new Ingrediente();
        cheddar.setNome("Cheddar");
        cheddar.setPreco(5.49);
        ingredienteRepository.save(cheddar);


        Ingrediente queijoMussarela = new Ingrediente();
        queijoMussarela.setNome("Queijo Mussarela");
        queijoMussarela.setPreco(4.49);
        ingredienteRepository.save(queijoMussarela);

        return ingredientes;
    }

    @RequestMapping(value = "/mostraringrediente/{id}", method = RequestMethod.GET)
    public Ingrediente findById(@PathVariable long id) {
        Optional<Ingrediente> resultado = this.ingredienteRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Ingrediente não encontrado");
        } else {
            return resultado.get();
        }
    }


    @RequestMapping(value = "/ingredientes", method = RequestMethod.GET)
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    @RequestMapping(value = "/editaringrediente/{id}", method = RequestMethod.PUT)
    public Ingrediente updateById(@PathVariable long id, @RequestBody Ingrediente ingrediente) {
        this.findById(id);
        ingrediente.setId(id);
        ingrediente = this.ingredienteRepository.save(ingrediente);
        return ingrediente;
    }

    @RequestMapping(value = "/excluiringrediente/{id}", method = RequestMethod.DELETE)
    public Ingrediente deleteById(@PathVariable long id) {
        Ingrediente ingrediente = findById(id);
        this.ingredienteRepository.deleteById(id);
        return ingrediente;
    }
}