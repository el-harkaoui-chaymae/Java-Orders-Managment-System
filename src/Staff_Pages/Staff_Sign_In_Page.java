package Staff_Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import General_Pages.Splash_Page;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;

public class Staff_Sign_In_Page {
	
	// constructor
	public Staff_Sign_In_Page(Custom_Frame frame) {
		
		
		// page panel
	    Custom_Panel page_panel = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
		
		
		

	    // left panel
	    int left_panel_width = (int) (frame.getWidth() - (frame.getWidth() / (900.0 / 540.0)));
	    Custom_Panel left_panel = new Custom_Panel(0,0,left_panel_width,frame.getHeight(),"#D0E6F0");
	    left_panel.add_background("Needed Images\\sign.png");
	    page_panel.add(left_panel);
	    
	    
	    
	    
	    
        
	    // label 1 - unlock
	    int lb1_x = (int) ((36*frame.getWidth())/900);
	    int lb1_y = (int) ((123*frame.getHeight())/600);
	    int lb1_width = (int) ((510*frame.getWidth())/900);
	    int lb1_height = (int) ((80*frame.getHeight())/600);
	    int lb1_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,"Unlock Boundless Possibilities",
        "Arial Rounded MT Bold",lb1_font_size,"#2F5597"); 
        left_panel.add(lab1);
        
        
        // label 2 - Join us
        int lb2_x = (int) ((36*frame.getWidth())/900);
	    int lb2_y = (int) ((163*frame.getHeight())/600);
	    int lb2_width = (int) ((510*frame.getWidth())/900);
	    int lb2_height = (int) ((50*frame.getHeight())/600);
	    int lb2_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,"Administration Area",
        "Segoe Print",lb2_font_size,"#2F5597"); 
        left_panel.add(lab2);
	    
 
     
         
        
        // label 14 - company logo 
        int lb14_x = (int) ((90*frame.getWidth())/900);
	    int lb14_y = (int) ((51*frame.getHeight())/600);
	    int lb14_width = (int) ((510*frame.getWidth())/900);
	    int lb14_height = (int) ((80*frame.getHeight())/600);
	    int lb14_font_size = (int) ((18*frame.getWidth())/900);
        Custom_Label lab14 = new Custom_Label(lb14_x, lb14_y, lb14_width, lb14_height,
        "Vertex Group Solutions","Arial",lb14_font_size,"#C00000"); 
        left_panel.add(lab14);
        
         
        // label 15 - slogan
        int lb15_x = (int) ((92*frame.getWidth())/900);
	    int lb15_y = (int) ((76*frame.getHeight())/600);
	    int lb15_width = (int) ((510*frame.getWidth())/900);
	    int lb15_height = (int) ((80*frame.getHeight())/600);
	    int lb15_font_size = (int) ((10*frame.getWidth())/900);
        Custom_Label lab15 = new Custom_Label(lb15_x, lb15_y, lb15_width, lb15_height,
        "Crafting the Foundations of Tomorrow","Consolas",lb15_font_size,"#b39700");
        left_panel.add(lab15);
        
        
        
        // label 3 - Home Page
        int lb3_x = (int) ((70*frame.getWidth())/900);
	    int lb3_y = (int) ((217*frame.getHeight())/600);
	    int lb3_width = (int) ((510*frame.getWidth())/900);
	    int lb3_height = (int) ((50*frame.getHeight())/600);
	    int lb3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,"Previous Page",
        "Segoe Print",lb3_font_size,"#2F5597"); 
        left_panel.add(lab3);
        
        // user icon
	    int lb4_x = (int) ((573*frame.getWidth())/900);
	    int lb4_y = (int) ((50*frame.getHeight())/600);
	    int lb4_width = (int) ((80*frame.getWidth())/900);
	    int lb4_height = (int) ((100*frame.getHeight())/600);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,null,null,6,"#FFFFFF");
	    lab4.add_background("Needed Images\\staff_icon.png");
        page_panel.add(lab4);
        
        
        
        // label 4 - administration 
	    int lb5_x = (int) ((530*frame.getWidth())/900);
	    int lb5_y = (int) ((120*frame.getHeight())/600);
	    int lb5_width = (int) ((200*frame.getWidth())/900);
	    int lb5_height = (int) ((100*frame.getHeight())/600);
	    int lb5_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,
        "administration team","Segoe Print",lb5_font_size,"#C00000");
        page_panel.add(lab5);
        
        
        
        
        
        // label 5 - enter the system password
	    int lb6_x = (int) ((494*frame.getWidth())/900);
	    int lb6_y = (int) ((205*frame.getHeight())/600);
	    int lb6_width = (int) ((200*frame.getWidth())/900);
	    int lb6_height = (int) ((100*frame.getHeight())/600);
	    int lb6_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,
        "System Password","Century Gothic",lb6_font_size,"#b39700");
        lab5.setHorizontalAlignment(SwingConstants.LEFT);
        page_panel.add(lab6);
        
        // password text field
        int x_m = (int) ((494*frame.getWidth())/900);
	    int y_m = (int) ((270*frame.getHeight())/600);
	    int width_m = (int) ((250*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field password = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Calibri",font_size_m,"#000000") ; 
	    page_panel.add(password);
	    
	    
	    
	    
	    // enter button
        int bt1_x = (int) ((494*frame.getWidth())/900);
	    int bt1_y = (int) ((325*frame.getHeight())/600);
	    int bt1_width = (int) ((250*frame.getWidth())/900);
	    int bt1_height = (int) ((30*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button enter = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,"Enter",
        "#FFFFFF","Consolas",bt1_font_size,true);
        enter.setRound_shape_variables(35, 35);
        page_panel.add(enter);
        
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove staff sign in  page
              frame.getContentPane().removeAll();    
              // create an instance staff space  page 
              Staff_Space_Page staff_page = new Staff_Space_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
        
        // return button and its action 
        int panel_original_width = 360;
	    int panel_original_height = 600;
	    left_panel.add_return_button(40, 230, 15, 20, panel_original_width, panel_original_height).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove staff sign in page
              frame.getContentPane().removeAll();    
              // create an instance splash page 
              Splash_Page previous_page = new Splash_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
        
        
        // add page-panel to the frame 
        frame.getContentPane().add(page_panel);
        
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(page_panel);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(left_panel);

        
        
		
		
		
	}

}
