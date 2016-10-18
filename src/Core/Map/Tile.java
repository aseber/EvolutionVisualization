package Core.Map;

import Core.GameObjects.Updatable;
import Gui.Drawable;
import Utilities.ColorFinder;

import java.awt.*;
import java.util.Random;

/**
 * Created by asebe on 10/15/2016.
 */
public class Tile implements Drawable, Updatable {

    public static int TILE_SIZE = 7;

    private static Random randomGenerator = new Random(System.currentTimeMillis());
    private int energy;
    private Point location;
    private ColorFinder color = new ColorFinder(new Color(150, 95, 0), new Color(38, 106, 46));

    public Tile(Point location) {

        this.location = location;
        this.energy = randomGenerator.nextInt(2500);

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

        g.setColor(color.getColorInRange(Math.min(10000, getEnergy()), 10000));

        int x = getLocation().x * TILE_SIZE;
        int y = getLocation().y * TILE_SIZE;

        g.fillRect(x, y, TILE_SIZE, TILE_SIZE);

        g.setColor(Color.WHITE);
        g.drawRect(x, y, TILE_SIZE, TILE_SIZE);

    }

    public Point getLocation() {

        return location;

    }

}
