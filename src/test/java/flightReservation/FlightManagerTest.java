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
}