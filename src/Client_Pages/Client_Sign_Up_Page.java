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

import Data_Base.Client;

public class Client_Sign_Up_Page {
	

	// constructor
	public Client_Sign_Up_Page(Custom_Frame frame) {
		
		// sign up  panel
	    Custom_Panel sign_up = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
	    
	    
	    // create left panel and its components
	    Client_Sign content = new Client_Sign(frame,sign_up);
	     
	    
	    // set an user icon
	    content.add_user_icon(frame, sign_up, 570, 50, 80, 100);
	    
	    
	    // add a welcoming expression - welcome back
	    content.add_welcome_expression(frame, sign_up, 555, 120, 200, 100, 16, "welcome here");
	     
     
        
	    // label 5 - enter your first name
	    int lb5_x = (int) ((405*frame.getWidth())/900);
	    int lb5_y = (int) ((145*frame.getHeight())/600);
	    int lb5_width = (int) ((200*frame.getWidth())/900);
	    int lb5_height = (int) ((100*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,
        "First Name","Century Gothic",lb5_font_size,"#b39700");
        lab5.setHorizontalAlignment(SwingConstants.LEFT);
        sign_up.add(lab5);
        
        // first_name text field
        int x_f = (int) ((405*frame.getWidth())/900);
	    int y_f = (int) ((210*frame.getHeight())/600);
	    int width_f = (int) ((200*frame.getWidth())/900);
	    int height_f = (int) ((23*frame.getHeight())/600);
	    int font_size_f = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field first_name = new Custom_Text_Field(x_f,y_f,width_f,height_f,"Calibri",font_size_f,"#000000") ; 
        sign_up.add(first_name);
        
        
        
        
        
        
        // label 6 - enter your second name
	    int lb6_x = (int) ((619*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb5_y, lb5_width, lb5_height,
        "Second Name","Century Gothic",lb5_font_size,"#b39700");
        lab6.setHorizontalAlignment(SwingConstants.RIGHT);
        sign_up.add(lab6);
        
        // second_name text field
        int x_s = (int) ((620*frame.getWidth())/900);
	    Custom_Text_Field second_name = new Custom_Text_Field(x_s,y_f,width_f,height_f,"Calibri",font_size_f,"#000000") ; 
        sign_up.add(second_name);
	    
        
        
        
        
        
        // label 7 - enter your city
	    int lb7_y = (int) ((200*frame.getHeight())/600);
        Custom_Label lab7 = new Custom_Label(lb5_x, lb7_y, lb5_width, lb5_height,
        "City","Century Gothic",lb5_font_size,"#b39700");
        lab7.setHorizontalAlignment(SwingConstants.LEFT);
        sign_up.add(lab7);
  
        // city text field
	    int y_c = (int) ((265*frame.getHeight())/600);
	    Custom_Text_Field city = new Custom_Text_Field(x_f,y_c,width_f,height_f,"Calibri",font_size_f,"#000000") ; 
        sign_up.add(city);
        
        
        
        
        
        
        
        // label 8 - enter your adress
	    int lb8_x = (int) ((780*frame.getWidth())/900);
        Custom_Label lab8 = new Custom_Label(lb8_x, lb7_y, lb5_width, lb5_height,
        "Adress","Century Gothic",lb5_font_size,"#b39700");
        lab8.setHorizontalAlignment(SwingConstants.LEFT);
        sign_up.add(lab8);
        
        // adress text field
	    Custom_Text_Field adress = new Custom_Text_Field(x_s,y_c,width_f,height_f,"Calibri",font_size_f,"#000000") ; 
        sign_up.add(adress);
        
        
        
        
        
        
        
        // label 9 - enter your phone number
	    int lb9_y = (int) ((255*frame.getHeight())/600);
        Custom_Label lab9 = new Custom_Label(lb5_x, lb9_y, lb5_width, lb5_height,
        "Phone Number","Century Gothic",lb5_font_size,"#b39700");
        lab9.setHorizontalAlignment(SwingConstants.LEFT);
        sign_up.add(lab9);
  
        // phone number text field
	    int y_n = (int) ((320*frame.getHeight())/600);
	    Custom_Text_Field number = new Custom_Text_Field(x_f,y_n,width_f,height_f,"Calibri",font_size_f,"#000000") ; 
        sign_up.add(number);
	   
        
        
        
        
        // label 10 - enter your email
	    int lb10_x = (int) ((618*frame.getWidth())/900);
        Custom_Label lab10 = new Custom_Label(lb10_x, lb9_y, lb5_width, lb5_height,
        "E-mail Adress","Century Gothic",lb5_font_size,"#b39700");
        lab10.setHorizontalAlignment(SwingConstants.RIGHT);
        sign_up.add(lab10);
        
        // adress text field
	    Custom_Text_Field mail = new Custom_Text_Field(x_s,y_n,width_f,height_f,"Calibri",font_size_f,"#000000") ; 
        sign_up.add(mail);
        
        
        
        
        
        // label 11 - set your password
	    int lb11_y = (int) ((310*frame.getHeight())/600);
        Custom_Label lab11 = new Custom_Label(lb5_x, lb11_y, lb5_width, lb5_height,
        "Password","Century Gothic",lb5_font_size,"#b39700");
        lab11.setHorizontalAlignment(SwingConstants.LEFT);
        sign_up.add(lab11);
  
        // password text field
	    int y_p = (int) ((375*frame.getHeight())/600);
	    Custom_Text_Field password = new Custom_Text_Field(x_f,y_p,width_f,height_f,"Calibri",font_size_f,"#000000") ; 
        sign_up.add(password);
        
        
        
        // label 12 - confirm your password
	    int lb12_x = (int) ((618*frame.getWidth())/900);
        Custom_Label lab12 = new Custom_Label(lb12_x, lb11_y, lb5_width, lb5_height,
        "Confirm Password","Century Gothic",lb5_font_size,"#b39700");
        lab12.setHorizontalAlignment(SwingConstants.RIGHT);
        sign_up.add(lab12);
        
        // confirmed password text field
	    Custom_Text_Field confirmed_password = new Custom_Text_Field(x_s,y_p,width_f,height_f,"Calibri",font_size_f,"#000000") ; 
        sign_up.add(confirmed_password);

        
        
        
        // sign up button
        int bt1_x = (int) ((485*frame.getWidth())/900);
	    int bt1_y = (int) ((420*frame.getHeight())/600);
	    int bt1_width = (int) ((250*frame.getWidth())/900);
	    int bt1_height = (int) ((30*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button sign_up_btn = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,"Sign Up",
        "#FFFFFF","Consolas",bt1_font_size,true);
        sign_up_btn.setRound_shape_variables(35, 35);
        sign_up.add(sign_up_btn);
        
        // sign up btn action
        sign_up_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// store all text fields 
            	Custom_Text_Field [] text_filds = {first_name,second_name,city,adress,number,mail,password};
            	
            	// get entered details
            	String firstName = text_filds[0].getText();
            	String secondName = text_filds[1].getText();
            	String City = text_filds[2].getText();
            	String Adress = text_filds[3].getText();
            	String phoneNumber = text_filds[4].getText();
            	String Mail = text_filds[5].getText();
            	String Password = text_filds[6].getText();
            	
            	// create an instance of client 
            	Client new_client = new Client(firstName,secondName,City,Adress,phoneNumber,Mail,Password);
            	
            	// check if this new visitor is already a client - member
            	if(new_client.check_existance(1) == false) {
            		
            		// chech for empty text fields
            		boolean empty = false;
            		for(Custom_Text_Field  text_field:text_filds) {
            			if ((text_field.getText()).isEmpty()) {
            				// raise a message
                        	Custom_Message message = new Custom_Message(90,140,"Needed Images\\x_icon.png","Empty field",
                        			                                    "Please fill all fields");
                        	empty = true;
                        	break;}}
            			
            		// if all fields are filled
            		if(empty==false) {
            			
            			// check if the entered passwords do match
                		if((password.getText().equals(confirmed_password.getText()))) {
                			
                        	// add the new client to client table
                        	new_client.add();
                        	// raise a message
                    		Custom_Message message = new Custom_Message(65,140,"Needed Images\\verification_icon.png",
                    				                                    "Successful Sign Up",
                    				                                    "Account created - Log in now");
                    		
                    		// remove client sign up page - take the client back to log in
                            frame.getContentPane().removeAll();    
                            // create an instance of sign in page 
                            Client_Sign_In_Page sign_in = new Client_Sign_In_Page (frame);                       
                            // refresh the window
                            frame.revalidate();
                            frame.repaint();}
                    		
                		else {
                    		// raise a message
                        	Custom_Message message = new Custom_Message(90,140,"Needed Images\\x_icon.png","Password Error",
                        			                                    "Passwords do not match");}
                	
            		}}	
         
            	else {
            		
            		// remove the reference to the client object
            		new_client = null;
            		// raise a message
            		Custom_Message message = new Custom_Message(10,140,"Needed Images\\x_icon.png","Membership Error",
                			                                     "You have already an account, please log in");
            	}}});
        
        
        
       
        
        
        // add another method to sign in
        content.add_another_way_to_connect(frame, sign_up, 570, 430, 125, 100, 12," or sign up with");
        
        
        
        
      

        
        // return button and its action 
        int panel_original_width = 360;
	    int panel_original_height = 600;
	    content.getLeftPanel().add_return_button(40, 230, 15, 20, panel_original_width, panel_original_height).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove client sign up page
              frame.getContentPane().removeAll();    
              // create an instance sign in page 
              Client_Sign_In_Page previous_page = new Client_Sign_In_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
	    
	    
	    
	    // add sign_up page to the frame
        frame.getContentPane().add(sign_up);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(sign_up);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(content.getLeftPanel());
		
		
		
		
		
	}

}
