package io.zipcoder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    public SafeCopier(String toCopy) {
        super(toCopy);
    }
    Lock lock = new ReentrantLock();

    public void run() {
        boolean continuing = true;
        try {
            TimeUnit.MILLISECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (continuing) {
            if (lock.tryLock()){
                if (this.stringIterator.hasNext()) {
                    this.copied += stringIterator.next() + " " + Thread.currentThread().getName() + " ";
                } else continuing = false;
                lock.unlock();
            }
        }
    }
}
