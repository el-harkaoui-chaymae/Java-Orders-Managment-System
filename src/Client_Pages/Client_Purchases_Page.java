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
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    

			// Purchase information panel
			int pn2_x = (int) ((20*frame.getWidth())/900);
		    int pn2_y = (int) ((80*frame.getHeight())/600);
		    int pn2_width = (int) ((687*frame.getWidth())/900);
		    int pn2_height = (int) ((165*frame.getHeight())/600);
		    Custom_Panel purchase_displayer = new Custom_Panel(pn2_x,pn2_y,pn2_width,pn2_height,"#FFFFFF");
		    Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#B4B4B4")); // Top-left-bottom-right
		    purchase_displayer.setBorder(border);
		    center_panel.add(purchase_displayer);
		    
		    
		    
		    // label - Purchase 
		    int lp_x = (int) ((20*frame.getWidth())/900);
		    int lp_y = (int) ((15*frame.getHeight())/600);
		    int lp_width = (int) ((100*frame.getWidth())/900);
		    int lp_height = (int) ((25*frame.getHeight())/600);
		    int lp_font_size = (int) ((14*frame.getWidth())/900);
		    Custom_Label lp = new Custom_Label(lp_x, lp_y, lp_width, lp_height,
	        "Purchase","Segoe Print",lp_font_size,"#2F5597");
	        lp.setHorizontalAlignment(SwingConstants.LEFT);
	        purchase_displayer.add(lp);
	        
	        
	        
	        // label - date 
		    int ld_x = (int) ((130*frame.getWidth())/900);
		    int ld_y = (int) ((18*frame.getHeight())/600);
		    int ld_width = (int) ((250*frame.getWidth())/900);
		    int ld_height = (int) ((25*frame.getHeight())/600);
		    int ld_font_size = (int) ((12*frame.getWidth())/900);
		    Custom_Label ld = new Custom_Label(ld_x, ld_y, ld_width, ld_height,
	        "2024-05-26 -- 15:25:45","Consolas",ld_font_size,"#000000");
	        ld.setHorizontalAlignment(SwingConstants.LEFT);
	        purchase_displayer.add(ld);
	        
	        
	        
	        
	        // label - total cost 
		    int lc_x = (int) ((350*frame.getWidth())/900);
		    int lc_y = (int) ((18*frame.getHeight())/600);
		    int lc_width = (int) ((250*frame.getWidth())/900);
		    int lc_height = (int) ((25*frame.getHeight())/600);
		    int lc_font_size = (int) ((12*frame.getWidth())/900);
		    Custom_Label lc = new Custom_Label(lc_x, lc_y, lc_width, lc_height,
	        "1093 Dhs","Consolas",lc_font_size,"#C00000");
	        lc.setHorizontalAlignment(SwingConstants.LEFT);
	        purchase_displayer.add(lc);
	        
	        
	        
	        
	        // label - total items 
		    int li_x = (int) ((20*frame.getWidth())/900);
		    int li_y = (int) ((50*frame.getHeight())/600);
		    int li_width = (int) ((250*frame.getWidth())/900);
		    int li_height = (int) ((25*frame.getHeight())/600);
		    int li_font_size = (int) ((12*frame.getWidth())/900);
		    Custom_Label li = new Custom_Label(li_x, li_y, li_width, li_height,
	        "Total Items :","Consolas",li_font_size,"#b39700");
	        li.setHorizontalAlignment(SwingConstants.LEFT);
	        purchase_displayer.add(li);
	        
	        

	        // label - total items number
		    int lt_x = (int) ((130*frame.getWidth())/900);
		    int lt_y = (int) ((50*frame.getHeight())/600);
		    int lt_width = (int) ((250*frame.getWidth())/900);
		    int lt_height = (int) ((25*frame.getHeight())/600);
		    int lt_font_size = (int) ((12*frame.getWidth())/900);
		    Custom_Label lt = new Custom_Label(lt_x, lt_y, lt_width, lt_height,
	        "20","Consolas",lt_font_size,"#000000");
	        lt.setHorizontalAlignment(SwingConstants.LEFT);
	        purchase_displayer.add(lt);
			
		    
		   
	        
	        // label - satus 
		    int ls_x = (int) ((20*frame.getWidth())/900);
		    int ls_y = (int) ((75*frame.getHeight())/600);
		    int ls_width = (int) ((250*frame.getWidth())/900);
		    int ls_height = (int) ((25*frame.getHeight())/600);
		    int ls_font_size = (int) ((12*frame.getWidth())/900);
		    Custom_Label ls = new Custom_Label(ls_x, ls_y, ls_width, ls_height,
	        "Status :","Consolas",ls_font_size,"#b39700");
	        ls.setHorizontalAlignment(SwingConstants.LEFT);
	        purchase_displayer.add(ls);
		    
		    
		    

	        // label - purchase status
		    int lss_x = (int) ((130*frame.getWidth())/900);
		    int lss_y = (int) ((75*frame.getHeight())/600);
		    int lss_width = (int) ((250*frame.getWidth())/900);
		    int lss_height = (int) ((25*frame.getHeight())/600);
		    int lss_font_size = (int) ((12*frame.getWidth())/900);
		    Custom_Label lss = new Custom_Label(lss_x, lss_y, lss_width, lss_height,
	        "not shipped","Consolas",lss_font_size,"#000000");
	        lss.setHorizontalAlignment(SwingConstants.LEFT);
	        purchase_displayer.add(lss);
		    
		    
		    
		    

	        // cancel purchase button 
		    int bt2_x = (int) ((150*frame.getWidth())/900);
		    int bt2_y = (int) ((120*frame.getHeight())/600);
		    int bt2_width = (int) ((200*frame.getWidth())/900);
		    int bt2_height = (int) ((25*frame.getHeight())/600);
		    int bt2_font_size = (int) ((12*frame.getWidth())/900);
	        Custom_Button cancel = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
	        "Cancel Purchase","#FFFFFF","Consolas",bt2_font_size,true);
	        cancel.setRound_shape_variables(35, 35);
	        cancel.setHorizontalAlignment(SwingConstants.CENTER);
	        purchase_displayer.add(cancel);
	        
	        
	        
	        // purchase details button 
		    int bt1_x = (int) ((20*frame.getWidth())/900);
		    int bt1_y = (int) ((120*frame.getHeight())/600);
		    int bt1_width = (int) ((100*frame.getWidth())/900);
		    int bt1_height = (int) ((25*frame.getHeight())/600);
		    int bt1_font_size = (int) ((12*frame.getWidth())/900);
	        Custom_Button details = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
	        "Details","#FFFFFF","Consolas",bt1_font_size,true);
	        details.setRound_shape_variables(35, 35);
	        details.setHorizontalAlignment(SwingConstants.CENTER);
	        purchase_displayer.add(details);
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
			
			
			// handle resizing
	        new Custom_Resizing_Manager(frame);
	        new Custom_Resizing_Manager(client_space.space);
	        new Custom_Resizing_Manager(center_panel);
	        
			    	
			    	
			    	
			    	
		}

}
