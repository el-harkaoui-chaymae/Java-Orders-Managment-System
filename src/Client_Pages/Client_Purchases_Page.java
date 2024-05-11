package Client_Pages;

import java.awt.Color;

import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Resizing_Manager;

public class Client_Purchases_Page {
	
	    // constructor
		public Client_Purchases_Page (Custom_Frame frame) {
			
			// create the client space elements
			Client_Space client_space = new Client_Space(frame);
					
			// change purchases button background to show that it's clicked
			client_space.purchases.setBackground(Color.decode("#002F5E"));
			client_space.labpr.setBackground(Color.decode("#002F5E"));
			client_space.purchases.change_color_background("#002F5E","#002F5E",client_space.labpr);
			client_space.purchases.change_style("#b39700","#b39700");
			
			
			
			
			
			
			
			
			// handle resizing
	        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
	        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(client_space.space);
	        
			    	
			    	
			    	
			    	
		}

}
