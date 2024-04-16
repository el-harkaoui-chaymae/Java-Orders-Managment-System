package Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;



public class Client_Reset_Password_Page {
	

	// constructor
	public  Client_Reset_Password_Page(Custom_Frame frame) {
		
		
		// reset_password  panel
	    Custom_Panel reset_password = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
	    
	    
	    // create left panel and its components
	    Client_Sign content = new Client_Sign(frame,reset_password);
	     
	    
	    // set an user icon
	    content.add_user_icon(frame, reset_password, 570, 50, 80, 100);
	    
	    
	    // add a welcoming expression - welcome back
	    content.add_welcome_expression(frame, reset_password, 555, 120, 200, 100, 16, "welcome back");
	    
	    
	    
	    // label 5 - enter your E-mail Adress
	    int lb5_x = (int) ((494*frame.getWidth())/900);
	    int lb5_y = (int) ((175*frame.getHeight())/600);
	    int lb5_width = (int) ((250*frame.getWidth())/900);
	    int lb5_height = (int) ((100*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,
        "E-mail Adress","Century Gothic",lb5_font_size,"#b39700");
        lab5.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password.add(lab5);
        
        // email adress text field
        int x_m = (int) ((494*frame.getWidth())/900);
	    int y_m = (int) ((240*frame.getHeight())/600);
	    int width_m = (int) ((250*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
        Custom_Text_Field mail = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Calibri",font_size_m,"#000000") ; 
	    reset_password.add(mail);
	    
	    
	    
	   
	    
	    // label 8 - enter new password
	    int lb8_x = (int) ((494*frame.getWidth())/900);
	    int lb8_y = (int) ((230*frame.getHeight())/600);
	    int lb8_width = (int) ((250*frame.getWidth())/900);
	    int lb8_height = (int) ((100*frame.getHeight())/600);
	    int lb8_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab8 = new Custom_Label(lb8_x, lb8_y, lb8_width, lb8_height,
        "New Password","Century Gothic",lb8_font_size,"#D0E6F0");
        lab8.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password.add(lab8);
        
        // new password text field
        int x_p = (int) ((494*frame.getWidth())/900);
	    int y_p = (int) ((295*frame.getHeight())/600);
	    int width_p = (int) ((250*frame.getWidth())/900);
	    int height_p = (int) ((23*frame.getHeight())/600);
	    int font_size_p = (int) ((11*frame.getWidth())/900);
        Custom_Text_Field password = new Custom_Text_Field(x_p,y_p,width_p,height_p,"Calibri",font_size_p,"#000000") ; 
        password.setEditable(false);
        password.setBackground(Color.WHITE);
	    reset_password.add(password);
	    
	    
	    
	    
	    
	    
	    // label 9 - enter confirmed password
	    int lb9_x = (int) ((494*frame.getWidth())/900);
	    int lb9_y = (int) ((285*frame.getHeight())/600);
	    int lb9_width = (int) ((250*frame.getWidth())/900);
	    int lb9_height = (int) ((100*frame.getHeight())/600);
	    int lb9_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab9 = new Custom_Label(lb9_x, lb9_y, lb9_width, lb9_height,
        "Confirm Password","Century Gothic",lb9_font_size,"#D0E6F0");
        lab9.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password.add(lab9);
        
        // confirmed password text field
        int x_pc = (int) ((494*frame.getWidth())/900);
	    int y_pc = (int) ((350*frame.getHeight())/600);
	    int width_pc = (int) ((250*frame.getWidth())/900);
	    int height_pc = (int) ((23*frame.getHeight())/600);
	    int font_size_pc = (int) ((11*frame.getWidth())/900);
        Custom_Text_Field confirmed_password = new Custom_Text_Field(x_pc,y_pc,width_pc,height_pc,"Calibri",font_size_pc,"#000000") ; 
        confirmed_password.setEditable(false);
        confirmed_password.setBackground(Color.WHITE);
        reset_password.add(confirmed_password);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    // send button
	    int bt1_x = (int) ((494*frame.getWidth())/900);
	    int bt1_y = (int) ((400*frame.getHeight())/600);
	    int bt1_width = (int) ((250*frame.getWidth())/900);
	    int bt1_height = (int) ((30*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button send = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,"Send",
        "#FFFFFF","Consolas",bt1_font_size,true);
        send.setRound_shape_variables(35, 35);
        reset_password.add(send);
        
        
        
        
        // label 6 - enter your E-mail Adress and
        int lb6_x = (int) ((519*frame.getWidth())/900);
	    int lb6_y = (int) ((410*frame.getHeight())/600);
	    int lb6_width = (int) ((250*frame.getWidth())/900);
	    int lb6_height = (int) ((100*frame.getHeight())/600);
	    int lb6_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,
        "Enter your E-mail Adress and we","Segoe Print",lb6_font_size ,"#000000");
        lab6.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password.add(lab6);
        
        
        
        // label 7 - will send you a Verification code
        int lb7_x = (int) ((519*frame.getWidth())/900);
	    int lb7_y = (int) ((430*frame.getHeight())/600);
	    int lb7_width = (int) ((250*frame.getWidth())/900);
	    int lb7_height = (int) ((100*frame.getHeight())/600);
	    int lb7_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab7 = new Custom_Label(lb7_x, lb7_y, lb7_width, lb7_height,
        "Will Send You A Verification Code","Segoe Print",lb7_font_size ,"#000000");
        lab7.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password.add(lab7);
        
        
        
        
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
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
		
		
	    // add sign_up page to the frame
        frame.getContentPane().add(reset_password);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(reset_password);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(content.getLeftPanel());
		
		
		
		
		
		
	}

}
