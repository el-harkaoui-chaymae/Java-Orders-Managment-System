package Staff_Pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Client_Pages.Client_Product_Details;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_ComboBox;
import Graphical_Interface.Custom_Table;



import Data_Base.Product;
 


public class Staff_Stock_Page {
	
	// attribute
	boolean changes_saved = false ;
	static int product_identifier;
	     
  
	// constructor
	public Staff_Stock_Page(Custom_Frame frame) {
		 
		// create the staff space elements
	    Staff_Space staff_space = new Staff_Space(frame);
		
		
		// change stock button background to show that it's clicked
	    staff_space.stock.setBackground(Color.decode("#2F5597"));
	    staff_space.labs.setBackground(Color.decode("#2F5597"));
	    staff_space.stock.change_style("#b39700","#b39700");
	    staff_space.stock.change_color_background("#2F5597","#2F5597",staff_space.labs);

	       
	     
	       
	    // center page panel
	    int pn1_x = (int) ((140*frame.getWidth())/900);
	    int pn1_y = (int) ((70*frame.getHeight())/600);
	    int pn1_width = (int) ((800*frame.getWidth())/900);
	    int pn1_height = (int) ((580*frame.getHeight())/600);
	    Custom_Panel center_panel = new Custom_Panel(pn1_x,pn1_y,pn1_width,pn1_height,"#FFFFFF");
	    staff_space.space.add(center_panel);
	    
	    
	    
	    
	    // enter button after selecting a product category
	    int bt_x = (int) ((235*frame.getWidth())/900);
	    int bt_y = (int) ((75*frame.getHeight())/600);
	    int bt_width = (int) ((50*frame.getWidth())/900);
	    int bt_height = (int) ((30*frame.getHeight())/600);
	    int bt_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button enter = new Custom_Button(bt_x,bt_y,bt_width,bt_height,
        "v","#808080","Segoe Print",bt_font_size,false);
        center_panel.add(enter);
        
        
        // product category text field
        int x_m = (int) ((25*frame.getWidth())/900);
	    int y_m = (int) ((80*frame.getHeight())/600);
	    int width_m = (int) ((250*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field product_category = new Custom_Text_Field(x_m,y_m,width_m,height_m,
	    "Segoe Print",font_size_m,"#000000") ; 
	    product_category.setText(" select products category ...");
	    center_panel.add(product_category);
	    
	   
	    
	    
	    
	    
	    
	    // product categories
	    String[] options = {"Heavy Machineries","Manufacturing Materials","Industrial Tools",
	                         "Electronics","Safety Equipments","Softwares"};
	    
	    
	    // a comboBox that holds the product categories 
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
        product_category.addKeyListener(new KeyAdapter() {
            
        	@Override
            public void keyTyped(KeyEvent e) {
                
            	if (product_category.getText().isEmpty()) {
                    
            		combo_box.setVisible(false);}
                
            	else { if (appears == false) {
                         combo_box.setVisible(true);}}}});

        
        // Add a listener to the combo box to update the text field with the selected option
        combo_box.addActionListener(e -> {
            
        	String selected_option = (String) combo_box.getSelectedItem();
            product_category.setText(selected_option);
            combo_box.setVisible(false);});
	    
	    
        
        
       
        
        
        
        
        
        // ---- products table
        
        
        
        // Define table data
        Object[][] row_column_number =  new Object[52][4];
      

        // Define column names
        String[] columns_names = {"Identifier", "Product", "Price Dhs", "Quantity"};

        // Define column widths
        int[] columns_widths = {120, 310, 120, 121};

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
        int columns_number = 4;
        
        
        
        // enter button action
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// create a virtual product with the same entered product category
                Product virtual_product = new Product(product_category.getText(),null,0,0,null,null,null,null,null);
                
                // Get all the products of the entered category
                ArrayList<Object[]>  similar_products = virtual_product.get_similar_products();
                
                // clear all rows
                for(int j=0;j<rows_number;j++) {
                	for(int k=0;k<columns_number;k++) table.setValueAt("", j, k);{}
                }

         
                // Iterate through the needed_attributes array and set values to the table
                for (int i = 0; i < similar_products.size(); i++) {
                    
                        table.setValueAt(similar_products.get(i)[0], i, 0);
                        table.setValueAt(similar_products.get(i)[2], i, 1);
                        table.setValueAt(similar_products.get(i)[3], i, 2);
                        table.setValueAt(similar_products.get(i)[4], i, 3);
                    }
               
            	}});
        
        
       
        
        
        

        
        
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
	    search.setText(" search a product ...");
	    center_panel.add(search);
	    
	    
	    // search button action
        button_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	

            	// create a virtual product with the same entered product category
                Product virtual_product = new Product(null,search.getText(),0,0,null,null,null,null,null);
                
                // Get all the products that contain the entered search word
                ArrayList<Object[]>  searched_products = virtual_product.search_product();
                
                // clear all rows
                for(int j=0;j<rows_number;j++) {
                	for(int k=0;k<columns_number;k++) table.setValueAt("", j, k);{}
                }
                
                
                if(searched_products.size() == 0) {
          
           	     // raise a message
           	     new Custom_Message(115,140,"Needed Images\\x_icon.png",
           	     "Unfound Product","No Product is Found");}
                
                else {
                	
                	 // Iterate through the searched_products array and set values to the table
                    for (int i = 0; i < searched_products.size(); i++) {
                        
                            table.setValueAt(searched_products.get(i)[0], i, 0);
                            table.setValueAt(searched_products.get(i)[1], i, 1);
                            table.setValueAt(searched_products.get(i)[2], i, 2);
                            table.setValueAt(searched_products.get(i)[3], i, 3);
                        }
                }

         
               
               
            	
            	
            	
               
            	}});
	    
	    
	    
	    
	    
        
        // label 17 - directives
	    int lb18_x = (int) ((25*frame.getWidth())/900);
	    int lb18_y = (int) ((15*frame.getHeight())/600);
	    int lb18_width = (int) ((600*frame.getWidth())/900);
	    int lb18_height = (int) ((20*frame.getHeight())/600);
	    int lb18_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab18 = new Custom_Label(lb18_x, lb18_y, lb18_width, lb18_height,"Select a category "
        + "to display products than click edit to select a row "
        + "and use the buttons above to perform actions on it ... ",
        "calibri",lb18_font_size,"#008080");
        center_panel.add(lab18);
	    
	    
        
        
       
        
        // --- top bar buttons
        
        
       String color = "#C00000"; 
       String font_color = "#2F5597";
        
        
        // edit button 
	    int bt1_x = (int) ((140*frame.getWidth())/900);
	    int bt1_y = (int) ((13*frame.getHeight())/600);
	    int bt1_width = (int) ((90*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button edit = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Edit",font_color,"Consolas",bt1_font_size,false);
        edit.change_style(color,font_color);
        edit.add_buttom_border(162, 50, 46, color, frame, staff_space.space);
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
	    int bt2_x = (int) ((250*frame.getWidth())/900);
	    int bt2_y = (int) ((13*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button cancel = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Cancel",font_color,"Consolas",bt2_font_size,false);
        cancel.change_style(color,font_color);
        cancel.add_buttom_border(268, 50, 54, color, frame, staff_space.space);
        staff_space.space.add(cancel);
       

        

   	    // cancel button action
   	    cancel.addActionListener(new ActionListener() {
   	       public void actionPerformed(ActionEvent e) {
   	         
   	    	 // if we did not save changes yet
   	    	 if(changes_saved == false) {
   	    		 

   	   	         // create a virtual product with the same entered product category
   	             Product virtual_product = new Product(product_category.getText(),null,0,0,null,null,null,null,null);
   	             
   	             // Get all the products of the entered category
   	             ArrayList<Object[]>  similar_products = virtual_product.get_similar_products();
   	             
   	             // clear all rows
   	             for(int j=0;j<rows_number;j++) {
   	             	for(int k=0;k<columns_number;k++) table.setValueAt("", j, k);{}
   	             }

   	      
   	             // Iterate through the needed_attributes array and set values to the table
   	             for (int i = 0; i < similar_products.size(); i++) {
   	                 
   	                     table.setValueAt(similar_products.get(i)[0], i, 0);
   	                     table.setValueAt(similar_products.get(i)[2], i, 1);
   	                     table.setValueAt(similar_products.get(i)[3], i, 2);
   	                     table.setValueAt(similar_products.get(i)[4], i, 3); }}

   	         // Set other properties
   	         table.getTableHeader().setForeground(Color.decode("#b39700"));
   	         table.setEnabled(false); }});

        
        
        
        
        

        // save button 
	    int bt3_x = (int) ((362*frame.getWidth())/900);
	    int bt3_y = (int) ((13*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button save = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Save",font_color,"Consolas",bt3_font_size,false);
        save.change_style(color,font_color);
        save.add_buttom_border(384, 50, 46, color, frame, staff_space.space);
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
            	 if (selected_row != -1 && table.getValueAt(selected_row, 0)!=null 
            			                && !(table.getValueAt(selected_row, 0).equals(""))) { 
            		 int id_product = Integer.parseInt(table.getValueAt(selected_row, 0).toString());
            	     String product_name = table.getValueAt(selected_row, 1).toString();
            	     double quantity = Double.parseDouble(table.getValueAt(selected_row, 3).toString());
            	     double price = Double.parseDouble(table.getValueAt(selected_row, 2).toString());
            	     
            	     // create a virtual product
            	     Product virtual_product = new Product(null,product_name,quantity,price,null,null,null,null,null);
            	     virtual_product.setId(id_product);
            	     
            	     // update the product of the selected row
            	     virtual_product.modify();
            	      
            	     
            	     // raise a message
            	     new Custom_Message(115,140,"Needed Images\\verification_icon.png",
            	     "Succussful Update","Changes are Saved");}
            	 
            	 else {
            		 
            		// raise a message
            	    new Custom_Message(95,140,"Needed Images\\x_icon.png",
            	    "Selection Error","Select a populated row");
            		 
            	 }
            	   
            	 }});
        
      
        
        
        
        
        
        
        // delete product button 
	    int bt5_x = (int) ((450*frame.getWidth())/900);
	    int bt5_y = (int) ((13*frame.getHeight())/600);
	    int bt5_width = (int) ((125*frame.getWidth())/900);
	    int bt5_height = (int) ((40*frame.getHeight())/600);
	    int bt5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button delete = new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "Delete",font_color,"Consolas",bt5_font_size,false);
        delete.change_style(color,font_color);
        delete.add_buttom_border(485, 50, 56, color, frame, staff_space.space);
        staff_space.space.add(delete);
        

        // delete button action
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
             // get the selected row id
           	 int selected_row = table.getSelectedRow();
           	 // Check if a row is selected
           	 if (selected_row != -1 && table.getValueAt(selected_row, 0)!=null 
           			                && !(table.getValueAt(selected_row, 0).equals(""))) { 
           		 int id_product = Integer.parseInt(table.getValueAt(selected_row, 0).toString());
           		 
           	     // create a virtual product
        	     Product virtual_product = new Product(null,null,0,0,null,null,null,null,null);
        	     virtual_product.setId(id_product);
        	     
        	     // delete the product of the selected row
        	     virtual_product.delete();
        	     
        	     // Clear the cells of the selected row
                 table.setValueAt(null, selected_row, 0); 
                 table.setValueAt(null, selected_row, 1);
                 table.setValueAt(null, selected_row, 2);
                 table.setValueAt(null, selected_row, 3);
                 
                 
                // raise a message
         	    new Custom_Message(75,140,"Needed Images\\verification_icon.png",
         	    "Successfully Deletion","Product Deleted Successfully");}
           	 
           	else {
       		 
        		// raise a message
        	    new Custom_Message(95,140,"Needed Images\\x_icon.png",
        	    "Selection Error","Select a populated row");}
           	     

            	 table.setEnabled(false);
            	 table.getTableHeader().setForeground(Color.decode("#b39700"));
               
            	}});
        
       
        
        
        
        
        // details about product button 
	    int bt6_x = (int) ((570*frame.getWidth())/900);
	    int bt6_y = (int) ((13*frame.getHeight())/600);
	    int bt6_width = (int) ((125*frame.getWidth())/900);
	    int bt6_height = (int) ((40*frame.getHeight())/600);
	    int bt6_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button details = new Custom_Button(bt6_x,bt6_y,bt6_width,bt6_height,
        "Details",font_color,"Consolas",bt6_font_size,false);
        details.change_style(color,font_color);
        details.add_buttom_border(602, 50, 61, color, frame, staff_space.space);
        staff_space.space.add(details);
        
        // details action
        details.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// get the selected row id
              	 int selected_row = table.getSelectedRow();
              	 // Check if a row is selected
              	 if (selected_row != -1 && table.getValueAt(selected_row, 0)!=null 
              			                && !(table.getValueAt(selected_row, 0).equals(""))) { 
              		 product_identifier = Integer.parseInt(table.getValueAt(selected_row, 0).toString());
              		 
					// Hide all components in the frame
					for (Component comp : frame.getContentPane().getComponents()) {
						comp.setVisible(false);
					}

					// open products details page
					new Staff_Product_Details_Page(frame);
					// refresh the window
					frame.revalidate();
					frame.repaint();}
              	 
              	 else {
              		 
              		// raise a message
            	    new Custom_Message(95,140,"Needed Images\\x_icon.png",
            	    "Selection Error","Select a populated row");}
              	 
            	
            	}});
        
        
        
        
        
        
	
        
        // handle resizing
        new Custom_Resizing_Manager(frame);
        new Custom_Resizing_Manager(staff_space.space);
        new Custom_Resizing_Manager(center_panel);

		
	}

}
