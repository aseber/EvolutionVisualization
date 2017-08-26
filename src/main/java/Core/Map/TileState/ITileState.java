package main.java.Core.Map.TileState;

import main.java.Core.Map.Tile;

import java.awt.*;

/**
 * Created by asebe on 10/17/2016.
 */
public interface ITileState {

    Color getColor(double value);
    double getNextEnergy();
    void update(Tile tile, double interpolationDelta);
    //double getEffectiveness();

}
