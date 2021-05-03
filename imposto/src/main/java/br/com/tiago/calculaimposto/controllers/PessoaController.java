package br.com.tiago.calculaimposto.controllers;

import br.com.tiago.calculaimposto.models.Pessoa;
import br.com.tiago.calculaimposto.repository.PessoaRepository;
import br.com.tiago.calculaimposto.services.ImpostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;



    @PostMapping
    public Pessoa calculaImpostoSalario(@RequestBody Pessoa pessoa){

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        return pessoaSalva;
    }

}
