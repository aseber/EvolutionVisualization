package main.java.Core.Map.TileState;

import java.awt.*;

/**
 * Created by asebe on 10/17/2016.
 */
public class DeepWaterState extends BaseTileState {

    // Produces a lot of seafood

    public DeepWaterState(float height) {

        super(new Color(0, 0, 128), new Color(0, 0, 85), height);

    }

    public double getNextEnergy() {

        return randomGenerator.nextInt(35);

    }

}
