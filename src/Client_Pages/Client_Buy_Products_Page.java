package Client_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import java.io.ByteArrayInputStream;

import Data_Base.Client;
import Data_Base.Product;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;

public class Client_Buy_Products_Page {
	
	// attributes
	String Product_Category;
	int start_point_x = 25 ;
	int start_point_y = 20 ;
	int horizontal_spacing = 27;
	int vertical_spacing = 160;
	int index = 0;
	int page_capacity = 0 ;
	
	int current_page_start_index = 0 ;
	int current_page_end_index = 7 ;
	
	 
	
	ArrayList<Custom_Panel> products_displayers_panels = new ArrayList<>();
	

	
	

	// constructor
	public Client_Buy_Products_Page(Custom_Frame frame) {

		
		// create the client space elements
		Client_Space client_space = new Client_Space(frame);

		
		// change products button background to show that it's clicked
		client_space.products.setBackground(Color.decode("#002F5E"));
		client_space.labr.setBackground(Color.decode("#002F5E"));
		client_space.products.change_color_background("#002F5E", "#002F5E", client_space.labr);
		client_space.products.change_style("#b39700", "#b39700");

		
		// center page panel
		int pn1_x = (int) ((140 * frame.getWidth()) / 900);
		int pn1_y = (int) ((70 * frame.getHeight()) / 600);
		int pn1_width = (int) ((800 * frame.getWidth()) / 900);
		int pn1_height = (int) ((580 * frame.getHeight()) / 600);
		Custom_Panel center_panel = new Custom_Panel(pn1_x, pn1_y, pn1_width, pn1_height, "#FFFFFF");
		client_space.space.add(center_panel);
		
		
		
		// category title
	    int ls_x = (int) ((170*frame.getWidth())/900);
	    int ls_y = (int) ((14*frame.getHeight())/600);
	    int ls_width = (int) ((400*frame.getWidth())/900);
	    int ls_height = (int) ((30*frame.getHeight())/600);
	    int ls_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label ls = new Custom_Label(ls_x, ls_y, ls_width, ls_height,
        Client_Products_Page.Product_category+"  ...","Segoe Print",ls_font_size,"#008080");
        ls.setHorizontalAlignment(SwingConstants.LEFT);
        client_space.space.add(ls);
	    
	    
	    // ============================================================================================
	    
	    
	    
	    
	    // selected product category
        String selected_category = Client_Products_Page.Product_category;
        
        // virtual product
        Product virtual_product = new Product(selected_category,null,0,0,null,null,null,null,null);
        
        // get this category products
        ArrayList<Object[]> products = virtual_product.get_similar_products();
        
        for(Object[] product:products) {
        	
        	
        	if((index % 4 == 0) && (index!=0)) {
        		start_point_x = 25 ;
        		start_point_y += 70 + vertical_spacing;} 
        	
        	if((page_capacity == 8) ) {
        		
        		start_point_x = 25 ;
        		start_point_y = 20;
        		page_capacity = 0; }
        	
        	
        	
        	// needed infos
        	ByteArrayInputStream photo_5 =  (ByteArrayInputStream )product[5];
        	String product_name = product[2].toString();
        	String price = product[4].toString();
        	int product_id = (int) product[0];
        	
        	// create a virtual client with the same valid entered mail in the sign in page
            Client client = new Client(null,null,null,null,null,Client_Sign_In_Page.mail,null);
            
            // retrieve the id 
        	int id_client = client.get_client_id();
        	
        	
        	// display the products
        	Client_Product_Displayer displayer = new Client_Product_Displayer(frame,center_panel,start_point_x,start_point_y,150,200,
        	photo_5,product_name,price,product_id,id_client);
        	
        	products_displayers_panels.add(displayer.panel);
        	
        	start_point_x += 150 + horizontal_spacing;
        	
        	
        	index += 1 ;
        	
        	page_capacity += 1 ;
        	
        	
        	
        	
        }
        
        
		
        
        // ====================================================================================
        
        
        // previous image button 
	    int bt_x = (int) ((210*frame.getWidth())/900);
	    int bt_y = (int) ((465*frame.getHeight())/600);
	    int bt_width = (int) ((150*frame.getWidth())/900);
	    int bt_height = (int) ((30*frame.getHeight())/600);
	    int bt_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button previous = new Custom_Button(bt_x,bt_y,bt_width,bt_height,
        "<< previous","#808080","Segoe Print",bt_font_size,false);
        center_panel.add(previous);
        
        
        
        // next image button 
	    int bn_x = (int) ((370*frame.getWidth())/900);
	    int bn_y = (int) ((465*frame.getHeight())/600);
	    int bn_width = (int) ((100*frame.getWidth())/900);
	    int bn_height = (int) ((30*frame.getHeight())/600);
	    int bn_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button next = new Custom_Button(bn_x,bn_y,bn_width,bn_height,
        "next >>","#808080","Segoe Print",bn_font_size,false);
        center_panel.add(next);
		
        
        
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	// Check if there is a previous partition to show
                if (current_page_start_index > 0) {
                    // Hide the current partition
                    for (int i = current_page_start_index; i <= current_page_end_index && i < products_displayers_panels.size(); i++) {
                        products_displayers_panels.get(i).setVisible(false);}
                    
                    // Move to previous partition
                    current_page_start_index -= 8;
                    current_page_end_index = current_page_start_index + 7;
                    
                    // Ensure indices are within valid range
                    if (current_page_start_index < 0) {
                        current_page_start_index = 0;}
                    
                    if (current_page_end_index >= products_displayers_panels.size()) {
                        current_page_end_index = products_displayers_panels.size() - 1;}
                    // Show the new current partition
                    
                    for (int i = current_page_start_index; i <= current_page_end_index; i++) {
                        products_displayers_panels.get(i).setVisible(true);
                    }
                
                
                }}});

        
        
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	// Check if there is a next partition to show
                if (current_page_end_index < products_displayers_panels.size() - 1) {
                    // Hide the current partition
                    for (int i = current_page_start_index; i <= current_page_end_index; i++) {
                        products_displayers_panels.get(i).setVisible(false);}
                    
                    // Move to next partition
                    current_page_start_index += 8;
                    current_page_end_index = current_page_start_index + 7;
                    
                    // Ensure indices are within valid range
                    if (current_page_end_index >= products_displayers_panels.size()) {
                        current_page_end_index = products_displayers_panels.size() - 1;}
                    
                    // Show the new current partition
                    for (int i = current_page_start_index; i <= current_page_end_index; i++) {
                        products_displayers_panels.get(i).setVisible(true);}
                
                }}});

		
		
		
		
		
		
		
		
		
		

		// handle resizing
        new Custom_Resizing_Manager(frame);
        new Custom_Resizing_Manager(client_space.space);
        new Custom_Resizing_Manager(center_panel);

	}
            
}
