package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Fornada;
import com.soulcodeapi.apirestpizzaria.repositories.FornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FornadaController {
    @Autowired
    private FornadaRepository fornadaRepository;

    @RequestMapping(value = "/cadquantidade", method = RequestMethod.POST)
    public Fornada save() {
        Fornada fornada = new Fornada();
        fornada.setNumFornada(1);
        fornada.setQuantidadePizzas(2);
        return fornadaRepository.save(fornada);
    }

    @RequestMapping(value = "/fornadas", method = RequestMethod.GET)
    public List<Fornada> getAllFornada() {
        return fornadaRepository.findAll();
    }
}