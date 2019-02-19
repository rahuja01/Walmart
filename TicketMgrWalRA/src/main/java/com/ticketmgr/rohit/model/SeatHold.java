package com.ticketmgr.rohit.model;

import java.util.ArrayList;
import java.util.List;

public class SeatHold {

    private String id;
    //private String customerName;
    int numSeats;
    private String customerEmail;

    private List<Seat> seatsLst = new ArrayList<>();

    public SeatHold(String id, String customerEmail, int numSeats) {
        this.id = id;
        //this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.numSeats = numSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Seat> getSeatsLst() {
        return seatsLst;
    }

    public void setSeatsLst(List<Seat> seatsLst) {
        this.seatsLst = seatsLst;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }



}
