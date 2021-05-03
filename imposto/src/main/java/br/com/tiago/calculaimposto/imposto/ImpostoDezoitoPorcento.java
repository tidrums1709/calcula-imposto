package br.com.tiago.calculaimposto.imposto;

import java.math.BigDecimal;

public class ImpostoDezoitoPorcento extends Imposto {
    @Override
    public BigDecimal calculaImposto(BigDecimal salario) {
        BigDecimal imposto = salario.multiply(new BigDecimal("0.18"));
        return imposto.add(new BigDecimal("80"));
    }


}
