package flightReservation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import flightReservation.FlightManager.*;

class PPETest {

    FlightManager manager;

    @BeforeEach
    void setUp() {
        manager = new FlightManager();
    }

    @Test
    @DisplayName("Testa Criação de Voo")
    void testCreateFlight() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", LocalDate.of(2024, 4, 1), 2);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);

        assertEquals(1, manager.getFlights().size());
        assertEquals(flight, manager.getFlights().get(0));
    }

    @Test
    @DisplayName("Testa Voo com Número Inválido de Passageiros")
    void testFlightWithInvalidPassengerNumber() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", LocalDate.of(2024, 4, 1), 0);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);

        assertEquals(0, manager.getFlights().size());
    }

    @Test
    @DisplayName("Testa Voo com Data Inválida")
    void testFlightWithInvalidDate() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", LocalDate.of(2023, 3, 1), 2);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);

        assertEquals(0, manager.getFlights().size());
    }

    @Test
    @DisplayName("Testa Remoção de Voo")
    void testRemoveFlight() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", LocalDate.of(2024, 4, 1), 2);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);

        manager.removeFlight(0);
        assertEquals(0, manager.getFlights().size());
    }

    @Test
    @DisplayName("Testa Atualização de Voo")
    void testUpdateFlight() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", LocalDate.of(2024, 4, 1), 2);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);
        flight.setDestination("New York");
        manager.updateFlight(0, flight);

        assertEquals(flight, manager.getFlights().get(0));
    }
}