package Client_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Data_Base.Client;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;

import Data_Base.Purchase;
import Data_Base.Purchase_Product;
import Data_Base.Invoice;

public class Client_Purchases_Page {

	// attributes

	int start_point_y = 75;
	int vertical_spacing = 110;
	int index = 0;
	int page_capacity = 0;
	

	int current_page_start_index = 0 ;
	int current_page_end_index = 1 ; 
	
	ArrayList<Custom_Panel> purchases_displayers_panels = new ArrayList<>();

	
	
	
	
	
	
	
	
	
	// constructor
	public Client_Purchases_Page(Custom_Frame frame) {

		
		// create the client space elements
		Client_Space client_space = new Client_Space(frame);

		// change purchases button background to show that it's clicked
		client_space.purchases.setBackground(Color.decode("#002F5E"));
		client_space.labpr.setBackground(Color.decode("#002F5E"));
		client_space.purchases.change_color_background("#002F5E", "#002F5E", client_space.labpr);
		client_space.purchases.change_style("#b39700", "#b39700");

		// center page panel
		int pn1_x = (int) ((140 * frame.getWidth()) / 900);
		int pn1_y = (int) ((70 * frame.getHeight()) / 600);
		int pn1_width = (int) ((800 * frame.getWidth()) / 900);
		int pn1_height = (int) ((580 * frame.getHeight()) / 600);
		Custom_Panel center_panel = new Custom_Panel(pn1_x, pn1_y, pn1_width, pn1_height, "#FFFFFF");
		client_space.space.add(center_panel);

		
		
		
		
		
		
		
		// search button
		int bt4_x = (int) ((686 * frame.getWidth()) / 900);
		int bt4_y = (int) ((10 * frame.getHeight()) / 600);
		int bt4_width = (int) ((15 * frame.getWidth()) / 900);
		int bt4_height = (int) ((20 * frame.getHeight()) / 600);
		Custom_Button button_search = new Custom_Button(bt4_x, bt4_y, bt4_width, bt4_height, "",
		"#000000", "Consolas",7, false);
		center_panel.add(button_search);

		
		// label 17 - search icon
		int lb17_x = (int) ((686 * frame.getWidth()) / 900);
		int lb17_y = (int) ((21 * frame.getHeight()) / 600);
		int lb17_width = (int) ((15 * frame.getWidth()) / 900);
		int lb17_height = (int) ((20 * frame.getHeight()) / 600);
		Custom_Label lab17 = new Custom_Label(lb17_x, lb17_y, lb17_width, lb17_height, "", "Calibri", 7, "#b39700");
		lab17.add_background("Needed images\\search_icon.png");
		center_panel.add(lab17);

		
		// search text_field
		int x_s = (int) ((457 * frame.getWidth()) / 900);
		int y_s = (int) ((20 * frame.getHeight()) / 600);
		int width_s = (int) ((250 * frame.getWidth()) / 900);
		int height_s = (int) ((23 * frame.getHeight()) / 600);
		int font_size_s = (int) ((11 * frame.getWidth()) / 900);
		Custom_Text_Field search = new Custom_Text_Field(x_s, y_s, width_s, height_s, "Segoe Print", 
		font_size_s,"#000000");
		search.setText(" search per date ...");
		center_panel.add(search);

		
		
		
		
		
		
		// --- get the client purchases infos

		// virtual client
		Client virtual_client = new Client(null, null, null, null, null, Client_Sign_In_Page.mail, null);
		int client_id = virtual_client.get_client_id();

		// virtual purchase
		Purchase purch = new Purchase(null, null, client_id);
		ArrayList<Object[]> client_purchases_infos = purch.get_client_purchases_infos();

		// needed purchases infos
		ArrayList<Object[]> needed_purchases_infos = new ArrayList();

		

		
		// iterate from the last to the first row
		for (int i = client_purchases_infos.size() - 1; i >= 0; i--) {
		    
			Object[] cl_pur_in = client_purchases_infos.get(i);

			// virtual purchase_product to get total purchase items
			int purchase_id = Integer.valueOf(cl_pur_in[0].toString());
			Purchase_Product virtual_pur_pr = new Purchase_Product(purchase_id, 0, 0);
			double total_purchase_quantity = virtual_pur_pr.get_total_purchased_items();

			// virtual invoice to get the purchase total cost
			Invoice invoice = new Invoice(0, purchase_id);
			double total_cost = invoice.get_total_cost();

			
			// get needed infos for each purchase
			Object[] purch_inf = new Object[5];
			purch_inf[0] = cl_pur_in[1];                 // date
			purch_inf[1] = cl_pur_in[2];                 // time
			purch_inf[2] = total_cost;                   // total cost
			purch_inf[3] = total_purchase_quantity;      // total items
			purch_inf[4] = cl_pur_in[3];                 // status

			needed_purchases_infos.add(purch_inf);
			
			

		}

		
		
		
		
		
		// iterate through needed infos
		for (Object[] purchase_info : needed_purchases_infos) {
			
			

			if ((index == 1)) {
				start_point_y += 75 + vertical_spacing;
				index = 0 ;
			}

			if ((page_capacity == 2)) {

				start_point_y = 75;
				page_capacity = 0;
			}
			
			
			
			
			// retrieve infos
			String date_time = purchase_info[0].toString() + " ---  " + purchase_info[1].toString() ;
			String total_price = purchase_info[2].toString() ;
			String total_items = purchase_info[3].toString() ;
			String status = purchase_info[4].toString();
			
			
			// display purchase
			Client_Purchase_Displayer displayer = new Client_Purchase_Displayer(frame, center_panel, 20, start_point_y, 687, 165,
			date_time,total_price,total_items,status);
			
			purchases_displayers_panels.add(displayer.panel);
			
			
        	index += 1 ;
        	
        	page_capacity += 1 ;
			
		}
		
		
		
		
		
		
		
		
		
		
		// previous  button 
	    int bt_x = (int) ((210*frame.getWidth())/900);
	    int bt_y = (int) ((465*frame.getHeight())/600);
	    int bt_width = (int) ((150*frame.getWidth())/900);
	    int bt_height = (int) ((30*frame.getHeight())/600);
	    int bt_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button previous = new Custom_Button(bt_x,bt_y,bt_width,bt_height,
        "<<  previous","#808080","Calibri",bt_font_size,false);
        center_panel.add(previous);
        
        
        
        // next  button 
	    int bn_x = (int) ((370*frame.getWidth())/900);
	    int bn_y = (int) ((465*frame.getHeight())/600);
	    int bn_width = (int) ((100*frame.getWidth())/900);
	    int bn_height = (int) ((30*frame.getHeight())/600);
	    int bn_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button next = new Custom_Button(bn_x,bn_y,bn_width,bn_height,
        "next  >>","#808080","Calibri",bn_font_size,false);
        center_panel.add(next);
		
        
        
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	// Check if there is a previous partition to show
                if (current_page_start_index > 0) {
                    // Hide the current partition
                    for (int i = current_page_start_index; i <= current_page_end_index && i < purchases_displayers_panels.size(); i++) {
                    	purchases_displayers_panels.get(i).setVisible(false);}
                    
                    // Move to previous partition
                    current_page_start_index -= 2;
                    current_page_end_index = current_page_start_index + 1;
                    
                    // Ensure indices are within valid range
                    if (current_page_start_index < 0) {
                        current_page_start_index = 0;}
                    
                    if (current_page_end_index >= purchases_displayers_panels.size()) {
                        current_page_end_index = purchases_displayers_panels.size() - 1;}
                    // Show the new current partition
                    
                    for (int i = current_page_start_index; i <= current_page_end_index; i++) {
                    	purchases_displayers_panels.get(i).setVisible(true);
                    }
                
                
                }}});

        
        
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	// Check if there is a next partition to show
                if (current_page_end_index < purchases_displayers_panels.size() - 1) {
                    // Hide the current partition
                    for (int i = current_page_start_index; i <= current_page_end_index; i++) {
                    	purchases_displayers_panels.get(i).setVisible(false);}
                    
                    // Move to next partition
                    current_page_start_index += 2;
                    current_page_end_index = current_page_start_index + 1;
                    
                    // Ensure indices are within valid range
                    if (current_page_end_index >= purchases_displayers_panels.size()) {
                        current_page_end_index = purchases_displayers_panels.size() - 1;}
                    
                    // Show the new current partition
                    for (int i = current_page_start_index; i <= current_page_end_index; i++) {
                    	purchases_displayers_panels.get(i).setVisible(true);}
                
                }}});

		
		

		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// handle resizing
		new Custom_Resizing_Manager(frame);
		new Custom_Resizing_Manager(client_space.space);
		new Custom_Resizing_Manager(center_panel);

	}

}
