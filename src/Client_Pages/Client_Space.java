package Client_Pages;

import javax.swing.SwingConstants;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;

import Data_Base.Client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client_Space {
	
	// attributes
	public Custom_Panel space;

	public Custom_Button profile;
	public Custom_Button products;
	public Custom_Button purchases;
	public Custom_Button orders;
	public Custom_Button favorites;
	public Custom_Button settings;

		
	public Custom_Label labp;
	public Custom_Label labr;
	public Custom_Label labpr;
	public Custom_Label labo;
	public Custom_Label labf;
	public Custom_Label labg;
	public Custom_Label labs;




	
	// construtor
	public Client_Space(Custom_Frame frame){
		
		
		
		// page panel
		space = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
		space.add_background("Needed images\\client_space.png");
		
		
	    
	    
	    // menu panel
	    int pn1_x = (int) ((0*frame.getWidth())/900);
	    int pn1_width = (int) ((120*frame.getWidth())/900);
		Custom_Panel menu = new Custom_Panel(pn1_x,0,pn1_width,frame.getHeight(),"#2F5597");
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
        "Menu","Segoe Print",lb1_font_size,"#2F5597");
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
        
        
        
        // label 5 - user icon
	    int lb5_x = (int) ((850*frame.getWidth())/900);
	    int lb5_y = (int) ((20*frame.getHeight())/600);
	    int lb5_width = (int) ((16*frame.getWidth())/900);
	    int lb5_height = (int) ((20*frame.getHeight())/600);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,"","Consolas",7,"#808080");
        lab5.add_background("Needed images\\user_on.png");
        space.add(lab5);
        
        
        
        // get the client infos
        
        // create a virtual client with the same valid entered mail in the sign in page
        Client client = new Client(null,null,null,null,null,Client_Sign_In_Page.mail,null);
        // use this mail to get client infos
        String[] informations = client.get_informations();
        // retrieve the first an second name 
        String first_name = informations[0];
        String second_name = informations[1];
        
        
        // label 6 - client name
	    int lb6_x = (int) ((633*frame.getWidth())/900);
	    int lb6_y = (int) ((21*frame.getHeight())/600);
	    int lb6_width = (int) ((200*frame.getWidth())/900);
	    int lb6_height = (int) ((20*frame.getHeight())/600);
	    int lb6_font_size = (int) ((11*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,first_name +" "+ second_name,
        "Segoe Print",lb6_font_size,"#C00000");
        lab6.setHorizontalAlignment(SwingConstants.RIGHT);
        space.add(lab6);
        
        
        
     
        
        // color
        String color = "#002F5E";
        // font
        String font = "calibri";
       
        
        
        // profile button 
	    int bt1_x = (int) ((30*frame.getWidth())/900);
	    int bt1_y = (int) ((77*frame.getHeight())/600);
	    int bt1_width = (int) ((90*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        profile = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Profile","#FFFFFF",font,bt1_font_size,false);
        profile.setBackground(Color.decode("#2F5597"));
        profile.setOpaque(true);
        profile.change_style("#b39700","#FFFFFF");
        menu.add(profile);
        
        // action
        profile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// remove client space page 
                frame.getContentPane().removeAll();    
                
                // open client profile page 
                Client_Profile_Page client_page = new Client_Profile_Page (frame);                       
                
                // refresh the window
                frame.revalidate();
                frame.repaint();            		
            	}});
        
        
        
        // label  - profile icon
	    int lbp_x = (int) ((0*frame.getWidth())/900);
	    int lbp_y = (int) ((77*frame.getHeight())/600);
	    int lbp_width = (int) ((30*frame.getWidth())/900);
	    int lbp_height = (int) ((40*frame.getHeight())/600);
        labp = new Custom_Label(lbp_x, lbp_y, lbp_width, lbp_height,
        "","Segoe Print",7,"#2F5597");
        labp.setBackground(Color.decode("#2F5597"));
        labp.setOpaque(true);
        labp.add_background("Needed images\\user_icon.png");
        menu.add(labp);
        profile.change_color_background(color,"#2F5597",labp);
        
        
       
       
        
        
        // products button 
	    int bt2_x = (int) ((30*frame.getWidth())/900);
	    int bt2_y = (int) ((140*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        products = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Products","#FFFFFF",font,bt2_font_size,false);
        products.setBackground(Color.decode("#2F5597"));
        products.setOpaque(true);
        products.change_style("#b39700","#FFFFFF");
        menu.add(products);
        
        // action
        products.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// remove client space page 
                frame.getContentPane().removeAll();    
                
                // open client products page 
                Client_Products_Page client_page = new Client_Products_Page (frame);                       
                
                // refresh the window
                frame.revalidate();
                frame.repaint();            		
            	}});
        
        
        
        // label  - products icon
	    int lbr_x = (int) ((0*frame.getWidth())/900);
	    int lbr_y = (int) ((140*frame.getHeight())/600);
	    int lbr_width = (int) ((30*frame.getWidth())/900);
	    int lbr_height = (int) ((40*frame.getHeight())/600);
        labr = new Custom_Label(lbr_x, lbr_y, lbr_width, lbr_height,
        "","Segoe Print",7,"#2F5597");
        labr.setBackground(Color.decode("#2F5597"));
        labr.setOpaque(true);
        labr.add_background("Needed images\\product_icon.png");
        menu.add(labr);
        products.change_color_background(color,"#2F5597",labr);
        
        
        
        
        
        
        // purchase button 
	    int bt3_x = (int) ((30*frame.getWidth())/900);
	    int bt3_y = (int) ((203*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        purchases = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Purchases","#FFFFFF",font,bt3_font_size,false);
        purchases.setBackground(Color.decode("#2F5597"));
        purchases.setOpaque(true);
        purchases.change_style("#b39700","#FFFFFF");
        menu.add(purchases);
        
        // action
        purchases.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// remove client space page 
                frame.getContentPane().removeAll();    
                
                // open client purchases page 
                Client_Purchases_Page client_page = new Client_Purchases_Page (frame);                       
                
                // refresh the window
                frame.revalidate();
                frame.repaint();            		
            	}});
        
        
        // label  - purchase icon
	    int lbpr_x = (int) ((0*frame.getWidth())/900);
	    int lbpr_y = (int) ((203*frame.getHeight())/600);
	    int lbpr_width = (int) ((30*frame.getWidth())/900);
	    int lbpr_height = (int) ((40*frame.getHeight())/600);
        labpr = new Custom_Label(lbpr_x, lbpr_y, lbpr_width, lbpr_height,
        "","Segoe Print",7,"#2F5597");
        labpr.setBackground(Color.decode("#2F5597"));
        labpr.setOpaque(true);
        labpr.add_background("Needed images\\purchase_icon.png");
        menu.add(labpr);
        purchases.change_color_background(color,"#2F5597",labpr);
        
        
        
        
        
        
        
        // orders button 
	    int bt4_x = (int) ((30*frame.getWidth())/900);
	    int bt4_y = (int) ((266*frame.getHeight())/600);
	    int bt4_width = (int) ((90*frame.getWidth())/900);
	    int bt4_height = (int) ((40*frame.getHeight())/600);
	    int bt4_font_size = (int) ((12*frame.getWidth())/900);
        orders = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "Orders","#FFFFFF",font,bt4_font_size,false);
        orders.setBackground(Color.decode("#2F5597"));
        orders.setOpaque(true);
        orders.change_style("#b39700","#FFFFFF");
        menu.add(orders);
        
        // action
        orders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// remove client space page 
                frame.getContentPane().removeAll();    
                
                // open client orders page 
                Client_Orders_Page client_page = new Client_Orders_Page (frame);                       
                
                // refresh the window
                frame.revalidate();
                frame.repaint();            		
            	}});
        
        
        // label  - orders icon
	    int lbo_x = (int) ((0*frame.getWidth())/900);
	    int lbo_y = (int) ((266*frame.getHeight())/600);
	    int lbo_width = (int) ((30*frame.getWidth())/900);
	    int lbo_height = (int) ((40*frame.getHeight())/600);
        labo = new Custom_Label(lbo_x, lbo_y, lbo_width, lbo_height,
        "","Segoe Print",7,"#2F5597");
        labo.setBackground(Color.decode("#2F5597"));
        labo.setOpaque(true);
        labo.add_background("Needed images\\order_icon.png");
        menu.add(labo);
        orders.change_color_background(color,"#2F5597",labo);
        
        
        
       
        
        
        
        // favorites button 
	    int bt5_x = (int) ((30*frame.getWidth())/900);
	    int bt5_y = (int) ((329*frame.getHeight())/600);
	    int bt5_width = (int) ((90*frame.getWidth())/900);
	    int bt5_height = (int) ((40*frame.getHeight())/600);
	    int bt5_font_size = (int) ((12*frame.getWidth())/900);
        favorites = new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "Favorites","#FFFFFF",font,bt5_font_size,false);
        favorites.setBackground(Color.decode("#2F5597"));
        favorites.setOpaque(true);
        favorites.change_style("#b39700","#FFFFFF");
        menu.add(favorites);
        
        // action
        favorites.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// remove client space page 
                frame.getContentPane().removeAll();    
                
                // open client favorites page 
                Client_Favorites_Page client_page = new Client_Favorites_Page (frame);                       
                
                // refresh the window
                frame.revalidate();
                frame.repaint();            		
            	}});
        
        
        
        // label  - favorites icon
	    int lbf_x = (int) ((0*frame.getWidth())/900);
	    int lbf_y = (int) ((329*frame.getHeight())/600);
	    int lbf_width = (int) ((30*frame.getWidth())/900);
	    int lbf_height = (int) ((40*frame.getHeight())/600);
        labf = new Custom_Label(lbf_x, lbf_y, lbf_width, lbf_height,
        "","Segoe Print",7,"#2F5597");
        labf.setBackground(Color.decode("#2F5597"));
        labf.setOpaque(true);
        labf.add_background("Needed images\\favorite_icon.png");
        menu.add(labf);
        favorites.change_color_background(color,"#2F5597",labf);
        
        
        
        
        
        
        
        
        
        
        // log out button 
	    int bt6_x = (int) ((30*frame.getWidth())/900);
	    int bt6_y = (int) ((392*frame.getHeight())/600);
	    int bt6_width = (int) ((90*frame.getWidth())/900);
	    int bt6_height = (int) ((40*frame.getHeight())/600);
	    int bt6_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button log_out = new Custom_Button(bt6_x,bt6_y,bt6_width,bt6_height,
        "Log out","#FFFFFF",font,bt6_font_size,false);
        log_out.setBackground(Color.decode("#2F5597"));
        log_out.setOpaque(true);
        log_out.change_style("#b39700","#FFFFFF");
        menu.add(log_out);
        // log out action
        log_out.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove client space  page
              frame.getContentPane().removeAll();    
              // create an instance client sign in page 
              Client_Sign_In_Page sign_in__page = new Client_Sign_In_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        // label  - log out icon
	    int lbg_x = (int) ((0*frame.getWidth())/900);
	    int lbg_y = (int) ((392*frame.getHeight())/600);
	    int lbg_width = (int) ((30*frame.getWidth())/900);
	    int lbg_height = (int) ((40*frame.getHeight())/600);
        labg = new Custom_Label(lbg_x, lbg_y, lbg_width, lbg_height,
        "","Segoe Print",7,"#2F5597");
        labg.setBackground(Color.decode("#2F5597"));
        labg.setOpaque(true);
        labg.add_background("Needed images\\logout_icon.png");
        menu.add(labg);
        log_out.change_color_background(color,"#2F5597",labg);
        
     
		
		 
        
        
   
        
        
        
        // add space panel to the frame 
        frame.getContentPane().add(space);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(menu);
         

		
	}

}
