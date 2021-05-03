package br.com.tiago.calculaimposto.imposto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ImpostoIsento extends Imposto {
    @Override
    public BigDecimal calculaImposto(BigDecimal salario) {

        return new BigDecimal(BigInteger.ZERO);
    }


}
