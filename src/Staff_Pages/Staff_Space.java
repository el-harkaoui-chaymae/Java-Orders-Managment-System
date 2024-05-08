package Staff_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Client_Pages.Client_Products_Page;
import Client_Pages.Client_Profile_Page;
import Client_Pages.Client_Purchases_Page;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;

public class Staff_Space {
	
	// attributes
	public Custom_Panel space;

	
	
	public Custom_Button stock;
	public Custom_Button client;
	public Custom_Button delivery;


	
	
	public Custom_Label labs;
	public Custom_Label labr;
	public Custom_Label labpr;

	

	
	
	
	
	


     
	// constructor
	public Staff_Space(Custom_Frame frame) {
		
		
		// page panel
		space = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
		space.add_background("Needed images\\client_space.png");
		
		// menu bar panel
		int pn1_x = (int) ((0*frame.getWidth())/900);
	    int pn1_width = (int) ((120*frame.getWidth())/900);
		Custom_Panel menu = new Custom_Panel(pn1_x,0,pn1_width,frame.getHeight(),"#002F5E");
		space.add(menu);
		
		// label  - menu icon
	    int lbm_x = (int) ((0*frame.getWidth())/900);
	    int lbm_y = (int) ((15*frame.getHeight())/600);
	    int lbm_width = (int) ((30*frame.getWidth())/900);
	    int lbm_height = (int) ((41*frame.getHeight())/600);
        Custom_Label labm = new Custom_Label(lbm_x, lbm_y, lbm_width, lbm_height,
        "","Segoe Print",7,"#2F5597");
        labm.setBackground(Color.decode("#b7c9e2"));
        labm.setOpaque(true);
        labm.add_background("Needed images\\menu_icon.png");
        menu.add(labm);
        
        
        // label 2 - menu
	    int lb1_x = (int) ((30*frame.getWidth())/900);
	    int lb1_y = (int) ((15*frame.getHeight())/600);
	    int lb1_width = (int) ((90*frame.getWidth())/900);
	    int lb1_height = (int) ((41*frame.getHeight())/600);
	    int lb1_font_size = (int) ((18*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,
        "Board","Segoe Print",lb1_font_size,"#2F5597");
        lab1.setHorizontalAlignment(SwingConstants.CENTER);
        lab1.setBackground(Color.decode("#b7c9e2"));
        lab1.setOpaque(true);
        menu.add(lab1);
        
        
        // label - above menu
	    int lb_x = (int) ((0*frame.getWidth())/900);
	    int lb_y = (int) ((0*frame.getHeight())/600);
	    int lb_width = (int) ((120*frame.getWidth())/900);
	    int lb_height = (int) ((15*frame.getHeight())/600);
        Custom_Label lab = new Custom_Label(lb_x, lb_y, lb_width, lb_height,
        "","Segoe Print",7,"#2F5597");
        lab.setBackground(Color.decode("#b7c9e2"));
        lab.setOpaque(true);
        menu.add(lab);
        
        
        
        

        // label 4 - -------
	    int lb4_x = (int) ((120*frame.getWidth())/900);
	    int lb4_y = (int) ((46*frame.getHeight())/600);
	    int lb4_width = (int) ((780*frame.getWidth())/900);
	    int lb4_height = (int) ((10*frame.getHeight())/600);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,"","Consolas",7,"#808080");
        lab4.create_bottom_border(1,"#B4B4B4");
        space.add(lab4);
        
        
        
        // color
        String color = "#2F5597";
        // font
        String font = "calibri";
        
        
        
        
        
        
        
        // label  - stock icon
	    int lbs_x = (int) ((0*frame.getWidth())/900);
	    int lbs_y = (int) ((77*frame.getHeight())/600);
	    int lbs_width = (int) ((30*frame.getWidth())/900);
	    int lbs_height = (int) ((40*frame.getHeight())/600);
        labs = new Custom_Label(lbs_x, lbs_y, lbs_width, lbs_height,
        "","Segoe Print",7,"#2F5597");
        labs.setBackground(Color.decode("#002F5E"));
        labs.setOpaque(true);
        labs.add_background("Needed images\\product_icon.png");
        menu.add(labs);
        
        
        // stock button 
	    int bt1_x = (int) ((30*frame.getWidth())/900);
	    int bt1_y = (int) ((77*frame.getHeight())/600);
	    int bt1_width = (int) ((90*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        stock = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Stock","#FFFFFF",font,bt1_font_size,false);
        stock.setBackground(Color.decode("#002F5E"));
        stock.setOpaque(true);
        stock.change_style("#b39700","#FFFFFF");
        menu.add(stock);
        stock.change_color_background(color,"#002F5E",labs);
        
        // action
        stock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// remove staff space page 
                frame.getContentPane().removeAll();    
                
                // open staff stock page 
                Staff_Stock_Page client_page = new Staff_Stock_Page (frame);                       
                
                // refresh the window
                frame.revalidate();
                frame.repaint();            		
            	}});

        
       
        
        
        
        
        
        // label  - client icon
	    int lbr_x = (int) ((0*frame.getWidth())/900);
	    int lbr_y = (int) ((140*frame.getHeight())/600);
	    int lbr_width = (int) ((30*frame.getWidth())/900);
	    int lbr_height = (int) ((40*frame.getHeight())/600);
        labr = new Custom_Label(lbr_x, lbr_y, lbr_width, lbr_height,
        "","Segoe Print",7,"#2F5597");
        labr.setBackground(Color.decode("#002F5E"));
        labr.setOpaque(true);
        labr.add_background("Needed images\\user_icon.png");
        menu.add(labr);
        
        

        // client button 
	    int bt2_x = (int) ((30*frame.getWidth())/900);
	    int bt2_y = (int) ((140*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        client = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Clients","#FFFFFF",font,bt2_font_size,false);
        client.setBackground(Color.decode("#002F5E"));
        client.setOpaque(true);
        client.change_style("#b39700","#FFFFFF");
        client.change_color_background(color,"#002F5E",labr);
        menu.add(client);
        
        
        
        
        
        
        
        
       // label  - delivery icon
	    int lbpr_x = (int) ((0*frame.getWidth())/900);
	    int lbpr_y = (int) ((203*frame.getHeight())/600);
	    int lbpr_width = (int) ((30*frame.getWidth())/900);
	    int lbpr_height = (int) ((40*frame.getHeight())/600);
        labpr = new Custom_Label(lbpr_x, lbpr_y, lbpr_width, lbpr_height,
        "","Segoe Print",7,"#2F5597");
        labpr.setBackground(Color.decode("#002F5E"));
        labpr.setOpaque(true);
        labpr.add_background("Needed images\\delivery_icon.png");
        menu.add(labpr);
        
        
        
        // delivery button 
	    int bt3_x = (int) ((30*frame.getWidth())/900);
	    int bt3_y = (int) ((203*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        delivery = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Deliveries","#FFFFFF",font,bt3_font_size,false);
        delivery.setBackground(Color.decode("#002F5E"));
        delivery.setOpaque(true);
        delivery.change_style("#b39700","#FFFFFF");
        delivery.change_color_background(color,"#002F5E",labpr);
        menu.add(delivery);
        
        
        
        
        
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// add space panel to the frame 
        frame.getContentPane().add(space);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(menu);
	}

}
