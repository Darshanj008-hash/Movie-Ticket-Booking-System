package com.reva.movie.app;

import java.util.Scanner;

import com.reva.movie.model.Customer;
import com.reva.movie.model.Movie;
import com.reva.movie.model.Person;
import com.reva.movie.model.SeatType;
import com.reva.movie.model.Staff;
import com.reva.movie.model.Ticket;
import com.reva.movie.service.BookingService;
import com.reva.movie.service.MovieService;
import com.reva.movie.util.InputUtil;

public class MovieBookingApp {
    private static final String APP_NAME = "REVA Movie Ticket Booking System";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieService movieService = new MovieService();
        BookingService bookingService = new BookingService();
        Customer customer = new Customer();
        Person personReference = new Staff("Counter Staff", "9999999999", "STF01");

        System.out.println("=================================================");
        System.out.println("       " + APP_NAME);
        System.out.println("=================================================");
        System.out.println("Demo staff role: " + personReference.getRole());

        boolean running = true;
        while (running) {
            System.out.println("\n1. Register Customer");
            System.out.println("2. View Movies");
            System.out.println("3. Search Movie");
            System.out.println("4. Book Tickets");
            System.out.println("5. View Bookings");
            System.out.println("6. Exit");

            int choice = InputUtil.readInt(scanner, "Enter choice: ");
            switch (choice) {
                case 1:
                    String name = InputUtil.readText(scanner, "Name: ");
                    String phone = InputUtil.readText(scanner, "Phone: ");
                    String email = InputUtil.readText(scanner, "Email: ");
                    customer = new Customer(name, phone, email);
                    customer.printIdentity();
                    System.out.println("Customer registered: " + customer);
                    break;
                case 2:
                    movieService.listMovies();
                    break;
                case 3:
                    String query = InputUtil.readText(scanner, "Enter movie title keyword: ");
                    Movie found = movieService.findMovie(query);
                    System.out.println(found == null ? "Movie not found." : "Found: " + found);
                    break;
                case 4:
                    movieService.listMovies();
                    int movieId = InputUtil.readInt(scanner, "Enter movie ID: ");
                    Movie movie = movieService.findMovie(movieId);
                    if (movie == null) {
                        System.out.println("Invalid movie ID.");
                        break;
                    }
                    int typeChoice = InputUtil.readInt(scanner, "Seat type (1-Regular, 2-Premium, 3-Recliner): ");
                    SeatType seatType;
                    switch (typeChoice) {
                        case 1: seatType = SeatType.REGULAR; break;
                        case 2: seatType = SeatType.PREMIUM; break;
                        case 3: seatType = SeatType.RECLINER; break;
                        default:
                            System.out.println("Invalid seat type.");
                            continue;
                    }
                    int seats = InputUtil.readInt(scanner, "Number of seats: ");
                    if (seats <= 0) {
                        System.out.println("Seat count must be positive.");
                        continue;
                    }
                    Ticket ticket = bookingService.book(customer, movie, seatType, seats);
                    if (ticket == null) {
                        System.out.println("Booking failed.");
                        break;
                    }
                    bookingService.pay(ticket);
                    System.out.println("Booking successful: " + ticket.getTicketId());
                    int roundedAmount = (int) ticket.calculateAmount(); // explicit double-to-int casting
                    System.out.println("Approximate bill (int cast): Rs. " + roundedAmount);
                    break;
                case 5:
                    bookingService.listTickets();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using " + APP_NAME + ".");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.printf("Movies loaded: %d | People created: %d | Tickets booked: %d%n",
                movieService.getMovieCount(), Person.getPersonCount(), bookingService.getTicketCount());
        scanner.close();
    }
}
