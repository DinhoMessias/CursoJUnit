package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReajusteServiceTest {

    @Test
    void deveCalcularReajusteParaDesempenhoADesejar(){
        //cenario
        ReajusteService service = new ReajusteService();
        Funcionario func = new Funcionario("Dinho", LocalDate.now(), new BigDecimal("1000"));

        //acao
        service.calcularReajuste(func, Desempenho.A_DESEJAR);

        //verificacao
        assertEquals(new BigDecimal("1030.00"), func.getSalario());
    }

    @Test
    void deveCalcularReajusteParaDesempenhoBom(){
        //cenario
        ReajusteService service = new ReajusteService();
        Funcionario func = new Funcionario("Dinho", LocalDate.now(), new BigDecimal("1000"));

        //acao
        service.calcularReajuste(func, Desempenho.BOM);

        //verificacao
        assertEquals(new BigDecimal("1150.00"), func.getSalario());
    }

    @Test
    void deveCalcularReajusteParaDesempenhoOtimo(){
        //cenario
        ReajusteService service = new ReajusteService();
        Funcionario func = new Funcionario("Dinho", LocalDate.now(), new BigDecimal("1000"));

        //acao
        service.calcularReajuste(func, Desempenho.OTIMO);

        //verificacao
        assertEquals(new BigDecimal("1200.00"), func.getSalario());
    }
}
