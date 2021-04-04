package com.leetcode.Companies.GoldmanSachs;

import javafx.event.Event;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer implements Runnable {
    private volatile boolean isEvent = false;
    ReentrantLock lock;
    private final Condition event;
    private final String val;

    ProducerConsumer() {
        lock = new ReentrantLock();
        event = lock.newCondition();
        val = "default";
        //register for the event listener
        //If we need to store the parameters for reg_cb method, we can instantiate a blocking queue for the object
        //and have that blocking queue store the parameters

        //we can have a Collections.concurrentSet if we want no duplicate entries and Order Does not matter


    }

    @Override
    public void run() {
//        while(lock.isLocked()){
        lock.lock();
        while (isEvent) {
            try {
                event.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        reg_cb(val);
    }

    public void reg_cb(String val) {


    }

    public synchronized void eventHandler(Event e) {
        //set event is true
        lock.lock();
        isEvent = true;
        //do all event handling here

        //set event to false and return
        isEvent = false;
        lock.unlock();
        event.signalAll();
    }
}
