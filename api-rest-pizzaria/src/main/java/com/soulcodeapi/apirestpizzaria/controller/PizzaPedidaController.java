package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Pedido;
import com.soulcodeapi.apirestpizzaria.models.Pizza;
import com.soulcodeapi.apirestpizzaria.models.PizzaPedida;
import com.soulcodeapi.apirestpizzaria.models.Tamanho;
import com.soulcodeapi.apirestpizzaria.repositories.PedidoRepository;
import com.soulcodeapi.apirestpizzaria.repositories.PizzaPedidaRepository;
import com.soulcodeapi.apirestpizzaria.repositories.PizzaRepository;
import com.soulcodeapi.apirestpizzaria.repositories.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PizzaPedidaController {

    @Autowired
    private PizzaPedidaRepository pizzaPedidaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @RequestMapping(value = "/adicionarpedidopizza", method = RequestMethod.POST)
    public PizzaPedida save(){
        long pedidoId = 1;
        long pizzaId = 2;
        long tamanhoId = 2;

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoId);
        Pedido pedido = pedidoOptional.get();

        Optional<Pizza> pizzaOptional = pizzaRepository.findById(pizzaId);
        Pizza pizza = pizzaOptional.get();

        Optional<Tamanho> tamanhoOptional = tamanhoRepository.findById(tamanhoId);
        Tamanho tamanho = tamanhoOptional.get();

        PizzaPedida pizzaPedida = new PizzaPedida();
        pizzaPedida.setPedido(pedido);
        pizzaPedida.setPizza(pizza);
        pizzaPedida.setTamanho(tamanho);
        pizzaPedida.setQuantidade(2);

        return pizzaPedidaRepository.save(pizzaPedida);
    }

    @RequestMapping(value = "/mostrarpedidopizza/{id}", method = RequestMethod.GET)
    public PizzaPedida findById(@PathVariable long id){
        Optional<PizzaPedida>resultado = this.pizzaPedidaRepository.findById(id);
        if(resultado.isEmpty()){
            throw new RuntimeException("Pedido de Pizza não encontrado");
        }else{
            return resultado.get();
        }
    }

    @RequestMapping(value = "/pizzaspedidas", method = RequestMethod.GET)
    public List<PizzaPedida> getAllPizzaPedida(){
        return pizzaPedidaRepository.findAll();
    }

    @RequestMapping(value = "editarpedidopizza/{id}", method = RequestMethod.PUT)
    public PizzaPedida updateById(@PathVariable long id, @RequestBody PizzaPedida pizzaPedida){
        this.findById(id);
        pizzaPedida.setId(id);
        pizzaPedida = this.pizzaPedidaRepository.save(pizzaPedida);
        return pizzaPedida;
    }

    @RequestMapping(value = "/excluirpedidopizza/{id}", method = RequestMethod.DELETE)
    public PizzaPedida deleteById (@PathVariable long id){
        PizzaPedida pizzaPedida = findById(id);
        this.pizzaPedidaRepository.deleteById(id);
        return pizzaPedida;
    }
}

