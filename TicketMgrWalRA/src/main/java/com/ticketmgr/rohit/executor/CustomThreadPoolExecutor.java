package com.ticketmgr.rohit.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor implements Runnable {

    public static final int RESTART_THREAD = 1;
    public static final int STOP_APP = 2;


    private boolean isRunning = false;
    private long monitortime = 60000;
    private static int defaultPoolCoreSize = 5;

    private static int keepAliveTime = 360000;
    private String executorName = null;


    public CustomThreadPoolExecutor(int maxWorkerThreads, String name ) {

        // Initialize & setup ThreadPoolExecutor
        super(defaultPoolCoreSize, maxWorkerThreads, keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>() );
        this.executorName = name;
        //this.setThreadFactory( new MailingThreadFactory( name ) );
        //this.setRejectedExecutionHandler( new RejectedMailingTaskHandler() );

        //setting thread pool name
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {



    }
}
