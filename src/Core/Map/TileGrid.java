package Core.Map;

import Core.GameObjects.Updatable;
import Gui.Drawable;
import Utilities.Ensure;

import java.awt.*;

/**
 * Created by asebe on 10/16/2016.
 */
public class TileGrid implements Updatable, Drawable {

    private Dimension gridSize;
    private Tile[][] tileGrid;

    public TileGrid(Dimension gridSize) {

        this.gridSize = gridSize;

        int width = getGridSize().width;
        int height = getGridSize().height;
        tileGrid = new Tile[width][height];

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                tileGrid[x][y] = new Tile(new Point(x, y));

            }

        }

    }

    public void update() {

        int width = getGridSize().width;
        int height = getGridSize().height;

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                getTile(new Point(x, y)).update();

            }

        }

    }

    public void draw(Graphics g) {

        int width = getGridSize().width;
        int height = getGridSize().height;

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                getTile(new Point(x, y)).draw(g);

            }

        }
    }

    public Tile getTile(Point location) {

        int width = getGridSize().width;
        int height = getGridSize().height;

        int x = location.x;
        int y = location.y;

        if (!Ensure.InRange(0, x, width) || !Ensure.InRange(0, y, height)) {

            return null;

        }

        return tileGrid[x][y];

    }

    public Dimension getGridSize() {

        return gridSize;

    }



}
