package Staff_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Data_Base.Delivery_Destination ;
import Data_Base.Product;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_ComboBox;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Table;
import Graphical_Interface.Custom_Text_Field;

public class Staff_Deliveries_Page {
	
	// attributes
	
	ArrayList<Object[]> destinations;
	boolean changes_saved = false ;
 
	// constructor
	public Staff_Deliveries_Page(Custom_Frame frame) {

		// create the staff space elements
		Staff_Space staff_space = new Staff_Space(frame);

		
		// change delivery button background to show that it's clicked
		staff_space.delivery.setBackground(Color.decode("#2F5597"));
		staff_space.labpr.setBackground(Color.decode("#2F5597"));
		staff_space.delivery.change_style("#b39700", "#b39700");
		staff_space.delivery.change_color_background("#2F5597", "#2F5597", staff_space.labpr);

		
		// center page panel
		int pn1_x = (int) ((140 * frame.getWidth()) / 900);
		int pn1_y = (int) ((70 * frame.getHeight()) / 600);
		int pn1_width = (int) ((800 * frame.getWidth()) / 900);
		int pn1_height = (int) ((580 * frame.getHeight()) / 600);
		Custom_Panel center_panel = new Custom_Panel(pn1_x, pn1_y, pn1_width, pn1_height, "#FFFFFF");
		staff_space.space.add(center_panel);
		
		
		
		
		
		
		
        // ---- delevries table
        
        
        
        // Define table data
        Object[][] row_column_number =  new Object[52][2];
      

        // Define column names
        String[] columns_names = {"Delivery Destination", "Estimated Fee Dhs"};

        // Define column widths
        int[] columns_widths = {341, 329};

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
        int columns_number = 2;
        
        
        // get all available destinations in the DB
        destinations = Delivery_Destination.get_destinations();
        
        

        // Iterate through the destinations array and set values to the table
        for (int i = 0; i < destinations.size(); i++) {
            
                table.setValueAt(destinations.get(i)[0], i, 0);
                table.setValueAt(destinations.get(i)[1], i, 1);
                
            }
        
        
        
        
        
        
   
        

        // search button 
	    int bt4_x = (int) ((686*frame.getWidth())/900);
	    int bt4_y = (int) ((70*frame.getHeight())/600);
	    int bt4_width = (int) ((15*frame.getWidth())/900);
	    int bt4_height = (int) ((20*frame.getHeight())/600);
        Custom_Button button_search = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "","#000000","Consolas",7,false);
        center_panel.add(button_search);
        
        
       
        
        // label 17 - search icon
	    int lb17_x = (int) ((686*frame.getWidth())/900);
	    int lb17_y = (int) ((81*frame.getHeight())/600);
	    int lb17_width = (int) ((15*frame.getWidth())/900);
	    int lb17_height = (int) ((20*frame.getHeight())/600);
        Custom_Label lab17 = new Custom_Label(lb17_x, lb17_y, lb17_width, lb17_height,"",
        "Calibri",7,"#b39700");
        lab17.add_background("Needed images\\search_icon.png");
        center_panel.add(lab17);
        
        
        // search text_field
        int x_s = (int) ((457*frame.getWidth())/900);
	    int y_s = (int) ((80*frame.getHeight())/600);
	    int width_s = (int) ((250*frame.getWidth())/900);
	    int height_s = (int) ((23*frame.getHeight())/600);
	    int font_size_s = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field search = new Custom_Text_Field(x_s,y_s,width_s,height_s,"Segoe Print",font_size_s,"#000000") ;
	    search.setText(" search a destination ...");
	    center_panel.add(search);
        
		
	    
	    
	    
	    
	    
	    
	    
	    

        // label - add a new delivery destination
	    int lb18_x = (int) ((25*frame.getWidth())/900);
	    int lb18_y = (int) ((35*frame.getHeight())/600);
	    int lb18_width = (int) ((600*frame.getWidth())/900);
	    int lb18_height = (int) ((20*frame.getHeight())/600);
	    int lb18_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab18 = new Custom_Label(lb18_x, lb18_y, lb18_width, lb18_height,"Add a New Delivery Destination ",
        "Segoe Print",lb18_font_size,"#008080");
        center_panel.add(lab18);
	    
	    
	    
	   
	    
	   
        
        
        // new delivery price text field
        int x1_m = (int) ((190*frame.getWidth())/900);
	    int y1_m = (int) ((80*frame.getHeight())/600);
	    int width1_m = (int) ((120*frame.getWidth())/900);
	    int height1_m = (int) ((23*frame.getHeight())/600);
	    int font_size1_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field price = new Custom_Text_Field(x1_m,y1_m,width1_m,height1_m,
	    "Segoe Print",font_size1_m,"#000000") ; 
	    price.setText(" estimated fee Dhs");
	    center_panel.add(price);
	    
	    
	    
        
        // add new location text field
        int x_m = (int) ((25*frame.getWidth())/900);
	    int y_m = (int) ((80*frame.getHeight())/600);
	    int width_m = (int) ((150*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field new_location = new Custom_Text_Field(x_m,y_m,width_m,height_m,
	    "Segoe Print",font_size_m,"#000000") ; 
	    new_location.setText(" select new Destination ...");
	    center_panel.add(new_location);
	    
	   
	    
	    // add button  to insert a new delivery destination
	    int bt1_x = (int) ((330*frame.getWidth())/900);
	    int bt1_y = (int) ((77*frame.getHeight())/600);
	    int bt1_width = (int) ((18*frame.getWidth())/900);
	    int bt1_height = (int) ((26*frame.getHeight())/600);
        Custom_Button add = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "","#808080","Segoe Print",7,false);
        center_panel.add(add);
        
        // action
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// existance flag
            	boolean destination_exists = false;
            	
            	// create a new destination
            	double delivery_price = Double.valueOf(price.getText()) ;
            	Delivery_Destination new_destination = new Delivery_Destination(new_location.getText(),delivery_price);
            	
            	
            	for(Object[] destination:destinations) {
            		
            		if(destination[0].equals(new_location.getText())) {
            			destination_exists = true;
            			break ; }}
            	
            	
            	if (! destination_exists) {
            		
            		// add this new delivery destination
            		new_destination.add();
                	
                	// raise a message
           	        new Custom_Message(55,140,"Needed Images\\verification_icon.png",
           	        "Succussful Insertion","Destination Succussfully Added");
           	        
           	        new_location.setText(" select new Destination ...");
           	        price.setText(" estimated fee Dhs");
           	        
           	  
           	        // Iterate through the destinations array and set values to the table
           	        destinations = Delivery_Destination.get_destinations();
           	        for (int i = 0; i < destinations.size(); i++) {
           	            
           	             table.setValueAt(destinations.get(i)[0], i, 0);
           	             table.setValueAt(destinations.get(i)[1], i, 1); } }
            	
            	
            	else {
            		
            		    // raise a message
           	            new Custom_Message(65,140,"Needed Images\\x_icon.png",
           	            "Existed Destination","Destination Already Existed");
            		
            	}
            	
            	
            	
       	        

       	        
            	
            }});
        
	    
	    
	    // label  - add icon
	    int lbm_x = (int) ((330*frame.getWidth())/900);
	    int lbm_y = (int) ((77*frame.getHeight())/600);
	    int lbm_width = (int) ((18*frame.getWidth())/900);
	    int lbm_height = (int) ((26*frame.getHeight())/600);
        Custom_Label labm = new Custom_Label(lbm_x, lbm_y, lbm_width, lbm_height,
        "","Segoe Print",7,"#2F5597");
        labm.add_background("Needed images\\add_icon.png");
        center_panel.add(labm);
	    

       
	    
	    
	    
	    
	    
	    
	    
	    
	    // citie to deliver to 
	    String[] options = {
	    	    
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
        int x_c = (int) ((25*frame.getWidth())/900);
	    int y_c = (int) ((100*frame.getHeight())/600);
	    int width_c = (int) ((150*frame.getWidth())/900);
	    int height_c = (int) ((23*frame.getHeight())/600);
	    int font_size_c = (int) ((11*frame.getWidth())/900);
        Custom_ComboBox combo_box = new Custom_ComboBox(x_c,y_c,width_c,height_c,font_size_c,options);
        center_panel.add(combo_box);
        combo_box.setVisible(false);
       
        boolean appears = false;
        
        
     
        // Add a key listener to the text field to show or hide the comboBox as needed
        new_location.addKeyListener(new KeyAdapter() {
            
        	@Override
            public void keyTyped(KeyEvent e) {
                
            	if (new_location.getText().isEmpty()) {
                    
            		combo_box.setVisible(false);}
                
            	else { if (appears == false) {
                         combo_box.setVisible(true);}}}});

        
        // Add a listener to the combo box to update the text field with the selected option
        combo_box.addActionListener(e -> {
            
        	String selected_option = (String) combo_box.getSelectedItem();
            new_location.setText(selected_option);
            combo_box.setVisible(false);});
	    
	    
		
		
		
		
		
		
		
		
		
		// ---- top bar buttons
        
        
        String color = "#C00000"; 
        String font_color = "#2F5597";
         
         
        // edit button 
 	    int bt11_x = (int) ((170*frame.getWidth())/900);
 	    int bt11_y = (int) ((13*frame.getHeight())/600);
 	    int bt11_width = (int) ((90*frame.getWidth())/900);
 	    int bt11_height = (int) ((40*frame.getHeight())/600);
 	    int bt11_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button edit = new Custom_Button(bt11_x,bt11_y,bt11_width,bt11_height,
        "Edit",font_color,"Consolas",bt11_font_size,false);
        edit.change_style(color,font_color);
        edit.add_buttom_border(192, 50, 46, color, frame, staff_space.space);
        staff_space.space.add(edit);
		
        // edit button action
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 table.setEnabled(true);
            	 table.getTableHeader().setForeground(Color.decode("#56AE57"));
            	 
            	 // changes not saved yet
            	 changes_saved = false ;
               
            	}});
        
        
        
        
        
        
        
        
        
        // cancel button 
	    int bt2_x = (int) ((280*frame.getWidth())/900);
	    int bt2_y = (int) ((13*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button cancel = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Cancel",font_color,"Consolas",bt2_font_size,false);
        cancel.change_style(color,font_color);
        cancel.add_buttom_border(298, 50, 54, color, frame, staff_space.space);
        staff_space.space.add(cancel);
        
        // cancel button action
   	    cancel.addActionListener(new ActionListener() {
   	       public void actionPerformed(ActionEvent e) {
   	         
   	    	 // if we did not save changes yet
   	    	 if(changes_saved == false) {
   	    		 
   	             // clear all rows
   	             for(int j=0;j<rows_number;j++) {
   	             	for(int k=0;k<columns_number;k++) {table.setValueAt("", j, k);}}

   	      
   	             // reset the values that were before editing
   	             for (int i = 0; i < destinations.size(); i++) {
   	                 
   	                     table.setValueAt(destinations.get(i)[0], i, 0);
   	                     table.setValueAt(destinations.get(i)[1], i, 1);}}
   	         
   	    	 
   	         // Set other properties
   	         table.getTableHeader().setForeground(Color.decode("#b39700"));
   	         table.setEnabled(false);
   	     }
   	   });
		
		
		
        
        
   	    
   	    
   	    
   	    
   	    
   	    
   	    
   	    // save button 
	    int bt3_x = (int) ((392*frame.getWidth())/900);
	    int bt3_y = (int) ((13*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button save = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Save",font_color,"Consolas",bt3_font_size,false);
        save.change_style(color,font_color);
        save.add_buttom_border(414, 50, 46, color, frame, staff_space.space);
        staff_space.space.add(save);
        
        // save button action
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 table.setEnabled(false);
            	 table.getTableHeader().setForeground(Color.decode("#b39700"));
            	 
            	 // changes now are saved
            	 changes_saved = true ;
            	 
            	 // get the selected row values
            	 int selected_row = table.getSelectedRow();
            	 // Check if a row is selected
            	 if (selected_row != -1 && table.getValueAt(selected_row, 0)!=null) { 
            		 
            		  
            		 String destination_city = table.getValueAt(selected_row, 0).toString();
            	     double delivery_price = Double.valueOf(table.getValueAt(selected_row, 1).toString());
            	     
            	     // create a virtual destination with the values before editting to get this destination id
            	     String city = destinations.get(selected_row)[0].toString();
            	     double price = Double.valueOf(destinations.get(selected_row)[1].toString());
            	    
            	     Delivery_Destination ds = new Delivery_Destination(city,price);
            	     int destenation_id = ds.get_destination_id();
            	     
            	     // update
            	     Delivery_Destination dxn = new Delivery_Destination(destination_city,delivery_price);
            	     dxn.destination_id = destenation_id;
            	     
            	     dxn.modify();
            	     
            	      
            	     
            	     // raise a message
            	     new Custom_Message(115,140,"Needed Images\\verification_icon.png",
            	     "Succussful Update","Changes are Saved");}
            	 
            	 else {
            		 
            		// raise a message
            	    new Custom_Message(95,140,"Needed Images\\x_icon.png",
            	    "Selection Error","Select a populated row");
            		 
            	 }}});
        
        
        
        
        
        
        
        
        
        
        
        
        // delete product button 
	    int bt5_x = (int) ((480*frame.getWidth())/900);
	    int bt5_y = (int) ((13*frame.getHeight())/600);
	    int bt5_width = (int) ((125*frame.getWidth())/900);
	    int bt5_height = (int) ((40*frame.getHeight())/600);
	    int bt5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button delete = new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "Delete",font_color,"Consolas",bt5_font_size,false);
        delete.change_style(color,font_color);
        delete.add_buttom_border(515, 50, 56, color, frame, staff_space.space);
        staff_space.space.add(delete);
        
        
        // delete button action
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
             // get the selected row id
           	 int selected_row = table.getSelectedRow();
           	 // Check if a row is selected
           	 if (selected_row != -1 && table.getValueAt(selected_row, 0)!=null) { 
           		 
        		 String destination_city = table.getValueAt(selected_row, 0).toString();
        	     double delivery_price = Double.valueOf(table.getValueAt(selected_row, 1).toString());
        	     
        	     // create a virtual destination with the values before editting to get this destination id
        	     String city = destinations.get(selected_row)[0].toString();
        	     double price = Double.valueOf(destinations.get(selected_row)[1].toString());
        	    
        	     Delivery_Destination ds = new Delivery_Destination(city,price);
        	     int destenation_id = ds.get_destination_id();
        	     
        	     // delete
        	     Delivery_Destination dxn = new Delivery_Destination(null,0);
        	     dxn.destination_id = destenation_id;
        	     
        	     dxn.delete();
        	     
        	     // Clear the cells of the selected row
                 table.setValueAt(null, selected_row, 0); 
                 table.setValueAt(null, selected_row, 1);
                 
                 
                 
                // raise a message
         	    new Custom_Message(72,140,"Needed Images\\verification_icon.png",
         	    "Successfully Deletion","Destination Deleted Successfully");}
           	 
           	else {
       		 
        		// raise a message
        	    new Custom_Message(95,140,"Needed Images\\x_icon.png",
        	    "Selection Error","Select a populated row");}
           	     

            	 table.setEnabled(false);
            	 table.getTableHeader().setForeground(Color.decode("#b39700"));
               
            	}});
        
        
        
        
        
        
        
		
		
		
		
		
		
		
		
		

        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(staff_space.space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(center_panel);
		
		
		
		
		

	}

}
 