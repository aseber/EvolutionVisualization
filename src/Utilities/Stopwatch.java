package Utilities;

/**
 * Created by asebe on 10/16/2016.
 */
public class Stopwatch {

    private boolean started;
    private long startTime;
    private long endTime;

    public void start() {

        if (!started) {

            started = true;
            startTime = System.nanoTime();

        }

    }

    public void stop() {

        if (started) {

            endTime = System.nanoTime();
            started = false;

        }

    }

    public long getElapsedNanoseconds() {

        return endTime - startTime;

    }

    public long getElapsedMilliseconds() {

        return getElapsedNanoseconds() / 1000000;

    }

    public long getElapsedSeconds() {

        return getElapsedNanoseconds() / 1000000000;

    }

}
