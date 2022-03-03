package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService service;


    @BeforeEach
    void setUp() {
        service = new BonusService();
    }

    @Test
    void deveLancarExceptionParaSalarioAcimaDeDezMil() {
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Dinho", LocalDate.now(), new BigDecimal("15000"))));
    }

    @Test
    void deveRetornarMensagemErroParaFuncionarioQueNaoTemDireitoBonus() {
        try {
            service.calcularBonus(new Funcionario("Dinho", LocalDate.now(), new BigDecimal("15000")));
            fail("Teste falhou");
        } catch (Exception e) {
            assertEquals("Funcionario não tem direito a bonus", e.getMessage());
        }
    }

    @Test
    void deveRetornarBonusDeQuinhentosReaisParaSalarioDeCincoMil() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Dinho", LocalDate.now(), new BigDecimal("5000")));
        assertEquals(new BigDecimal("500.0"), bonus);
    }

    @Test
    void deveRetornarBonusDeMilReais() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Dinho", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}