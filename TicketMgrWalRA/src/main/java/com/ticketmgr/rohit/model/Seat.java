package com.ticketmgr.rohit.model;

public class Seat {

    private int number;
    private SeatStatus status;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "number=" + number +
                ", status=" + status +
                '}';
    }

}
