package paint_one;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingPaint {

    DrawArea draw;
    JButton clearBTN, blackBTN, blueBTN, redBTN, greenBTN, magnetaBTN, circleBTN, lineBTN, rectangleBTN;

    ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == blackBTN) {
                draw.black();
            } else if (ae.getSource() == blueBTN) {
                draw.blue();
            } else if (ae.getSource() == greenBTN) {
                draw.green();
            } else if (ae.getSource() == redBTN) {
                draw.red();
            } else if (ae.getSource() == magnetaBTN) {
                draw.magneta();
            } else if (ae.getSource() == clearBTN) {
                draw.clear();
            } else if (ae.getSource() == circleBTN) {
                draw.paintCircle();
            } else if (ae.getSource() == lineBTN) {
                draw.paintLine();
            } else if (ae.getSource() == rectangleBTN) {
                draw.paintRecatngle();
            }
        }
    };

    public static void main(String[] args) {
        new SwingPaint().view();
    }

    public void view() {
        JFrame frame = new JFrame("Paint");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        //draw variable
        draw = new DrawArea();
        content.add(draw, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        //Buttons and actions
        clearBTN = new JButton("Clear");
        clearBTN.addActionListener(action);
        blackBTN = new JButton("Black");
        blackBTN.addActionListener(action);
        blueBTN = new JButton("Blue");
        blueBTN.addActionListener(action);
        redBTN = new JButton("Red");
        redBTN.addActionListener(action);
        magnetaBTN = new JButton("Magneta");
        magnetaBTN.addActionListener(action);
        greenBTN = new JButton("Green");
        greenBTN.addActionListener(action);
        lineBTN = new JButton("Draw Line");
        lineBTN.addActionListener(action);
        circleBTN = new JButton("Draw Circle");
        circleBTN.addActionListener(action);
        rectangleBTN = new JButton("Draw Rectangle");
        rectangleBTN.addActionListener(action);
        //add to panel
        panel.add(greenBTN);
        panel.add(blueBTN);
        panel.add(blackBTN);
        panel.add(redBTN);
        panel.add(magnetaBTN);
        panel.add(clearBTN);
        panel.add(lineBTN);
        panel.add(circleBTN);
        panel.add(rectangleBTN);
        //add to content
        content.add(panel, BorderLayout.NORTH);
        //create frame
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
