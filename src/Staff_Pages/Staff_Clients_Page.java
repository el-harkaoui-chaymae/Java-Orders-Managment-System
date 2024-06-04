package Staff_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Data_Base.Delivery_Destination;
import Data_Base.Product;
import Data_Base.Purchase;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_ComboBox;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Table;
import Graphical_Interface.Custom_Text_Field;


public class Staff_Clients_Page {

	// constructor
	public Staff_Clients_Page(Custom_Frame frame) {

		// create the staff space elements
		Staff_Space staff_space = new Staff_Space(frame);

		// change client button background to show that it's clicked
		staff_space.client.setBackground(Color.decode("#2F5597"));
		staff_space.labr.setBackground(Color.decode("#2F5597"));
		staff_space.client.change_style("#b39700", "#b39700");
		staff_space.client.change_color_background("#2F5597", "#2F5597", staff_space.labr);

		// center page panel
		int pn1_x = (int) ((140 * frame.getWidth()) / 900);
		int pn1_y = (int) ((70 * frame.getHeight()) / 600);
		int pn1_width = (int) ((800 * frame.getWidth()) / 900);
		int pn1_height = (int) ((580 * frame.getHeight()) / 600); 
		Custom_Panel center_panel = new Custom_Panel(pn1_x, pn1_y, pn1_width, pn1_height, "#FFFFFF");
		staff_space.space.add(center_panel);
		
		
		
		
		
		
		
		
		

	    // enter button after selecting a purchase state
	    int bt_x = (int) ((235*frame.getWidth())/900);
	    int bt_y = (int) ((75*frame.getHeight())/600);
	    int bt_width = (int) ((50*frame.getWidth())/900);
	    int bt_height = (int) ((30*frame.getHeight())/600);
	    int bt_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button enter = new Custom_Button(bt_x,bt_y,bt_width,bt_height,
        "v","#808080","Segoe Print",bt_font_size,false);
        center_panel.add(enter);
		
		
		// purchase status text field
        int x_m = (int) ((25*frame.getWidth())/900);
	    int y_m = (int) ((80*frame.getHeight())/600);
	    int width_m = (int) ((250*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field status = new Custom_Text_Field(x_m,y_m,width_m,height_m,
	    "Segoe Print",font_size_m,"#000000") ; 
	    status.setText(" select purchase state ...");
	    center_panel.add(status);
	    
	   
	    
	    
	    // status
	    String[] options = {"Shipped","While Shipping","Not Shipped"};
	    
	    
	    // a comboBox that holds the states
        int x_c = (int) ((25*frame.getWidth())/900);
	    int y_c = (int) ((100*frame.getHeight())/600);
	    int width_c = (int) ((250*frame.getWidth())/900);
	    int height_c = (int) ((23*frame.getHeight())/600);
	    int font_size_c = (int) ((11*frame.getWidth())/900);
        Custom_ComboBox combo_box = new Custom_ComboBox(x_c,y_c,width_c,height_c,font_size_c,options);
        center_panel.add(combo_box);
        combo_box.setVisible(false);
       
        boolean appears = false;
        
        
     
        // Add a key listener to the text field to show or hide the comboBox as needed
        status.addKeyListener(new KeyAdapter() {
            
        	@Override
            public void keyTyped(KeyEvent e) {
                
            	if (status.getText().isEmpty()) {
                    
            		combo_box.setVisible(false);}
                
            	else { if (appears == false) {
                         combo_box.setVisible(true);}}}});

        
        // Add a listener to the combo box to update the text field with the selected option
        combo_box.addActionListener(e -> {
            
        	String selected_option = (String) combo_box.getSelectedItem();
            status.setText(selected_option);
            combo_box.setVisible(false);});
        
        
        
        
        
        
        
        
        

	    // enter button after selecting a destination
	    int bt_x2 = (int) ((485*frame.getWidth())/900);
	    int bt_y2 = (int) ((75*frame.getHeight())/600);
	    int bt_width2 = (int) ((50*frame.getWidth())/900);
	    int bt_height2 = (int) ((30*frame.getHeight())/600);
	    int bt_font_size2 = (int) ((12*frame.getWidth())/900);
        Custom_Button enter_2 = new Custom_Button(bt_x2,bt_y2,bt_width2,bt_height2,
        "v","#808080","Segoe Print",bt_font_size2,false);
        center_panel.add(enter_2);
        
        
        
        // location text field
        int x_l = (int) ((325*frame.getWidth())/900);
	    int y_l = (int) ((80*frame.getHeight())/600);
	    int width_l = (int) ((200*frame.getWidth())/900);
	    int height_l = (int) ((23*frame.getHeight())/600);
	    int font_size_l = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field location = new Custom_Text_Field(x_l,y_l,width_l,height_l,
	    "Segoe Print",font_size_l,"#000000") ; 
	    location.setText(" select Destination ...");
	    center_panel.add(location);
	    
	    

	    // citie to deliver to 
	    String[] options_2 = {
	    	    
	    		"Agadir", "Ahfir", "Ain Harrouda", "Ait Melloul", "Al Hoceima", 
	    	    "Asilah", "Azemmour", "Azrou", "Beni Ansar", "Beni Mellal", 
	    	    "Ben Guerir", "Berkane", "Berrechid", "Bouarfa", "Boujdour", 
	    	    "Bouznika", "Casablanca", "Chefchaouen", "Chichaoua", "Dakhla", 
	    	    "Dcheira El Jihadia", "Demnate", "El Aioun Sidi Mellouk", 
	    	    "El Hajeb", "El Jadida", "El Kelaa des Sraghna", "Erfoud", 
	    	    "Errachidia", "Essaouira", "Fes", "Fnideq", "Fquih Ben Salah", 
	    	    "Guelmim", "Guercif", "Guelmim", "Had Kourt", "Ifrane", "Inezgane", 
	    	    "Jerada", "Kasba Tadla", "Kelaa Mgouna", "Khemisset", "Khouribga", 
	    	    "Kenitra", "Ksar El Kebir", "Laayoune", "Larache", "Martil", 
	    	    "Marrakech", "Meknes", "Midelt", "Mohammedia", "Nador", "Ouarzazate", 
	    	    "Ouezzane", "Oujda", "Oulad Ayad", "Oulad Berhil", "Oulad Teima", 
	    	    "Rabat", "Rich", "Safi", "Sale", "Sefrou", "Settat", "Sidi Bennour", 
	    	    "Sidi Bou Othmane", "Sidi Ifni", "Sidi Kacem", "Sidi Slimane", 
	    	    "Skhirat", "Souk El Arbaa", "Tan-Tan", "Tantan", "Taounate", 
	    	    "Taourirt", "Taroudant", "Taza", "Temara", "Tetouan", "Tiflet", 
	    	    "Tinghir", "Tiznit", "Youssoufia", "Zaio", "Zagora"
	    	};

	    
	    
	    // a comboBox that holds the product categories 
        int x_b = (int) ((325*frame.getWidth())/900);
	    int y_b = (int) ((100*frame.getHeight())/600);
	    int width_b = (int) ((200*frame.getWidth())/900);
	    int height_b = (int) ((23*frame.getHeight())/600);
	    int font_size_b = (int) ((11*frame.getWidth())/900);
        Custom_ComboBox combo_box_2 = new Custom_ComboBox(x_b,y_b,width_b,height_b,font_size_b,options_2);
        center_panel.add(combo_box_2);
        combo_box_2.setVisible(false);
       
        boolean appears_2 = false;
        
        
     
        // Add a key listener to the text field to show or hide the comboBox as needed
        location.addKeyListener(new KeyAdapter() {
            
        	@Override
            public void keyTyped(KeyEvent e) {
                
            	if (location.getText().isEmpty()) {
                    
            		combo_box_2.setVisible(false);}
                
            	else { if (appears_2 == false) {
                         combo_box_2.setVisible(true);}}}});

        
        // Add a listener to the combo box to update the text field with the selected option
        combo_box_2.addActionListener(e -> {
            
        	String selected_option_2 = (String) combo_box_2.getSelectedItem();
            location.setText(selected_option_2);
            combo_box_2.setVisible(false);});
	    
		
        
        
        
        
        
        
        // search button after selecting for both textfields
	    int bt_x3 = (int) ((605*frame.getWidth())/900);
	    int bt_y3 = (int) ((80*frame.getHeight())/600);
	    int bt_width3 = (int) ((18*frame.getWidth())/900);
	    int bt_height3 = (int) ((23*frame.getHeight())/600);
        Custom_Button search = new Custom_Button(bt_x3,bt_y3,bt_width3,bt_height3,
        "","#808080","Segoe Print",7,false);
        center_panel.add(search);
        
        
        // label  - search icon
	    int lbm_x = (int) ((605*frame.getWidth())/900);
	    int lbm_y = (int) ((80*frame.getHeight())/600);
	    int lbm_width = (int) ((18*frame.getWidth())/900);
	    int lbm_height = (int) ((23*frame.getHeight())/600);
        Custom_Label labm = new Custom_Label(lbm_x, lbm_y, lbm_width, lbm_height,
        "","Segoe Print",7,"#2F5597");
        labm.add_background("Needed images\\search2_icon.png");
        center_panel.add(labm);
		
		
		
		
		
		 
        // ---- purchases table
        
        
        
        // Define table data
        Object[][] row_column_number =  new Object[52][5];
      

        // Define column names
        String[] columns_names = {"Purchase Id", "Date", "Time","Purchase State", "Client Id"};

        // Define column widths
        int[] columns_widths = {90, 170, 170,160, 80};

        // Define row height
	    int r_height = (int) ((30*frame.getHeight())/600);
        int row_height = r_height;

        // Define header font size
	    int font_size_h = (int) ((13*frame.getWidth())/900);
        int header_font_size = font_size_h;

        // Create the custom product table
        int x_t = (int) ((25*frame.getWidth())/900);
	    int y_t = (int) ((160*frame.getHeight())/600);
	    int width_t = (int) ((682*frame.getWidth())/900);
	    int height_t = (int) ((295*frame.getHeight())/600);
	    int cell_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Table table = new Custom_Table(frame,x_t, y_t, width_t, height_t, row_column_number, columns_names, 
        columns_names.length, columns_widths, row_height,header_font_size,cell_font_size);
                
     
        // Add the scroll pane holding the view of the table to the center panel
        center_panel.add(table.scroll_pane);
        
        

        // the table rows and columns number
        int rows_number = 52;
        int columns_number = 5;
        
        
        
        
        
        // fill the table
        
        
        
        
        // get all available purchases in the DB
        ArrayList<Object[]> all_purchases = Purchase.get_purchases_infos();
        
        
        

        // Iterate through the purchases` array and set values to the table
        for (int i = 0; i < all_purchases.size(); i++) {
            
                table.setValueAt(all_purchases.get(i)[0], i, 0);
                table.setValueAt(all_purchases.get(i)[1], i, 1);
                table.setValueAt(all_purchases.get(i)[2], i, 2);
                table.setValueAt(all_purchases.get(i)[3], i, 3);
                table.setValueAt(all_purchases.get(i)[4], i, 4);
                
            }
        
        
        
        
        
        
        // enter button action
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// create a virtual purchase 
                Purchase virtual_purchase = new Purchase(null,null,0);
                
                // Get all the purchases with the same entered status
                ArrayList<Object[]>  similar_purchases = virtual_purchase.get_purchases(status.getText());
                
                // clear all rows
                for(int j=0;j<rows_number;j++) {
                	for(int k=0;k<columns_number;k++) table.setValueAt("", j, k);{}
                }

         
                // Iterate through the needed_attributes array and set values to the table
                for (int i = 0; i < similar_purchases.size(); i++) {
                    
                        table.setValueAt(similar_purchases.get(i)[0], i, 0);
                        table.setValueAt(similar_purchases.get(i)[1], i, 1);
                        table.setValueAt(similar_purchases.get(i)[2], i, 2);
                        table.setValueAt(similar_purchases.get(i)[3], i, 3);
                        table.setValueAt(similar_purchases.get(i)[4], i, 4);
                    }
               
            	}});
        
        
        
        

        // enter 2 button action
        enter_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// create a virtual purchase 
                Purchase virtual_purchase = new Purchase(null,null,0);
                
                // Get all the purchases with the same entered status
                ArrayList<Object[]>  similar_purchases = virtual_purchase.purchases_by_destination(location.getText());
                
                // clear all rows
                for(int j=0;j<rows_number;j++) {
                	for(int k=0;k<columns_number;k++) table.setValueAt("", j, k);{}
                }

         
                // Iterate through the needed_attributes array and set values to the table
                for (int i = 0; i < similar_purchases.size(); i++) {
                    
                        table.setValueAt(similar_purchases.get(i)[0], i, 0);
                        table.setValueAt(similar_purchases.get(i)[1], i, 1);
                        table.setValueAt(similar_purchases.get(i)[2], i, 2);
                        table.setValueAt(similar_purchases.get(i)[3], i, 3);
                        table.setValueAt(similar_purchases.get(i)[4], i, 4);
                    }
               
            	}});
        
        
        
        
        // search button action
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// create a virtual purchase 
                Purchase virtual_purchase = new Purchase(null,null,0);
                
                // Get all the purchases with the same entered status and location
                ArrayList<Object[]>  similar_purchases = 
                virtual_purchase.purchases_by_state_destination(status.getText(),location.getText());
                
                // clear all rows
                for(int j=0;j<rows_number;j++) {
                	for(int k=0;k<columns_number;k++) table.setValueAt("", j, k);{}
                }

         
                // Iterate through the needed_attributes array and set values to the table
                for (int i = 0; i < similar_purchases.size(); i++) {
                    
                        table.setValueAt(similar_purchases.get(i)[0], i, 0);
                        table.setValueAt(similar_purchases.get(i)[1], i, 1);
                        table.setValueAt(similar_purchases.get(i)[2], i, 2);
                        table.setValueAt(similar_purchases.get(i)[3], i, 3);
                        table.setValueAt(similar_purchases.get(i)[4], i, 4);
                    }
               
            	}});
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // --- top bar buttons
        
        
        String color = "#C00000"; 
        String font_color = "#2F5597";
         
         
         // select button 
 	    int bt1_x = (int) ((140*frame.getWidth())/900);
 	    int bt1_y = (int) ((13*frame.getHeight())/600);
 	    int bt1_width = (int) ((90*frame.getWidth())/900);
 	    int bt1_height = (int) ((40*frame.getHeight())/600);
 	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
         Custom_Button select = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
         "Select",font_color,"Consolas",bt1_font_size,false);
         select.change_style(color,font_color);
         select.add_buttom_border(162, 50, 46, color, frame, staff_space.space);
         staff_space.space.add(select);
         
         // select button action
         select.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
             	
             	 table.setEnabled(true);
             	 table.getTableHeader().setForeground(Color.decode("#56AE57"));
             	
                
             	}});
         
         
         
         
         // ship button 
  	    int bt2_x = (int) ((250*frame.getWidth())/900);
  	    int bt2_y = (int) ((13*frame.getHeight())/600);
  	    int bt2_width = (int) ((90*frame.getWidth())/900);
  	    int bt2_height = (int) ((40*frame.getHeight())/600);
  	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button ship = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Ship",font_color,"Consolas",bt2_font_size,false);
        ship.change_style(color,font_color);
        ship.add_buttom_border(272, 50, 46, color, frame, staff_space.space);
        staff_space.space.add(ship);
          
        // ship button action
        ship.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
        	
        	int[] selectedRows = table.getSelectedRows();
            for (int row : selectedRows) {
                Object purchaseIdObj = table.getValueAt(row, 0);
                if (purchaseIdObj != null) {
                    int purchaseId = Integer.valueOf(purchaseIdObj.toString());
                    String newState = "While Shipping"; 
                    Purchase.modify(newState, purchaseId);
                    
                   // raise a message
           	       new Custom_Message(80,140,"Needed Images\\verification_icon.png",
           	       "Shipping starts","Purchases are on their way");
                    
                    table.setValueAt("While Shipping", row, 3);
                }}
        
              	
                 
         }});
         
         
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // handle resizing
        new Custom_Resizing_Manager(frame);
        new Custom_Resizing_Manager(staff_space.space);
        new Custom_Resizing_Manager(center_panel);

	}

}
 