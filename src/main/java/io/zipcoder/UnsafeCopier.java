package io.zipcoder;

import java.util.concurrent.TimeUnit;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (this.stringIterator.hasNext()) {
            String s = stringIterator.next();
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            this.copied += sb.toString() + " " + Thread.currentThread().getName() + " ";
        }
    }
}
