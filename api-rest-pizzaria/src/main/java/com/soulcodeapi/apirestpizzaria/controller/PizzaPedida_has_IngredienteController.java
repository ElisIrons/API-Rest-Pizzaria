package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Ingrediente;
import com.soulcodeapi.apirestpizzaria.models.PizzaPedida;
import com.soulcodeapi.apirestpizzaria.models.PizzaPedida_has_Ingrediente;
import com.soulcodeapi.apirestpizzaria.repositories.IngredienteRepository;
import com.soulcodeapi.apirestpizzaria.repositories.PizzaPedidaRepository;
import com.soulcodeapi.apirestpizzaria.repositories.PizzaPedida_has_IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PizzaPedida_has_IngredienteController {

    @Autowired
    private PizzaPedida_has_IngredienteRepository pizzaPedida_has_IngredienteRepository;

    @Autowired
    private PizzaPedidaRepository pizzaPedidaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @RequestMapping(value = "/adicionaringrediente", method = RequestMethod.POST)
    public PizzaPedida_has_Ingrediente save() {
        long pizzaPedidaId = 1;
        long ingredienteId = 2;

        Optional<PizzaPedida> pizzaPedidaOptional = pizzaPedidaRepository.findById(pizzaPedidaId);
        PizzaPedida pizzaPedida = pizzaPedidaOptional.get();

        Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(ingredienteId);
        Ingrediente ingrediente = ingredienteOptional.get();

        PizzaPedida_has_Ingrediente pizzaPedidaHasIngrediente = new PizzaPedida_has_Ingrediente();
        pizzaPedidaHasIngrediente.setPizzaPedida(pizzaPedida);
        pizzaPedidaHasIngrediente.setIngrediente(ingrediente);

        return pizzaPedida_has_IngredienteRepository.save(pizzaPedidaHasIngrediente);
    }

    @RequestMapping(value = "/pedidoscomingrediente", method = RequestMethod.GET)
    public List<PizzaPedida_has_Ingrediente> getAllPizzaPedida_has_Ingrediente() {
        return pizzaPedida_has_IngredienteRepository.findAll();
    }
}