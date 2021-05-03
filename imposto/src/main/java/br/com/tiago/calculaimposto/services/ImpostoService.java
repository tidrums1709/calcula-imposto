package br.com.tiago.calculaimposto.services;

import br.com.tiago.calculaimposto.imposto.ImpostoDezoitoPorcento;
import br.com.tiago.calculaimposto.imposto.ImpostoIsento;
import br.com.tiago.calculaimposto.imposto.ImpostoOitoPorcento;
import br.com.tiago.calculaimposto.imposto.ImpostoVinteEOitoPorcento;
import br.com.tiago.calculaimposto.models.Pessoa;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Service
public class ImpostoService {

    private BigDecimal valorImposto;
    private BigDecimal salario;

    public BigDecimal calcula(Pessoa pessoa) {
        salario = pessoa.getSalario();

        if(salario.compareTo(new BigDecimal("2000")) <= 0){
            valorImposto =  new ImpostoIsento().calculaImposto(salario);
        }else if (salario.compareTo(new BigDecimal("3000")) < 0){
            valorImposto =  new ImpostoOitoPorcento().calculaImposto(salario);
        }else if (salario.compareTo(new BigDecimal("4500")) < 0){
            valorImposto =  new ImpostoDezoitoPorcento().calculaImposto(salario.subtract(new BigDecimal("3000")));
        }else{
            valorImposto = new ImpostoVinteEOitoPorcento().calculaImposto(salario.subtract(new BigDecimal("4500")));
        }
        return  valorImposto.setScale(2);

    }

    public String verificaImpostoIsento(Pessoa pessoa) {
        BigDecimal calcula = calcula(pessoa);
        if (calcula.compareTo(new BigDecimal(BigInteger.ZERO)) == 0) {
            return  "Isento";
        }else{
            return "R$ " + calcula;
        }

    }

}
