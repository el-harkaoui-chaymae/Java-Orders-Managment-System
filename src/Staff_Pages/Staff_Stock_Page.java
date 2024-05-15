package Staff_Pages;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;


import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_ComboBox;
import Graphical_Interface.Custom_Table;



public class Staff_Stock_Page {

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
	    
	    
	    
	    
     
        
        
        // product category text field
        int x_m = (int) ((25*frame.getWidth())/900);
	    int y_m = (int) ((80*frame.getHeight())/600);
	    int width_m = (int) ((200*frame.getWidth())/900);
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
	    int width_c = (int) ((200*frame.getWidth())/900);
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
	    
	    
        
        
       
        
        
        
        
        
        // products table
        
        // Define table data
        Object[][] row_column_number =  new Object[52][6];
      

        // Define column names
        String[] columns_names = {"Identifier", "Product", "Price", "Quantity"};

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
	    int cell_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Table table = new Custom_Table(frame,x_t, y_t, width_t, height_t, row_column_number, columns_names, 
        columns_names.length, columns_widths, row_height,header_font_size,cell_font_size);
                
     
        // Add the scroll pane holding the view of the table to the center panel
        center_panel.add(table.scroll_pane);
        
        
        

        
        
        // search button 
	    int bt4_x = (int) ((686*frame.getWidth())/900);
	    int bt4_y = (int) ((96*frame.getHeight())/600);
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
        int x_s = (int) ((557*frame.getWidth())/900);
	    int y_s = (int) ((80*frame.getHeight())/600);
	    int width_s = (int) ((150*frame.getWidth())/900);
	    int height_s = (int) ((23*frame.getHeight())/600);
	    int font_size_s = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field search = new Custom_Text_Field(x_s,y_s,width_s,height_s,"Segoe Print",font_size_s,"#000000") ;
	    search.setText(" search ...");
	    center_panel.add(search);
	    
	    
	    
	    
	    
	    
        
        // label 17 - directives
	    int lb18_x = (int) ((25*frame.getWidth())/900);
	    int lb18_y = (int) ((15*frame.getHeight())/600);
	    int lb18_width = (int) ((550*frame.getWidth())/900);
	    int lb18_height = (int) ((20*frame.getHeight())/600);
	    int lb18_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab18 = new Custom_Label(lb18_x, lb18_y, lb18_width, lb18_height,"Please select a row from the table "
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
        
        
        
        
        
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    

	    
	    
	
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(staff_space.space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(center_panel);

		
	}

}
