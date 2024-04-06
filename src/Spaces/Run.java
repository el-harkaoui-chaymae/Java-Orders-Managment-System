package Spaces;
import javax.swing.*;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Panel;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Run{
	
	
	public static void main(String[] args) {
        
		Custom_Frame frame = new Custom_Frame();
        
        Custom_Panel pn = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#D0E6F0");
        pn.add_background("logo_background.png");
        
        
        
        Custom_Button bt = new Custom_Button(1000,50,150,40,"company");
        Custom_Button bt2 = new Custom_Button(1200,50,150,40,"about us");
        
       
        
        // Create a JLabel and set its text
        JLabel label = new JLabel("Vertex Group Solutions");
        
        // Set the location of the JLabel
        label.setBounds(250, 285, 510, 80); // X, Y, width, height
        
        Font font = new Font("Arial", Font.BOLD, 45); // Font name, style, size
        label.setFont(font);
        
        label.setForeground(Color.decode("#b39700"));
        
        // Create a bottom border for the label
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#19566B")); // Top, left, bottom, right
        frame.getContentPane().add(pn);

        // Set the border of the label
        label.setBorder(border);

        
        // Add the JLabel to the JFrame
        pn.add(label);
        
        
     // Create a JLabel and set its text
        JLabel label2 = new JLabel("Crafting the Foundations of Tomorrow");
     // Set the location of the JLabel
        label2.setBounds(290, 365, 500, 50); // X, Y, width, height
        
        Font font2 = new Font("Consolas", Font.BOLD, 22); // Font name, style, size
        label2.setFont(font2);
        
        label2.setForeground(Color.decode("#19566B"));
        pn.add(label2);
        
     
       
        pn.add(bt);
        pn.add(bt2);
        



        
        frame.getContentPane().add(pn);

        frame.setVisible(true);
    }
}