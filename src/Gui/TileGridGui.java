package Gui;

import Core.GameObjects.Updatable;
import Core.Map.Tile;
import Core.Map.TileGrid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asebe on 10/15/2016.
 */
public class TileGridGui extends JPanel implements Updatable {

    private TileGrid tileGrid;

    public TileGridGui(Dimension gridSize) {

        this.tileGrid = new TileGrid(gridSize);
        this.setPreferredSize(new Dimension(getGridSize().width * Tile.TILE_SIZE, getGridSize().height * Tile.TILE_SIZE));

    }

    public void update(double interpolationDelta) {

        tileGrid.update(interpolationDelta);
        this.repaint();

    }

    public void paintComponent(Graphics g) {

        tileGrid.draw(g);

    }

    public Dimension getGridSize() {

        return tileGrid.getGridSize();

    }

}
