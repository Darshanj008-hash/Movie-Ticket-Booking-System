package com.reva.movie.service;

import com.reva.movie.model.Customer;
import com.reva.movie.model.Movie;
import com.reva.movie.model.Payable;
import com.reva.movie.model.SeatType;
import com.reva.movie.model.Ticket;

public class BookingService {
    private static final int MAX_TICKETS = 50;
    private final Ticket[] tickets = new Ticket[MAX_TICKETS];
    private int ticketCount;
    private int nextTicketNumber = 1001;

    public Ticket book(Customer customer, Movie movie, SeatType seatType, int seatCount) {
        if (movie == null || seatCount <= 0 || ticketCount >= MAX_TICKETS) return null;
        String ticketId = "T" + nextTicketNumber++;
        Ticket ticket = new Ticket(ticketId, movie, customer, seatType, seatCount);
        tickets[ticketCount++] = ticket;
        return ticket;
    }

    public void pay(Ticket ticket) {
        if (ticket == null) return;
        Payable payable = ticket; // interface reference accessing implementation
        System.out.printf("Amount payable: Rs. %.2f%n", payable.calculateAmount());
        ticket.markPaid();
        payable.printPaymentStatus();
    }

    public void listTickets() {
        if (ticketCount == 0) {
            System.out.println("No bookings found.");
            return;
        }
        System.out.println("\nBooking History");
        System.out.println("---------------");
        for (int i = 0; i < ticketCount; i++) {
            System.out.println(tickets[i]);
        }
    }

    public int getTicketCount() { return ticketCount; }
}
