package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Cliente;
import com.soulcodeapi.apirestpizzaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/cadcliente", method = RequestMethod.POST)
    public List<Cliente> save() {
        List<Cliente> clientes = new ArrayList<>();

        Cliente mulher = new Cliente();
        mulher.setNome("Juliana Rosa Vasconcelos ");
        mulher.setTelefone("(35) 7254-8855");
        mulher.setEndereco("Rua Flor de Lotus, nº52, bairro Jardins, Botanico - MG");
        mulher.setLogin("juliana_rosa");
        mulher.setSenha("1234");
        clienteRepository.save(mulher);

        Cliente homem = new Cliente();
        homem.setNome("Roberto de Souza ");
        homem.setTelefone("(35) 7387-3265");
        homem.setEndereco("Rua Margarida, nº11, bairro Jardins, Botanico - MG");
        homem.setLogin("robert035");
        homem.setSenha("5678");
        clienteRepository.save(homem);

        return clientes;
    }

    @RequestMapping(value = "/mostrarcliente/{id}", method = RequestMethod.GET)
    public Cliente findById(@PathVariable long id) {
        Optional<Cliente> resultado = this.clienteRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Cliente não encontrada");
        } else {
            return resultado.get();
        }
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @RequestMapping(value = "/editarcliente/{id}", method = RequestMethod.PUT)
    public Cliente updateById(@PathVariable long id, @RequestBody Cliente cliente) {
        this.findById(id);
        cliente.setId(id);
        cliente = this.clienteRepository.save(cliente);
        return cliente;
    }

    @RequestMapping(value = "/excluircliente/{id}", method = RequestMethod.DELETE)
    public Cliente deleteById(@PathVariable long id) {
        Cliente cliente = findById(id);
        this.clienteRepository.deleteById(id);
        return cliente;
    }

}
