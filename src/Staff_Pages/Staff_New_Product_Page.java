package Staff_Pages;

import java.awt.Color;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;
import Graphical_Interface.Custom_Text_Area;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_ComboBox;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;
import Data_Base.Product;



public class Staff_New_Product_Page {
	
	// attributes
	Image image_1;
	File selected_file_1;
	Image image_2;
	File selected_file_2;
	Image image_3;
	File selected_file_3;
	
	// constructor
	public Staff_New_Product_Page(Custom_Frame frame) {
		
		// create the staff space elements
	    Staff_Space staff_space = new Staff_Space(frame);
		
		
		// change new_product button background to show that it's clicked
	    staff_space.new_product.setBackground(Color.decode("#2F5597"));
	    staff_space.labn.setBackground(Color.decode("#2F5597"));
	    staff_space.new_product.change_style("#b39700","#b39700");
	    staff_space.new_product.change_color_background("#2F5597","#2F5597",staff_space.labn);

	       
	    
	    // center page panel
	    int pn1_x = (int) ((140*frame.getWidth())/900);
	    int pn1_y = (int) ((70*frame.getHeight())/600);
	    int pn1_width = (int) ((800*frame.getWidth())/900);
	    int pn1_height = (int) ((580*frame.getHeight())/600);
	    Custom_Panel center_panel = new Custom_Panel(pn1_x,pn1_y,pn1_width,pn1_height,"#FFFFFF");
	    staff_space.space.add(center_panel);
	    
	    
	    
	    
	    // ---- product photo 1
	    
	    
	    // product photo_1 label
	    int lb1_x = (int) ((100*frame.getWidth())/900);
	    int lb1_y = (int) ((10*frame.getHeight())/600);
	    int lb1_width = (int) ((120*frame.getWidth())/900);
	    int lb1_height = (int) ((130*frame.getHeight())/600);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,"",
        "Calibri",7,"#b39700");
        Border border = BorderFactory.createLineBorder(Color.decode("#2F5597"), 3);
        lab1.setBorder(border);
        center_panel.add(lab1);
       
        
        // drop photo 1  button 
	    int bt1_x = (int) ((98*frame.getWidth())/900);
	    int bt1_y = (int) ((50*frame.getHeight())/600);
	    int bt1_width = (int) ((125*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button drop_1 = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Drop a Photo","#000000","Segoe Print",bt1_font_size,false);
        drop_1.change_style("#2F5597","#000000");
        center_panel.add(drop_1);
        
        // drop Button 1 action
        drop_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    
                	selected_file_1 = fileChooser.getSelectedFile();
                	
                	// Read the image file and set it into the Label
                	try {
                        
                         image_1 = ImageIO.read(selected_file_1);
                        lab1.setIcon(new ImageIcon(image_1.getScaledInstance(lab1.getWidth(),
                        lab1.getHeight(), Image.SCALE_SMOOTH)));}
                     
                	catch (Exception ex) {
                        ex.printStackTrace();
                    }}}});
        
        
        

	    
	    
	    
		    
	    
	    
	    // ---- product photo 2
	    
	    

	    // product photo_2 label
	    int lb2_x = (int) ((300*frame.getWidth())/900);
	    int lb2_y = (int) ((10*frame.getHeight())/600);
	    int lb2_width = (int) ((120*frame.getWidth())/900);
	    int lb2_height = (int) ((130*frame.getHeight())/600);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,"",
        "Calibri",7,"#b39700");
        Border border_2 = BorderFactory.createLineBorder(Color.decode("#b39700"), 3);
        lab2.setBorder(border_2);
        center_panel.add(lab2);
        
        
        
        
        // drop photo 2  button 
	    int bt2_x = (int) ((295*frame.getWidth())/900);
	    int bt2_y = (int) ((50*frame.getHeight())/600);
	    int bt2_width = (int) ((125*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button drop_2 = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Drop a Photo","#b39700","Segoe Print",bt2_font_size,false);
        drop_2.change_style("#b39700","#000000");
        center_panel.add(drop_2);
        
        // drop Button 2 action
        drop_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	JFileChooser fileChooser_2 = new JFileChooser();
                int result_2 = fileChooser_2.showOpenDialog(null);
                if (result_2 == JFileChooser.APPROVE_OPTION) {
                    
                	selected_file_2 = fileChooser_2.getSelectedFile();
                	
                	// Read the image file and set it into the Label
                	try {
                        
                        image_2 = ImageIO.read(selected_file_2);
                        lab2.setIcon(new ImageIcon(image_2.getScaledInstance(lab2.getWidth(),
                        lab2.getHeight(), Image.SCALE_SMOOTH)));}
                     
                	catch (Exception ex) {
                        ex.printStackTrace();
                    }}}});
        
        
        
        
        
        
        // ---- product photo 3
	    
	    

	    // product photo_3 label
	    int lb3_x = (int) ((500*frame.getWidth())/900);
	    int lb3_y = (int) ((10*frame.getHeight())/600);
	    int lb3_width = (int) ((120*frame.getWidth())/900);
	    int lb3_height = (int) ((130*frame.getHeight())/600);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,"",
        "Calibri",7,"#b39700");
        Border border_3 = BorderFactory.createLineBorder(Color.decode("#C00000"), 3);
        lab3.setBorder(border_3);
        center_panel.add(lab3);
        
        
        
        
        // drop photo 3  button 
	    int bt3_x = (int) ((495*frame.getWidth())/900);
	    int bt3_y = (int) ((50*frame.getHeight())/600);
	    int bt3_width = (int) ((125*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button drop_3 = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Drop a Photo","#000000","Segoe Print",bt3_font_size,false);
        drop_3.change_style("#C00000","#000000");
        center_panel.add(drop_3);
        
        // drop Button 3 action
        drop_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	JFileChooser fileChooser_3 = new JFileChooser();
                int result_3 = fileChooser_3.showOpenDialog(null);
                if (result_3 == JFileChooser.APPROVE_OPTION) {
                    
                	selected_file_3 = fileChooser_3.getSelectedFile();
                	
                	// Read the image file and set it into the Label
                	try {
                        
                         image_3 = ImageIO.read(selected_file_3);
                         lab3.setIcon(new ImageIcon(image_3.getScaledInstance(lab3.getWidth(),
                         lab3.getHeight(), Image.SCALE_SMOOTH)));}
                     
                	catch (Exception ex) {
                        ex.printStackTrace();
                    }}}});
        
        
        
       
        
        
        
        
        
        
        // handel labels resizing to ensure that the images always fit their containers
	    lab1.addComponentListener(new ComponentAdapter() {

	            @Override
	            public void componentResized(ComponentEvent e) {
	            	
	            	if (!(image_1==null)) {
	            		
	            		lab1.setIcon(new ImageIcon(image_1.getScaledInstance(lab1.getWidth(),
	 		            lab1.getHeight(), Image.SCALE_SMOOTH)));}
	            	
	            	

	            	if (!(image_2==null)) {
	            		
	            		lab2.setIcon(new ImageIcon(image_2.getScaledInstance(lab2.getWidth(),
	 		            lab2.getHeight(), Image.SCALE_SMOOTH)));}	            	

                    if (!(image_3==null)) {
	            		
	            		lab3.setIcon(new ImageIcon(image_3.getScaledInstance(lab3.getWidth(),
	 		            lab3.getHeight(), Image.SCALE_SMOOTH)));}
	            	
	            	
	            	 }});
	    
	    
	    
	    
	    
	    
	    // labels text color
	    String color = "#b39700";
	    
	    
	    // label  - product category
	    int lb4_x = (int) ((70*frame.getWidth())/900);
	    int lb4_y = (int) ((160*frame.getHeight())/600);
	    int lb4_width = (int) ((250*frame.getWidth())/900);
	    int lb4_height = (int) ((30*frame.getHeight())/600);
	    int lb4_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,
        "Product Category","Century Gothic",lb4_font_size,color);
        lab4.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(lab4);
        
  
        
        // product category text field
        int x_m = (int) ((70*frame.getWidth())/900);
	    int y_m = (int) ((195*frame.getHeight())/600);
	    int width_m = (int) ((280*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field product_category = new Custom_Text_Field(x_m,y_m,width_m,height_m,
	    "Segoe Print",font_size_m,"#000000") ; 
	    product_category.setText(" select ...");
        center_panel.add(product_category);
	    
	    
	    // product categories
	    String[] options = {"Heavy Machineries","Manufacturing Materials","Industrial Tools",
	                         "Electronics","Safety Equipments","Softwares"};
	    
	    
	    // a comboBox that holds the product categories 
        int x_c = (int) ((70*frame.getWidth())/900);
	    int y_c = (int) ((218*frame.getHeight())/600);
	    int width_c = (int) ((280*frame.getWidth())/900);
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
	    
	    
	    
	    
	    
        
        
        
        
        
        
        
        // label  - product name
	    int lb5_x = (int) ((70*frame.getWidth())/900);
	    int lb5_y = (int) ((280*frame.getHeight())/600);
	    int lb5_width = (int) ((250*frame.getWidth())/900);
	    int lb5_height = (int) ((30*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,
        "Product Name","Century Gothic",lb5_font_size,color);
        lab5.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(lab5);
        
        
        // product name text field
        int x_n = (int) ((70*frame.getWidth())/900);
	    int y_n = (int) ((310*frame.getHeight())/600);
	    int width_n = (int) ((580*frame.getWidth())/900);
	    int height_n = (int) ((23*frame.getHeight())/600);
	    int font_size_n = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field product_name = new Custom_Text_Field(x_n,y_n,width_n,height_n,
	    "Segoe Print",font_size_n,"#000000") ; 
	    center_panel.add(product_name);
	    
	    
	    
	    

	    // label  - supplier
	    int lb6_x = (int) ((603*frame.getWidth())/900);
	    int lb6_y = (int) ((160*frame.getHeight())/600);
	    int lb6_width = (int) ((250*frame.getWidth())/900);
	    int lb6_height = (int) ((30*frame.getHeight())/600);
	    int lb6_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,
        "Supplier","Century Gothic",lb6_font_size,color);
        lab6.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(lab6);
        
        
        // product supplier text field
        int x_s = (int) ((370*frame.getWidth())/900);
	    int y_s = (int) ((195*frame.getHeight())/600);
	    int width_s = (int) ((280*frame.getWidth())/900);
	    int height_s = (int) ((23*frame.getHeight())/600);
	    int font_size_s = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field supplier = new Custom_Text_Field(x_s,y_s,width_s,height_s,
	    "Segoe Print",font_size_s,"#000000") ;
	    supplier.setText(" select ...");
	    center_panel.add(supplier);
	    
	    
	    
	    
	    // supplier options
	    String[] supplier_options = {"Volvo Construction Equipment","Bobcat Company",
	                         "Terex Corporation","Vertex Group","Jacobs Engineering Group",
	                         "SOMAGEC","Siemens","Oracle Construction and Engineering"};
	    
	    
	    // a comboBox that holds the product categories 
        int x_0 = (int) ((370*frame.getWidth())/900);
	    int y_0 = (int) ((218*frame.getHeight())/600);
	    int width_0 = (int) ((280*frame.getWidth())/900);
	    int height_0 = (int) ((23*frame.getHeight())/600);
	    int font_size_0 = (int) ((11*frame.getWidth())/900);
        Custom_ComboBox combo_box_supplier = new Custom_ComboBox(x_0,y_0,width_0,height_0,font_size_0,supplier_options);
        center_panel.add(combo_box_supplier);
        combo_box_supplier.setVisible(false);
       
        boolean appears_2 = false;
        
        
        // Add a key listener to the text field to show or hide the comboBox as needed
        supplier.addKeyListener(new KeyAdapter() {
            
        	@Override
            public void keyTyped(KeyEvent e) {
                
            	if (supplier.getText().isEmpty()) {
                    
            		combo_box_supplier.setVisible(false);}
                
            	else { if (appears_2 == false) {
            		combo_box_supplier.setVisible(true);}}}});

        
        // Add a listener to the combo box to update the text field with the selected option
        combo_box_supplier.addActionListener(e -> {
            
        	String selected_option_supplier = (String) combo_box_supplier.getSelectedItem();
            supplier.setText(selected_option_supplier);
            combo_box_supplier.setVisible(false);});
	    
        
        
        
        
        
        // label  - quantity
	    int lb7_x = (int) ((70*frame.getWidth())/900);
	    int lb7_y = (int) ((225*frame.getHeight())/600);
	    int lb7_width = (int) ((250*frame.getWidth())/900);
	    int lb7_height = (int) ((30*frame.getHeight())/600);
	    int lb7_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab7 = new Custom_Label(lb7_x, lb7_y, lb7_width, lb7_height,
        "Quantity","Century Gothic",lb7_font_size,color);
        lab7.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(lab7);
        
        
        // quantity text field
        int x_q = (int) ((70*frame.getWidth())/900);
	    int y_q = (int) ((250*frame.getHeight())/600);
	    int width_q = (int) ((280*frame.getWidth())/900);
	    int height_q = (int) ((23*frame.getHeight())/600);
	    int font_size_q = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field quantity = new Custom_Text_Field(x_q,y_q,width_q,height_q,
	    "Segoe Print",font_size_q,"#000000") ;
	    center_panel.add(quantity);
	    
	    
	    
	    // label  - price
	    int lb8_x = (int) ((623*frame.getWidth())/900);
	    int lb8_y = (int) ((224*frame.getHeight())/600);
	    int lb8_width = (int) ((250*frame.getWidth())/900);
	    int lb8_height = (int) ((30*frame.getHeight())/600);
	    int lb8_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab8 = new Custom_Label(lb8_x, lb8_y, lb8_width, lb8_height,
        "Price","Century Gothic",lb8_font_size,color);
        lab8.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(lab8);
        
        
        // price text field
        int x_p = (int) ((370*frame.getWidth())/900);
	    int y_p = (int) ((250*frame.getHeight())/600);
	    int width_p = (int) ((280*frame.getWidth())/900);
	    int height_p = (int) ((23*frame.getHeight())/600);
	    int font_size_p = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field price = new Custom_Text_Field(x_p,y_p,width_p,height_p,
	    "Segoe Print",font_size_p,"#000000") ;
	    center_panel.add(price);
	    
	    
	    
	    
	    
	    
	    // label  - description
	    int lb9_x = (int) ((70*frame.getWidth())/900);
	    int lb9_y = (int) ((340*frame.getHeight())/600);
	    int lb9_width = (int) ((250*frame.getWidth())/900);
	    int lb9_height = (int) ((30*frame.getHeight())/600);
	    int lb9_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab9 = new Custom_Label(lb9_x, lb9_y, lb9_width, lb9_height,
        "Description","Century Gothic",lb9_font_size,color);
        lab9.setHorizontalAlignment(SwingConstants.LEFT);
        center_panel.add(lab9);
        
        
        // product description text area
        int x_d = (int) ((70*frame.getWidth())/900);
	    int y_d = (int) ((370*frame.getHeight())/600);
	    int width_d = (int) ((580*frame.getWidth())/900);
	    int height_d = (int) ((110*frame.getHeight())/600);
	    int font_size_d = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Area description = new Custom_Text_Area(x_d,y_d,width_d,height_d,
	    "Segoe Print",font_size_d,"#000000") ;
	    center_panel.add(description);
	    
	    
	    
	 
       
	    
	    // --- top bar buttons
	    
	    // add button 
	    int bt4_x = (int) ((250*frame.getWidth())/900);
	    int bt4_y = (int) ((13*frame.getHeight())/600);
	    int bt4_width = (int) ((150*frame.getWidth())/900);
	    int bt4_height = (int) ((40*frame.getHeight())/600);
	    int bt4_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button add = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "Add This Product","#2F5597","Consolas",bt4_font_size,false);
        add.change_style("#0496C7","#2F5597");
        add.add_buttom_border(260, 50, 135,"#0496C7", frame, staff_space.space);
        staff_space.space.add(add);
        
        // add action
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// track the empty fields
            	boolean empty = false;
            	
            	// store all the text_fields that should not be empty
            	Custom_Text_Field [] text_fields = new Custom_Text_Field [4];
            	text_fields[0] = product_category;
            	text_fields[1] = product_name;
            	text_fields[2] = quantity;
            	text_fields[3] = price;
            	
            	for(Custom_Text_Field text_field:text_fields) {
            		
            		if((text_field.getText()).isEmpty()) {
            			// raise a message
                    	Custom_Message message = new Custom_Message(90,140,"Needed Images\\x_icon.png","Empty Field",
                    			                                    "Please fill all fields");
                    	empty = true;
                		break;
            		}}
            	
            	// the selection should be done
            	if((product_category.getText().equals(" select ...")) || (supplier.getText().equals(" select ..."))) {
            		
            		// raise a message
                	Custom_Message message = new Custom_Message(85,140,"Needed Images\\x_icon.png","Selection Not Done",
                			                                    "Please Make a Selection");
                	empty = true;
            	}
            		
                
            	// the descreption text should not be empty
            	if(description.getText().isEmpty()) {
            		
            		// raise a message
                	Custom_Message message = new Custom_Message(42,140,"Needed Images\\x_icon.png","Empty Description",
                			                                    "Please add the Product's Desciption");
                	empty = true;
            	}
            	
            	
            	// the first photo should not be null
            	if(selected_file_1 == null) {
            		empty = true;
            		// raise a message
                	Custom_Message message = new Custom_Message(65,140,"Needed Images\\x_icon.png","Empty Photo",
                            "Please Dropp the first Photo");}
            	
            	
            	// ready for insertion
            	if(empty == false) {
            		
            		// create new product instance with the same entered values
                	String product_Category = product_category.getText();
                	String product_Name = product_name.getText();
                	double Quantity = Double.parseDouble(quantity.getText());
                	double Price = Double.parseDouble(price.getText());
                	File photo_1 = selected_file_1;
                	File photo_2 = selected_file_2;
                	File photo_3 = selected_file_3;
                	String Description = description.getText();
                	String Supplier = supplier.getText();
                	
                	Product new_product = new Product(product_Category,product_Name,Quantity,
                	Price,photo_1,photo_2,photo_3,Description,Supplier);
                	
                	// insert the new product in the table produit
                	new_product.add();
                	
                	// raise a message
                	new Custom_Message(130,140,"Needed Images\\verification_icon.png",
                	"Succussful Insertion","Product Added");
                    
            	}}});

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // cancel button 
	    int bt5_x = (int) ((450*frame.getWidth())/900);
	    int bt5_y = (int) ((13*frame.getHeight())/600);
	    int bt5_width = (int) ((100*frame.getWidth())/900);
	    int bt5_height = (int) ((40*frame.getHeight())/600);
	    int bt5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button cancel = new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "Cancel","#2F5597","Consolas",bt5_font_size,false);
        cancel.change_style("#0496C7","#2F5597");
        cancel.add_buttom_border(470, 50, 60,"#0496C7", frame, staff_space.space);
        staff_space.space.add(cancel);
	    
        
        // cancel action
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// original state of text fields
            	product_category.setText(" select ...");
            	supplier.setText(" select ...");
            	quantity.setText("");
            	price.setText("");
            	product_name.setText("");
            	description.setText("");
            	
            	// original state of images
            	lab1.setIcon(null);
            	lab2.setIcon(null);
            	lab3.setIcon(null);
            	
            	
                    
            	}});

        
	    
	    
        
        
        
        
        
        
        
        
        
        

        
        
        

        
        
        
        
		
	    
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(staff_space.space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(center_panel);
	 
        
        
	    
	}
	

}
