package br.com.tiago.calculaimposto.services;

import br.com.tiago.calculaimposto.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

class ImpostoServiceTest {

    private Pessoa pessoa;
    private ImpostoService impostoService;
    private String saida;

    @BeforeEach
    public void beforEach(){
        pessoa = new Pessoa("Tiago Silva", new BigDecimal(BigInteger.ZERO));
        impostoService = new ImpostoService();
    }

    @Test
    public void deveriaApresentarValorImpostoDeAcordoComAFaixaSalarial(){
        pessoa.setSalario(new BigDecimal("3002.00"));
        verificaImpostoIsento();
        Assertions.assertEquals("R$ 80.36", saida);

        pessoa.setSalario(new BigDecimal("1701.12"));
        verificaImpostoIsento();
        Assertions.assertEquals("Isento", saida);

        pessoa.setSalario(new BigDecimal("4520.00"));
        verificaImpostoIsento();
        Assertions.assertEquals("R$ 355.60", saida);
    }

    private void verificaImpostoIsento() {
        BigDecimal calcula = impostoService.calcula(pessoa);
        if (calcula.compareTo(new BigDecimal(BigInteger.ZERO)) == 0) {
            saida = "Isento";
        }else{
            saida = "R$ " + calcula;
        }

    }




}