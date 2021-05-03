package br.com.tiago.calculaimposto.imposto;

import java.math.BigDecimal;

public class ImpostoVinteEOitoPorcento extends Imposto {
    @Override
    public BigDecimal calculaImposto(BigDecimal salario) {
        BigDecimal imposto = salario.multiply(new BigDecimal("0.28"));
        return imposto.add(new BigDecimal("350"));
    }
}
