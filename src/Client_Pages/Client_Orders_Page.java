package Client_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;

import Data_Base.Order;
import Data_Base.Client;
import Data_Base.Product;

public class Client_Orders_Page {
	
	
	// attributes
	int start_point_x = 25 ;
	int start_point_y = 20 ;
	int horizontal_spacing = 27;
	int vertical_spacing = 160;
	int index = 0;
	int page_capacity = 0 ;
	
	int current_page_start_index = 0 ;
	int current_page_end_index = 3 ;
	
	public static Custom_Label total_ordered_items ;
	
	public static Custom_Label subtotal_pr ;
	
	
	
	
	
	ArrayList<Custom_Panel> products_displayers_panels = new ArrayList<>();
	

    // constructor
	public Client_Orders_Page (Custom_Frame frame) {
		
		// create the client space elements
		Client_Space client_space = new Client_Space(frame);
				

		// change orders button background to show that it's clicked
		client_space.orders.setBackground(Color.decode("#002F5E"));
		client_space.labo.setBackground(Color.decode("#002F5E"));
		client_space.orders.change_color_background("#002F5E","#002F5E",client_space.labo);
		client_space.orders.change_style("#b39700","#b39700");
		 
		
		// order title
	    int ls_x = (int) ((170*frame.getWidth())/900);
	    int ls_y = (int) ((14*frame.getHeight())/600);
	    int ls_width = (int) ((500*frame.getWidth())/900);
	    int ls_height = (int) ((30*frame.getHeight())/600);
	    int ls_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label ls = new Custom_Label(ls_x, ls_y, ls_width, ls_height,
	    "Review your Shopping Cart  ..." ,"Segoe Print",ls_font_size,"#008080");
        ls.setHorizontalAlignment(SwingConstants.LEFT);
        client_space.space.add(ls);
        
        
        
        
        // center page panel
        int pn1_x = (int) ((140 * frame.getWidth()) / 900);
     	int pn1_y = (int) ((70 * frame.getHeight()) / 600);
     	int pn1_width = (int) ((800 * frame.getWidth()) / 900);
     	int pn1_height = (int) ((580 * frame.getHeight()) / 600);
     	Custom_Panel center_panel = new Custom_Panel(pn1_x, pn1_y, pn1_width, pn1_height, "#FFFFFF");
     	client_space.space.add(center_panel);
     	
     	
     	
     	
        // rignt page panel
        int pn2_x = (int) ((405 * frame.getWidth()) / 900);
     	int pn2_y = (int) ((20 * frame.getHeight()) / 600);
     	int pn2_width = (int) ((318 * frame.getWidth()) / 900);
     	int pn2_height = (int) ((463 * frame.getHeight()) / 600);
     	Custom_Panel right_panel = new Custom_Panel(pn2_x, pn2_y, pn2_width, pn2_height, "#FFFFFF");
     	//right_panel.add_background("Needed images\\order_background.png");
     	Border border = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#b39700")); // Top-left-bottom-right
     	right_panel.setBorder(border);
     	center_panel.add(right_panel);
     	
     	
     	
     	
     	
        
        // virtual client
        Client virtual_client = new Client(null,null,null,null,null,Client_Sign_In_Page.mail,null);
        int client_id = virtual_client.get_client_id();
        
       
        // get this user ordered products Ids
        ArrayList<Integer> ordered_products_ids = Order.get_ordered_products_id(client_id);
        
        
        // display ordered products
        for(int id:ordered_products_ids) {
        	
        	
        	if((index % 2 == 0) && (index!=0)) {
        		start_point_x = 25 ;
        		start_point_y += 70 + vertical_spacing;}
        	
        	if((page_capacity == 4) ) {
        		
        		start_point_x = 25 ;
        		start_point_y = 20;
        		page_capacity = 0; }
        	
        	
        	
        	// virtual product
        	Product virtual_product = new Product (null,null,0,0,null,null,null,null,null);
        	// set the virtual product id
        	virtual_product.setId(id);
        	// get infos
        	Object[] infos = virtual_product.get_details();
        	
        	String product_name = infos[2].toString();
        	String price = infos[4].toString();
        	ByteArrayInputStream photo_1 = (ByteArrayInputStream) infos[5];
        	
        	// create a virtual client with the same valid entered mail in the sign in page
            Client client = new Client(null,null,null,null,null,Client_Sign_In_Page.mail,null);
            
            // retrieve the id 
        	int id_client = client.get_client_id();
        	
        	
        	// display the products
        	Client_Product_Displayer displayer = new Client_Product_Displayer(frame,center_panel,start_point_x,start_point_y,150,200,
        	photo_1,product_name,price,id,id_client);
        	
        	// set the ordered item quantity for each product
        	Order virtual_order = new Order(client_id,id);
        	int item_ordered_Q = virtual_order.get_product_ordered_quantity();
        	displayer.product_ordered_quantity.setText(String.valueOf(item_ordered_Q));
        	
        	// hide the buttons buy and like  and show the other buttons to change items quantity
        	displayer.increase_decrease_remove_item();        	
        	
        	
        	// add this displayer's panel to the displayers panels array 
        	products_displayers_panels.add(displayer.panel);
        	
        	start_point_x += 150 + horizontal_spacing;
        	index += 1 ;
        	page_capacity += 1 ;  }
        
        
		
		
        
        
        
        // previous image button 
	    int bt_x = (int) ((50*frame.getWidth())/900);
	    int bt_y = (int) ((465*frame.getHeight())/600);
	    int bt_width = (int) ((150*frame.getWidth())/900);
	    int bt_height = (int) ((30*frame.getHeight())/600);
	    int bt_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button previous = new Custom_Button(bt_x,bt_y,bt_width,bt_height,
        "<< previous","#808080","Segoe Print",bt_font_size,false);
        center_panel.add(previous);
        
        
        
        // next image button 
	    int bn_x = (int) ((210*frame.getWidth())/900);
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
                    current_page_start_index -= 4;
                    current_page_end_index = current_page_start_index + 3;
                    
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
                    current_page_start_index += 4;
                    current_page_end_index = current_page_start_index + 3;
                    
                    // Ensure indices are within valid range
                    if (current_page_end_index >= products_displayers_panels.size()) {
                        current_page_end_index = products_displayers_panels.size() - 1;}
                    
                    // Show the new current partition
                    for (int i = current_page_start_index; i <= current_page_end_index; i++) {
                        products_displayers_panels.get(i).setVisible(true);}
                
                }}});

		
		
		
		
		
		
		
		

		
		
		
        
        
        
        // label - purchase your orders
	    int la_x = (int) ((60*frame.getWidth())/900);
	    int la_y = (int) ((10*frame.getHeight())/600);
	    int la_width = (int) ((200*frame.getWidth())/900);
	    int la_height = (int) ((30*frame.getHeight())/600);
	    int la_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label la = new Custom_Label(la_x, la_y, la_width, la_height,
        "Purchase Your Orders","Segoe Print",la_font_size,"#2F5597");
        la.setHorizontalAlignment(SwingConstants.CENTER);
        right_panel.add(la);
        
        
        
        
        
        // label - total items
	    int lb_x = (int) ((25*frame.getWidth())/900);
	    int lb_y = (int) ((85*frame.getHeight())/600);
	    int lb_width = (int) ((200*frame.getWidth())/900);
	    int lb_height = (int) ((30*frame.getHeight())/600);
	    int lb_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lb = new Custom_Label(lb_x, lb_y, lb_width, lb_height,
        "Total Items :","Segoe Print",lb_font_size,"#b39700");
        lb.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(lb);
        
        
        
        
        
         
        // get the total orered items number from the DB
    	Order virtual_order = new Order(client_id,0);
    	int total_items = virtual_order.get_total_ordered_items();
        
        
        // label - total items number
	    int lc_x = (int) ((155*frame.getWidth())/900);
	    int lc_y = (int) ((87*frame.getHeight())/600);
	    int lc_width = (int) ((200*frame.getWidth())/900);
	    int lc_height = (int) ((30*frame.getHeight())/600);
	    int lc_font_size = (int) ((11*frame.getWidth())/900);
	    total_ordered_items = new Custom_Label(lc_x, lc_y, lc_width, lc_height,
        String.valueOf(total_items),"Consolas",lc_font_size,"#000000");
        total_ordered_items.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(total_ordered_items);
        
        
        
                
        
        // label - sutotal price
	    int ld_x = (int) ((25*frame.getWidth())/900);
	    int ld_y = (int) ((125*frame.getHeight())/600);
	    int ld_width = (int) ((200*frame.getWidth())/900);
	    int ld_height = (int) ((30*frame.getHeight())/600);
	    int ld_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label ld = new Custom_Label(ld_x, ld_y, ld_width, ld_height,
        "Subtotal Price :","Segoe Print",ld_font_size,"#b39700");
        ld.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(ld);
        
        
        
        // the subtotal price
        double subtotal_price = virtual_order.get_total_orders_price();
        
        
        // label - total price value
	    int le_x = (int) ((155*frame.getWidth())/900);
	    int le_y = (int) ((127*frame.getHeight())/600);
	    int le_width = (int) ((200*frame.getWidth())/900);
	    int le_height = (int) ((30*frame.getHeight())/600);
	    int le_font_size = (int) ((11*frame.getWidth())/900);
        subtotal_pr = new Custom_Label(le_x, le_y, le_width, le_height,
        String.valueOf(subtotal_price) + " Dhs","Consolas",le_font_size,"#000000");
        subtotal_pr.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(subtotal_pr);
         
        
        
        
        // label - delivery city
	    int ln_x = (int) ((25*frame.getWidth())/900);
	    int ln_y = (int) ((175*frame.getHeight())/600);
	    int ln_width = (int) ((200*frame.getWidth())/900);
	    int ln_height = (int) ((30*frame.getHeight())/600);
	    int ln_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label ln = new Custom_Label(ln_x, ln_y, ln_width, ln_height,
        "Delivery City  :","Segoe Print",ln_font_size,"#b39700");
        ln.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(ln);
        
        
        // label - client city
	    int lo_x = (int) ((155*frame.getWidth())/900);
	    int lo_y = (int) ((177*frame.getHeight())/600);
	    int lo_width = (int) ((200*frame.getWidth())/900);
	    int lo_height = (int) ((30*frame.getHeight())/600);
	    int lo_font_size = (int) ((11*frame.getWidth())/900);
        Custom_Label lo = new Custom_Label(lo_x, lo_y, lo_width, lo_height,
        "Khouribga","Consolas",lo_font_size,"#000000");
        lo.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(lo);
        
        
        
        
        
        
        
        // label - delivery Adress
	    int lf_x = (int) ((25*frame.getWidth())/900);
	    int lf_y = (int) ((205*frame.getHeight())/600);
	    int lf_width = (int) ((200*frame.getWidth())/900);
	    int lf_height = (int) ((30*frame.getHeight())/600);
	    int lf_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lf = new Custom_Label(lf_x, lf_y, lf_width, lf_height,
        "Delivery Adress :","Segoe Print",lf_font_size,"#b39700");
        lf.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(lf);
        
        
        // label - client adress
	    int lj_x = (int) ((155*frame.getWidth())/900);
	    int lj_y = (int) ((207*frame.getHeight())/600);
	    int lj_width = (int) ((200*frame.getWidth())/900);
	    int lj_height = (int) ((30*frame.getHeight())/600);
	    int lj_font_size = (int) ((11*frame.getWidth())/900);
        Custom_Label lj = new Custom_Label(lj_x, lj_y, lj_width, lj_height,
        "LOT ABC N 83","Consolas",lj_font_size,"#000000");
        lj.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(lj);
        
        
        
        
        
        // label - delivery fee
	    int lh_x = (int) ((25*frame.getWidth())/900);
	    int lh_y = (int) ((235*frame.getHeight())/600);
	    int lh_width = (int) ((200*frame.getWidth())/900);
	    int lh_height = (int) ((30*frame.getHeight())/600);
	    int lh_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lh = new Custom_Label(lh_x, lh_y, lh_width, lh_height,
        "Delivery Fee :","Segoe Print",lh_font_size,"#b39700");
        lh.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(lh);
        
        
        // label - delivery fee value
	    int li_x = (int) ((155*frame.getWidth())/900);
	    int li_y = (int) ((237*frame.getHeight())/600);
	    int li_width = (int) ((200*frame.getWidth())/900);
	    int li_height = (int) ((30*frame.getHeight())/600);
	    int li_font_size = (int) ((11*frame.getWidth())/900);
        Custom_Label li = new Custom_Label(li_x, li_y, li_width, li_height,
        "16.84 Dhs","Consolas",li_font_size,"#000000");
        li.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(li);
        
        
        
        

        // label - total cost
	    int lg_x = (int) ((25*frame.getWidth())/900);
	    int lg_y = (int) ((285*frame.getHeight())/600);
	    int lg_width = (int) ((200*frame.getWidth())/900);
	    int lg_height = (int) ((30*frame.getHeight())/600);
	    int lg_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lg = new Custom_Label(lg_x, lg_y, lg_width, lg_height,
        "Total Cost :","Segoe Print",lg_font_size,"#b39700");
        lg.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(lg);
        
        
        // label - total cost value
	    int lk_x = (int) ((155*frame.getWidth())/900);
	    int lk_y = (int) ((287*frame.getHeight())/600);
	    int lk_width = (int) ((200*frame.getWidth())/900);
	    int lk_height = (int) ((30*frame.getHeight())/600);
	    int lk_font_size = (int) ((11*frame.getWidth())/900);
        Custom_Label lk = new Custom_Label(lk_x, lk_y, lk_width, lk_height,
        "1656.84 Dhs","Consolas",lk_font_size,"#000000");
        lk.setHorizontalAlignment(SwingConstants.LEFT);
        right_panel.add(lk);
        
        
        
        
        

        // confirm purchase button 
	    int bt2_x = (int) ((25*frame.getWidth())/900);
	    int bt2_y = (int) ((380*frame.getHeight())/600);
	    int bt2_width = (int) ((265*frame.getWidth())/900);
	    int bt2_height = (int) ((30*frame.getHeight())/600);
	    int bt2_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Button confirm = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Confirm Your Purchase","#FFFFFF","Segoe Print",bt2_font_size,true);
        confirm.setRound_shape_variables(35, 35);
        confirm.setHorizontalAlignment(SwingConstants.CENTER);
        right_panel.add(confirm);
        
        
		
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
     // handle resizing
     new Custom_Resizing_Manager(frame);
     new Custom_Resizing_Manager(client_space.space);
     new Custom_Resizing_Manager(center_panel);
     new Custom_Resizing_Manager(right_panel);
        
		    	
		    	
		    	
		    	
	}
	
	
	
	

}
