package main.java.Core.Map.TileState;

import java.awt.*;

/**
 * Created by asebe on 10/17/2016.
 */
public class ShallowWaterState extends BaseTileState {

    // Produces a small/medium amount of seafood

    public ShallowWaterState(float height) {

        super(new Color(0, 0, 255), new Color(0, 0, 150), height);

    }

    public double getNextEnergy() {

        return randomGenerator.nextInt(15);

    }

}
