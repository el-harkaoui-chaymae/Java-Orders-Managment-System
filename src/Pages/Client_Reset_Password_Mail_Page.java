package Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.SwingConstants;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;
import Graphical_Interface.Custom_Message;

import Pages.Client_Reset_Password_Verification_Page;



public class Client_Reset_Password_Mail_Page {
	

	// constructor
	public  Client_Reset_Password_Mail_Page(Custom_Frame frame) {
		
		
		// reset_password_mail  panel
	    Custom_Panel reset_password_mail = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
	    
	    
	    // create left panel and its components
	    Client_Sign content = new Client_Sign(frame,reset_password_mail);
	     
	    
	    // set an user icon
	    content.add_user_icon(frame, reset_password_mail, 570, 50, 80, 100);
	    
	    
	    // add a welcoming expression - welcome back
	    content.add_welcome_expression(frame, reset_password_mail, 555, 120, 200, 100, 16, "welcome back");
	    
	    
	    
	    // label 5 - enter your E-mail Adress
	    int lb5_x = (int) ((494*frame.getWidth())/900);
	    int lb5_y = (int) ((195*frame.getHeight())/600);
	    int lb5_width = (int) ((250*frame.getWidth())/900);
	    int lb5_height = (int) ((100*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,
        "E-mail Adress","Century Gothic",lb5_font_size,"#b39700");
        lab5.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password_mail.add(lab5);
        
        // email adress text field
        int x_m = (int) ((494*frame.getWidth())/900);
	    int y_m = (int) ((260*frame.getHeight())/600);
	    int width_m = (int) ((250*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
        Custom_Text_Field mail = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Calibri",font_size_m,"#000000") ; 
	    reset_password_mail.add(mail);
	    
	    
	    
	    

        // send button
	    int bt1_x = (int) ((494*frame.getWidth())/900);
	    int bt1_y = (int) ((320*frame.getHeight())/600);
	    int bt1_width = (int) ((250*frame.getWidth())/900);
	    int bt1_height = (int) ((30*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button send = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,"Send",
        "#FFFFFF","Consolas",bt1_font_size,true);
        send.setRound_shape_variables(35, 35);
        reset_password_mail.add(send);
        // send button action
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// raise a message
            	Custom_Message message = new Custom_Message(90,135,"Needed Images\\verification_icon.png","Verification","Verification Code Sent");
            	// remove reset password mail page
                frame.getContentPane().removeAll();    
                // create an instance reset password verification page 
                Client_Reset_Password_Verification_Page next_page = new Client_Reset_Password_Verification_Page (frame);                       
                // refresh the window
                frame.revalidate();
                frame.repaint(); }});
	    
	    
	    
	 
        
        // label 6 - enter your E-mail Adress and
        int lb6_x = (int) ((516*frame.getWidth())/900);
	    int lb6_y = (int) ((330*frame.getHeight())/600);
	    int lb6_width = (int) ((250*frame.getWidth())/900);
	    int lb6_height = (int) ((100*frame.getHeight())/600);
	    int lb6_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,
        "Enter your E-mail Adress and we","Segoe Print",lb6_font_size ,"#000000");
        lab6.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password_mail.add(lab6);
        
        // label 7 - will send you a Verification code
        int lb7_x = (int) ((516*frame.getWidth())/900);
	    int lb7_y = (int) ((350*frame.getHeight())/600);
	    int lb7_width = (int) ((250*frame.getWidth())/900);
	    int lb7_height = (int) ((100*frame.getHeight())/600);
	    int lb7_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab7 = new Custom_Label(lb7_x, lb7_y, lb7_width, lb7_height,
        "Will Send You A Verification Code","Segoe Print",lb7_font_size ,"#000000");
        lab7.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password_mail.add(lab7);
        
        
    
        
        

        
        // return button and its action 
        int panel_original_width = 360;
	    int panel_original_height = 600;
	    content.getLeftPanel().add_return_button(25, 35, 33, 25, panel_original_width, panel_original_height).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove reset password page
              frame.getContentPane().removeAll();    
              // create an instance sign in page 
              Client_Sign_In_Page previous_page = new Client_Sign_In_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
	    
	    
	    
	    
	    
	
		
	    // add reset password mail page to the frame
        frame.getContentPane().add(reset_password_mail);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(reset_password_mail);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(content.getLeftPanel());
		
		
		
		
		
		
	}

}
