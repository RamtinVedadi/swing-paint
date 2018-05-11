package paint_two;

import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.DecimalFormat;

@SuppressWarnings("Serial")
public class draw extends JFrame {

    JButton brushBTN, lineBTN, rectBTN, circleBTN, strokeBTN, fillBTN;

    //for Chanhe transparency
    JSlider slider;
    JLabel transLabel;

    DecimalFormat dec = new DecimalFormat("#.##");
    Graphics2D graph;

    int currentAction = 1;//this value is for which action we are doing
    float transparentValue = 1.0f;

    Color strokeColor = Color.BLACK;
    Color fillColor = Color.BLACK;

    public static void main(String[] args) {
        new draw();
    }

    public draw() {
        this.setSize(900, 600);
        this.setTitle("Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        Box box = Box.createHorizontalBox();

        brushBTN = makeButton(ImageAdress.cancelImg, 1);
        lineBTN = makeButton("C:\\Users\\SONY\\Documents\\NetBeansProjects\\JavaApplication63\\src\\Line.png", 2);
        circleBTN = makeButton("C:\\Users\\SONY\\Documents\\NetBeansProjects\\JavaApplication63\\src\\Ellipse.png", 3);
        rectBTN = makeButton("C:\\Users\\SONY\\Documents\\NetBeansProjects\\JavaApplication63\\src\\Rectangle.png", 4);

        strokeBTN = makeColorButton("C:\\Users\\SONY\\Documents\\NetBeansProjects\\JavaApplication63\\src\\Stroke.png", 5, true);
        fillBTN = makeColorButton("C:\\Users\\SONY\\Documents\\NetBeansProjects\\JavaApplication63\\src\\Fill.png", 6, false);

        box.add(brushBTN);
        box.add(lineBTN);
        box.add(circleBTN);
        box.add(rectBTN);
        box.add(strokeBTN);
        box.add(fillBTN);

        transLabel = new JLabel("Transparent : 1 ");
        slider = new JSlider(1, 99, 99);
        ListenForSlider lfs = new ListenForSlider();
        slider.addChangeListener(lfs);
        box.add(transLabel);
        box.add(slider);

        panel.add(box);
        this.add(panel, BorderLayout.SOUTH);
        this.add(new DrawingBoard(), BorderLayout.CENTER);
        this.setVisible(true);
    }

    public JButton makeButton(String icon, int actionNum) {
        JButton button = new JButton();
        Icon buttunIcon = new ImageIcon(icon);
        button.setIcon(buttunIcon);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                currentAction = actionNum;
            }
        });
        return button;
    }

    private JButton makeColorButton(String icon, int actionNum, boolean stroke) {
        JButton button = new JButton();
        Icon buttunIcon = new ImageIcon(icon);
        button.setIcon(buttunIcon);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (stroke) {
                    strokeColor = JColorChooser.showDialog(null, "Pick a Stroke", Color.BLACK);
                } else {
                    fillColor = JColorChooser.showDialog(null, "Pick a Fill", Color.BLACK);
                }
            }
        });
        return button;
    }

    private class DrawingBoard extends JComponent {

        ArrayList<Shape> shapes = new ArrayList<>();
        ArrayList<Color> shapeFill = new ArrayList<>();
        ArrayList<Color> shapeStroke = new ArrayList<>();
        //array list for our slider for transparency
        ArrayList<Float> transPercent = new ArrayList<>();

        Point start, end;

        public DrawingBoard() {
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (currentAction != 1) {
                        start = new Point(e.getX(), e.getY());
                        end = start;
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (currentAction != 1)
                    {
                        Shape aShape = null;
                        if (currentAction == 2) {
                            aShape = drawLine(start.x, start.y, e.getX(), e.getY());
                        } else if (currentAction == 3) {
                            aShape = drawCircle(start.x, start.y, e.getX(), e.getY());
                        } else if (currentAction == 4) {
                            aShape = drawRectangle(start.x, start.y, e.getX(), e.getY());
                        }

                        shapes.add(aShape);
                        shapeFill.add(fillColor);
                        shapeStroke.add(strokeColor);
                        transPercent.add(transparentValue);

                        start = null;
                        end = null;
                        repaint();
                    }
                }
            });
            this.addMouseMotionListener(new MouseMotionAdapter() 
            {
                @Override
                public void mouseDragged(MouseEvent e) 
                {
                    if (currentAction == 1) 
                    {
                        int x = e.getX();
                        int y = e.getY();
                        Shape aShape = null;
                        
                        strokeColor = fillColor;
                        aShape = drawBrush(x, y, 5, 5);

                        shapes.add(aShape);
                        shapeFill.add(fillColor);
                        shapeStroke.add(strokeColor);
                        transPercent.add(transparentValue);
                    }
                    end = new Point(e.getX(), e.getY());
                    repaint();
                }                
            });
        }
        
        @Override
        public void paint(Graphics g) {
            graph = (Graphics2D) g;
            graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            graph.setStroke(new BasicStroke(4));

            Iterator<Color> strokeCounter = shapeStroke.iterator();
            Iterator<Color> fillCounter = shapeFill.iterator();
            Iterator<Float> transCounter = transPercent.iterator();

            for (Shape s : shapes) {
                //transparency settings
                graph.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transCounter.next()));
                graph.setPaint(strokeCounter.next());
                graph.draw(s);
                graph.setPaint(fillCounter.next());
                graph.fill(s);
            }
            if (start != null && end != null) {
                graph.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
                graph.setPaint(Color.LIGHT_GRAY);
                Shape aShape = null;
                switch (currentAction) {
                    case 2:
                        aShape = drawLine(start.x, start.y, end.x, end.y);
                        break;
                    case 3:
                        aShape = drawCircle(start.x, start.y, end.x, end.y);
                        break;
                    case 4:
                        aShape = drawRectangle(start.x, start.y, end.x, end.y);
                        break;
                    default:
                        break;
                }

                graph.draw(aShape);
            }
        }

        private Rectangle2D.Float drawRectangle(int x1, int y1, int x2, int y2) {
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);

            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            return new Rectangle2D.Float(x, y, width, height);
        }

        private Ellipse2D.Float drawCircle(int x1, int y1, int x2, int y2) {
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);

            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            return new Ellipse2D.Float(x, y, width, height);
        }

        private Line2D.Float drawLine(int x1, int y1, int x2, int y2) {
            return new Line2D.Float(x1, y1, x2, y2);
        }

        private Ellipse2D.Float drawBrush(int x1, int y1, int brushStrokeWidth, int brushStrokeHeight) {
            return new Ellipse2D.Float(x1, y1, brushStrokeWidth, brushStrokeHeight);
        }
    }

    private class ListenForSlider implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource() == slider) {
                transLabel.setText("Transport : " + dec.format(slider.getValue() * .01));
                transparentValue = (float) (slider.getValue() * .01);
            }
        }
    }
}
