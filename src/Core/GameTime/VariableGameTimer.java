package Core.GameTime;

/**
 * Created by Austin Seber2 on 10/16/2016.
 */
public class VariableGameTimer {

    private final InterpolatedTimerAction event;
    private boolean running = false, paused = false;
    private final long optimumTime;
    private final Thread gameLoop;
    private int fps;

    public VariableGameTimer(long targetFps, InterpolatedTimerAction event) {

        optimumTime = 1000000000 / targetFps;
        this.event = event;
        Thread gameLoop = new Thread(getGameLoopRunnable());
        this.gameLoop = gameLoop;
        setGameLoopTitle(-1);

    }

    private Runnable getGameLoopRunnable() {

        return () -> {

            long lastLoopTime = System.nanoTime();
            int fps = 0;
            long lastFpsTime = 0;

            while (running) {

                if (!paused) {

                    long now = System.nanoTime();
                    long updateLength = now - lastLoopTime;
                    lastLoopTime = now;
                    double delta = updateLength / ((double) optimumTime);

                    lastFpsTime += updateLength;
                    fps++;

                    if (lastFpsTime >= 1000000000) {
                        setGameLoopTitle(fps);
                        this.fps = fps;
                        lastFpsTime = 0;
                        fps = 0;
                    }

                    event.ActionPerformed(delta);

                } else {



                }

            }

        };

    }

    private void setGameLoopTitle(int fps) {

        gameLoop.setName("Variable Game Timer Thread (" + fps + ")");

    }

    public int getFps() {

        return fps;

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

    public void unpause() {

        paused = false;

    }

}
