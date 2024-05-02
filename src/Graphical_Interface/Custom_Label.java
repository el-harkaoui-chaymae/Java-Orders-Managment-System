package Graphical_Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Custom_Label extends JLabel {
	
	// attributes
	public int x;
	public int y;
	public int width;
	public int height;
	String text ; 
	String font; 
	int font_size; 
	String color;
    Image backgroundImage;

	
	// constructor
	public Custom_Label(int x,int y,int width,int height,String text,String font,int font_size,String color) {
		
		// set the text
		super(text);
		
		// set location and size
		this.setBounds(x, y, width, height);
		
		// set font style
		Font f = new Font(font, Font.BOLD, font_size); 
        this.setFont(f);
        this.setForeground(Color.decode(color));

		
	}
	
    // method to create a bottom border for the label
    public void create_bottom_border(int size,String color) { 
    	Border border = BorderFactory.createMatteBorder(0, 0, size, 0, Color.decode(color)); // Top-left-bottom-right
        this.setBorder(border);}
    
    
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

    // repaint the image to fit the label
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        repaint();

    }
	
    
    
    

}
