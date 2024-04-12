
package Graphical_Interface;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.imageio.ImageIO;
 

public class Custom_Frame extends JFrame {

    
	public Custom_Frame() {
    	
    	
        // Call the superclass constructor with a title
        super("Vertex Group Solutions");
        
        // set the Layout to null for absolute constrol
        this.setLayout(null); 
 
      
     	// set size and position
     	setBounds(400,100,900,600); 
        
 
        // Set default close operation 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // Load the frame icon - logo
        Image icon = null;
        try { icon = ImageIO.read(new File("frame_icon.png")); }
        catch (IOException e) { e.printStackTrace();}
       
        
        // Set the icon for the frame
        if (icon != null) { this.setIconImage(icon); }
        
        
        // Make the frame visible
        this.setVisible(true); 
        
        
        
        
        // handle frame resizing
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component[] components = getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JComponent) {
                        
                        // frame parameters after resizing
                        int width_fa = getWidth();
                        int height_fa = getHeight();
                        
                        // determine new  size
                        int width_a = (width_fa);
                        int height_a = (height_fa);

                        // set new parameters for the component
                        component.setBounds(0, 0, width_a, height_a);
                  
                    }}}});
    

    
    }
    
}

    

