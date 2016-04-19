/**
 * 
 * DO NOT CHANGE THIS CLASS
 * 
 *
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
import javax.swing.*;

public class SketchPad extends JComponent
{
  private JFrame frame;
  private BufferedImage image;
  
  public SketchPad()
  {
    int width = 400;
    int height = 400;
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    
    frame = new JFrame();
    frame.setTitle("SketchPad");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.getContentPane().setLayout(new BorderLayout());
    
    this.setPreferredSize(new Dimension(width, height));
    frame.getContentPane().add(this, BorderLayout.CENTER);
    
    frame.pack();
    frame.setVisible(true);
  }
  
  //range from 0 to 1, where (0, 0) is bottom left
  public void drawLine(double x1, double y1, double x2, double y2)
  {
    Graphics g = image.getGraphics();
    g.setColor(Color.BLACK);
    
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    
    g.drawLine((int)(x1 * width), (int)((1 - y1) * height), (int)(x2 * width), (int)((1 - y2) * height));
    repaint();
  }
  
  public void paintComponent(Graphics g)
  {
    g.drawImage(image, 0, 0, null);
  }
}