package br.com.tiago.calculaimposto.models;

import br.com.tiago.calculaimposto.imposto.Imposto;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private BigDecimal salario;

    public Pessoa() {
    }

    public Pessoa(String nome, BigDecimal salario) {
        this.nome = nome;
        this.salario = salario;
    }

}

