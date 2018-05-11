package paint_one;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class DrawArea extends JComponent {

    private Image image;//Image is for which that we gonna draw in it
    private Graphics2D g1;
    private Graphics2D g2;//used for draw on
    private int currentX, currentY, oldX, oldY;//Mouse cordinates
    List<int[]> points = new ArrayList();
    List<String[]> shapes = new ArrayList();

    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //save position of mouse when it pressed
                oldX = e.getX();
                oldY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int[] positions = {oldX, oldY, currentX, currentY};
                points.add(positions);
            }

        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //when we drag mouse it will save mouse pposition
                currentX = e.getX();
                currentY = e.getY();
                if (g2 != null) {
                    //it draws a line with cordinates of mouse positions
//                    clear();
//                    g2.drawLine(oldX, oldY, currentX, currentY);
                    paintLine();
                    paintCircle();
                    //refresh draw area
//                    repaint();
                    //store current cordinates x,y as old x,y
//                    oldX = currentX;
//                    oldY = currentY;
                }
            }
        });
    }

    public void paintLine() {
        int oldx, oldy, currentx, currenty;
        clear();
        g2.drawLine(oldX, oldY, currentX, currentY);
        repaint();
        for (int[] point : points) {
            oldx = point[0];
            oldy = point[1];
            currentx = point[2];
            currenty = point[3];

            g2.drawLine(oldx, oldy, currentx, currenty);
            repaint();
        }
    }

    public void paintCircle() {
        int oldx, oldy, currentx, currenty;
        g2.drawOval(oldX, oldY, currentX, currentY);
        repaint();
        for (int[] point : points) {
            oldx = point[0];
            oldy = point[1];
            currentx = point[2];
            currenty = point[3];

            g2.drawOval(oldx, oldy, currentx, currenty);
            repaint();
        }
    }

    public void paintRecatngle() {
        int oldx, oldy, currentx, currenty;
//        g2.drawOval(oldX, oldY, currentX, currentY);
        g2.drawRect(oldX, oldY, currentX, currentY);
        repaint();
        for (int[] point : points) {
            oldx = point[0];
            oldy = point[1];
            currentx = point[2];
            currenty = point[3];

            g2.drawOval(oldx, oldy, currentx, currenty);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g1 = (Graphics2D) image.getGraphics();
            g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g1.setPaint(Color.white);
        g1.fillRect(0, 0, getSize().width, getSize().height);
//        g2.setPaint(Color.BLACK);
        repaint();
    }

    public void black() {
        g2.setPaint(Color.BLACK);
    }

    public void red() {
        g2.setPaint(Color.RED);
    }

    public void magneta() {
        g2.setPaint(Color.MAGENTA);
    }

    public void green() {
        g2.setPaint(Color.GREEN);
    }

    public void blue() {
        g2.setPaint(Color.BLUE);
    }
}
