package main.java.Gui;

import main.java.Utils.MathUtils;

/**
 * Created by Austin Seber2 on 2/5/2017.
 */
public class ScrollPolicy {

    private double minimumZoomValue;
    private double maximumZoomValue;
    private double zoomScalar;

    public ScrollPolicy(double minimumZoomValue, double maximumZoomValue) {

        this.minimumZoomValue = minimumZoomValue;
        this.maximumZoomValue = maximumZoomValue;
        zoomScalar = 0.33;

    }

    public ScrollPolicy(double minimumZoomValue, double maximumZoomValue, double zoomScalar) {

        this.minimumZoomValue = minimumZoomValue;
        this.maximumZoomValue = maximumZoomValue;
        this.zoomScalar = zoomScalar;

    }

    public double getMinimumZoomValue() {
        return minimumZoomValue;
    }

    public double getMaximumZoomValue() {
        return maximumZoomValue;
    }

    public double getZoomScalar() {
        return zoomScalar;
    }

}
