package main.java.Core.Map.TileState;

import java.awt.*;

/**
 * Created by asebe on 10/17/2016.
 */
public class GrassState extends BaseTileState {

    // Produces a lot of land food

    public GrassState(float height) {

        super(new Color(32, 140, 0), new Color(9, 106, 9), height);

    }

    public double getNextEnergy() {

        return randomGenerator.nextInt(30);

    }

}
