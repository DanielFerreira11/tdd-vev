import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReservaTest {

    @Test
    @DisplayName("Testa Reserva Válida com Destino e Origem Diferentes e Data Válida")
    public void testReservaValida_DestinoOrigemDiferentesDataValida() {
        Reserva reserva = new Reserva("São Paulo", "Rio de Janeiro", "2024-04-01", 2);
        assertTrue(reserva.ehReservaValida());
    }

    @Test
    @DisplayName("Testa Reserva Inválida com Destino e Origem Vazios e Data Válida e Número de Passageiros Inválido")
    public void testReservaInvalida_DestinoOrigemVaziosDataValidaNumPassageirosInvalido() {
        Reserva reserva = new Reserva("", "", "2023-03-01", 0);
        assertFalse(reserva.ehReservaValida());
    }

    @Test
    @DisplayName("Testa Cadastro Válido com Nome, Número de Contato e Email do Passageiro Válidos")
    public void testCadastroValido_NomeNumContatoPassageiroValido() {
        Passageiro passageiro = new Passageiro("João Silva", "1", "joão@email.com");
        assertTrue(passageiro.ehCadastroValido());
    }

    @Test
    @DisplayName("Testa Cadastro Inválido com Nome e Número de Passageiro Vazios e Email do Passageiro Válido")
    public void testCadastroInvalido_NomeNumPassageiroVaziosContatoValido() {
        Passageiro passageiro = new Passageiro("", "", "joão@email.com");
        assertFalse(passageiro.ehCadastroValido());
    }
}