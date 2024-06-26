package Client_Pages;

import java.awt.Color;

import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Resizing_Manager;

public class Client_Favorites_Page {
	
	// constructor
    public Client_Favorites_Page (Custom_Frame frame) {
			
			// create the client space elements
			Client_Space client_space = new Client_Space(frame);
					

			// change favorites button background to show that it's clicked
			client_space.favorites.setBackground(Color.decode("#002F5E"));
			client_space.labf.setBackground(Color.decode("#002F5E"));
			client_space.favorites.change_color_background("#002F5E","#002F5E",client_space.labf);
			client_space.favorites.change_style("#b39700","#b39700");
			
			
			
			
			 
			 
			
			
			// handle resizing
	        new Custom_Resizing_Manager(frame);
	        new Custom_Resizing_Manager(client_space.space);
	        
			    	
			    	
			    	
			    	
		}


}
