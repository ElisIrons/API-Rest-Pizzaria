package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Bebida;
import com.soulcodeapi.apirestpizzaria.models.BebidaPedida;
import com.soulcodeapi.apirestpizzaria.models.Pedido;
import com.soulcodeapi.apirestpizzaria.repositories.BebidaPedidaRepository;
import com.soulcodeapi.apirestpizzaria.repositories.BebidaRepository;
import com.soulcodeapi.apirestpizzaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BebidaPedidaController {

    @Autowired
    private BebidaPedidaRepository bebidaPedidaRepository;

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    @RequestMapping(value = "/adicionarbebida", method = RequestMethod.POST)
    public BebidaPedida save() {

        long bebidaId = 1;
        long pedidoId = 1;

        Optional<Bebida> bebidaOptional = bebidaRepository.findById(bebidaId);
        Bebida bebida = bebidaOptional.get();

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoId);
        Pedido pedido = pedidoOptional.get();

        BebidaPedida bebidaPedida = new BebidaPedida();
        bebidaPedida.setBebida(bebida);
        bebidaPedida.setPedido(pedido);
        bebidaPedida.setQuantidade(2);

        return bebidaPedidaRepository.save(bebidaPedida);
    }


    @RequestMapping(value = "/mostrarpedidobebida/{id}", method = RequestMethod.GET)
    public BebidaPedida findById(@PathVariable long id) {
        Optional<BebidaPedida> resultado = this.bebidaPedidaRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Pedido de bebida não encontrado");
        } else {
            return resultado.get();
        }
    }

    @RequestMapping(value = "/bebidaspedidas", method = RequestMethod.GET)
    public List<BebidaPedida> getAllBebidasPedidas() {
        return bebidaPedidaRepository.findAll();
    }

    @RequestMapping(value = "/editarpedidobebida/{id}", method = RequestMethod.PUT)
    public BebidaPedida updateById(@PathVariable long id, @RequestBody BebidaPedida bebidaPedida) {
        this.findById(id);
        bebidaPedida.setId(id);
        bebidaPedida = this.bebidaPedidaRepository.save(bebidaPedida);
        return bebidaPedida;
    }

    @RequestMapping(value = "/excluirpedidobebida/{id}", method = RequestMethod.DELETE)
    public BebidaPedida deleteById(@PathVariable long id) {
        BebidaPedida bebidaPedida = findById(id);
        this.bebidaPedidaRepository.deleteById(id);
        return bebidaPedida;
    }

}