package Client_Pages;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Data_Base.Product;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Area;
import Graphical_Interface.Custom_Text_Field;
import Staff_Pages.Staff_Stock_Page;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;




public class Client_Product_Details {
	
	
	// attributes
	
	Custom_Label visible_lab;
		
	ByteArrayInputStream photo_1 ;
	ByteArrayInputStream photo_2 ; 
	ByteArrayInputStream photo_3 ;
		
	
	// array of photos labels 
	ArrayList<Custom_Label> photo_labels = new ArrayList<>();

	
	
	
	
	
	// constructor
	public Client_Product_Details(Custom_Frame frame) {

		// create the client space elements
		Client_Space client_space = new Client_Space(frame);

		// change products button background to show that it's clicked
		client_space.products.setBackground(Color.decode("#002F5E"));
		client_space.labr.setBackground(Color.decode("#002F5E"));
		client_space.products.change_color_background("#002F5E", "#002F5E", client_space.labr);
		client_space.products.setForeground(Color.decode("#b39700"));
		client_space.products.change_style("#b39700", "#b39700");

		
		
		
		
		
		

	    // create a virtual product
	    Product virtual_product = new Product(null,null,0,0,null,null,null,null,null);
	    virtual_product.setId(Client_Product_Displayer.productId);
	    
	    // get the selcted product details
	    Object[] product_details = virtual_product.get_details();
	    
	    
	    
	    
	    

	    // photos panel
	    int pn3_x = (int) ((150*frame.getWidth())/900);
	    int pn3_y = (int) ((80*frame.getHeight())/600);
	    int pn3_width = (int) ((200*frame.getWidth())/900);
	    int pn3_height = (int) ((200*frame.getHeight())/600);
	    Custom_Panel photos_panel = new Custom_Panel(pn3_x,pn3_y,pn3_width,pn3_height,"#FFFFFF");
	    client_space.space.add(photos_panel);
	    
	    
	    
	    
	    // product photo_1 label
	    int lb1_x = (int) ((40*frame.getWidth())/900);
	    int lb1_y = (int) ((18*frame.getHeight())/600);
	    int lb1_width = (int) ((120*frame.getWidth())/900);
	    int lb1_height = (int) ((130*frame.getHeight())/600);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,"",
        "Calibri",7,"#b39700");
        Border border = BorderFactory.createLineBorder(Color.decode("#2F5597"), 3);
        lab1.setBorder(border);
        photos_panel.add(lab1);
        
        // Read the image and set it into the Label
    	if(!(product_details[5] == null)) {
    		
    		try {
      		    photo_1 = (ByteArrayInputStream) product_details[5];
                lab1.setIcon(new ImageIcon(ImageIO.read(photo_1).getScaledInstance(lab1.getWidth(),
                lab1.getHeight(), Image.SCALE_SMOOTH)));}
          
      	    catch (Exception ex) { ex.printStackTrace();}}
    	
        
        
        
    	
    	
    	
    	
    	
    	
    	// product photo_2 label
	    int lb2_x = (int) ((40*frame.getWidth())/900);
	    int lb2_y = (int) ((18*frame.getHeight())/600);
	    int lb2_width = (int) ((120*frame.getWidth())/900);
	    int lb2_height = (int) ((130*frame.getHeight())/600);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,"",
        "Calibri",7,"#b39700");
        Border border2 = BorderFactory.createLineBorder(Color.decode("#b39700"), 3);
        lab2.setBorder(border2);
        photos_panel.add(lab2);
        lab2.setVisible(false);
        
        // set product photo_2
        if(!(product_details[6] == null)) {
        	
        	// Read the image and set it into the Label
        	try {
        		  photo_2 = (ByteArrayInputStream) product_details[6];
                  lab2.setIcon(new ImageIcon(ImageIO.read(photo_2).getScaledInstance(lab2.getWidth(),
                  lab2.getHeight(), Image.SCALE_SMOOTH)));}
            
        	catch (Exception ex) { ex.printStackTrace();} }
        
        
        
        
        
       
        
        
        
        
        
        
        // product photo_3 label
	    int lb3_x = (int) ((40*frame.getWidth())/900);
	    int lb3_y = (int) ((18*frame.getHeight())/600);
	    int lb3_width = (int) ((120*frame.getWidth())/900);
	    int lb3_height = (int) ((130*frame.getHeight())/600);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,"",
        "Calibri",7,"#b39700");
        Border border_3 = BorderFactory.createLineBorder(Color.decode("#C00000"), 3);
        lab3.setBorder(border_3);
        photos_panel.add(lab3);
        lab3.setVisible(false);
        
        
        // set product photo_3
        if(!(product_details[7] == null)) {
        	
        	// Read the image and set it into the Label
        	try {
        		  photo_3 = (ByteArrayInputStream) product_details[7];
                  lab3.setIcon(new ImageIcon(ImageIO.read(photo_3).getScaledInstance(lab3.getWidth(),
                  lab3.getHeight(), Image.SCALE_SMOOTH)));}
            
        	catch (Exception ex) { ex.printStackTrace();} }
        
        
        
        
        
        
        
        // handel labels resizing to ensure that the images always fit their containers
	    lab1.addComponentListener(new ComponentAdapter() {

	            @Override
	            public void componentResized(ComponentEvent e) {
	            	
	            	// reset photo 1
	            	if (product_details[5] != null) {
	            		
	            		try { 
	                    	   // Reset the stream to the beginning
	                           photo_1.reset();
	                           lab1.setIcon(new ImageIcon(ImageIO.read(photo_1).getScaledInstance(lab1.getWidth(),
	                           lab1.getHeight(), Image.SCALE_SMOOTH)));}
	               
	            	catch (Exception ex) {
	                    ex.printStackTrace();}}
	            	
	            	
	            	// reset photo 2
                    if (product_details[6] != null) {
	            		
	            		try {
	                    	   // Reset the stream to the beginning
	                           photo_2.reset();
	                           lab2.setIcon(new ImageIcon(ImageIO.read(photo_2).getScaledInstance(lab2.getWidth(),
	                           lab2.getHeight(), Image.SCALE_SMOOTH)));}
	               
	            	catch (Exception ex) {
	                    ex.printStackTrace();}}
                    
                    
                    // reset photo 3
                    if (product_details[7] != null) {
	            		
	            		try {
	                    	  // Reset the stream to the beginning
	                          photo_3.reset();
	                          lab3.setIcon(new ImageIcon(ImageIO.read(photo_3).getScaledInstance(lab3.getWidth(),
	                          lab3.getHeight(), Image.SCALE_SMOOTH)));}
	               
	            	catch (Exception ex) {
	                    ex.printStackTrace();}}
	            	
                    }});
        
        
        
        
        
        // photo number label
	    int lb4_x = (int) ((95*frame.getWidth())/900);
	    int lb4_y = (int) ((160*frame.getHeight())/600);
	    int lb4_width = (int) ((30*frame.getWidth())/900);
	    int lb4_font_size = (int) ((14*frame.getWidth())/900);
	    int lb4_height = (int) ((30*frame.getHeight())/600);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,"1",
        "Calibri",lb4_font_size,"#808080");
        photos_panel.add(lab4);
        
        
        
        
        // fill the previous labels array
        photo_labels.add(lab1); 
        photo_labels.add(lab2);
        photo_labels.add(lab3);
        
        
        
        
        
        
        
        
        
        // previous image button 
	    int bt_x = (int) ((35*frame.getWidth())/900);
	    int bt_y = (int) ((160*frame.getHeight())/600);
	    int bt_width = (int) ((70*frame.getWidth())/900);
	    int bt_height = (int) ((30*frame.getHeight())/600);
	    int bt_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Button previous_image = new Custom_Button(bt_x,bt_y,bt_width,bt_height,
        "<<","#808080","Consolas",bt_font_size,false);
        photos_panel.add(previous_image);
        
        
         
        // previous_image button action
        previous_image.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	// get the visible label
            	for (Custom_Label label:photo_labels) {
            		
            		if(label.isVisible()) {
            			
            			visible_lab = label;
            			break; }}
            	
            	// if the label is lab1
            	if(visible_lab == lab1) {
            		
            		lab1.setVisible(false);
            		lab2.setVisible(false);
            		lab3.setVisible(true);
            		lab4.setText("3");
            	}
            	
            	
            	// if the label is lab2
            	if(visible_lab == lab2) {
            		
            		lab2.setVisible(false);
            		lab3.setVisible(false);
            		lab1.setVisible(true);
            		lab4.setText("1");
            	}
            	
            	// if the label is lab3
            	if(visible_lab == lab3) {
            		
            		lab3.setVisible(false);
            		lab1.setVisible(false);
            		lab2.setVisible(true);
            		lab4.setText("2");
            	}
            	
            }});
        
        
        
        
        
        
        
        
        
        // next image button 
	    int bt2_x = (int) ((95*frame.getWidth())/900);
	    int bt2_y = (int) ((160*frame.getHeight())/600);
	    int bt2_width = (int) ((70*frame.getWidth())/900);
	    int bt2_height = (int) ((30*frame.getHeight())/600);
	    int bt2_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Button next_image = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        ">>","#808080","Consolas",bt2_font_size,false);
        photos_panel.add(next_image);
        
        // next_image button action
        next_image.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	// get the visible label
            	for (Custom_Label label:photo_labels) {
            		
            		if(label.isVisible()) {
            			
            			visible_lab = label;
            			break; }}
            	
            	// if the label is lab1
            	if(visible_lab == lab1) {
            		
            		lab1.setVisible(false);
            		lab2.setVisible(true);
            		lab3.setVisible(false);
            		lab4.setText("2");
            	}
            	
            	
            	// if the label is lab2
            	if(visible_lab == lab2) {
            		
            		lab2.setVisible(false);
            		lab3.setVisible(true);
            		lab1.setVisible(false);
            		lab4.setText("3");            	}
            	
            	// if the label is lab3
            	if(visible_lab == lab3) {
            		
            		lab3.setVisible(false);
            		lab1.setVisible(true);
            		lab2.setVisible(false);
            		lab4.setText("1");
            	}

            	   }});
        
        
        
        
        
        
        
        
        

		// general information panel
		int pn1_x = (int) ((390*frame.getWidth())/900);
	    int pn1_y = (int) ((80*frame.getHeight())/600);
	    int pn1_width = (int) ((450*frame.getWidth())/900);
	    int pn1_height = (int) ((200*frame.getHeight())/600);
	    Custom_Panel general_infos = new Custom_Panel(pn1_x,pn1_y,pn1_width,pn1_height,"#FFFFFF");
	    client_space.space.add(general_infos);
	    
	    
	    // label  - general information
	    int lb5_x = (int) ((10*frame.getWidth())/900);
	    int lb5_y = (int) ((10*frame.getHeight())/600);
	    int lb5_width = (int) ((200*frame.getWidth())/900);
	    int lb5_height = (int) ((30*frame.getHeight())/600);
	    int lb5_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,"General Information",
        "Segoe Print",lb5_font_size,"#2F5597");
        general_infos.add(lab5);
        
        
        
        
        // label  - product id
	    int lbi_x = (int) ((10*frame.getWidth())/900);
	    int lbi_y = (int) ((65*frame.getHeight())/600);
	    int lbi_width = (int) ((200*frame.getWidth())/900);
	    int lbi_height = (int) ((30*frame.getHeight())/600);
	    int lbi_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label labi = new Custom_Label(lbi_x, lbi_y, lbi_width, lbi_height,"Product Identifier :",
        "Calibri",lbi_font_size,"#b39700");
        general_infos.add(labi);
        
        
        // product id text field
        int x_i = (int) ((130*frame.getWidth())/900);
	    int y_i = (int) ((68*frame.getHeight())/600);
	    int width_i = (int) ((300*frame.getWidth())/900);
	    int height_i = (int) ((23*frame.getHeight())/600);
	    int font_size_i = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field product_id = new Custom_Text_Field(x_i,y_i,width_i,height_i,"Calibri",font_size_i,"#000000");
	    product_id.setBorder(new EmptyBorder(0, 0, 0, 0));
	    product_id.setEditable(false);
	    product_id.setBackground(Color.WHITE);
	    product_id.setText(product_details[0].toString());
	    general_infos.add(product_id);
        
        
       
	    
	    
	    
	    
	    // label  - product category
	    int lbc_x = (int) ((10*frame.getWidth())/900);
	    int lbc_y = (int) ((95*frame.getHeight())/600);
	    int lbc_width = (int) ((200*frame.getWidth())/900);
	    int lbc_height = (int) ((30*frame.getHeight())/600);
	    int lbc_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label labc = new Custom_Label(lbc_x, lbc_y, lbc_width, lbc_height,"Product Category :",
        "Calibri",lbc_font_size,"#b39700");
        general_infos.add(labc);
        
        
        // product category text field
        int x_c = (int) ((130*frame.getWidth())/900);
	    int y_c = (int) ((98*frame.getHeight())/600);
	    int width_c = (int) ((300*frame.getWidth())/900);
	    int height_c = (int) ((23*frame.getHeight())/600);
	    int font_size_c = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field product_category = new Custom_Text_Field(x_c,y_c,width_c,height_c,"Calibri",font_size_c,"#000000");
	    product_category.setBorder(new EmptyBorder(0, 0, 0, 0));
	    product_category.setEditable(false);
	    product_category.setBackground(Color.WHITE);
	    product_category.setText(product_details[1].toString());
	    general_infos.add(product_category);
        
        
        
       
	    
	    
	    
	    
	    // label  - product name
	    int lbn_x = (int) ((10*frame.getWidth())/900);
	    int lbn_y = (int) ((125*frame.getHeight())/600);
	    int lbn_width = (int) ((200*frame.getWidth())/900);
	    int lbn_height = (int) ((30*frame.getHeight())/600);
	    int lbn_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label labn = new Custom_Label(lbn_x, lbn_y, lbn_width, lbn_height,"Product Name :",
        "Calibri",lbn_font_size,"#b39700");
        general_infos.add(labn);
        
        
        // product name text field
        int x_n = (int) ((130*frame.getWidth())/900);
	    int y_n = (int) ((128*frame.getHeight())/600);
	    int width_n = (int) ((300*frame.getWidth())/900);
	    int height_n = (int) ((23*frame.getHeight())/600);
	    int font_size_n = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field product_name = new Custom_Text_Field(x_n,y_n,width_n,height_n,"Calibri",font_size_n,"#000000");
	    product_name.setBorder(new EmptyBorder(0, 0, 0, 0));
	    product_name.setEditable(false);
	    product_name.setBackground(Color.WHITE);
	    product_name.setText(product_details[2].toString());
	    general_infos.add(product_name);
        
        
        
       
	    
	    
	    
	    // label  - supplier
	    int lbs_x = (int) ((10*frame.getWidth())/900);
	    int lbs_y = (int) ((155*frame.getHeight())/600);
	    int lbs_width = (int) ((200*frame.getWidth())/900);
	    int lbs_height = (int) ((30*frame.getHeight())/600);
	    int lbs_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label labs = new Custom_Label(lbs_x, lbs_y, lbs_width, lbs_height,"Supplier :",
        "Calibri",lbs_font_size,"#b39700");
        general_infos.add(labs);
        
        
        // supplier text field
        int x_s = (int) ((130*frame.getWidth())/900);
	    int y_s = (int) ((158*frame.getHeight())/600);
	    int width_s = (int) ((300*frame.getWidth())/900);
	    int height_s = (int) ((23*frame.getHeight())/600);
	    int font_size_s = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field supplier = new Custom_Text_Field(x_s,y_s,width_s,height_s,"Calibri",font_size_s,"#000000");
	    supplier.setBorder(new EmptyBorder(0, 0, 0, 0));
	    supplier.setEditable(false);
	    supplier.setBackground(Color.WHITE);
	    supplier.setText(product_details[9].toString());
	    general_infos.add(supplier);
        
        
        
        
        
        
        
    
        
		// description information panel
		int pn2_x = (int) ((390*frame.getWidth())/900);
	    int pn2_y = (int) ((320*frame.getHeight())/600);
	    int pn2_width = (int) ((450*frame.getWidth())/900);
	    int pn2_height = (int) ((200*frame.getHeight())/600);
	    Custom_Panel description_infos = new Custom_Panel(pn2_x,pn2_y,pn2_width,pn2_height,"#FFFFFF");
	    client_space.space.add(description_infos);
	    
	    
	    // label  - description information
	    int lb6_x = (int) ((10*frame.getWidth())/900);
	    int lb6_y = (int) ((10*frame.getHeight())/600);
	    int lb6_width = (int) ((200*frame.getWidth())/900);
	    int lb6_height = (int) ((30*frame.getHeight())/600);
	    int lb6_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,"Product Description",
        "Segoe Print",lb6_font_size,"#2F5597");
        description_infos.add(lab6); 
        
        
        
        
        // product description text area
        int x_d = (int) ((10*frame.getWidth())/900);
	    int y_d = (int) ((68*frame.getHeight())/600);
	    int width_d = (int) ((425*frame.getWidth())/900);
	    int height_d = (int) ((110*frame.getHeight())/600);
	    int font_size_d = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Area description = new Custom_Text_Area(x_d,y_d,width_d,height_d,
	    "Calibri",font_size_d,"#000000") ;
	    description.setBorder(new EmptyBorder(0, 0, 0, 0));
	    description.setText(product_details[8].toString());
	    description.setEditable(false);
	    description_infos.add(description);
        
        
        
        
        // stock and pricing panel
	    int pn4_x = (int) ((150*frame.getWidth())/900);
	    int pn4_y = (int) ((320*frame.getHeight())/600);
	    int pn4_width = (int) ((200*frame.getWidth())/900);
	    int pn4_height = (int) ((200*frame.getHeight())/600);
	    Custom_Panel stock_pricing_panel = new Custom_Panel(pn4_x,pn4_y,pn4_width,pn4_height,"#FFFFFF");
	    client_space.space.add(stock_pricing_panel);
	    
	    
	    // label  - Product Availability and Cost
	    int lb7_x = (int) ((10*frame.getWidth())/900);
	    int lb7_y = (int) ((10*frame.getHeight())/600);
	    int lb7_width = (int) ((200*frame.getWidth())/900);
	    int lb7_height = (int) ((30*frame.getHeight())/600);
	    int lb7_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab7 = new Custom_Label(lb7_x, lb7_y, lb7_width, lb7_height,"Status and Cost",
        "Segoe Print",lb7_font_size,"#2F5597");
        stock_pricing_panel.add(lab7); 
	    
        
        
        
        
        
        
        // quantity text field
        int x_q = (int) ((10*frame.getWidth())/900);
	    int y_q = (int) ((65*frame.getHeight())/600);
	    int width_q = (int) ((100*frame.getWidth())/900);
	    int height_q = (int) ((23*frame.getHeight())/600);
	    int font_size_q = (int) ((15*frame.getWidth())/900);
	    Custom_Text_Field quantity = new Custom_Text_Field(x_q,y_q,width_q,height_q,"Consolas",font_size_q,"#008000");
	    quantity.setBorder(new EmptyBorder(0, 0, 0, 0));
	    quantity.setEditable(false);
	    quantity.setBackground(Color.WHITE);
	    
	    quantity.setText("In Stock");
	    
	    if(Double.valueOf(product_details[3].toString())<= 0) {
	    	quantity.setText("Out Of Stock");
	    	quantity.setForeground(Color.red);}
	   
	    stock_pricing_panel.add(quantity);
        
        
       
	    
	    
	    
	    
	    // label  - price
	    int lbp_x = (int) ((10*frame.getWidth())/900);
	    int lbp_y = (int) ((95*frame.getHeight())/600);
	    int lbp_width = (int) ((200*frame.getWidth())/900);
	    int lbp_height = (int) ((30*frame.getHeight())/600);
	    int lbp_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label labp = new Custom_Label(lbp_x, lbp_y, lbp_width, lbp_height,"Price :",
        "Calibri",lbp_font_size,"#b39700");
        stock_pricing_panel.add(labp);
        
        
        // price text field
        int x_p = (int) ((65*frame.getWidth())/900);
	    int y_p = (int) ((98*frame.getHeight())/600);
	    int width_p = (int) ((100*frame.getWidth())/900);
	    int height_p = (int) ((23*frame.getHeight())/600);
	    int font_size_p = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field price = new Custom_Text_Field(x_p,y_p,width_p,height_p,"Calibri",font_size_p,"#000000");
	    price.setBorder(new EmptyBorder(0, 0, 0, 0));
	    price.setEditable(false);
	    price.setBackground(Color.WHITE);
	    price.setText(product_details[4].toString()+ " Dhs");
	    stock_pricing_panel.add(price );
	    
        
       
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	    // handle resizing
        new Custom_Resizing_Manager(frame);
        new Custom_Resizing_Manager(client_space.space);
        new Custom_Resizing_Manager(general_infos);
        new Custom_Resizing_Manager(description_infos);
        new Custom_Resizing_Manager(photos_panel);
        new Custom_Resizing_Manager(stock_pricing_panel);

	}

}
