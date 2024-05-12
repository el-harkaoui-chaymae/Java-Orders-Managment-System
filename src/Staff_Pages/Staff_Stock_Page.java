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
	    
	    
	    
	    
	    // label 5 - product category
	    int lb5_x = (int) ((25*frame.getWidth())/900);
	    int lb5_y = (int) ((25*frame.getHeight())/600);
	    int lb5_width = (int) ((200*frame.getWidth())/900);
	    int lb5_height = (int) ((30*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,
        "Product Category","Century Gothic",lb5_font_size,"#b39700");
        lab5.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(lab5);
        
        
        // product category text field
        int x_m = (int) ((25*frame.getWidth())/900);
	    int y_m = (int) ((60*frame.getHeight())/600);
	    int width_m = (int) ((150*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field product_category = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Segoe Print",font_size_m,"#000000") ; 
	    product_category.setText(" select ...");
	    center_panel.add(product_category);
	    
	    
	    
	    
	    
	    // product categories
	    String[] options = {"Heavy Machineries","Manufacturing Materials","Industrial Tools",
	                         "Electronics","Safety Equipments","Softwares"};
	    
	    
	    // a comboBox that holds the product categories 
        int x_c = (int) ((25*frame.getWidth())/900);
	    int y_c = (int) ((80*frame.getHeight())/600);
	    int width_c = (int) ((149*frame.getWidth())/900);
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
	    int y_t = (int) ((120*frame.getHeight())/600);
	    int width_t = (int) ((682*frame.getWidth())/900);
	    int height_t = (int) ((295*frame.getHeight())/600);
	    int cell_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Table table = new Custom_Table(frame,x_t, y_t, width_t, height_t, row_column_number, columns_names, 
        columns_names.length, columns_widths, row_height,header_font_size,cell_font_size);
                
     
        // Add the scroll pane holding the view of the table to the center panel
        center_panel.add(table.scroll_pane);
        
        
        

        
        
        // search button 
	    int bt4_x = (int) ((686*frame.getWidth())/900);
	    int bt4_y = (int) ((61*frame.getHeight())/600);
	    int bt4_width = (int) ((15*frame.getWidth())/900);
	    int bt4_height = (int) ((20*frame.getHeight())/600);
        Custom_Button button_search = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "","#000000","Consolas",7,false);
        center_panel.add(button_search);
        
        
        // label 17 - search icon
	    int lb17_x = (int) ((686*frame.getWidth())/900);
	    int lb17_y = (int) ((61*frame.getHeight())/600);
	    int lb17_width = (int) ((15*frame.getWidth())/900);
	    int lb17_height = (int) ((20*frame.getHeight())/600);
        Custom_Label lab17 = new Custom_Label(lb17_x, lb17_y, lb17_width, lb17_height,"",
        "Calibri",7,"#b39700");
        lab17.add_background("Needed images\\search_icon.png");
        center_panel.add(lab17);
        
        
        // search text_field
        int x_s = (int) ((557*frame.getWidth())/900);
	    int y_s = (int) ((60*frame.getHeight())/600);
	    int width_s = (int) ((150*frame.getWidth())/900);
	    int height_s = (int) ((23*frame.getHeight())/600);
	    int font_size_s = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field search = new Custom_Text_Field(x_s,y_s,width_s,height_s,"Segoe Print",font_size_s,"#000000") ;
	    search.setText(" search ...");
	    center_panel.add(search);
	    
	    
	    
	    
	    
	    
	    
	    // label 17 - info icon
	    int lb19_x = (int) ((25*frame.getWidth())/900);
	    int lb19_y = (int) ((445*frame.getHeight())/600);
	    int lb19_width = (int) ((25*frame.getWidth())/900);
	    int lb19_height = (int) ((30*frame.getHeight())/600);
	    int lb19_font_size = (int) ((20*frame.getWidth())/900);
        Custom_Label lab19 = new Custom_Label(lb19_x, lb19_y, lb19_width, lb19_height,"i",
        "Consolas",lb19_font_size,"#C00000");
        center_panel.add(lab19);
	    
        
        // label 17 - directives
	    int lb18_x = (int) ((50*frame.getWidth())/900);
	    int lb18_y = (int) ((449*frame.getHeight())/600);
	    int lb18_width = (int) ((550*frame.getWidth())/900);
	    int lb18_height = (int) ((20*frame.getHeight())/600);
	    int lb18_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab18 = new Custom_Label(lb18_x, lb18_y, lb18_width, lb18_height,"Select a row from the table "
        + "and use the buttons above to perform actions on it ...",
        "Segoe Print",lb18_font_size,"#AFAFAF");
        center_panel.add(lab18);
	    
	    
        
        
       
        
        // --- top bar buttons
        
        
       String color = "#C00000"; 
       String font_color = "#2F5597";
        
        
        // edit button 
	    int bt1_x = (int) ((140*frame.getWidth())/900);
	    int bt1_y = (int) ((11*frame.getHeight())/600);
	    int bt1_width = (int) ((90*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button edit = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Edit",font_color,"Consolas",bt1_font_size,false);
        edit.change_style(color,font_color);
        edit.add_buttom_border(152, 50, 55, color, frame, staff_space.space);
        staff_space.space.add(edit);
        
        
        
        // label 16 - edit icon
	    int lb16_x = (int) ((150*frame.getWidth())/900);
	    int lb16_y = (int) ((19*frame.getHeight())/600);
	    int lb16_width = (int) ((15*frame.getWidth())/900);
	    int lb16_height = (int) ((20*frame.getHeight())/600);
        Custom_Label lab16 = new Custom_Label(lb16_x, lb16_y, lb16_width, lb16_height,"",
        "Calibri",7,"#b39700");
        lab16.add_background("Needed images\\edit_icon.png");
        staff_space.space.add(lab16);
        
        
        
        
        
        
        // cancel button 
	    int bt2_x = (int) ((250*frame.getWidth())/900);
	    int bt2_y = (int) ((11*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button cancel = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Cancel",font_color,"Consolas",bt2_font_size,false);
        cancel.change_style(color,font_color);
        cancel.add_buttom_border(259, 50, 60, color, frame, staff_space.space);
        staff_space.space.add(cancel);
        
        
        // label 15 - cancel icon
	    int lb15_x = (int) ((260*frame.getWidth())/900);
	    int lb15_y = (int) ((18*frame.getHeight())/600);
	    int lb15_width = (int) ((15*frame.getWidth())/900);
	    int lb15_height = (int) ((16*frame.getHeight())/600);
	    int lb15_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab15 = new Custom_Label(lb15_x, lb15_y, lb15_width, lb15_height,"x",
        "Segoe Print",lb15_font_size,"#000000");
        staff_space.space.add(lab15);
        
        
        
        
        
        
        

        // save button 
	    int bt3_x = (int) ((362*frame.getWidth())/900);
	    int bt3_y = (int) ((11*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button save = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Save",font_color,"Consolas",bt3_font_size,false);
        save.change_style(color,font_color);
        save.add_buttom_border(372, 50, 55, color, frame, staff_space.space);
        staff_space.space.add(save);
        
        
        // label 14 - save icon
	    int lb14_x = (int) ((375*frame.getWidth())/900);
	    int lb14_y = (int) ((19*frame.getHeight())/600);
	    int lb14_width = (int) ((12*frame.getWidth())/900);
	    int lb14_height = (int) ((15*frame.getHeight())/600);
	    int lb14_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab14 = new Custom_Label(lb14_x, lb14_y, lb14_width, lb14_height,"v",
        "Segoe Print",lb14_font_size,"#000000");
        staff_space.space.add(lab14);
        
        
        
        
        
        
        
        // delete product button 
	    int bt5_x = (int) ((450*frame.getWidth())/900);
	    int bt5_y = (int) ((11*frame.getHeight())/600);
	    int bt5_width = (int) ((125*frame.getWidth())/900);
	    int bt5_height = (int) ((40*frame.getHeight())/600);
	    int bt5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button delete = new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "Delete",font_color,"Consolas",bt5_font_size,false);
        delete.change_style(color,font_color);
        delete.add_buttom_border(475, 50, 63, color, frame, staff_space.space);
        staff_space.space.add(delete);
        
        // label 20 - delete icon
	    int lb20_x = (int) ((475*frame.getWidth())/900);
	    int lb20_y = (int) ((21*frame.getHeight())/600);
	    int lb20_width = (int) ((12*frame.getWidth())/900);
	    int lb20_height = (int) ((15*frame.getHeight())/600);
        Custom_Label lab20 = new Custom_Label(lb20_x, lb20_y, lb20_width, lb20_height,"",
        "Segoe Print",7,"#000000");
        lab20.add_background("Needed images\\delete_icon.png");
        staff_space.space.add(lab20);
        
        
        
        
        
        
        // details about product button 
	    int bt6_x = (int) ((570*frame.getWidth())/900);
	    int bt6_y = (int) ((11*frame.getHeight())/600);
	    int bt6_width = (int) ((125*frame.getWidth())/900);
	    int bt6_height = (int) ((40*frame.getHeight())/600);
	    int bt6_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button details = new Custom_Button(bt6_x,bt6_y,bt6_width,bt6_height,
        "Details",font_color,"Consolas",bt6_font_size,false);
        details.change_style(color,font_color);
        details.add_buttom_border(593, 50, 65, color, frame, staff_space.space);
        staff_space.space.add(details);
        
        // label 21 - details icon
	    int lb21_x = (int) ((593*frame.getWidth())/900);
	    int lb21_y = (int) ((21*frame.getHeight())/600);
	    int lb21_width = (int) ((12*frame.getWidth())/900);
	    int lb21_height = (int) ((20*frame.getHeight())/600);
	    int lb21_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab21 = new Custom_Label(lb21_x, lb21_y, lb21_width, lb21_height,"i",
        "Consolas",lb21_font_size,"#000000");
        //lab21.add_background("Needed images\\delete_icon.png");
        staff_space.space.add(lab21);
        
        
        
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    

	    
	    
	
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(staff_space.space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(center_panel);

		
	}

}
