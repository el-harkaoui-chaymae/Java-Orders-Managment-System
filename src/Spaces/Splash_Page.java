package Spaces;

import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;


public class Splash_Page  {
	
	// constructeur
	public Splash_Page(Custom_Frame frame) {
		
		
		// add new panel
	    Custom_Panel splash = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#D0E6F0");
	    splash.add_background("logo_background.png");
	    
	    // add bar menu panel
	    Custom_Panel bar = new Custom_Panel(0,0,frame.getWidth(),100,"#19566B");
	    splash.add(bar);
	    
	    
	    // about us button
        Custom_Button about = new Custom_Button(1200,40,150,40,"About Us",23,false);
        about.change_style();
        bar.add(about);
        
        
        // services button
        Custom_Button services = new Custom_Button(1000,40,150,40,"Services",23,false);
        services.change_style();
        bar.add(services);

        
        // client button
        Custom_Button client = new Custom_Button(800,40,150,40,"Client",23,false);
        client.change_style();
        bar.add(client);
        
        
        // staff button
        Custom_Button staff = new Custom_Button(600,40,150,40,"Staff",23,false);
        staff.change_style();
        bar.add(staff);
        
        
        // contact us button
        Custom_Button contact = new Custom_Button(250,500,170,40,"Contact Us",23,true);
        splash.add(contact);
		
        

        // add company logo labal
        Custom_Label lab1 = new Custom_Label(250, 285, 510, 80,"Vertex Group Solutions","Arial",45,"#b39700"); 
        lab1.create_buttom_border(4, "#19566B");
        splash.add(lab1);
        
        
        // add slogan label
        Custom_Label lab2 = new Custom_Label(290, 365, 500, 50,"Crafting the Foundations of Tomorrow","Consolas",22,"#19566B");
        splash.add(lab2);
        
        // add splach page-panel to the frame
        frame.getContentPane().add(splash);
		
		
		
	}
	
	
	
}
