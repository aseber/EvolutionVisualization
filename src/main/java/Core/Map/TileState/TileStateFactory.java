package main.java.Core.Map.TileState;

/**
 * Created by asebe on 10/18/2016.
 */
public class TileStateFactory {

    public static ITileState getTileState(float height) {

        if (height >= 0.90) {

            return new SnowState(height);

        } else if (height >= 0.7750) {

            return new RockState(height);

        } else if (height >= 0.5250) {

            return new DirtState(height);

        } else if (height >= 0.3250) {

            return new GrassState(height);

        } else if (height >= 0.0625) {

            return new SandState(height);

        } else if (height >= 0.0) {

            return new ShoreState(height);

        } else if (height >= -0.2500) {

            return new ShallowWaterState(height);

        } else {

            return new DeepWaterState(height);

        }

    }

}
