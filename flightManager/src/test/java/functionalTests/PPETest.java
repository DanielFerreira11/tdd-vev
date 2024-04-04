package functionalTests;

import static org.junit.Assert.*;
import org.junit.Test;

public class PPETest {

    @Test
    public void testReservaValida_DestinoOrigemDiferentesDataValida() {
        Reserva reserva = new Reserva("São Paulo", "Rio de Janeiro", "2024-04-01", 2);
        assertTrue(reserva.ehReservaValida());
    }

    @Test
    public void testReservaInvalida_DestinoOrigemVaziosDataValidaNumPassageirosInvalido() {
        Reserva reserva = new Reserva("", "", "2023-03-01", 0);
        assertFalse(reserva.ehReservaValida());
    }

    @Test
    public void testCadastroValido_NomeNumContatoPassageiroValido() {
        Passageiro passageiro = new Passageiro("João Silva", "1", "joão@email.com");
        assertTrue(passageiro.ehCadastroValido());
    }

    @Test
    public void testCadastroInvalido_NomeNumPassageiroVaziosContatoValido() {
        Passageiro passageiro = new Passageiro("", "", "joão@email.com");
        assertFalse(passageiro.ehCadastroValido());
    }
}