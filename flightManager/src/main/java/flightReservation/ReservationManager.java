package flightReservation;

import java.util.HashMap;
import java.util.Map;

public class ReservationManager {
    private final Map<String, Flight> reservations;

    public ReservationManager() {
        this.reservations = new HashMap<>();
    }

    public boolean reserveFlight(Flight flight, int numPassengers) {
        if (flight.getAvailableSeats() >= numPassengers) {
            String reservationCode = generateReservationCode();

            flight.setAvailableSeats(flight.getAvailableSeats() - numPassengers);
            reservations.put(reservationCode, flight);

            return true;
        } else {
            return false;
        }
    }

    public boolean cancelReservation(String reservationCode,int numPassengers ) {
        if (reservations.containsKey(reservationCode)) {
            Flight flight = reservations.get(reservationCode);

            flight.setAvailableSeats(flight.getAvailableSeats() + numPassengers);

            reservations.remove(reservationCode);

            return true;
        } else {
            return false;
        }
    }

    // Método simples para gerar um código de reserva
    private String generateReservationCode() {
        return "RES" + reservations.size();
    }
}
