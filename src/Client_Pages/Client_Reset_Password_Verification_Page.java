package Client_Pages;

import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;


public class Client_Reset_Password_Verification_Page {
	
	// constructor
	public Client_Reset_Password_Verification_Page(Custom_Frame frame) {
		
		
		
		// reset_password_Verification  panel
	    Custom_Panel reset_password_verification = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
	    
	    
	    // create left panel and its components
	    Client_Sign content = new Client_Sign(frame,reset_password_verification);
	     
	    
	    // set an user icon
	    content.add_user_icon(frame, reset_password_verification, 570, 50, 80, 100);
	    
	    
	    // add a welcoming expression - welcome back
	    content.add_welcome_expression(frame, reset_password_verification, 555, 120, 200, 100, 16, "welcome back");
	    
	    
	    // label 1 - enter your verification code
	    int lb1_x = (int) ((494*frame.getWidth())/900); 
	    int lb1_y = (int) ((195*frame.getHeight())/600);
	    int lb1_width = (int) ((250*frame.getWidth())/900);
	    int lb1_height = (int) ((100*frame.getHeight())/600);
	    int lb1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,
        "Verification Code","Century Gothic",lb1_font_size,"#b39700");
        lab1.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password_verification.add(lab1);
        
        // verification text field
        int x_m = (int) ((494*frame.getWidth())/900);
	    int y_m = (int) ((260*frame.getHeight())/600);
	    int width_m = (int) ((250*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
        Custom_Text_Field verification = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Calibri",font_size_m,"#000000") ; 
        reset_password_verification.add(verification);
        
        
        
        // verify button
	    int bt1_x = (int) ((494*frame.getWidth())/900);
	    int bt1_y = (int) ((320*frame.getHeight())/600);
	    int bt1_width = (int) ((250*frame.getWidth())/900);
	    int bt1_height = (int) ((30*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button verify = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,"Verify",
        "#FFFFFF","Consolas",bt1_font_size,true);
        verify.setRound_shape_variables(35, 35);
        reset_password_verification.add(verify);
        // verify button action
        verify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// the verification code is correct
            	if(verification.getText().equals(String.valueOf(Client_Reset_Password_Mail_Page.verification_code))) {
            		
            		// remove reset password verification page
                    frame.getContentPane().removeAll();    
                    // create an instance of reset password  page 
                    new Client_Reset_Password_Page (frame);                       
                    // refresh the window
                    frame.revalidate();
                    frame.repaint();}
            	
            	
            	else {
            		
            		// raise a message
                	new Custom_Message(70,140,"Needed Images\\x_icon.png","Code Error","Verification Code incorrect");}
            	 }});
        
        
        
        // label 2 - code is sent
        int lb2_x = (int) ((536*frame.getWidth())/900);
	    int lb2_y = (int) ((330*frame.getHeight())/600);
	    int lb2_width = (int) ((250*frame.getWidth())/900);
	    int lb2_height = (int) ((100*frame.getHeight())/600);
	    int lb2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,
        "Enter the Code we send you","Consolas",lb2_font_size ,"#000000");
        lab2.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password_verification.add(lab2);
	    
	    
	    
	    
	    
	    
	    
	    // return button and its action 
        int panel_original_width = 360;
	    int panel_original_height = 600;
	    content.getLeftPanel().add_return_button(40, 230, 15, 20, panel_original_width, panel_original_height).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove reset password page
              frame.getContentPane().removeAll();    
              // create an instance of client reset password mail_Page page 
              new Client_Reset_Password_Mail_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
	    
	    
	    
	    
	    // add reset password verification page to the frame
        frame.getContentPane().add(reset_password_verification);
        
        
        // handle resizing
        new Custom_Resizing_Manager(frame);
        new Custom_Resizing_Manager(reset_password_verification);
        new Custom_Resizing_Manager(content.getLeftPanel());
	}

	
	
	
	
	
	
	
	
	
}
