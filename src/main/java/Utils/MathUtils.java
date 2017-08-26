package main.java.Utils;

/**
 * Created by Austin Seber2 on 10/24/2016.
 */
public class MathUtils {

    public static double clamp(double low, double value, double high) {

        return Math.max(low, Math.min(value, high));

    }

    public static double round(double value, int precision) {

        double scale = Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;

    }

}
