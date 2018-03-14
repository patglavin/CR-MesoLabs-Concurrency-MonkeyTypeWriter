package Java.zipcoder;

import io.zipcoder.Copier;
import io.zipcoder.SafeCopier;

public class Test {
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

    @org.junit.Test
    public void safeTest(){
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
        System.out.println(safeCopier.copied);
        //assert.(safeCopier.copied, introduction);
    }
}
