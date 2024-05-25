package Client_Pages;

import Graphical_Interface.Custom_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;
import Data_Base.Client;
import General_Pages.Splash_Page;



public class Client_Sign_In_Page {
	
	// attributes
	static String mail;
		
	
	// constructor
	public Client_Sign_In_Page(Custom_Frame frame) {
		
		 
		// sign in  panel
	    Custom_Panel sign_in = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
	    
	    
	    // create the content that would be common between 
	    // sign in - sign up - reset password pages
	    Client_Sign content = new Client_Sign(frame,sign_in);
	    
	    
	    // set an user icon
	    content.add_user_icon(frame, sign_in, 570, 50, 80, 100);
	    
	    
	    // add a welcoming expression - welcome back
	    content.add_welcome_expression(frame, sign_in, 555, 120, 200, 100, 16, "welcome back");
	    
     
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
  
        // action to perform
        log_in.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// get the entered values
            	String Mail = mail.getText();
            	String Password = password.getText();
            	
            	// create a virtual client to check if it is a real client
            	Client virtual_client = new Client(null,null,null,null,null,Mail,Password);
            	
            	// check 
            	if(virtual_client.check_existance(2) == true) {
            		
            		// store the entered mail for future use
            		Client_Sign_In_Page.mail = Mail;
            		// remove client sign in page
                    frame.getContentPane().removeAll();    
                    // open client space 
                    Client_Space_Page client_page = new Client_Space_Page (frame);                       
                    // refresh the window
                    frame.revalidate();
                    frame.repaint();            		
            	}
            	
            	else {
            		// raise a message
            		Custom_Message message = new Custom_Message(50,140,"Needed Images\\x_icon.png","Log in Failure",
                                                                "Invalid Email adress or Password");}
           
               }});
        
        
        
        
        
      
        
        
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
        // action to perform
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove client sign in page
              frame.getContentPane().removeAll();    
              // create an instance reset password page 
              Client_Reset_Password_Mail_Page reset_password_page = new Client_Reset_Password_Mail_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
       
        
        
        // add another method to sign in
        content.add_another_way_to_connect(frame, sign_in, 576, 400, 125, 100, 12,"or connect with");
        
     
        
        
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
        // action to perform
        sign_up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove client sign in page
              frame.getContentPane().removeAll();    
              // create an instance sign up page 
              Client_Sign_Up_Page sign_up_page = new Client_Sign_Up_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
        // return button and its action 
        int panel_original_width = 360;
	    int panel_original_height = 600;
	    content.getLeftPanel().add_return_button(40, 230, 15, 20, panel_original_width, panel_original_height).addActionListener(new ActionListener() {
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
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(content.getLeftPanel());


        
	
	}

}