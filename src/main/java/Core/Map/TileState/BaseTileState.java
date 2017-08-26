package main.java.Core.Map.TileState;

import main.java.Core.Map.Tile;
import main.java.Utils.GradientColor;

import java.awt.*;
import java.util.Random;

/**
 * Created by asebe on 10/19/2016.
 */
public abstract class BaseTileState implements ITileState {

    private final GradientColor foodColor;
    protected static final Random randomGenerator = new Random(System.currentTimeMillis());
    protected final float height;

    public BaseTileState(Color startColor, Color endColor, float height) {

        foodColor = new GradientColor(startColor, endColor);
        this.height = height;

    }

    public final Color getColor(double value) {

        return foodColor.getColor(value / 10000.0);

    }

    public final void update(Tile tile, double interpolationDelta) {

        tile.addEnergy(this.getNextEnergy() * interpolationDelta);

    }

}
