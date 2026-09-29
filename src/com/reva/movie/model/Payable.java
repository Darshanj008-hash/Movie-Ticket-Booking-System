package com.reva.movie.model;

public interface Payable {
    double calculateAmount();
    default void printPaymentStatus() {
        System.out.println("Payment amount calculated successfully.");
    }
}
