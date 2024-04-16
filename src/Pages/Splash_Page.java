package Pages;

import Graphical_Interface.Custom_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Resizing_Manager;
 

public class Splash_Page  {
 	
	// constructeur
	public Splash_Page(Custom_Frame frame) {
		
		  
		// add new panel
	    Custom_Panel splash = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#D0E6F0");
	    splash.add_background("logo_background.png");
	    
	    

	    
	   
	    // add bar menu panel 
	    int height = (int) ((70*frame.getHeight())/600);
	    Custom_Panel bar = new Custom_Panel(0,0,frame.getWidth(),height,"#2F5597");
	    splash.add(bar);
	    
	    
	    
	    // about us button 
	    int bt1_x = (int) ((700*frame.getWidth())/900);
	    int bt1_y = (int) ((30*frame.getHeight())/600);
	    int bt1_width = (int) ((100*frame.getWidth())/900);
	    int bt1_height = (int) ((30*frame.getHeight())/600);
	    int bt1_font_size = (int) ((13*frame.getWidth())/900);
        Custom_Button about = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "About Us","#FFFFFF","Consolas",bt1_font_size,false);
        about.change_style("#b39700","#FFFFFF");
        bar.add(about);
        
        
        
        // services button
        int bt2_x = (int) ((580*frame.getWidth())/900);
	    int bt2_width = (int) ((100*frame.getWidth())/900);
        Custom_Button services = new Custom_Button(bt2_x,bt1_y,bt2_width,bt1_height,
        "Services","#FFFFFF","Consolas",bt1_font_size,false);
        services.change_style("#b39700","#FFFFFF");
        bar.add(services);

        
        
        
        // client button
        int bt3_x = (int) ((470*frame.getWidth())/900);
	    int bt3_width = (int) ((85*frame.getWidth())/900);
        Custom_Button client = new Custom_Button(bt3_x,bt1_y,bt3_width,bt1_height,"Client","#FFFFFF","Consolas",bt1_font_size,false);
        client.change_style("#b39700","#FFFFFF");
        bar.add(client);
        
        // action
        client.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// remove the splash page panel from the frame
            	Container contentPane = frame.getContentPane(); 
                contentPane.remove(splash); 
            	// open the sign up page panel
                Client_Sign_In_Page page = new Client_Sign_In_Page(frame);
                // refresh the window
                frame.revalidate();
                frame.repaint();
         	
                }}) ;
                 
            
        
     
       
        // staff button
        int bt4_x = (int) ((355*frame.getWidth())/900);
	    int bt4_width = (int) ((100*frame.getWidth())/900);
        Custom_Button staff = new Custom_Button(bt4_x,bt1_y,bt4_width,bt1_height,"Staff","#FFFFFF","Consolas",bt1_font_size,false);
        staff.change_style("#b39700","#FFFFFF");
        bar.add(staff);
        
        
        
        // contact us button
        int bt5_x = (int) ((115*frame.getWidth())/900);
	    int bt5_y = (int) ((300*frame.getHeight())/600);
	    int bt5_width = (int) ((200*frame.getWidth())/900);
	    int bt5_height = (int) ((40*frame.getHeight())/600);
	    int bt5_font_size = (int) ((17*frame.getWidth())/900);
        Custom_Button contact = new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "Contact Us","#2F5597","Segoe Print",bt5_font_size,false);
        splash.add(contact);
        
 
       
        // add company logo labal
        int lb1_x = (int) ((168*frame.getWidth())/900);
	    int lb1_y = (int) ((185*frame.getHeight())/600);
	    int lb1_width = (int) ((510*frame.getWidth())/900);
	    int lb1_height = (int) ((80*frame.getHeight())/600);
	    int lb1_font_size = (int) ((28*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,
        "Vertex Group Solutions","Arial",lb1_font_size,"#C00000"); 
        splash.add(lab1);
        
         
       
        // add slogan label
        int lb2_x = (int) ((170*frame.getWidth())/900);
	    int lb2_y = (int) ((235*frame.getHeight())/600);
	    int lb2_width = (int) ((510*frame.getWidth())/900);
	    int lb2_height = (int) ((50*frame.getHeight())/600);
	    int lb2_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,
        "Crafting the Foundations of Tomorrow","Consolas",lb2_font_size,"#b39700");
        splash.add(lab2);
        
        
     
        // add splach page-panel to the frame 
        frame.getContentPane().add(splash);
        
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(splash);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(bar); 

		
		
		
	}
	
	
	
}
