package functionalTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import flightReservation.*;

class DTTests {
    FlightManager manager = new FlightManager();

    @Test
    void testCreateFlight() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", "2024-04-01", 200, 2);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);

        assertEquals(1, manager.getFlights().size());
        assertEquals(flight, manager.getFlights().get(0));
    }

    @Test
    void testFlightWithInvalidPassengerNumber() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", "2024-04-01", 200, 0);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);

        assertEquals(0, manager.getFlights().size());
    }

    @Test
    void testFlightWithInvalidDate() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", "2024-03-01", 200, 2);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);

        assertEquals(0, manager.getFlights().size());
    }

    @Test
    void testRemoveFlight() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", "2024-04-01", 200, 2);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);

        manager.removeFlight(0);
        assertEquals(0, manager.getFlights().size());
    }

    @Test
    void testUpdateFlight() {
        Flight flight = new Flight("Voo 1", "São Paulo", "Rio de Janeiro", "2024-04-01", 200, 2);
        assertFalse(manager.getFlights().contains(flight));

        manager.addFlight(flight);
        flight.setDestination("New York");
        manager.updateFlight(0, flight);

        assertEquals(flight, manager.getFlights().get(0));
    }
}