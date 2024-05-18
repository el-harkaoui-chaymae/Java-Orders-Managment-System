package Graphical_Interface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Custom_Text_Field extends JTextField {

    // attributes
    public int x;
    public int y;
    public int width;
    public int height;
    String font;
    int font_size; 
    String color;

    // constructor
    public Custom_Text_Field(int x, int y, int width, int height, String font, int font_size, String color) {
        
        // size and position
        this.setBounds(x, y, width, height);
                
        // cursor
        this.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        
        // text alignment
        this.setHorizontalAlignment(SwingConstants.LEFT);
        
        // text color
        this.setForeground(Color.decode(color));
        
        // text font
        this.setFont(new Font(font, Font.PLAIN, font_size));  
        
        
    }
}
