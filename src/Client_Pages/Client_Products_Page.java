package Client_Pages;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.SwingConstants;

import Data_Base.Product;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_ComboBox;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;

public class Client_Products_Page {
	
	// attributes

	ByteArrayInputStream photo_1 ;
	ByteArrayInputStream photo_2 ;
	ByteArrayInputStream photo_3 ;
	ByteArrayInputStream photo_4 ;
	
	ByteArrayInputStream photo_5 ;
	
	static String Product_category;
	 
	int horizontal_spacing = 30;
    int start_point = 25;
    
   
    
	  
	 
	
	// constructor   
	public Client_Products_Page (Custom_Frame frame) {
		
		// create the client space elements
		Client_Space client_space = new Client_Space(frame);
				


		// change products button background to show that it's clicked
		client_space.products.setBackground(Color.decode("#002F5E"));
		client_space.labr.setBackground(Color.decode("#002F5E"));
		client_space.products.change_color_background("#002F5E","#002F5E",client_space.labr);
		client_space.products.change_style("#b39700","#b39700");
		
		
		// center page panel
	    int pn1_x = (int) ((140*frame.getWidth())/900);
	    int pn1_y = (int) ((70*frame.getHeight())/600);
	    int pn1_width = (int) ((800*frame.getWidth())/900);
	    int pn1_height = (int) ((580*frame.getHeight())/600);
	    Custom_Panel center_panel = new Custom_Panel(pn1_x,pn1_y,pn1_width,pn1_height,"#FFFFFF");
	    client_space.space.add(center_panel);
	    
	    
	    // recommended products panel 
	    int pn2_x = (int) ((25*frame.getWidth())/900);
	    int pn2_y = (int) ((170*frame.getHeight())/600);
	    int pn2_width = (int) ((680*frame.getWidth())/900);
	    int pn2_height = (int) ((250*frame.getHeight())/600);
	    Custom_Panel recommended_products_panel = new Custom_Panel(pn2_x,pn2_y,pn2_width,pn2_height,"#F9F9F8");
	    recommended_products_panel.add_background("Needed images\\client_space.png");
	    center_panel.add(recommended_products_panel);
	    
	    
	    // label  - Recommended Products
	    int lb_x = (int) ((170*frame.getWidth())/900);
	    int lb_y = (int) ((14*frame.getHeight())/600);
	    int lb_width = (int) ((400*frame.getWidth())/900);
	    int lb_height = (int) ((30*frame.getHeight())/600);
	    int lb_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab = new Custom_Label(lb_x, lb_y, lb_width, lb_height,"Recommended Products for you  ...",
        "Segoe Print",lb_font_size,"#008080");
        client_space.space.add(lab);
	    
	    
        
        // virtual product
        Product virtual_product = new Product(null,null,0,0,null,null,null,null,null);
        
        // git 3 random products names and first photos 
        ArrayList<Object[]> random_products_needed_infos = virtual_product.get_4_random_products();
        
        
	    
	    
	    // product photo_1 label
	    int lb1_x = (int) ((122*frame.getWidth())/900);
	    int lb1_y = (int) ((55*frame.getHeight())/600);
	    int lb1_width = (int) ((100*frame.getWidth())/900);
	    int lb1_height = (int) ((130*frame.getHeight())/600);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,"",
        "Calibri",7,"#E5E6E4");
        Border border = BorderFactory.createLineBorder(Color.decode("#E5E6E4"), 4);
        lab1.setBorder(border);
        recommended_products_panel.add(lab1);
        
        if((random_products_needed_infos.get(1))[1] != null) {
        	
        	// set the label icon
            try {
      		    photo_2 = (ByteArrayInputStream) (random_products_needed_infos.get(1))[1];
                lab1.setIcon(new ImageIcon(ImageIO.read(photo_2).getScaledInstance(lab1.getWidth(),
                lab1.getHeight(), Image.SCALE_SMOOTH)));}
          
      	    catch (Exception ex) { ex.printStackTrace();}
        }
        
        
        
        
        
        // product photo_2 label
	    int lb2_x = (int) ((260*frame.getWidth())/900);
	    int lb2_y = (int) ((35*frame.getHeight())/600);
	    int lb2_width = (int) ((140*frame.getWidth())/900);
	    int lb2_height = (int) ((170*frame.getHeight())/600);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,"",
        "Calibri",7,"#E5E6E4");
        Border border2 = BorderFactory.createLineBorder(Color.decode("#b39700"), 4);
        lab2.setBorder(border2);
        recommended_products_panel.add(lab2);
        
        if(photo_3 != (random_products_needed_infos.get(2))[1]) {
        	
        	// set the label icon
            try {
      		    photo_3 = (ByteArrayInputStream) (random_products_needed_infos.get(2))[1];
                lab2.setIcon(new ImageIcon(ImageIO.read(photo_3).getScaledInstance(lab2.getWidth(),
                lab2.getHeight(), Image.SCALE_SMOOTH)));}
          
      	    catch (Exception ex) { ex.printStackTrace();}
        }
        
        
     
         
        
        
        
        
        // product photo_3 label
	    int lb3_x = (int) ((438*frame.getWidth())/900);
	    int lb3_y = (int) ((55*frame.getHeight())/600);
	    int lb3_width = (int) ((100*frame.getWidth())/900);
	    int lb3_height = (int) ((130*frame.getHeight())/600);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,"",
        "Calibri",7,"#C00000");
        Border border3 = BorderFactory.createLineBorder(Color.decode("#E5E6E4"), 4);
        lab3.setBorder(border3);
        recommended_products_panel.add(lab3);
        
        
        // set the label icon
        if((random_products_needed_infos.get(3))[1] != null) {
        	
        	try {
      		    photo_4 = (ByteArrayInputStream) (random_products_needed_infos.get(3))[1];
                lab3.setIcon(new ImageIcon(ImageIO.read(photo_4).getScaledInstance(lab3.getWidth(),
                lab3.getHeight(), Image.SCALE_SMOOTH)));}
          
      	    catch (Exception ex) { ex.printStackTrace();}
        }
        
        
        
        
        
        
        // random choosen selected product name
	    int ls_x = (int) ((25*frame.getWidth())/900);
	    int ls_y = (int) ((120*frame.getHeight())/600);
	    int ls_width = (int) ((600*frame.getWidth())/900);
	    int ls_height = (int) ((30*frame.getHeight())/600);
	    int ls_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Label ls = new Custom_Label(ls_x, ls_y, ls_width, ls_height,
        (random_products_needed_infos.get(2))[0].toString(),"Segoe Print",ls_font_size,"#C00000");
        ls.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(ls);
        
        
        
        
        
        
        // handel labels resizing to ensure that the images always fit their containers
	    lab2.addComponentListener(new ComponentAdapter() {

	            @Override
	            public void componentResized(ComponentEvent e) {
	            	
	            	// reset photo 1
	            	try { 
	                    	   // Reset the stream to the beginning
	                           
	                           lab1.setIcon(new ImageIcon(((ImageIcon) lab1.getIcon()).getImage().getScaledInstance(lab1.getWidth(),
	                           lab1.getHeight(), Image.SCALE_SMOOTH)));}
	               
	            	catch (Exception ex) {
	                    ex.printStackTrace();}
	            	
	            	
	            	// reset photo 2
	            	try { 
	                    	   // Reset the stream to the beginning
	                           
	                           lab2.setIcon(new ImageIcon(((ImageIcon) lab2.getIcon()).getImage().getScaledInstance(lab2.getWidth(),
	                           lab2.getHeight(), Image.SCALE_SMOOTH)));}
	               
	            	catch (Exception ex) {
	                    ex.printStackTrace();}
                    
	            	
	            	// reset photo 3
	            	try { 
	                    	   // Reset the stream to the beginning
	                           
	                           lab3.setIcon(new ImageIcon(((ImageIcon) lab3.getIcon()).getImage().getScaledInstance(lab3.getWidth(),
	                           lab3.getHeight(), Image.SCALE_SMOOTH)));}
	            	
	            	catch (Exception ex) {
	                    ex.printStackTrace();}
	            	
	            	
	            	
                    }});
        
        
        
        
	    photo_1 = (ByteArrayInputStream) (random_products_needed_infos.get(0))[1];
	   
        
	    // store recommended products names in order
	    String [] products_names = new String [4];
	    
	    int i = 0;
	    
	    for ( Object[] product:random_products_needed_infos) {
	    	
	    	String name = product[0].toString();
	    	products_names[i] = name ;
	    	i += 1 ;
	    }
	    
        
        
        
        
        // previous image button 
	    int bt_x = (int) ((0*frame.getWidth())/900);
	    int bt_y = (int) ((100*frame.getHeight())/600);
	    int bt_width = (int) ((70*frame.getWidth())/900);
	    int bt_height = (int) ((30*frame.getHeight())/600);
	    int bt_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Button previous_image = new Custom_Button(bt_x,bt_y,bt_width,bt_height,
        "<<","#808080","Consolas",bt_font_size,false);
        recommended_products_panel.add(previous_image);
        
        // next image button 
	    int bn_x = (int) ((600*frame.getWidth())/900);
	    int bn_y = (int) ((100*frame.getHeight())/600);
	    int bn_width = (int) ((70*frame.getWidth())/900);
	    int bn_height = (int) ((30*frame.getHeight())/600);
	    int bn_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Button next_image = new Custom_Button(bn_x,bn_y,bn_width,bn_height,
        ">>","#808080","Consolas",bn_font_size,false);
        recommended_products_panel.add(next_image);
        
        
       
        
        // previous_image button action
        previous_image.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// change the buttons visibility to show that the end is reached
            	previous_image.setVisible(false);
            	next_image.setVisible(true);
            	
            	// change the selected product name
            	ls.setText((random_products_needed_infos.get(2))[0].toString());
            	
            
            	// reset icon for lab 3 
            	try { 
                    	   // Reset the stream to the beginning
                           photo_4.reset();
                           lab3.setIcon(new ImageIcon(ImageIO.read(photo_4).getScaledInstance(lab3.getWidth(),
                           lab3.getHeight(), Image.SCALE_SMOOTH)));}
               
            	catch (Exception ex) {
                    ex.printStackTrace();}
            	
            	
            	
            	
            	// reset icon for lab 2
            	try { 
                    	   // Reset the stream to the beginning
                           photo_3.reset();
                           lab2.setIcon(new ImageIcon(ImageIO.read(photo_3).getScaledInstance(lab2.getWidth(),
                           lab2.getHeight(), Image.SCALE_SMOOTH)));}
               
            	catch (Exception ex) {
                    ex.printStackTrace();}
            	
            	
            	// reset icon for lab 1
            	try { 
                    	   // Reset the stream to the beginning
                           photo_2.reset();
                           lab1.setIcon(new ImageIcon(ImageIO.read(photo_2).getScaledInstance(lab1.getWidth(),
                           lab1.getHeight(), Image.SCALE_SMOOTH)));}
               
            	catch (Exception ex) {
                    ex.printStackTrace();}  }});
        
        
        
        
        
        
        
        // next_image button action
        next_image.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// change the buttons visibility to show that the end is reached
            	next_image.setVisible(false);
            	previous_image.setVisible(true);
            	
            	// change the selected product name
            	ls.setText((random_products_needed_infos.get(1))[0].toString());
            	
        
            
            	// reset icon for lab 1
            	try { 
                    	   // Reset the stream to the beginning
                           photo_1.reset();
                           lab1.setIcon(new ImageIcon(ImageIO.read(photo_1).getScaledInstance(lab1.getWidth(),
                           lab1.getHeight(), Image.SCALE_SMOOTH)));}
               
            	catch (Exception ex) {
                    ex.printStackTrace();}
            	
            	
            	
            	
            	// reset icon for lab 2
            	try { 
                    	   // Reset the stream to the beginning
                           photo_2.reset();
                           lab2.setIcon(new ImageIcon(ImageIO.read(photo_2).getScaledInstance(lab2.getWidth(),
                           lab2.getHeight(), Image.SCALE_SMOOTH)));}
               
            	catch (Exception ex) {
                    ex.printStackTrace();}
            	
            	
            	
            	// reset icon for lab 3
            	try { 
                    	   // Reset the stream to the beginning
                           photo_3.reset();
                           lab3.setIcon(new ImageIcon(ImageIO.read(photo_3).getScaledInstance(lab3.getWidth(),
                           lab3.getHeight(), Image.SCALE_SMOOTH)));}
               
            	catch (Exception ex) {
                    ex.printStackTrace();}
            	
            }});
		
	    
	    
        
       
        
        // enter button after selecting a product category
	    int btn_x = (int) ((235*frame.getWidth())/900);
	    int btn_y = (int) ((15*frame.getHeight())/600);
	    int btn_width = (int) ((50*frame.getWidth())/900);
	    int btn_height = (int) ((30*frame.getHeight())/600);
	    int btn_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button enter = new Custom_Button(btn_x,btn_y,btn_width,btn_height,
        "v","#808080","Segoe Print",btn_font_size,false);
        center_panel.add(enter);
        
        
        
        
        
        
        // product category text field
        int x_m = (int) ((25*frame.getWidth())/900);
	    int y_m = (int) ((20*frame.getHeight())/600);
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
	    int y_c = (int) ((40*frame.getHeight())/600);
	    int width_c = (int) ((250*frame.getWidth())/900);
	    int height_c = (int) ((23*frame.getHeight())/600);
	    int font_size_c = (int) ((11*frame.getWidth())/900);
        Custom_ComboBox combo_box = new Custom_ComboBox(x_c,y_c,width_c,height_c,font_size_c,options);
        center_panel.add(combo_box);
        combo_box.setVisible(false);
       
        boolean appears = false;
        
        
     
        // Add a key listener to the text field to show or hide the comboBox and others as needed
        product_category.addKeyListener(new KeyAdapter() {
            
        	@Override
            public void keyTyped(KeyEvent e) {
                
            	if (product_category.getText().isEmpty()) {
            		
            		// show the recommended products
            		recommended_products_panel.setVisible(true);
            		lab.setVisible(true);
            		ls.setVisible(true);
                    
            		combo_box.setVisible(false);}
                
            	else { 
            		
            		// hide the recommended products
            		recommended_products_panel.setVisible(false);
            		lab.setVisible(false);
            		ls.setVisible(false);
            		
            		if (appears == false) {
                         combo_box.setVisible(true);}}}});

        
        // Add a listener to the combo box to update the text field with the selected option
        combo_box.addActionListener(e -> {
            
        	String selected_option = (String) combo_box.getSelectedItem();
            product_category.setText(selected_option);
            combo_box.setVisible(false);});
        
        
        
        
        
        // -------------------------------------------------------------------------------
        
        
        
        
        // enter button action
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Product_category = product_category.getText();
            	
            	// remove client product page
                frame.getContentPane().removeAll();    
                // create an instance client buy products  page 
                new Client_Buy_Products_Page (frame);                       
                // refresh the window
                frame.revalidate();
                frame.repaint();  }});
        
        
       
        
        
        
        // search button 
	    int bt4_x = (int) ((686*frame.getWidth())/900);
	    int bt4_y = (int) ((10*frame.getHeight())/600);
	    int bt4_width = (int) ((15*frame.getWidth())/900);
	    int bt4_height = (int) ((20*frame.getHeight())/600);
        Custom_Button button_search = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "","#000000","Consolas",7,false);
        center_panel.add(button_search);
        
        
       
        
        // label 17 - search icon
	    int lb17_x = (int) ((686*frame.getWidth())/900);
	    int lb17_y = (int) ((21*frame.getHeight())/600);
	    int lb17_width = (int) ((15*frame.getWidth())/900);
	    int lb17_height = (int) ((20*frame.getHeight())/600);
        Custom_Label lab17 = new Custom_Label(lb17_x, lb17_y, lb17_width, lb17_height,"",
        "Calibri",7,"#b39700");
        lab17.add_background("Needed images\\search_icon.png");
        center_panel.add(lab17);
        
        
        // search text_field
        int x_s = (int) ((457*frame.getWidth())/900);
	    int y_s = (int) ((20*frame.getHeight())/600);
	    int width_s = (int) ((250*frame.getWidth())/900);
	    int height_s = (int) ((23*frame.getHeight())/600);
	    int font_size_s = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field search = new Custom_Text_Field(x_s,y_s,width_s,height_s,"Segoe Print",font_size_s,"#000000") ;
	    search.setText(" search ...");
	    center_panel.add(search);
	    
	    
        
        
        
        
        

    	
        
        
       
        
        
        
        
        
	    
	   
        
        
	    
	    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
		
		
		
		
		
		
		// handle resizing
        new Custom_Resizing_Manager(frame);
        new Custom_Resizing_Manager(client_space.space);
        new Custom_Resizing_Manager(center_panel);
        new Custom_Resizing_Manager(recommended_products_panel);
        
        
        
		    	
		    	
		    	
		    	
	}
	
	
	
	
	
	// ------------------------------------------------------------------------------
	
	
	
	
	
	
	

}