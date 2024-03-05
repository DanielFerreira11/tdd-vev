package flightReservation;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlightManagerTest {

    @Test
    public void searchFlights_ReturnsListOfFlights() {
        FlightManager flightManager = new FlightManager();
        String origin = "CityA";
        String destination = "CityB";
        String date = "2024-03-10";
        int numPassengers = 2;

        List<Flight> result = flightManager.searchFlights(origin, destination, date, numPassengers);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    // Exemplo para um caso em que a origem e a data são opcionais
    @Test
    public void searchFlights_ReturnsListOfFlights_ptional() {
        FlightManager flightManager = new FlightManager();
        String destination = "CityB";
        int numPassengers = 2;

        List<Flight> result = flightManager.searchFlights("", destination, "", numPassengers);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void reserveFlight_ReturnsTrue_WhenSeatsAvailable() {
        FlightManager flightManager = new FlightManager();
        Flight flight = new Flight("CityA", "CityB", "2024-03-10", "10:00", 150.00, 5);
        int numPassengers = 2;

        boolean result = flightManager.reserveFlight(flight, numPassengers);

        assertTrue(result);
        assertEquals(3, flight.getAvailableSeats()); // Verifica se os assentos foram atualizados corretamente
    }

    @Test
    public void reserveFlight_ReturnsFalse_WhenNotEnoughSeats() {
        FlightManager flightManager = new FlightManager();
        Flight flight = new Flight("CityA", "CityB", "2024-03-10", "10:00", 150.00, 2);
        int numPassengers = 4;

        boolean result = flightManager.reserveFlight(flight, numPassengers);

        assertFalse(result);
        assertEquals(2, flight.getAvailableSeats()); // Verifica se os assentos não foram alterados
    }

    @Test
    public void generateConfirmation_ReturnsCorrectConfirmation() {
        FlightManager flightManager = new FlightManager();
        Flight flight = new Flight("CityA", "CityB", "2024-03-10", "10:00", 150.00, 5);
        String passengerName = "John Doe";
        int numPassengers = 2;
        String contactInfo = "john@example.com";


        flightManager.reserveFlight(flight, numPassengers);
        String confirmation = flightManager.generateConfirmation(flight, passengerName, numPassengers, contactInfo);

        assertNotNull(confirmation);
        assertTrue(confirmation.contains("Reserva confirmada"));
        assertTrue(confirmation.contains("Nome do passageiro: " + passengerName));
        assertTrue(confirmation.contains("Informações de contato: " + contactInfo));
    }

}