package main.java;

import net.jlibnoise.generator.Perlin;
import net.jlibnoise.utils.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by asebe on 10/17/2016.
 */
public class Start2 {

    public static void main(String[] args) {

        Perlin perlinNoise = new Perlin();
        perlinNoise.setSeed((int) System.currentTimeMillis());

        NoiseMap noiseMap = new NoiseMap();

        NoiseMapBuilderPlane heightMapBuilder = new NoiseMapBuilderPlane();
        heightMapBuilder.setSourceModule(perlinNoise);
        heightMapBuilder.setDestNoiseMap(noiseMap);
        heightMapBuilder.setDestSize(100, 100);
        heightMapBuilder.setBounds(0.0, 5.0, 0.0, 5.0);
        heightMapBuilder.build();

        RendererImage renderer = new RendererImage();
        renderer.setSourceNoiseMap(noiseMap);

        renderer.clearGradient();
        renderer.addGradientPoint (-1.0000, new Color(  0,   0, 128)); // deeps
        renderer.addGradientPoint (-0.2500, new Color (  0,   0, 255)); // shallow
        renderer.addGradientPoint ( 0.0000, new Color (  0, 128, 255)); // shore
        renderer.addGradientPoint ( 0.0625, new Color (240, 240,  64)); // sand
        renderer.addGradientPoint ( 0.1250, new Color ( 32, 160,   0)); // grass
        renderer.addGradientPoint ( 0.3750, new Color (224, 224,   0)); // dirt
        renderer.addGradientPoint ( 0.7500, new Color (128, 128, 128)); // rock
        renderer.addGradientPoint ( 1.0000, new Color (255, 255, 255)); // snow
        renderer.enableLight();
        renderer.setLightContrast(3.0);
        renderer.setLightBrightness(2.0);
        BufferedImage image = renderer.render();

        try {

            ImageIO.write(image, "png", new File("src\\resources\\testOutput (" + perlinNoise.getSeed() + ").png"));

        } catch (IOException e) { }

        System.out.println("Done");

    }

}