package main.java.Utils.MapUtils;

import net.jlibnoise.generator.Perlin;
import net.jlibnoise.utils.NoiseMap;
import net.jlibnoise.utils.NoiseMapBuilderPlane;

import java.awt.*;

/**
 * Created by asebe on 10/18/2016.
 */
public class MapGen {

    public static NoiseMap generateMap(int seed, Dimension size) {

        Perlin perlinNoise = new Perlin();
        perlinNoise.setSeed(seed);

        NoiseMap noiseMap = new NoiseMap();

        NoiseMapBuilderPlane heightMapBuilder = new NoiseMapBuilderPlane();
        heightMapBuilder.setSourceModule(perlinNoise);
        heightMapBuilder.setDestNoiseMap(noiseMap);
        heightMapBuilder.setDestSize(size.width, size.height);
        heightMapBuilder.setBounds(0.0, 5.0, 0.0, 5.0);
        heightMapBuilder.build();

        return noiseMap;

    }

}
