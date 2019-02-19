package com.ticketmgr.rohit.service.impl;

import com.ticketmgr.rohit.Utility.Utilities;
import com.ticketmgr.rohit.model.Seat;
import com.ticketmgr.rohit.model.SeatHold;
import com.ticketmgr.rohit.model.SeatStatus;
import com.ticketmgr.rohit.repository.RepositoryVenue;
import com.ticketmgr.rohit.service.TicketService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

@Service
public class TicketServiceImpl implements TicketService {

    int timeOut = 40;

    @Autowired
    RepositoryVenue repositoryVenue;




    @Override
    public int numSeatsAvailable() {
        return repositoryVenue.getAvailableSeats();
    }

    @Override
    public synchronized SeatHold findAndHoldSeats(int numSeats, String customerEmail) {

        List<Seat> lst = new ArrayList<>();

        if (numSeats > numSeatsAvailable()){
            System.out.println("Number of Seats requested are not available, Please try with a lesser number");
            return null;
        }else{
            String primaryId = Utilities.createID();
            SeatHold seatHold = new SeatHold(primaryId, customerEmail, numSeats);

            // Get Seats that are available
            // @Todo ask for number for seats, Email ID.
            // either hold all of the seats or some of them.

            lst = repositoryVenue.getSeatsAvailable(numSeats);
            if(lst!=null){
                for(Seat seat : lst){
                    seat.setStatus(SeatStatus.HELD);
                }
                repositoryVenue.addSeats(lst);
            }

            // Save Seats in repo
            repositoryVenue.saveSeatHold(seatHold);

            return seatHold;

        }

    }

    @Override
    public String reserveSeats(int seatHoldId, String customerEmail) {
        return null;
    }



    static class Task extends TimerTask {
        public Task() {
        }

        public void run() {

        }
    }




}
