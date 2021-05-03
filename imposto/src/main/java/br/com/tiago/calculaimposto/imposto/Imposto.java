package br.com.tiago.calculaimposto.imposto;

import java.math.BigDecimal;

public abstract class Imposto {
    
    public abstract BigDecimal calculaImposto(BigDecimal salario);

}
