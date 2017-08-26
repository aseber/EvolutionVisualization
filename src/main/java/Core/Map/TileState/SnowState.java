package main.java.Core.Map.TileState;

import main.java.Core.Map.Tile;

import java.awt.*;

/**
 * Created by asebe on 10/18/2016.
 */
public class SnowState implements ITileState {

    private final float height;

    // Produces no food

    public SnowState(float height) {

        this.height = height;

    }

    public void update(Tile tile, double interpolationDelta) { }

    public Color getColor(double value) {

        return Color.WHITE;

    }

    public double getNextEnergy() {

        return 0;

    }

}
