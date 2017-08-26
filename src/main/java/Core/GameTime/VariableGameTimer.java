package main.java.Core.GameTime;

import java.util.ArrayList;

/**
 * Created by Austin Seber2 on 10/16/2016.
 */
public class VariableGameTimer {

    private ArrayList<InterpolatedTimerAction> events = new ArrayList<>();
    private boolean running = false, paused = false;
    private final double optimumTime;
    private final Thread gameLoop;
    private int ups;
    private final Object lock = new Object();

    public VariableGameTimer(long targetUps) {

        optimumTime = 1000000000.0 / targetUps;
        Thread gameLoop = new Thread(getGameLoopRunnable());
        this.gameLoop = gameLoop;

    }

    private Runnable getGameLoopRunnable() {

        return () -> {

            long lastLoopTime = System.nanoTime();
            int ups = 0;
            long lastUpsTime = 0;

            while (running) {

                if (!paused) {

                    long now = System.nanoTime();
                    long updateLength = now - lastLoopTime;
                    double delta = updateLength / optimumTime;

                    if (delta >= 1.0) {

                        lastLoopTime = now;

                        lastUpsTime += updateLength;
                        ups += delta;

                        if (lastUpsTime >= 1000000000) {
                            this.ups = ups;
                            lastUpsTime = 0;
                            ups = 0;
                        }

                        synchronized (lock) {

                            for (InterpolatedTimerAction event : events) {

                                event.ActionPerformed(delta);

                            }

                        }

                    }

                }

            }

        };

    }

    public void addAction(InterpolatedTimerAction action) {

        synchronized (lock) {

            events.add(action);

        }

    }

    public void removeAction(InterpolatedTimerAction action) {

        synchronized (lock) {

            events.remove(action);

        }

    }

    public int getUps() {

        return ups;

    }

    public void start() {

        running = true;
        gameLoop.start();

    }

    public void stop() {

        running = false;

    }

    public void pause() {

        paused = true;

    }

    public void resume() {

        paused = false;

    }

}
