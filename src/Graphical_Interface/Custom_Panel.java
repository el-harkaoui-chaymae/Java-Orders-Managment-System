package Graphical_Interface;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;

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
               try { backgroundImage = ImageIO.read(new File(image_path));
                     repaint();}
               catch (IOException e) {e.printStackTrace();}  
           }).start(); }
    

    // repaint the image to fit the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        repaint();

    }
    
    
    // method to add return button
    public Custom_Button add_return_button(int x,int y,int width,int height,int panel_originel_width,int panel_original_height) {
    	
        //  return button
        int bt_x = (int) ((x*getWidth())/panel_originel_width);
	    int bt_y = (int) ((y*getHeight())/panel_original_height);
	    int bt_width = (int) ((width*getWidth())/panel_originel_width);
	    int bt_height = (int) ((height*getHeight())/panel_original_height);
        Custom_Button Return = new Custom_Button(bt_x,bt_y,bt_width,bt_height,"",
        "#4C4C4C","Arial",10,false);
        Return.setHorizontalAlignment(SwingConstants.LEFT);
        add(Return);
        // label - return icon
        int lb_x = (int) ((x*getWidth())/panel_originel_width);
	    int lb_y = (int) ((y*getHeight())/panel_original_height);
	    int lb_width = (int) ((width*getWidth())/panel_originel_width);
	    int lb_height = (int) ((height*getHeight())/panel_original_height);
        Custom_Label lab = new Custom_Label(lb_x, lb_y, lb_width, lb_height,
        "","Arial",10,"#b39700");
        lab.add_background("return_icon.png");
        add(lab);
        
        return Return;
    	
 	
    }
    
    
    
    
}
