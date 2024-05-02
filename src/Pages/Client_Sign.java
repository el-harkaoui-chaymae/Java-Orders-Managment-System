package Pages;

import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Frame;


public class Client_Sign {
	
	// attributs
	Custom_Panel left_panel;
	
	// constructor
	public  Client_Sign(Custom_Frame frame,Custom_Panel panel) {
		 
		
	    
	    
	    // left panel
	    int left_panel_width = (int) (frame.getWidth() - (frame.getWidth() / (900.0 / 540.0)));
	    left_panel = new Custom_Panel(0,0,left_panel_width,frame.getHeight(),"#D0E6F0");
	    left_panel.add_background("Needed Images\\sign.png");
	    panel.add(left_panel);
	    
	    
	    
	    
	    
        
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
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,"Join Our Clients",
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
        
        
        
        
        
        
        
        
        
		
		
	}
	
	
	// a getter 
	public Custom_Panel getLeftPanel() {return left_panel;}
	
	
	
	// a method to add a user icon
	public void add_user_icon(Custom_Frame frame,Custom_Panel panel,int x,int y,int width,int height) {
		
		// label 3 - user icon
	    int lb3_x = (int) ((x*frame.getWidth())/900);
	    int lb3_y = (int) ((y*frame.getHeight())/600);
	    int lb3_width = (int) ((width*frame.getWidth())/900);
	    int lb3_height = (int) ((height*frame.getHeight())/600);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,null,null,6,"#FFFFFF");
	    lab3.add_background("Needed Images\\sign_user.png");
        panel.add(lab3);
	}
	
	
	
	
	// a method to add a welcomming expression
	public void add_welcome_expression(Custom_Frame frame,Custom_Panel panel,int x,int y,int width,int height,int font_size,String text) {
		// label 4 - welcome 
	    int lb4_x = (int) ((x*frame.getWidth())/900);
	    int lb4_y = (int) ((y*frame.getHeight())/600);
	    int lb4_width = (int) ((width*frame.getWidth())/900);
	    int lb4_height = (int) ((height*frame.getHeight())/600);
	    int lb4_font_size = (int) ((font_size*frame.getWidth())/900);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,
        text,"Segoe Print",lb4_font_size,"#C00000");
        panel.add(lab4);
	}
	
	
	
	
	
	
	// method to add an other way to connect
	public void add_another_way_to_connect(Custom_Frame frame,Custom_Panel panel,int x,int y,
			                               int width,int height,int font_size,String text) {
		
		// label 8 - or connect with
	    int lb8_x = (int) ((x*frame.getWidth())/900);
	    int lb8_y = (int) ((y*frame.getHeight())/600);
	    int lb8_width = (int) ((width*frame.getWidth())/900);
	    int lb8_height = (int) ((100*frame.getHeight())/600);
	    int lb8_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab8 = new Custom_Label(lb8_x, lb8_y, lb8_width, lb8_height,
        text,"Calibri",lb8_font_size,"#808080");
        panel.add(lab8);
        
        // label 9 - --------
	    int lb9_x = (int) (((x-82)*frame.getWidth())/900);
	    int lb9_y = (int) (((y+20)*frame.getHeight())/600);
	    int lb9_width = (int) (((width-60)*frame.getWidth())/900);
	    int lb9_height = (int) (((height-70)*frame.getHeight())/600);
        Custom_Label lab9 = new Custom_Label(lb9_x, lb9_y, lb9_width, lb9_height,
        "","Calibri",7,"#808080");
        lab9.create_bottom_border(2, "#808080");
        panel.add(lab9);
        
        // label 10 - --------
	    int lb10_x = (int) (((x+89)*frame.getWidth())/900);
	    int lb10_y = (int) (((y+20)*frame.getHeight())/600);
	    int lb10_width = (int) (((width-50)*frame.getWidth())/900);
        Custom_Label lab10 = new Custom_Label(lb10_x, lb10_y, lb10_width, lb9_height,
        "","Calibri",7,"#808080");
        lab10.create_bottom_border(2, "#808080");
        panel.add(lab10);
        
        // label 11 - linkedIn icon
	    int lb11_x = (int) (((x-16)*frame.getWidth())/900);
	    int lb11_y = (int) (((y+70)*frame.getHeight())/600);
	    int lb11_width = (int) (((width-99)*frame.getWidth())/900);
        Custom_Label lab11 = new Custom_Label(lb11_x, lb11_y, lb11_width, lb9_height,
        "","Calibri",7,"#000000");
        lab11.add_background("Needed Images\\linkedin.png");
        panel.add(lab11);
        
        // label 12 - google icon
	    int lb12_x = (int) (((x+24)*frame.getWidth())/900);
	    int lb12_y = (int) (((y+70)*frame.getHeight())/600);
	    int lb12_width = (int) (((width-102)*frame.getWidth())/900);
        Custom_Label lab12 = new Custom_Label(lb12_x, lb12_y, lb12_width, lb9_height,
        "","Calibri",7,"#000000");
        lab12.add_background("Needed Images\\google.png");
        panel.add(lab12);
        
        // label 13 - facebook icon
	    int lb13_x = (int) (((x+69)*frame.getWidth())/900);
	    int lb13_y = (int) (((y+76)*frame.getHeight())/600);
	    int lb13_width = (int) (((width-112)*frame.getWidth())/900);
	    int lb13_height = (int) (((height-82)*frame.getHeight())/600);
        Custom_Label lab13 = new Custom_Label(lb13_x, lb13_y, lb13_width, lb13_height,
        "","Calibri",7,"#000000");
        lab13.add_background("Needed Images\\facebook.png");
        panel.add(lab13);
	}

}
