package br.com.tiago.calculaimposto.imposto;

import java.math.BigDecimal;

public class ImpostoOitoPorcento extends Imposto {
    @Override
    public BigDecimal calculaImposto(BigDecimal salario) {

        return salario.multiply(new BigDecimal("0.08"));
    }


}
