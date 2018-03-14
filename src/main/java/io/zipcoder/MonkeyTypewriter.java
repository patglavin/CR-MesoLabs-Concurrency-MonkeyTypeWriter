package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.


//        Copier unsafeCopier = new UnsafeCopier(introduction);
//        Thread[] unsafeThreads = new Thread[] {new Thread(unsafeCopier), new Thread(unsafeCopier), new Thread(unsafeCopier), new Thread(unsafeCopier), new Thread(unsafeCopier)};
//        for (Thread thread : unsafeThreads) {
//            thread.start();
//        }

        Copier safeCopier = new SafeCopier(introduction);
        Thread[] safeThreads = new Thread[] {new Thread(safeCopier), new Thread(safeCopier), new Thread(safeCopier), new Thread(safeCopier), new Thread(safeCopier)};
        for (Thread thread : safeThreads) {
            thread.start();
        }
//        for (int j = 0; j < safeArray.length; j++) safeArray[j].start();



        for(Thread thread : safeThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // Print out the copied versions here.
        //System.out.println(unsafeCopier.copied);
        System.out.println("---------------------------------------");
        System.out.println(safeCopier.copied);
    }
}