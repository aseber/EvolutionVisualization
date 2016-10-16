package Gui;

import Core.GameObjects.Updatable;
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

    }

    public void update() {

        this.repaint();

    }

    public void paintComponent(Graphics g) {

        tileGrid.update();
        tileGrid.draw(g);

    }

    public Dimension getGridSize() {

        return tileGrid.getGridSize();

    }

}
