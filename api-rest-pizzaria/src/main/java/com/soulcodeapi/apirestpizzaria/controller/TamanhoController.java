package com.soulcodeapi.apirestpizzaria.controller;

import com.soulcodeapi.apirestpizzaria.models.Tamanho;
import com.soulcodeapi.apirestpizzaria.repositories.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TamanhoController {

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @RequestMapping(value = "/cadtamanho", method = RequestMethod.POST)
    public List<Tamanho> save() {
        List<Tamanho> tamanhos = new ArrayList<>();

        Tamanho tamanho1 = new Tamanho();
        tamanho1.setNome("Pequena");
        tamanho1.setDesconto(0.1);
        tamanhoRepository.save(tamanho1);

        Tamanho tamanho2 = new Tamanho();
        tamanho2.setNome("Média");
        tamanho2.setDesconto(0.5);
        tamanhoRepository.save(tamanho2);

        Tamanho tamanho3 = new Tamanho();
        tamanho3.setNome("Grande");
        tamanho3.setDesconto(0.0);
        tamanhoRepository.save(tamanho3);

        return tamanhos;
    }

    @RequestMapping(value = "/mostrartamanho/{id}", method = RequestMethod.GET)
    public Tamanho findById(@PathVariable long id){
        Optional<Tamanho>resultado = this.tamanhoRepository.findById(id);
        if(resultado.isEmpty()){
            throw new RuntimeException("Tamanho não encontrado");
        }else {
            return resultado.get();
        }
    }

    @RequestMapping(value = "/tamanhos", method = RequestMethod.GET)
    public List<Tamanho> getAllTamanhos(){
        return tamanhoRepository.findAll();
    }

    @RequestMapping(value = "/editartamanho/{id}", method = RequestMethod.PUT)
    public Tamanho updateById(@PathVariable long id, @RequestBody Tamanho tamanho){
        this.findById(id);
        tamanho.setId(id);
        tamanho = this.tamanhoRepository.save(tamanho);
        return tamanho;
    }

    @RequestMapping(value = "/excluirtamanho/{id}", method = RequestMethod.DELETE)
    public Tamanho deleteById(@PathVariable long id) {
        Tamanho tamanho = findById(id);
        this.tamanhoRepository.deleteById(id);
        return tamanho;
    }
}