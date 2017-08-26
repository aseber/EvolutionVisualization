package main.java.Core.Map;

import main.java.Core.GameObjects.Updatable;
import main.java.Gui.Drawable;
import main.java.Utils.Ensure;
import main.java.Utils.MapUtils.MapGen;
import net.jlibnoise.utils.NoiseMap;

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

//        NoiseMap noiseMap = MapGen.generateMap((int) System.currentTimeMillis(), gridSize);
        NoiseMap noiseMap = MapGen.generateMap(0, gridSize);

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                float tileHeight = noiseMap.getValue(x, y);

                tileGrid[x][y] = new Tile(new Point(x, y), tileHeight);

            }

        }

    }

    public void update(double interpolationDelta) {

        int width = getGridSize().width;
        int height = getGridSize().height;

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                getTile(new Point(x, y)).update(interpolationDelta);

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
