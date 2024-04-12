package Graphical_Interface;

import java.awt.Color;
import java.awt.Font;
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
    public void create_buttom_border(int size,String color) { 
    	Border border = BorderFactory.createMatteBorder(0, 0, size, 0, Color.decode(color)); // Top-left-bottom-right
        this.setBorder(border);}
	
    
    
    

}
