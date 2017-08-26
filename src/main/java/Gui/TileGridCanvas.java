package main.java.Gui;

import main.java.Core.Map.Tile;
import main.java.Core.Map.TileGrid;

import java.awt.*;

/**
 * Created by asebe on 10/15/2016.
 */
public class TileGridCanvas extends UpdatableJComponent {

    private final TileGrid tileGrid;

    public TileGridCanvas(Dimension gridSize) {

        this.tileGrid = new TileGrid(gridSize);
        this.setPreferredSize(new Dimension(gridSize.width * Tile.TILE_SIZE, gridSize.height * Tile.TILE_SIZE));
        setFocusable(true);
        requestFocus();

    }

    public void update(double interpolationDelta) {

        tileGrid.update(interpolationDelta);

    }

    public void paint(Graphics g) {

        tileGrid.draw(g);

    }

    public Dimension getGridSize() {

        return tileGrid.getGridSize();

    }

}
