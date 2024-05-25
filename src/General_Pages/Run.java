package General_Pages;

import Graphical_Interface.Custom_Frame;

public class Run{
	
	
	public static void main(String[] args) {
        
		// add a frame
		Custom_Frame frame = new Custom_Frame();
        
		// add the Splash Page-Panel to the frame
		Splash_Page splash = new Splash_Page(frame);
		
        // make the frame visible
        frame.setVisible(true);

	}
	  
	  
}