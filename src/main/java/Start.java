package main.java;

import main.java.Core.GameTime.VariableGameTimer;
import main.java.Gui.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asebe on 10/15/2016.
 */
public class Start {

    public static JFrame frame;
    private static final String title = "Evolution Simulator";

    public static void main(String[] args) {

        ScrollPolicy scrollPolicy = new ScrollPolicy(0.1, 10.0, 0.25);
        Dimension tileGridSize = new Dimension(250, 250);

        BaseJComponentDecorator zoomDecorator = new ZoomableJComponentDecorator(scrollPolicy);
        UpdatableJComponent grid = new TileGridCanvas(tileGridSize);

        VariableGameTimer timer = new VariableGameTimer(60);
        timer.addAction(zoomDecorator::update);
        timer.addAction(grid::update);

        zoomDecorator.add(grid);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 1000));
        frame.add(zoomDecorator);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);

        timer.start();

    }

}
