package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void calcularReajuste(Funcionario func, Desempenho desempenho) {
        BigDecimal percentualReajuste = desempenho.getPercentualReajuste();
        BigDecimal valorReajuste = func.getSalario().multiply(percentualReajuste);
        func.realizarReajuste(valorReajuste);
    }
}

