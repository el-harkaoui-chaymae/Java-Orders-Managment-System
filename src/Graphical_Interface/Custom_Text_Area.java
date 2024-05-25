package Graphical_Interface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class Custom_Text_Area extends JTextArea{
	
	

    // attributes
    public int x; 
    public int y;
    public int width;
    public int height;
    String font;
    int font_size; 
    String color;

    // constructor
    public Custom_Text_Area(int x, int y, int width, int height, 
    		                String font, int font_size, String color) {
        
        // size and position
        this.setBounds(x, y, width, height);
                
        // cursor
        this.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        
        
        
        // text color
        this.setForeground(Color.decode(color));
        
        // text font
        this.setFont(new Font(font, Font.PLAIN, font_size));
        
        
        // Enable line wrapping
	    this.setLineWrap(true);
	    
	    // Wrap at word boundaries
	    this.setWrapStyleWord(true); 

	    // Set background color 
	    this.setBackground(Color.WHITE); 
	    
	    // Set border
	    this.setBorder(BorderFactory.createLineBorder(Color.decode("#999999")));  
        
        
    }

}
