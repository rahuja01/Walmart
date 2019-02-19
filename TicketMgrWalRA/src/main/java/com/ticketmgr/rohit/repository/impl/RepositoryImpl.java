package com.ticketmgr.rohit.repository.impl;

import com.ticketmgr.rohit.model.Seat;
import com.ticketmgr.rohit.model.SeatHold;
import com.ticketmgr.rohit.model.SeatStatus;
import com.ticketmgr.rohit.repository.RepositoryVenue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.*;

public class RepositoryImpl implements RepositoryVenue {



    int countSeatsAvail;
    // contains the available seats - FIFO for the customer.
    PriorityBlockingQueue<Seat> availSeats =null;

    // Map to hold and allocate the seats.
    ConcurrentHashMap<String, SeatHold> heldSeats = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, SeatHold> allocatedSeats= new ConcurrentHashMap<>();

    ScheduledExecutorService service = null;

    public RepositoryImpl(int countSeatsAvail) {

        this.countSeatsAvail = countSeatsAvail;
        availSeats = new PriorityBlockingQueue<>(countSeatsAvail);

    }

    public int getAvailableSeats() {
        return countSeatsAvail;
    }

    @Override
    public List<Seat> getSeatsAvailable(int numOfSeats) {

        List<Seat> seatList = new ArrayList<>();

        while (numOfSeats > 0) {
            seatList.add(availSeats.poll());
            numOfSeats--;
        }

        return seatList;
    }

    @Override
    public void saveSeatHold(SeatHold seatHold) {

        countSeatsAvail = countSeatsAvail - seatHold.getNumSeats();

        service = Executors.newSingleThreadScheduledExecutor();

        Runnable runnableTask = new Runnable() {
            @Override
            public void run() {

                {
                    try {
                        Thread.sleep(20000);
                        if (seatHold.getNumSeats() > 0 && seatHold.getSeatsLst().get(0).getStatus() == SeatStatus.HELD) {
                            for (Seat seat : seatHold.getSeatsLst()) {
                                seat.setStatus(SeatStatus.FREE);
                                availSeats.remove(seat);
                            }
                            addSeats(seatHold.getSeatsLst());
                            countSeatsAvail += seatHold.getSeatsLst().size();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        };

        service.schedule(runnableTask, 0, TimeUnit.MILLISECONDS);


    }

    @Override
    public SeatHold findSeatHold(int seatHoldId) {
        return null;
    }

    @Override
    public void addSeats(List<Seat> seats) {

    }
}
