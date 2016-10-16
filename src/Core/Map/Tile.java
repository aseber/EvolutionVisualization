package Core.Map;

import Core.GameObjects.Updatable;
import Gui.Drawable;

import java.awt.*;
import java.util.Random;

/**
 * Created by asebe on 10/15/2016.
 */
public class Tile implements Drawable, Updatable {

    private static Random randomGenerator = new Random(System.currentTimeMillis());
    private int energy;
    private Point location;

    public Tile(Point location) {

        this.location = location;
        this.energy = randomGenerator.nextInt(2000);

    }

    public void update() {

        addEnergy(randomGenerator.nextInt(35));

    }

    private void addEnergy(int energy) {

        this.energy += energy;

    }

    private int getEnergy() {

        return energy;

    }

    public void draw(Graphics g) {

        double ys = ((double) (Math.min(10000, getEnergy())) / 10000.0);

        double xs = 1.0 - ys;

        Color currentColor = new Color((int) (255 * xs), (int) (255 * ys), 0);

        g.setColor(currentColor);

        int x = getLocation().x;
        int y = getLocation().y;

        g.fillRect(x * 7, y * 7, 7, 7);

        g.setColor(Color.WHITE);
        g.drawRect(x * 7, y * 7, 7, 7);

    }

    public Point getLocation() {

        return location;

    }

}
