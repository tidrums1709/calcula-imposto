package br.com.tiago.calculaimposto.controllers;

import br.com.tiago.calculaimposto.imposto.*;
import br.com.tiago.calculaimposto.models.Pessoa;
import br.com.tiago.calculaimposto.repository.PessoaRepository;
import br.com.tiago.calculaimposto.services.ImpostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/imposto")
public class ImpostoController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ImpostoService impostoService;


    @GetMapping(value = "/{id}")
    public String calculaImpostoSalario(@PathVariable("id") Long idPessoa){

        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
        if(!pessoa.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada", null);
        }
        Pessoa pessoaSelecionada = pessoa.get();
        return impostoService.verificaImpostoIsento(pessoaSelecionada);

    }

}
