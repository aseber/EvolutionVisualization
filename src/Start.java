import Core.GameTime.VariableGameTimer;
import Gui.TileGridGui;

import javax.swing.*;
import java.awt.*;

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
        frame.setSize(frame.getSize());

        VariableGameTimer gameTimer = new VariableGameTimer(60, tileGridGui::update);
        gameTimer.start();



    }

}
