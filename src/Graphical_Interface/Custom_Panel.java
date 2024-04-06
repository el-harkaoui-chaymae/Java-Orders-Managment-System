package Graphical_Interface;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Custom_Panel extends JPanel {

    // attributes
    String type;
    public int x;
    public int y;
    public int width;
    public int height;
    public String color;
    public Image backgroundImage;

    // Constructor
    public Custom_Panel(int x, int y, int width, int height, String color) {
        // set the attributes
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        // Set layout
        this.setLayout(null);

        // Set background color
        this.setBackground(Color.decode(color));

        

        // Set panel position
        this.setLocation(x, y);

        // Set panel size
        this.setSize(width, height);

    }
    
    // method to add image background
    public void add_background(String image_path) {
    	

        // Start a new thread to load the image
           new Thread(() -> {
               try {
                   backgroundImage = ImageIO.read(new File(image_path));
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        repaint();

    }
}
