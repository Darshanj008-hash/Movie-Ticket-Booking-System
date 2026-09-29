package com.reva.movie.model;

public enum SeatType {
    REGULAR(150.0), PREMIUM(220.0), RECLINER(300.0);

    private final double price;

    SeatType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
