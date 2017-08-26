package main.java.Gui;

import main.java.Core.GameObjects.Updatable;
import main.java.Utils.MathUtils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by Austin Seber2 on 10/24/2016.
 */
public class ZoomableJComponentDecorator extends BaseJComponentDecorator {

    private ScrollPolicy scrollPolicy;

    private BufferedImage image;
    private Point viewLocation = new Point();
    private Point oldLocationOnScreen = new Point();
    private double zoomValue;

    public ZoomableJComponentDecorator(ScrollPolicy scrollPolicy) {

        this.scrollPolicy = scrollPolicy;

        setZoomValue(Math.min(getPreferredSize().getWidth() / getPreferredSize().getWidth(), getPreferredSize().getHeight() / getPreferredSize().getHeight()));

        image = new BufferedImage((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight(), BufferedImage.TYPE_INT_RGB);

        //addMouseWheelListener(getMouseWheelListener());
        addMouseMotionListener(getMouseMotionListener());
        addComponentListener(getComponentListener());

    }

    public void paint(Graphics g) {

        if (image == null) {

            System.out.println("How the hell is image null?");
            return;

        }

        Component[] children = getComponents();
        Graphics2D imageGraphics = (Graphics2D) image.getGraphics();
        ((Graphics2D) g).setBackground(Color.RED);

        try {

            imageGraphics.setBackground(Color.BLACK);

            imageGraphics.clearRect(0, 0, image.getWidth(), image.getHeight());
            g.clearRect(0, 0, getWidth(), getHeight());

            int xs1 = viewLocation.x + getPreferredSize().width / 2;
            int ys1 = viewLocation.y + getPreferredSize().height / 2;

            imageGraphics.translate(xs1, ys1);
            imageGraphics.scale(getZoomValue(), getZoomValue());
            imageGraphics.translate(-xs1, -ys1);

            int xs2 = viewLocation.x + (getPreferredSize().width - getPreferredSize().width) / 2; // Centers the image on the screen
            int ys2 = viewLocation.y + (getPreferredSize().height - getPreferredSize().height) / 2; // Centers the image on the screen

            imageGraphics.translate(xs2, ys2);

            for (Component component : children) {

                component.paint(imageGraphics);

            }

            g.drawImage(image, 0, 0, null);

        } finally {

            imageGraphics.dispose();

        }

    }

    public void update(double interpolationDelta) {

        repaint();

    }

    private MouseWheelListener getMouseWheelListener() {

        return (e) -> {

            double scrollAmount = e.getPreciseWheelRotation();

            double oldScrollAmount = getZoomValue();

            modZoomValue(scrollAmount * getZoomValue());

            double dScroll = Math.abs(getZoomValue() - oldScrollAmount);

            Point mouseLocation = oldLocationOnScreen;

            Dimension halfScreenSize = new Dimension(getPreferredSize().width / 2, getPreferredSize().height / 2);

            double scrollFactor = (scrollPolicy.getMaximumZoomValue() - getZoomValue()) / scrollPolicy.getMaximumZoomValue();

            int dx = (int) Math.round((halfScreenSize.width - mouseLocation.x) * dScroll * scrollFactor);
            int dy = (int) Math.round((halfScreenSize.height - mouseLocation.y) * dScroll * scrollFactor);

            System.out.println(getZoomValue() + " | " + dx + " | " + dy);
            System.out.println(viewLocation);
            viewLocation.translate(dx, dy);
            System.out.println(viewLocation);

        };

    }

    private MouseMotionListener getMouseMotionListener() {

        return new MouseMotionListener() {

            public void mouseDragged(MouseEvent e) {

                Point newLocationOnScreen = e.getLocationOnScreen();
                int dx = newLocationOnScreen.x - oldLocationOnScreen.x;
                int dy = newLocationOnScreen.y - oldLocationOnScreen.y;
                viewLocation.translate(dx, dy);
                oldLocationOnScreen = newLocationOnScreen;

            }

            public void mouseMoved(MouseEvent e) {

                oldLocationOnScreen = e.getLocationOnScreen();

            }

        };

    }

    private ComponentListener getComponentListener() {

        return new ComponentAdapter() {

            public void componentResized(ComponentEvent e) {

                setPreferredSize(new Dimension(e.getComponent().getWidth(), e.getComponent().getHeight()));
                image = new BufferedImage(e.getComponent().getWidth(), e.getComponent().getHeight(), BufferedImage.TYPE_INT_RGB);

                System.out.println(e.getComponent().getWidth() + " | " + e.getComponent().getHeight());

            }

        };

    }

    public Dimension getPreferredSize() {

        return new Dimension(1000, 1000);

    }

    public void setZoomValue(double newZoomValue) {

        this.zoomValue =  MathUtils.clamp(scrollPolicy.getMinimumZoomValue(), newZoomValue, scrollPolicy.getMaximumZoomValue());
    }


    public void modZoomValue(double zoomValue) {

        setZoomValue(getZoomValue() + zoomValue * scrollPolicy.getZoomScalar());

    }

    public double getZoomValue() {
        return zoomValue;
    }


}
