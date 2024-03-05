package flightReservation;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationManagerTest {

    @Test
    public void reserveFlight_ReturnsTrue_WhenSeatsAvailable() {
        ReservationManager reservationManager = new ReservationManager();
        Flight flight = new Flight("CityA", "CityB", "2024-03-10", "10:00", 150.00, 5);
        int numPassengers = 2;

        boolean result = reservationManager.reserveFlight(flight, numPassengers);

        assertTrue(result);
        assertEquals(3, flight.getAvailableSeats()); // Verifica se os assentos foram atualizados corretamente
    }

    @Test
    public void reserveFlight_ReturnsFalse_WhenNotEnoughSeats() {
        ReservationManager reservationManager = new ReservationManager();
        Flight flight = new Flight("CityA", "CityB", "2024-03-10", "10:00", 150.00, 2);
        int numPassengers = 4;

        boolean result = reservationManager.reserveFlight(flight, numPassengers);

        assertFalse(result);
        assertEquals(2, flight.getAvailableSeats()); // Verifica se os assentos não foram alterados
    }

}