
package Graphical_Interface;

import javax.swing.JFrame;

public class Custom_Frame extends JFrame {

    
	public Custom_Frame() {
    	
    	
        // Call the superclass constructor with a title
        super("Vertex Group Solutions");
        
        // set the Layout to null for absolute constrol
        this.setLayout(null);

        
        // maximizes the window to fit the screen size
     	setExtendedState(JFrame.MAXIMIZED_BOTH);
        

        // Set default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        this.setVisible(true); 
    }
    

   
    
    }
    
    

    

