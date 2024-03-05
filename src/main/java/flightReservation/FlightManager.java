package flightReservation;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FlightManager {
    private final List<Flight> availableFlights;
    private final ReservationManager reservationManager;


    public FlightManager() {
        this.reservationManager = new ReservationManager();
        availableFlights = new ArrayList<>();
        availableFlights.add(new Flight("CityA", "CityB", "2024-03-10", "10:00", 150.00, 5));
        availableFlights.add(new Flight("CityA", "CityC", "2024-03-10", "12:00", 120.00, 8));
        availableFlights.add(new Flight("CityB", "CityC", "2024-03-11", "14:00", 180.00, 10));
    }

    public List<Flight> searchFlights(String origin, String destination, String date, int numPassengers) {
        if (origin == null || destination == null || date == null) {
            throw new IllegalArgumentException("Origin, destination, and date cannot be null.");
        }

        List<Flight> result = new ArrayList<>();

        for (Flight flight : availableFlights) {
            if ((origin.isEmpty() || flight.getOrigin().equals(origin))
                    && (destination.isEmpty() || flight.getDestination().equals(destination))
                    && (date.isEmpty() || flight.getDate().equals(date))
                    && flight.getAvailableSeats() >= numPassengers) {
                result.add(flight);
            }
        }

        return result;
    }

    public boolean reserveFlight(Flight flight, int numPassengers) {
        return reservationManager.reserveFlight(flight, numPassengers);
    }

    public String generateConfirmation(Flight flight, String passengerName, int numPassengers, String contactInfo) {
        // Lógica para gerar a confirmação de reserva (pode ser uma simples concatenação de strings)
        String confirmation = "Reserva confirmada para " + numPassengers + " passageiro(s) em " +
                flight.getOrigin() + " com destino a " + flight.getDestination() + ".\n" +
                "Nome do passageiro: " + passengerName + "\n" +
                "Informações de contato: " + contactInfo;

        return confirmation;
    }

}