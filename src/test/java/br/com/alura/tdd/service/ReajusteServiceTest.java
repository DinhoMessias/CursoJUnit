package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario func;

    @BeforeEach
    void setUp() {
        service = new ReajusteService();
        func = new Funcionario("Dinho", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    void deveCalcularReajusteParaDesempenhoADesejar(){
        service.calcularReajuste(func, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), func.getSalario());
    }

    @Test
    void deveCalcularReajusteParaDesempenhoBom(){
        service.calcularReajuste(func, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), func.getSalario());
    }

    @Test
    void deveCalcularReajusteParaDesempenhoOtimo(){
        service.calcularReajuste(func, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), func.getSalario());
    }
}
