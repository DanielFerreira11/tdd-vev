package flightReservation;

public class ReservationManager {
    public boolean reserveFlight(Flight flight, int numPassengers) {
        if (flight.getAvailableSeats() >= numPassengers) {
            // Realiza a reserva (pode envolver atualização de banco de dados, se aplicável)
            flight.setAvailableSeats(flight.getAvailableSeats() - numPassengers);
            return true; // Reserva bem-sucedida
        } else {
            return false; // Não há assentos suficientes
        }
    }
}
