package com.leetcode.Companies.GooglePrep;

import java.util.HashMap;

public class Logger {
    HashMap<String, Integer> lastPrint;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        this.lastPrint = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (lastPrint.containsKey(message) && timestamp - lastPrint.get(message) >= 10) {
            lastPrint.put(message, timestamp);
            return true;
        } else if (!lastPrint.containsKey(message)) {
            lastPrint.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
}
