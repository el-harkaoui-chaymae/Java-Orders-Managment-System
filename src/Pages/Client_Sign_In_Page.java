package Pages;

import Graphical_Interface.Custom_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;



public class Client_Sign_In_Page {
		
	
	// constructor
	public Client_Sign_In_Page(Custom_Frame frame) {
		
		
		// sign in panel
	    Custom_Panel sign_in = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
	    
	    
	    // left panel
	    int left_panel_width = (int) (frame.getWidth() - (frame.getWidth() / (900.0 / 540.0)));
	    Custom_Panel left_panel = new Custom_Panel(0,0,left_panel_width,frame.getHeight(),"#D0E6F0");
	    left_panel.add_background("sign_in.png");
	    sign_in.add(left_panel);
	    
        
	    // label 1 - unlock
	    int lb1_x = (int) ((36*frame.getWidth())/900);
	    int lb1_y = (int) ((123*frame.getHeight())/600);
	    int lb1_width = (int) ((510*frame.getWidth())/900);
	    int lb1_height = (int) ((80*frame.getHeight())/600);
	    int lb1_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,"Unlock Boundless Possibilities",
        "Arial Rounded MT Bold",lb1_font_size,"#2F5597"); 
        left_panel.add(lab1);
        
        
        // label 2 - don't have an account
        int lb2_x = (int) ((36*frame.getWidth())/900);
	    int lb2_y = (int) ((163*frame.getHeight())/600);
	    int lb2_width = (int) ((510*frame.getWidth())/900);
	    int lb2_height = (int) ((50*frame.getHeight())/600);
	    int lb2_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,"Join Our Clients",
        "Segoe Print",lb2_font_size,"#2F5597"); 
        left_panel.add(lab2);
	    
 
        // label 3 - user icon
	    int lb3_x = (int) ((570*frame.getWidth())/900);
	    int lb3_y = (int) ((50*frame.getHeight())/600);
	    int lb3_width = (int) ((80*frame.getWidth())/900);
	    int lb3_height = (int) ((100*frame.getHeight())/600);
	    int lb3_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,null,null,lb3_font_size,"#FFFFFF");
	    lab3.add_background("sign_in_user.png");
        sign_in.add(lab3);
        
        
        // label 4 - welcome back
	    int lb4_x = (int) ((555*frame.getWidth())/900);
	    int lb4_y = (int) ((120*frame.getHeight())/600);
	    int lb4_width = (int) ((200*frame.getWidth())/900);
	    int lb4_height = (int) ((100*frame.getHeight())/600);
	    int lb4_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,
        "welcome back","Segoe Print",lb4_font_size,"#C00000");
        sign_in.add(lab4);
        
        
        
        
        // label 5 - enter your E-mail Adress
	    int lb5_x = (int) ((494*frame.getWidth())/900);
	    int lb5_y = (int) ((175*frame.getHeight())/600);
	    int lb5_width = (int) ((200*frame.getWidth())/900);
	    int lb5_height = (int) ((100*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,
        "E-mail Adress","Century Gothic",lb5_font_size,"#b39700");
        lab5.setHorizontalAlignment(SwingConstants.LEFT);
        sign_in.add(lab5);
        
  
        // email adress text field
        int x_m = (int) ((494*frame.getWidth())/900);
	    int y_m = (int) ((240*frame.getHeight())/600);
	    int width_m = (int) ((250*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field mail = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Calibri",font_size_m,"#000000") ; 
        sign_in.add(mail);
        
        
        
        
        // label 6 - enter your password
	    int lb6_x = (int) ((494*frame.getWidth())/900);
	    int lb6_y = (int) ((225*frame.getHeight())/600);
	    int lb6_width = (int) ((200*frame.getWidth())/900);
	    int lb6_height = (int) ((100*frame.getHeight())/600);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,
        "Password","Century Gothic",lb5_font_size,"#b39700");
        lab6.setHorizontalAlignment(SwingConstants.LEFT);
        sign_in.add(lab6);
        
  
        // password text field
        int x_p = (int) ((494*frame.getWidth())/900);
	    int y_p = (int) ((290*frame.getHeight())/600);
	    int width_p = (int) ((250*frame.getWidth())/900);
	    int height_p = (int) ((23*frame.getHeight())/600);
	    int font_size_p = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field password = new Custom_Text_Field(x_p,y_p,width_p,height_p,"Calibri",font_size_p,"#000000") ; 
        sign_in.add(password);
        
        
        // log in button
        int bt1_x = (int) ((494*frame.getWidth())/900);
	    int bt1_y = (int) ((335*frame.getHeight())/600);
	    int bt1_width = (int) ((250*frame.getWidth())/900);
	    int bt1_height = (int) ((30*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button log_in = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,"Log In",
        "#FFFFFF","Consolas",bt1_font_size,true);
        log_in.setRound_shape_variables(35, 35);
        sign_in.add(log_in);
        

        
        
        // reset password button
        int bt2_x = (int) ((485*frame.getWidth())/900);
	    int bt2_y = (int) ((375*frame.getHeight())/600);
	    int bt2_width = (int) ((120*frame.getWidth())/900);
	    int bt2_height = (int) ((25*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button reset = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,"Reset Password ?",
        "#4370FF","Calibri",bt2_font_size,false);
        reset.change_style("#b39700", "#4370FF");
        sign_in.add(reset);
        
       
        
        
        // label 8 - or connect with
	    int lb8_x = (int) ((576*frame.getWidth())/900);
	    int lb8_y = (int) ((400*frame.getHeight())/600);
	    int lb8_width = (int) ((125*frame.getWidth())/900);
	    int lb8_height = (int) ((100*frame.getHeight())/600);
	    int lb8_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab8 = new Custom_Label(lb8_x, lb8_y, lb8_width, lb8_height,
        "or connect with","Calibri",lb8_font_size,"#808080");
        sign_in.add(lab8);
        
        
        // label 9 - --------
	    int lb9_x = (int) ((494*frame.getWidth())/900);
	    int lb9_y = (int) ((420*frame.getHeight())/600);
	    int lb9_width = (int) ((65*frame.getWidth())/900);
	    int lb9_height = (int) ((30*frame.getHeight())/600);
	    int lb9_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab9 = new Custom_Label(lb9_x, lb9_y, lb9_width, lb9_height,
        "","Calibri",lb9_font_size,"#808080");
        lab9.create_buttom_border(2, "#808080");
        sign_in.add(lab9);
        
        
        // label 10 - --------
	    int lb10_x = (int) ((665*frame.getWidth())/900);
	    int lb10_y = (int) ((420*frame.getHeight())/600);
	    int lb10_width = (int) ((75*frame.getWidth())/900);
	    int lb10_height = (int) ((30*frame.getHeight())/600);
	    int lb10_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab10 = new Custom_Label(lb10_x, lb10_y, lb10_width, lb10_height,
        "","Calibri",lb10_font_size,"#808080");
        lab10.create_buttom_border(2, "#808080");
        sign_in.add(lab10);
        
       
        
   
        // label 11 - linkedIn icon
	    int lb11_x = (int) ((560*frame.getWidth())/900);
	    int lb11_y = (int) ((470*frame.getHeight())/600);
	    int lb11_width = (int) ((26*frame.getWidth())/900);
	    int lb11_height = (int) ((30*frame.getHeight())/600);
	    int lb11_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab11 = new Custom_Label(lb11_x, lb11_y, lb11_width, lb11_height,
        "","Calibri",lb11_font_size,"#000000");
        lab11.add_background("linkedin.png");
        sign_in.add(lab11);
        
 
        // label 12 - google icon
	    int lb12_x = (int) ((600*frame.getWidth())/900);
	    int lb12_y = (int) ((470*frame.getHeight())/600);
	    int lb12_width = (int) ((23*frame.getWidth())/900);
	    int lb12_height = (int) ((30*frame.getHeight())/600);
	    int lb12_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab12 = new Custom_Label(lb12_x, lb12_y, lb12_width, lb12_height,
        "","Calibri",lb12_font_size,"#000000");
        lab12.add_background("google.png");
        sign_in.add(lab12);
        
        
        
        // label 13 - facebook icon
	    int lb13_x = (int) ((645*frame.getWidth())/900);
	    int lb13_y = (int) ((476*frame.getHeight())/600);
	    int lb13_width = (int) ((13*frame.getWidth())/900);
	    int lb13_height = (int) ((18*frame.getHeight())/600);
	    int lb13_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab13 = new Custom_Label(lb13_x, lb13_y, lb13_width, lb13_height,
        "","Calibri",lb13_font_size,"#000000");
        lab13.add_background("facebook.png");
        sign_in.add(lab13);
       
         
        
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
        
        
        // sign up button
        int bt3_x = (int) ((625*frame.getWidth())/900);
	    int bt3_y = (int) ((375*frame.getHeight())/600);
	    int bt3_width = (int) ((130*frame.getWidth())/900);
	    int bt3_height = (int) ((25*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button sign_up = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,"Create an account ?",
        "#4370FF","Calibri",bt3_font_size,false);
        sign_up.change_style("#b39700", "#4370FF");
        sign_in.add(sign_up);
        
        
        
        // return button and its action 
        int panel_original_width = 360;
	    int panel_original_height = 600;
	    left_panel.add_return_button(25, 35, 33, 25, panel_original_width, panel_original_height).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove client sign in page
              frame.getContentPane().removeAll();    
              // create an instance splash page 
              Splash_Page previous_page = new Splash_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
        
       
	    
	    // add sign_up page to the frame
        frame.getContentPane().add(sign_in);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(sign_in);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(left_panel);

        
	
	}

}
