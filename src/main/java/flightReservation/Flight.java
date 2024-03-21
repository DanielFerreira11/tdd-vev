package flightReservation;

public class Flight {
    private String origin;
    private String destination;
    private String date;
    private String time;
    private double price;
    private int availableSeats;

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Flight(String origin, String destination, String date, String time, double price, int availableSeats) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}