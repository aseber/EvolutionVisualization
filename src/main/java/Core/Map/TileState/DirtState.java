package main.java.Core.Map.TileState;

import java.awt.*;

/**
 * Created by asebe on 10/18/2016.
 */
public class DirtState extends BaseTileState {

    // Produces a medium amount of land food

    public DirtState(float height) {

        super(new Color(140, 102, 0), new Color(120, 72, 0), height);

    }

    public double getNextEnergy() {

        return randomGenerator.nextInt(20);

    }

}
