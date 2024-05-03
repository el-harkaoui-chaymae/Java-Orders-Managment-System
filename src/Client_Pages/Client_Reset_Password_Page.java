package Client_Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;

public class Client_Reset_Password_Page {

	// constructor
	public Client_Reset_Password_Page(Custom_Frame frame) {

		// reset password panel
		Custom_Panel reset_password = new Custom_Panel(0, 0, frame.getWidth(), frame.getHeight(),"#FFFFFF");

		// create left panel and its components
		Client_Sign content = new Client_Sign(frame, reset_password);

		// set an user icon
		content.add_user_icon(frame, reset_password, 570, 50, 80, 100);

		// add a welcoming expression - welcome back
		content.add_welcome_expression(frame, reset_password, 555, 120, 200, 100, 16, "welcome back");
		
		
		
		// label 1 - enter your new password
	    int lb1_x = (int) ((494*frame.getWidth())/900);
	    int lb1_y = (int) ((195*frame.getHeight())/600);
	    int lb1_width = (int) ((250*frame.getWidth())/900);
	    int lb1_height = (int) ((100*frame.getHeight())/600);
	    int lb1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,
        "New Password","Century Gothic",lb1_font_size,"#b39700");
        lab1.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password.add(lab1);
        
        // new password text field
        int x_m = (int) ((494*frame.getWidth())/900);
	    int y_m = (int) ((260*frame.getHeight())/600);
	    int width_m = (int) ((250*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
        Custom_Text_Field password = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Calibri",font_size_m,"#000000") ; 
        reset_password.add(password);
        
        
        
        
        // label 2 - confirm your new password
	    int lb2_x = (int) ((494*frame.getWidth())/900);
	    int lb2_y = (int) ((255*frame.getHeight())/600);
	    int lb2_width = (int) ((250*frame.getWidth())/900);
	    int lb2_height = (int) ((100*frame.getHeight())/600);
	    int lb2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,
        "Confirm Password","Century Gothic",lb2_font_size,"#b39700");
        lab2.setHorizontalAlignment(SwingConstants.LEFT);
        reset_password.add(lab2);
        
        // new password text field
        int x_p = (int) ((494*frame.getWidth())/900);
	    int y_p = (int) ((320*frame.getHeight())/600);
	    int width_p = (int) ((250*frame.getWidth())/900);
	    int height_p = (int) ((23*frame.getHeight())/600);
	    int font_size_p = (int) ((11*frame.getWidth())/900);
        Custom_Text_Field Confirmed_password = new Custom_Text_Field(x_p,y_p,width_p,height_p,"Calibri",font_size_p,"#000000") ; 
        reset_password.add(Confirmed_password);
        
        
        
        // reset button
	    int bt1_x = (int) ((494*frame.getWidth())/900);
	    int bt1_y = (int) ((380*frame.getHeight())/600);
	    int bt1_width = (int) ((250*frame.getWidth())/900);
	    int bt1_height = (int) ((30*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button reset = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,"Reset",
        "#FFFFFF","Consolas",bt1_font_size,true);
        reset.setRound_shape_variables(35, 35);
        reset_password.add(reset);
        // reset action
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
              // raise a message
              Custom_Message message = new Custom_Message(70,140,"Needed Images\\verification_icon.png","Password","Password reset successfully");	
              // remove reset password page
              frame.getContentPane().removeAll();    
              // create an instance of client sign in  page 
              Client_Sign_In_Page sign_in_page = new Client_Sign_In_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
        
        
        
        
        // return button and its action 
        int panel_original_width = 360;
	    int panel_original_height = 600;
	    content.getLeftPanel().add_return_button(40, 230, 15, 20, panel_original_width, panel_original_height).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove reset password page
              frame.getContentPane().removeAll();    
              // create an instance of client reset password verification page 
              Client_Reset_Password_Verification_Page previous_page = new Client_Reset_Password_Verification_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
		
		
		
		
		
		
		// add reset password  page to the frame
        frame.getContentPane().add(reset_password);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(reset_password);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(content.getLeftPanel());

	}

}
