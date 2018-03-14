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

        Copier unsafeCopier = new UnsafeCopier(introduction);
        Thread unsafethread = new Thread(unsafeCopier);
        Thread unsafethread1 = new Thread(unsafeCopier);
        Thread unsafethread2 = new Thread(unsafeCopier);
        Thread unsafethread3 = new Thread(unsafeCopier);
        Thread unsafethread4 = new Thread(unsafeCopier);
        unsafethread.start();
        unsafethread1.start();
        unsafethread2.start();
        unsafethread3.start();
        unsafethread4.start();


        Copier safeCopier = new SafeCopier(introduction);
        Thread safethread = new Thread(safeCopier);
        Thread safethread1 = new Thread(safeCopier);
        Thread safethread2 = new Thread(safeCopier);
        Thread safethread3 = new Thread(safeCopier);
        Thread safethread4 = new Thread(safeCopier);
        safethread.start();
        safethread1.start();
        safethread2.start();
        safethread3.start();
        safethread4.start();
//        for (int j = 0; j < safeArray.length; j++) safeArray[j].start();



        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(unsafeCopier.copied);
        System.out.println("---------------------------------------");
        System.out.println(safeCopier.copied);
    }
}