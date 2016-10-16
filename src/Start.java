import Gui.TileGridGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by asebe on 10/15/2016.
 */
public class Start {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Evolution Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TileGridGui tileGridGui = new TileGridGui(new Dimension(100, 100));
        frame.add(tileGridGui);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 1000);

        Timer timer = new Timer(33, (e) -> {

                tileGridGui.update();

        });

        timer.setRepeats(true);
        timer.start();

    }

}
