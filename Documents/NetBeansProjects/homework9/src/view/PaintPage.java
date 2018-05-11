package view;

import dao.CircleDao;
import dao.LineDao;
import dao.RectangleDao;
import entity.Circle;
import entity.Line;
import entity.Rectangle;
import entity.Shape;
//import entity.ShapeLists;
import entity.User;
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.MouseAdapter;
//import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class PaintPage extends JFrame {

    private List<Shape> lineBuffer = new ArrayList<>();

    private static String username;
    private static int xStart, xEnd, yStart, yEnd;
    private static Graphics g;
    private Color color;

//    private ShapeLists drawedShape;
    private Shape shape;

    ArrayList<Shape> shapes = new ArrayList<>();

    public PaintPage(String user) {
        initComponents();
        g = PaintingPanel.getGraphics();
        //      drawedShape = ShapeLists.LINE;
        PaintPage.username = user;
        drawedPaintings(PaintPage.username);
    }

    public PaintPage() {
        initComponents();
    }

    private void drawedPaintings(String username) {
        try {
            shapes.addAll(LineDao.getInstance().lineInfo(username));
            shapes.addAll(RectangleDao.getInstance().rectangleInfo(username));
            shapes.addAll(CircleDao.getInstance().circleInfo(username));
        } catch (SQLException ex) {
            Logger.getLogger(PaintPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void drawAll(Color color) {
        g.setColor(color);
        shapes.forEach((shapeColor) -> {
            shapeColor.draw(g);
        });
    }

    private void addLine(Line line) {
        try {
            LineDao.getInstance().insert(line);
        } catch (SQLException ex) {
            System.out.println("something went wrong " + ex.getMessage());
        }
    }

    private void addRectangle(Rectangle rectangle) {
        try {
            RectangleDao.getInstance().insert(rectangle);
        } catch (SQLException ex) {
            System.out.println("something went wrong " + ex.getMessage());
        }
    }

    private void addCircle(Circle circle) {
        try {
            CircleDao.getInstance().insert(circle);
        } catch (SQLException ex) {
            System.out.println("something went wrong " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BluePanel = new javax.swing.JPanel();
        LineBTN = new javax.swing.JButton();
        RectBTN = new javax.swing.JButton();
        CircleBTN = new javax.swing.JButton();
        ColorBTN = new javax.swing.JButton();
        PaintingPanel = new javax.swing.JPanel();
        YellowPanel = new javax.swing.JPanel();
        CloseLabel = new javax.swing.JLabel();
        MinimizeLabel = new javax.swing.JLabel();
        PaintLabel = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint Page");
        setBackground(new java.awt.Color(44, 62, 80));
        setForeground(new java.awt.Color(44, 62, 80));
        setLocation(new java.awt.Point(540, 200));
        setUndecorated(true);

        BluePanel.setBackground(new java.awt.Color(44, 62, 80));
        BluePanel.setAlignmentX(0.0F);
        BluePanel.setAlignmentY(0.0F);
        BluePanel.setNextFocusableComponent(PaintingPanel);

        LineBTN.setBackground(new java.awt.Color(228, 241, 254));
        LineBTN.setIcon(new javax.swing.ImageIcon("C:\\Users\\SONY\\Desktop\\Line.png")); // NOI18N
        LineBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineBTNActionPerformed(evt);
            }
        });

        RectBTN.setBackground(new java.awt.Color(228, 241, 254));
        RectBTN.setIcon(new javax.swing.ImageIcon("C:\\Users\\SONY\\Desktop\\Rectangle.png")); // NOI18N
        RectBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RectBTNActionPerformed(evt);
            }
        });

        CircleBTN.setBackground(new java.awt.Color(228, 241, 254));
        CircleBTN.setIcon(new javax.swing.ImageIcon("C:\\Users\\SONY\\Desktop\\Ellipse.png")); // NOI18N
        CircleBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CircleBTNActionPerformed(evt);
            }
        });

        ColorBTN.setBackground(new java.awt.Color(228, 241, 254));
        ColorBTN.setIcon(new javax.swing.ImageIcon("C:\\Users\\SONY\\Desktop\\Fill.png")); // NOI18N
        ColorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BluePanelLayout = new javax.swing.GroupLayout(BluePanel);
        BluePanel.setLayout(BluePanelLayout);
        BluePanelLayout.setHorizontalGroup(
            BluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LineBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RectBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CircleBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ColorBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        BluePanelLayout.setVerticalGroup(
            BluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BluePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LineBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(RectBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(CircleBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(ColorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        PaintingPanel.setBackground(new java.awt.Color(255, 255, 255));
        PaintingPanel.setAlignmentX(0.0F);
        PaintingPanel.setAlignmentY(0.0F);

        javax.swing.GroupLayout PaintingPanelLayout = new javax.swing.GroupLayout(PaintingPanel);
        PaintingPanel.setLayout(PaintingPanelLayout);
        PaintingPanelLayout.setHorizontalGroup(
            PaintingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        PaintingPanelLayout.setVerticalGroup(
            PaintingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        YellowPanel.setBackground(new java.awt.Color(248, 148, 6));
        YellowPanel.setAlignmentX(0.0F);
        YellowPanel.setAlignmentY(0.0F);

        CloseLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CloseLabel.setForeground(new java.awt.Color(255, 255, 255));
        CloseLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CloseLabel.setText("X");
        CloseLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLabelMouseClicked(evt);
            }
        });

        MinimizeLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        MinimizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        MinimizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        MinimizeLabel.setText("-");
        MinimizeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MinimizeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseClicked(evt);
            }
        });

        PaintLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PaintLabel.setForeground(new java.awt.Color(255, 255, 255));
        PaintLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PaintLabel.setText("Painting Page");

        UserLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserLabel.setText("Username");
        UserLabel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                UserLabelComponentShown(evt);
            }
        });

        javax.swing.GroupLayout YellowPanelLayout = new javax.swing.GroupLayout(YellowPanel);
        YellowPanel.setLayout(YellowPanelLayout);
        YellowPanelLayout.setHorizontalGroup(
            YellowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, YellowPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PaintLabel)
                .addGap(189, 189, 189)
                .addComponent(UserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MinimizeLabel)
                .addGap(27, 27, 27)
                .addComponent(CloseLabel)
                .addContainerGap())
        );
        YellowPanelLayout.setVerticalGroup(
            YellowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MinimizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CloseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(UserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PaintLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PaintingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(YellowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(YellowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PaintingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void CloseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CloseLabelMouseClicked
    private void MinimizeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLabelMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinimizeLabelMouseClicked
    private void UserLabelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_UserLabelComponentShown
        User user = new User();
        UserLabel.setText(user.getUsername());
    }//GEN-LAST:event_UserLabelComponentShown
    private void ColorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorBTNActionPerformed
        color = JColorChooser.showDialog(this, "pick a color", Color.BLACK);
    }//GEN-LAST:event_ColorBTNActionPerformed
    private void LineBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineBTNActionPerformed
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (g == null) {
                    g = PaintingPanel.getGraphics();
                }
                if (ColorBTN.isSelected()) {
                    g.setColor(color);
                }
                xStart = me.getX();
                yStart = me.getY();
                xEnd = me.getX();
                yEnd = me.getY();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                PaintingPanel.update(g);
                xEnd = me.getX();
                yEnd = me.getY();
                shape = new Line(xStart, yStart, xEnd, yEnd, color, PaintPage.username);
//                Line line = new Line();
//                line.draw(g);
                shape.draw(g);
                shapes.add(shape);
                drawAll(color);
                addLine((Line) shape);
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                PaintingPanel.update(g);
                xEnd = me.getX();
                yEnd = me.getY();

                shape = new Line(xStart, yStart, xEnd, yEnd, color, PaintPage.username);
//                Line line = new Line();
//                line.draw(g);
                shape.draw(g);
                drawAll(color);
            }
        });
    }//GEN-LAST:event_LineBTNActionPerformed
    private void RectBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RectBTNActionPerformed
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (g == null) {
                    g = PaintingPanel.getGraphics();
                }
                if (ColorBTN.isSelected()) {
                    g.setColor(color);
                }
                xStart = me.getX();
                yStart = me.getY();
                xEnd = me.getX();
                yEnd = me.getY();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                PaintingPanel.update(g);
                xEnd = me.getX();
                yEnd = me.getY();
                shape = new Rectangle(xStart, yStart, xEnd, yEnd, color, PaintPage.username);
//                Rectangle rectangle = new Rectangle();
//                rectangle.draw(g);
                shape.draw(g);
                shapes.add(shape);
                drawAll(color);
                addRectangle((Rectangle) shape);
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                PaintingPanel.update(g);
                xEnd = me.getX();
                yEnd = me.getY();

                shape = new Rectangle(xStart, yStart, xEnd, yEnd, color, PaintPage.username);
//                Rectangle rectangle = new Rectangle();
//                rectangle.draw(g);
                shape.draw(g);
                drawAll(color);
            }
        });
    }//GEN-LAST:event_RectBTNActionPerformed

    private void CircleBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CircleBTNActionPerformed
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (g == null) {
                    g = PaintingPanel.getGraphics();
                }
                if (ColorBTN.isSelected()) {
                    g.setColor(color);
                }
                xStart = me.getX();
                yStart = me.getY();
                xEnd = me.getX();
                yEnd = me.getY();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                PaintingPanel.update(g);
                xEnd = me.getX();
                yEnd = me.getY();
                shape = new Circle(xStart, yStart, xEnd, yEnd, color, PaintPage.username);
//                Circle circle = new Circle();
//                circle.draw(g);
                shape.draw(g);
                shapes.add(shape);
                drawAll(color);
                addCircle((Circle) shape);
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                PaintingPanel.update(g);
                xEnd = me.getX();
                yEnd = me.getY();

                shape = new Circle(xStart, yStart, xEnd, yEnd, color, PaintPage.username);
//                Circle circle = new Circle();
//                circle.draw(g);
                shape.draw(g);
                drawAll(color);
            }
        });
    }//GEN-LAST:event_CircleBTNActionPerformed
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new PaintPage().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BluePanel;
    private javax.swing.JButton CircleBTN;
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JButton ColorBTN;
    private javax.swing.JButton LineBTN;
    private javax.swing.JLabel MinimizeLabel;
    private javax.swing.JLabel PaintLabel;
    private javax.swing.JPanel PaintingPanel;
    private javax.swing.JButton RectBTN;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JPanel YellowPanel;
    // End of variables declaration//GEN-END:variables
}
