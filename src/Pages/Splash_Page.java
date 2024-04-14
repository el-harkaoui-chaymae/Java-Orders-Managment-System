package Pages;

import Graphical_Interface.Custom_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import javax.swing.SwingUtilities;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Pages.Client_Sign_In_Page;
import Graphical_Interface.Custom_Resizing_Manager;
 

public class Splash_Page  {
 	
	// constructeur
	public Splash_Page(Custom_Frame frame) {
		
		  
		// add new panel
	    Custom_Panel splash = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#D0E6F0");
	    splash.add_background("logo_background.png");

	    
	    // add bar menu panel
	    Custom_Panel bar = new Custom_Panel(0,0,frame.getWidth(),70,"#2F5597");
	    splash.add(bar);
	    
	    
	    // about us button 
        Custom_Button about = new Custom_Button(700,30,100,30,"About Us","#FFFFFF","Consolas",13,false);
        about.change_style("#b39700","#FFFFFF");
        bar.add(about);
        
        
        // services button
        Custom_Button services = new Custom_Button(580,30,100,30,"Services","#FFFFFF","Consolas",13,false);
        services.change_style("#b39700","#FFFFFF");
        bar.add(services);

        
        // client button
        Custom_Button client = new Custom_Button(470,30,85,30,"Client","#FFFFFF","Consolas",13,false);
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
        Custom_Button staff = new Custom_Button(355,30,100,30,"Staff","#FFFFFF","Consolas",13,false);
        staff.change_style("#b39700","#FFFFFF");
        bar.add(staff);
        
        
        // contact us button
        Custom_Button contact = new Custom_Button(115,300,200,40,"Contact Us","#2F5597","Segoe Print",17,false);
        splash.add(contact);
        
 
        // add company logo labal
        Custom_Label lab1 = new Custom_Label(168, 185, 510, 80,"Vertex Group Solutions","Arial",28,"#C00000"); 
        splash.add(lab1);
        
         
        // add slogan label
        Custom_Label lab2 = new Custom_Label(170, 235, 500, 50,"Crafting the Foundations of Tomorrow","Consolas",14,"#b39700");
        splash.add(lab2);
        
        
        
        // add splach page-panel to the frame
        frame.getContentPane().add(splash);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(splash);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(bar); 

		
		
		
	}
	
	
	
}
