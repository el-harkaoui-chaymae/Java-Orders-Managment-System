package Graphical_Interface;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Custom_Panel extends JPanel {

    // attributes
    String type;
    int x; 
    int y;
    int width;
    int height;
    String color;
    Image backgroundImage;
    public ArrayList<Float> position_size_ratios = new ArrayList();
    public ArrayList<Integer> font_size_ratios = new ArrayList();

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
                   repaint();}
               catch (IOException e) {e.printStackTrace();}
               
           }).start(); 
    }

    // repaint the image to fit the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        repaint();

    }
    
    
    
    
}
