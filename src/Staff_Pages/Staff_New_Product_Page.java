package Staff_Pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;


public class Staff_New_Product_Page {
	
	Image image;
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
	    
	    
	    
	    
	    
	    
	    
	    // product photo label
	    int lb1_x = (int) ((25*frame.getWidth())/900);
	    int lb1_y = (int) ((25*frame.getHeight())/600);
	    int lb1_width = (int) ((130*frame.getWidth())/900);
	    int lb1_height = (int) ((140*frame.getHeight())/600);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,"",
        "Calibri",7,"#b39700");
        Border border = BorderFactory.createLineBorder(Color.decode("#BCD3E7"), 3);
        lab1.setBorder(border);
        center_panel.add(lab1);
        
        
        
        
        // drop photo  button 
	    int bt1_x = (int) ((28*frame.getWidth())/900);
	    int bt1_y = (int) ((70*frame.getHeight())/600);
	    int bt1_width = (int) ((125*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button drop = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Drop a Photo","#000000","Segoe Print",bt1_font_size,false);
        drop.change_style("#000000","#000000");
        center_panel.add(drop);
        
        // drop Button action
        drop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    
                	File selected_file = fileChooser.getSelectedFile();
                	
                	// Read the image file and set it into the Label
                	try {
                        
                         image = ImageIO.read(selected_file);
                        lab1.setIcon(new ImageIcon(image.getScaledInstance(lab1.getWidth(),
                        		                   lab1.getHeight(), Image.SCALE_SMOOTH)));}
                     catch (Exception ex) {
                        ex.printStackTrace();
                    }}}});
        
        
        
        // handel label resizing to ensure that the image always fits its container
	    lab1.addComponentListener(new ComponentAdapter() {

	            @Override
	            public void componentResized(ComponentEvent e) {
	            	
	            	lab1.setIcon(new ImageIcon(image.getScaledInstance(lab1.getWidth(),
 		                   lab1.getHeight(), Image.SCALE_SMOOTH))); }});

        
        
        

        
        
        
        
		
	    
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(staff_space.space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(center_panel);
	 
        
        
	    
	}
	

}
