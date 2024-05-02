package Pages;

import javax.swing.SwingConstants;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;

import Data_Base.Client;

import java.awt.Color;


public class Client_Space_Page {
	
	// construtor
	public Client_Space_Page(Custom_Frame frame){
		
		
		
		// page panel
		Custom_Panel space = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
		space.add_background("Needed images\\client_space.png");
		
		
	    
	    
	    // menu panel
	    int pn1_x = (int) ((40*frame.getWidth())/900);
	    int pn1_width = (int) ((90*frame.getWidth())/900);
		Custom_Panel menu = new Custom_Panel(pn1_x,0,pn1_width,frame.getHeight(),"#2F5597");
		space.add(menu);
		
		// label 2 - menu
	    int lb1_x = (int) ((0*frame.getWidth())/900);
	    int lb1_y = (int) ((15*frame.getHeight())/600);
	    int lb1_width = (int) ((90*frame.getWidth())/900);
	    int lb1_height = (int) ((41*frame.getHeight())/600);
	    int lb1_font_size = (int) ((17*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,
        "Menu","Segoe Print",lb1_font_size,"#2F5597");
        lab1.setHorizontalAlignment(SwingConstants.CENTER);
        lab1.setBackground(Color.decode("#b7c9e2"));
        lab1.setOpaque(true);
        menu.add(lab1);
        
        
        
        
        // label 4 - -------
	    int lb4_x = (int) ((130*frame.getWidth())/900);
	    int lb4_y = (int) ((46*frame.getHeight())/600);
	    int lb4_width = (int) ((770*frame.getWidth())/900);
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
	    int bt1_x = (int) ((0*frame.getWidth())/900);
	    int bt1_y = (int) ((77*frame.getHeight())/600);
	    int bt1_width = (int) ((90*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button profile = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Profile","#FFFFFF",font,bt1_font_size,false);
        profile.setBackground(Color.decode("#2F5597"));
        profile.setOpaque(true);
        profile.change_style("#b39700","#FFFFFF");
        profile.change_color_background(color,"#2F5597");
        menu.add(profile);
        
        
        
        // products button 
	    int bt2_x = (int) ((0*frame.getWidth())/900);
	    int bt2_y = (int) ((140*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button products = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Products","#FFFFFF",font,bt2_font_size,false);
        products.setBackground(Color.decode("#2F5597"));
        products.setOpaque(true);
        products.change_style("#b39700","#FFFFFF");
        products.change_color_background(color,"#2F5597");
        menu.add(products);
        
        
        
        // purchase button 
	    int bt3_x = (int) ((0*frame.getWidth())/900);
	    int bt3_y = (int) ((203*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button purchases = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Purchases","#FFFFFF",font,bt3_font_size,false);
        purchases.setBackground(Color.decode("#2F5597"));
        purchases.setOpaque(true);
        purchases.change_style("#b39700","#FFFFFF");
        purchases.change_color_background(color,"#2F5597");
        menu.add(purchases);
        
        
        
        // orders button 
	    int bt4_x = (int) ((0*frame.getWidth())/900);
	    int bt4_y = (int) ((266*frame.getHeight())/600);
	    int bt4_width = (int) ((90*frame.getWidth())/900);
	    int bt4_height = (int) ((40*frame.getHeight())/600);
	    int bt4_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button orders = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "Orders","#FFFFFF",font,bt4_font_size,false);
        orders.setBackground(Color.decode("#2F5597"));
        orders.setOpaque(true);
        orders.change_style("#b39700","#FFFFFF");
        orders.change_color_background(color,"#2F5597");
        menu.add(orders);
        
        
        
        // favorites button 
	    int bt5_x = (int) ((0*frame.getWidth())/900);
	    int bt5_y = (int) ((329*frame.getHeight())/600);
	    int bt5_width = (int) ((90*frame.getWidth())/900);
	    int bt5_height = (int) ((40*frame.getHeight())/600);
	    int bt5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button favorites = new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "Favorites","#FFFFFF",font,bt5_font_size,false);
        favorites.setBackground(Color.decode("#2F5597"));
        favorites.setOpaque(true);
        favorites.change_style("#b39700","#FFFFFF");
        favorites.change_color_background(color,"#2F5597");
        menu.add(favorites);
        
        
        
        // log out button 
	    int bt6_x = (int) ((0*frame.getWidth())/900);
	    int bt6_y = (int) ((392*frame.getHeight())/600);
	    int bt6_width = (int) ((90*frame.getWidth())/900);
	    int bt6_height = (int) ((40*frame.getHeight())/600);
	    int bt6_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button log_out = new Custom_Button(bt6_x,bt6_y,bt6_width,bt6_height,
        "Log out","#FFFFFF",font,bt6_font_size,false);
        log_out.setBackground(Color.decode("#2F5597"));
        log_out.setOpaque(true);
        log_out.change_style("#b39700","#FFFFFF");
        log_out.change_color_background(color,"#2F5597");
        menu.add(log_out);
		
        
        
        // label 3 - hello
	    int lb3_x = (int) ((440*frame.getWidth())/900);
	    int lb3_y = (int) ((150*frame.getHeight())/600);
	    int lb3_width = (int) ((100*frame.getWidth())/900);
	    int lb3_height = (int) ((110*frame.getHeight())/600);
	    int lb3_font_size = (int) ((22*frame.getWidth())/900);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,"Hello !!","Consolas",lb3_font_size,"#C00000");
        space.add(lab3);
        
		
        
        
        
        
		
		
		
		
		
		
		 // add space panel to the frame 
        frame.getContentPane().add(space);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(menu);
         

		
	}

}
