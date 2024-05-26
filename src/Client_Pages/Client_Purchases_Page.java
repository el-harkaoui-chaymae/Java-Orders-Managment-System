package Client_Pages;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;

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
			
			
			
			// center page panel
		    int pn1_x = (int) ((140*frame.getWidth())/900);
		    int pn1_y = (int) ((70*frame.getHeight())/600);
		    int pn1_width = (int) ((800*frame.getWidth())/900);
		    int pn1_height = (int) ((580*frame.getHeight())/600);
		    Custom_Panel center_panel = new Custom_Panel(pn1_x,pn1_y,pn1_width,pn1_height,"#FFFFFF");
		    client_space.space.add(center_panel);
			
		    
		    
		    
		    // search button 
		    int bt4_x = (int) ((686*frame.getWidth())/900);
		    int bt4_y = (int) ((10*frame.getHeight())/600);
		    int bt4_width = (int) ((15*frame.getWidth())/900);
		    int bt4_height = (int) ((20*frame.getHeight())/600);
	        Custom_Button button_search = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
	        "","#000000","Consolas",7,false);
	        center_panel.add(button_search);
	        
	        
	       
	        
	        // label 17 - search icon
		    int lb17_x = (int) ((686*frame.getWidth())/900);
		    int lb17_y = (int) ((21*frame.getHeight())/600);
		    int lb17_width = (int) ((15*frame.getWidth())/900);
		    int lb17_height = (int) ((20*frame.getHeight())/600);
	        Custom_Label lab17 = new Custom_Label(lb17_x, lb17_y, lb17_width, lb17_height,"",
	        "Calibri",7,"#b39700");
	        lab17.add_background("Needed images\\search_icon.png");
	        center_panel.add(lab17);
	        
	        
	        // search text_field
	        int x_s = (int) ((457*frame.getWidth())/900);
		    int y_s = (int) ((20*frame.getHeight())/600);
		    int width_s = (int) ((250*frame.getWidth())/900);
		    int height_s = (int) ((23*frame.getHeight())/600);
		    int font_size_s = (int) ((11*frame.getWidth())/900);
		    Custom_Text_Field search = new Custom_Text_Field(x_s,y_s,width_s,height_s,"Segoe Print",font_size_s,"#000000") ;
		    search.setText(" search per date ...");
		    center_panel.add(search);
		    
		    
		    
		    
		    
		    
		    
		    
	        new Client_Purchase_Displayer(frame,center_panel,20,80,687,165); 
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
			
			
			// handle resizing
	        new Custom_Resizing_Manager(frame);
	        new Custom_Resizing_Manager(client_space.space);
	        new Custom_Resizing_Manager(center_panel);
	        
			    	
			    	
			    	
			    	
		}

}
