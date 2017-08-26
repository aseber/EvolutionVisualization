package main.java.Core.Map.TileState;

import java.awt.*;

/**
 * Created by asebe on 10/18/2016.
 */
public class SandState extends BaseTileState {

    // Produces very little land food

    public SandState(float height) {

        super(new Color(240, 240,  64), new Color(200, 200,  32), height);

    }

    public double getNextEnergy() {

        return randomGenerator.nextInt(5);

    }

}
