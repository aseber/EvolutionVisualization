package main.java.Utils;

import java.awt.*;

/**
 * Created by asebe on 10/16/2016.
 */
public class GradientColor {

    private Color beginColor;
    private int rDifference, gDifference, bDifference;

    public GradientColor(Color beginColor, Color endColor) {

        this.beginColor = beginColor;
        rDifference = endColor.getRed() - beginColor.getRed();
        gDifference = endColor.getGreen() - beginColor.getGreen();
        bDifference = endColor.getBlue() - beginColor.getBlue();

    }

    public Color getColor(double percentage) {

        int r = beginColor.getRed() + (int) (percentage * rDifference);
        int g = beginColor.getGreen() + (int) (percentage * gDifference);
        int b = beginColor.getBlue() + (int) (percentage * bDifference);

        return new Color(r, g, b);

    }

}
