package main.java.Core.Map;

import main.java.Core.GameObjects.Updatable;
import main.java.Core.Map.TileState.ITileState;
import main.java.Core.Map.TileState.TileStateFactory;
import main.java.Gui.Drawable;

import java.awt.*;
import java.util.Random;

/**
 * Created by asebe on 10/15/2016.
 */
public class Tile implements Drawable, Updatable {

    public static int TILE_SIZE = 4;

    private static final Random randomGenerator = new Random(System.currentTimeMillis());
    private double energy;
    private Point location;
    private ITileState tileState;

    public Tile(Point location, float height) {

        this.location = location;
        this.energy = randomGenerator.nextInt(2500);
        this.tileState = TileStateFactory.getTileState(height);

    }

    public void update(double interpolationDelta) {

        tileState.update(this, interpolationDelta);

    }

    public void addEnergy(double energy) {

        this.energy += energy;

    }

    private double getEnergy() {

        return energy;

    }

    public void draw(Graphics g) {

        g.setColor(tileState.getColor(Math.min(10000.0, getEnergy())));

        int x = getLocation().x * TILE_SIZE;
        int y = getLocation().y * TILE_SIZE;

        g.fillRect(x, y, TILE_SIZE, TILE_SIZE);

        //g.setColor(Color.WHITE);
        //g.drawRect(x, y, TILE_SIZE, TILE_SIZE);

    }

    public Point getLocation() {

        return location;

    }

}
