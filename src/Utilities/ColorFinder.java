package Utilities;

import java.awt.*;

/**
 * Created by asebe on 10/16/2016.
 */
public class ColorFinder {

    private Color beginColor;
    private int rDifference, gDifference, bDifference;

    public ColorFinder(Color beginColor, Color endColor) {

        this.beginColor = beginColor;
        rDifference = endColor.getRed() - beginColor.getRed();
        gDifference = endColor.getGreen() - beginColor.getGreen();
        bDifference = endColor.getBlue() - beginColor.getBlue();

    }

    public Color getColorInRange(double value, double max) {

        double percentage = value / max;

        int r = beginColor.getRed() + (int) (percentage * rDifference);
        int g = beginColor.getGreen() + (int) (percentage * gDifference);
        int b = beginColor.getBlue() + (int) (percentage * bDifference);

        return new Color(r, g, b);

    }

}
