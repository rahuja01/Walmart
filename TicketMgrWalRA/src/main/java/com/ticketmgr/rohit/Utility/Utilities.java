package com.ticketmgr.rohit.Utility;

import java.util.concurrent.atomic.AtomicLong;

public class Utilities {

    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }

}
