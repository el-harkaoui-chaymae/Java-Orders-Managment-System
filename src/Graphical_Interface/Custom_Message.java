package Graphical_Interface;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Custom_Message extends JFrame {
	
	// contructor
	public Custom_Message(int x1,int x2,String icon_path,String bar_text,String message) {
		

		// Call the superclass constructor with a title
        super(bar_text);
		
		// set the Layout to null for absolute constrol
        this.setLayout(null);
       
        
        // Disable frame resizing
        this.setResizable(false);
		
		// set the position and size
        this.setBounds(570,300,400,200);
                
     	
        // Set the background color of the frame
        this.getContentPane().setBackground(Color.decode("#D0E6F0"));
        
     
        // Load the frame icon - logo
        Image icon = null;
        try { icon = ImageIO.read(new File(icon_path)); }
        catch (IOException e) { e.printStackTrace();}
       
        
        // Set the icon for the frame
        if (icon != null) { this.setIconImage(icon); }
        
        
        
        // label  - message text
        Custom_Label lab = new Custom_Label(x1, 30, 500, 50,
        message,"Consolas",16 ,"#000000");
        lab.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(lab);
        
        // ok button
        Custom_Button Ok = new Custom_Button(x2,80,100,30,"Ok",
        "#FFFFFF","Consolas",16,true);
        Ok.setRound_shape_variables(35, 35);
        this.add(Ok);
        // action
        Ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the frame
                dispose();
            }
        });

              

        
        
        // Make the frame visible
        this.setVisible(true);
		
		

		
		
		
		
	}
	
	

}
