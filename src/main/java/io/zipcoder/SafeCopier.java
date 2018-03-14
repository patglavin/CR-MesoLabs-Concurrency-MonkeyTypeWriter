package io.zipcoder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    boolean running =true;

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while (running) syncWrite();
    }

    private synchronized void syncWrite() {
        if (this.stringIterator.hasNext()) {
            this.copied += stringIterator.next() + " " + Thread.currentThread().getName() + " ";
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else running = false;
    }
}
