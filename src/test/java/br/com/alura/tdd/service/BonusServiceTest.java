package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void deveLancarExceptionParaSalarioAcimaDeDezMil() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Dinho", LocalDate.now(), new BigDecimal("15000"))));
    }

    @Test
    void deveRetornarMensagemErroParaFuncionarioQueNaoTemDireitoBonus(){
        BonusService service = new BonusService();

        try {
            service.calcularBonus(new Funcionario("Dinho", LocalDate.now(), new BigDecimal("15000")));
            fail("Teste falhou");
        } catch (Exception e){
            assertEquals("Funcionario não tem direito a bonus", e.getMessage());
        }
    }

    @Test
    void deveRetornarBonusDeQuinhentosReaisParaSalarioDeCincoMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Dinho", LocalDate.now(), new BigDecimal("5000")));

        assertEquals(new BigDecimal("500.0"), bonus);
    }

    @Test
    void deveRetornarBonusDeMilReais() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Dinho", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }

}