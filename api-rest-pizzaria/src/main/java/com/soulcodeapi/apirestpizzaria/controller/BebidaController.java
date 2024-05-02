package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Bebida;
import com.soulcodeapi.apirestpizzaria.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    @RestController
    public class BebidaController {

        @Autowired
        private BebidaRepository bebidaRespository;


        @RequestMapping(value = "/cadbebida", method = RequestMethod.POST)
        public List<Bebida> save() {
            List<Bebida> bebidas = new ArrayList<>();

            Bebida cocaCola = new Bebida();
            cocaCola.setNome("Coca Cola");
            cocaCola.setPreco(8.49);
            bebidaRespository.save(cocaCola);

            Bebida guarana = new Bebida();
            guarana.setNome("Guaraná");
            guarana.setPreco(7.49);
            bebidaRespository.save(guarana);

            Bebida fantaLaranja = new Bebida();
            fantaLaranja.setNome("Fanta Laranja");
            fantaLaranja.setPreco(7.00);
            bebidaRespository.save(fantaLaranja);

            return bebidas;
        }

        @RequestMapping(value = "/mostrarbebida/{id}", method = RequestMethod.GET)
        public Bebida findById(@PathVariable long id) {
            Optional<Bebida> resultado = this.bebidaRespository.findById(id);
            if (resultado.isEmpty()) {
                throw new RuntimeException("Bebida não encontrada");
            } else {
                return resultado.get();
            }
        }

        @RequestMapping(value = "/bebidas", method = RequestMethod.GET)
        public List<Bebida> getAllBebida() {
            return bebidaRespository.findAll();
        }

        @RequestMapping(value = "/editarbebida/{id}", method = RequestMethod.PUT)
        public Bebida updateById(@PathVariable long id, @RequestBody Bebida bebida) {
            this.findById(id);
            bebida.setId(id);
            bebida = this.bebidaRespository.save(bebida);
            return bebida;
        }

        @RequestMapping(value = "/excluirbebida/{id}", method = RequestMethod.DELETE)
        public Bebida deleteById(@PathVariable long id) {
            Bebida bebida = findById(id);
            this.bebidaRespository.deleteById(id);
            return bebida;
        }

    }


