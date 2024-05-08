package Staff_Pages;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;
import Graphical_Interface.Custom_ComboBox;











public class Staff_Stock_Page {

	// constructor
	public Staff_Stock_Page(Custom_Frame frame) {
		
		// create the staff space elements
	    Staff_Space staff_space = new Staff_Space(frame);
		
		
		// change stock button background to show that it's clicked
	    staff_space.stock.setBackground(Color.decode("#2F5597"));
	    staff_space.labs.setBackground(Color.decode("#2F5597"));
	    staff_space.stock.change_color_background("#2F5597","#2F5597",staff_space.labs);
	    staff_space.stock.change_style("#b39700","#b39700");
	    
	    
	    
	    // center page panel
	    int pn1_x = (int) ((140*frame.getWidth())/900);
	    int pn1_y = (int) ((70*frame.getHeight())/600);
	    int pn1_width = (int) ((800*frame.getWidth())/900);
	    int pn1_height = (int) ((580*frame.getHeight())/600);
	    Custom_Panel center_panel = new Custom_Panel(pn1_x,pn1_y,pn1_width,pn1_height,"#FFFFFF");
	    staff_space.space.add(center_panel);
	    
	    
	    
	    
	    // label 5 - product category
	    int lb5_x = (int) ((15*frame.getWidth())/900);
	    int lb5_y = (int) ((5*frame.getHeight())/600);
	    int lb5_width = (int) ((200*frame.getWidth())/900);
	    int lb5_height = (int) ((30*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,
        "Product Category","Century Gothic",lb5_font_size,"#b39700");
        lab5.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(lab5);
        
        
        // product category text field
        int x_m = (int) ((15*frame.getWidth())/900);
	    int y_m = (int) ((40*frame.getHeight())/600);
	    int width_m = (int) ((150*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field product_category = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Calibri",font_size_m,"#000000") ; 
	    center_panel.add(product_category);
	    
	    
	    // product categories
	    String[] options = {"Heavy Machineries","Manufacturing Materials","Industrial Tools",
	                         "Electronics","Safety Equipments","Softwares"};
	    
	    
	    // a comboBox that holds the product categories 
        int x_c = (int) ((15*frame.getWidth())/900);
	    int y_c = (int) ((60*frame.getHeight())/600);
	    int width_c = (int) ((149*frame.getWidth())/900);
	    int height_c = (int) ((23*frame.getHeight())/600);
	    int font_size_c = (int) ((11*frame.getWidth())/900);
        Custom_ComboBox comboBox = new Custom_ComboBox(x_c,y_c,width_c,height_c,font_size_c,options);
        center_panel.add(comboBox);
        comboBox.setVisible(false);
       
        boolean appears = false;
        
        
     
        // Add a key listener to the text field to show or hide the comboBox as needed
        product_category.addKeyListener(new KeyAdapter() {
            
        	@Override
            public void keyTyped(KeyEvent e) {
                
            	if (product_category.getText().isEmpty()) {
                    
            		comboBox.setVisible(false);}
                
            	else { if (appears == false) {
                         comboBox.setVisible(true);}}}});

        
        // Add a listener to the combo box to update the text field with the selected option
        comboBox.addActionListener(e -> {
            
        	String selectedOption = (String) comboBox.getSelectedItem();
            product_category.setText(selectedOption);
            comboBox.setVisible(false);});
	    
	    
        
        
        
        
        
        
        
    

	    
	    
	
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(staff_space.space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(center_panel);

		
	}

}
