package main.java.Core.Map.TileState;

import java.awt.*;

/**
 * Created by asebe on 10/18/2016.
 */
public class ShoreState extends BaseTileState {

    // Produces very little land food

    public ShoreState(float height) {

        super(new Color(0, 128, 255), new Color(0, 128, 255), height);

    }

    public double getNextEnergy() {

        return randomGenerator.nextInt(5);

    }

}
