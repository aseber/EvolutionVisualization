package main.java.Core.Map.TileState;

import java.awt.*;

/**
 * Created by asebe on 10/18/2016.
 */
public class RockState extends BaseTileState {

    // Produces a small amount of land food

    public RockState(float height) {

        super(new Color(128, 128, 128), new Color(120, 160, 120), height);

    }

    public double getNextEnergy() {

        return randomGenerator.nextInt(5);

    }

}
