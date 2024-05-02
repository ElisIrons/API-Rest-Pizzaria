package com.soulcodeapi.apirestpizzaria.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soulcodeapi.apirestpizzaria.models.Cliente;
import com.soulcodeapi.apirestpizzaria.models.Fornada;
import com.soulcodeapi.apirestpizzaria.models.Pedido;
import com.soulcodeapi.apirestpizzaria.repositories.ClienteRepository;
import com.soulcodeapi.apirestpizzaria.repositories.FornadaRepository;
import com.soulcodeapi.apirestpizzaria.repositories.PedidoRepository;

@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FornadaRepository fornadaRepository;

    @RequestMapping(value = "/cadpedido", method = RequestMethod.POST)
    public Pedido save() {

        long clienteId = 1;
        long fornadaId = 1;

        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        Cliente cliente = clienteOptional.get();


        Optional<Fornada> fornadaOptional = fornadaRepository.findById(fornadaId);
        Fornada fornada = fornadaOptional.get();


        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setFornada(fornada);
        pedido.setDataHora(new Timestamp(System.currentTimeMillis()));

        return pedidoRepository.save(pedido);
    }

    @RequestMapping(value = "/pedidos", method = RequestMethod.GET)
    public List<Pedido> getAllPedido() {
        return pedidoRepository.findAll();
    }
}
