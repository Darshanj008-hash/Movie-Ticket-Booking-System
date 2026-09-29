package com.reva.movie.model;

public class Ticket implements Payable {
    public static final double GST_RATE = 0.18;
    private final String ticketId;
    private Movie movie;
    private Customer customer;
    private SeatType seatType;
    private int seatCount;
    private boolean paid;

    public Ticket(String ticketId, Movie movie, Customer customer, SeatType seatType, int seatCount) {
        this.ticketId = ticketId;
        this.movie = movie;
        this.customer = customer;
        this.seatType = seatType;
        this.seatCount = seatCount;
        this.paid = false;
    }

    @Override
    public double calculateAmount() {
        double base = seatType.getPrice() * seatCount;
        double serviceFee = 20.0 * seatCount;
        return base + serviceFee + (base * GST_RATE);
    }

    public void markPaid() { paid = true; }
    public String getTicketId() { return ticketId; }
    public Movie getMovie() { return movie; }
    public Customer getCustomer() { return customer; }
    public SeatType getSeatType() { return seatType; }
    public int getSeatCount() { return seatCount; }
    public boolean isPaid() { return paid; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ticket)) return false;
        Ticket other = (Ticket) obj;
        return ticketId.equalsIgnoreCase(other.ticketId);
    }

    @Override
    public String toString() {
        return String.format("Ticket{%s, movie='%s', seats=%d, type=%s, amount=%.2f, paid=%s}",
                ticketId, movie.getTitle(), seatCount, seatType, calculateAmount(), paid);
    }
}
