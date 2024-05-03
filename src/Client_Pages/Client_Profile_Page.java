package Client_Pages;

import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;

import java.awt.Color;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;

public class Client_Profile_Page {
	
	
	// constructor
	public Client_Profile_Page(Custom_Frame frame) {
		
        
        

		// create the client space elements
		Client_Space client_space = new Client_Space(frame);
		

    	// change button background to show that it's clicked
    	client_space.profile.setBackground(Color.decode("#002F5E"));
    	client_space.profile.change_color_background("#002F5E","#002F5E");
    	client_space.profile.change_style("#b39700","#b39700");
		
		
		// personal information panel
		int pn1_x = (int) ((165*frame.getWidth())/900);
	    int pn1_y = (int) ((100*frame.getHeight())/600);
	    int pn1_width = (int) ((330*frame.getWidth())/900);
	    int pn1_height = (int) ((200*frame.getHeight())/600);
	    Custom_Panel personal_panel = new Custom_Panel(pn1_x,pn1_y,pn1_width,pn1_height,"#FFFFFF");
	    client_space.space.add(personal_panel);
	    
	    
	    // label 1 - personal information
	    int lb1_x = (int) ((10*frame.getWidth())/900);
	    int lb1_y = (int) ((10*frame.getHeight())/600);
	    int lb1_width = (int) ((200*frame.getWidth())/900);
	    int lb1_height = (int) ((30*frame.getHeight())/600);
	    int lb1_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,"Personal Information",
        "Segoe Print",lb1_font_size,"#C00000");
        personal_panel.add(lab1);
        
        // label 2 - first name
	    int lb2_x = (int) ((10*frame.getWidth())/900);
	    int lb2_y = (int) ((55*frame.getHeight())/600);
	    int lb2_width = (int) ((200*frame.getWidth())/900);
	    int lb2_height = (int) ((30*frame.getHeight())/600);
	    int lb2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,"First Name :",
        "Calibri",lb2_font_size,"#b39700");
        personal_panel.add(lab2);
        
        
        // label 3 - second name
	    int lb3_x = (int) ((10*frame.getWidth())/900);
	    int lb3_y = (int) ((85*frame.getHeight())/600);
	    int lb3_width = (int) ((200*frame.getWidth())/900);
	    int lb3_height = (int) ((30*frame.getHeight())/600);
	    int lb3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,"Second Name :",
        "Calibri",lb3_font_size,"#b39700");
        personal_panel.add(lab3);
        
        
        // label 4 - mail
	    int lb4_x = (int) ((10*frame.getWidth())/900);
	    int lb4_y = (int) ((115*frame.getHeight())/600);
	    int lb4_width = (int) ((200*frame.getWidth())/900);
	    int lb4_height = (int) ((30*frame.getHeight())/600);
	    int lb4_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,"Mail Adress :",
        "Calibri",lb4_font_size,"#b39700");
        personal_panel.add(lab4);
        
        
        
        // label 5 - password
	    int lb5_x = (int) ((10*frame.getWidth())/900);
	    int lb5_y = (int) ((145*frame.getHeight())/600);
	    int lb5_width = (int) ((200*frame.getWidth())/900);
	    int lb5_height = (int) ((30*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,"Password :",
        "Calibri",lb5_font_size,"#b39700");
        personal_panel.add(lab5);
        
        
        
        
        // default adress information panel
     	int pn2_x = (int) ((525*frame.getWidth())/900);
     	int pn2_y = (int) ((100*frame.getHeight())/600);
     	int pn2_width = (int) ((330*frame.getWidth())/900);
     	int pn2_height = (int) ((200*frame.getHeight())/600);
     	Custom_Panel adress_panel = new Custom_Panel(pn2_x,pn2_y,pn2_width,pn2_height,"#FFFFFF");
     	client_space.space.add(adress_panel);
     	
        // label 6 - default adress
	    int lb6_x = (int) ((10*frame.getWidth())/900);
	    int lb6_y = (int) ((10*frame.getHeight())/600);
	    int lb6_width = (int) ((200*frame.getWidth())/900);
	    int lb6_height = (int) ((30*frame.getHeight())/600);
	    int lb6_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,"Default Adress",
        "Segoe Print",lb6_font_size,"#C00000");
        adress_panel.add(lab6);
        
        
        // label 7 - phone number
	    int lb7_x = (int) ((10*frame.getWidth())/900);
	    int lb7_y = (int) ((55*frame.getHeight())/600);
	    int lb7_width = (int) ((200*frame.getWidth())/900);
	    int lb7_height = (int) ((30*frame.getHeight())/600);
	    int lb7_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab7 = new Custom_Label(lb7_x, lb7_y, lb7_width, lb7_height,"Phone Number :",
        "Calibri",lb7_font_size,"#b39700");
        adress_panel.add(lab7);
        
        
        // label 8 - city
	    int lb8_x = (int) ((10*frame.getWidth())/900);
	    int lb8_y = (int) ((85*frame.getHeight())/600);
	    int lb8_width = (int) ((200*frame.getWidth())/900);
	    int lb8_height = (int) ((30*frame.getHeight())/600);
	    int lb8_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab8 = new Custom_Label(lb8_x, lb8_y, lb8_width, lb8_height,"City :",
        "Calibri",lb8_font_size,"#b39700");
        adress_panel.add(lab8);
        
        
        // label 9 - adress
	    int lb9_x = (int) ((10*frame.getWidth())/900);
	    int lb9_y = (int) ((115*frame.getHeight())/600);
	    int lb9_width = (int) ((200*frame.getWidth())/900);
	    int lb9_height = (int) ((30*frame.getHeight())/600);
	    int lb9_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab9 = new Custom_Label(lb9_x, lb9_y, lb9_width, lb9_height,"Adress :",
        "Calibri",lb9_font_size,"#b39700");
        adress_panel.add(lab9);
        
        
        
        // additional details panel
     	int pn3_x = (int) ((165*frame.getWidth())/900);
     	int pn3_y = (int) ((330*frame.getHeight())/600);
     	int pn3_width = (int) ((690*frame.getWidth())/900);
     	int pn3_height = (int) ((190*frame.getHeight())/600);
     	Custom_Panel additional_panel = new Custom_Panel(pn3_x,pn3_y,pn3_width,pn3_height,"#FFFFFF");
     	client_space.space.add(additional_panel);
     	
     	
        // label 10 - additional details
	    int lb10_x = (int) ((10*frame.getWidth())/900);
	    int lb10_y = (int) ((10*frame.getHeight())/600);
	    int lb10_width = (int) ((200*frame.getWidth())/900);
	    int lb10_height = (int) ((30*frame.getHeight())/600);
	    int lb10_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab10 = new Custom_Label(lb10_x, lb10_y, lb10_width, lb10_height,"Additional Details",
        "Segoe Print",lb10_font_size,"#C00000");
        additional_panel.add(lab10);
        
        
        
        // label 11 - birth date
	    int lb11_x = (int) ((10*frame.getWidth())/900);
	    int lb11_y = (int) ((55*frame.getHeight())/600);
	    int lb11_width = (int) ((200*frame.getWidth())/900);
	    int lb11_height = (int) ((30*frame.getHeight())/600);
	    int lb11_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab11 = new Custom_Label(lb11_x, lb11_y, lb11_width, lb11_height,"Birth Date :",
        "Calibri",lb11_font_size,"#b39700");
        additional_panel.add(lab11);
        
        
        // label 12 - gender
	    int lb12_x = (int) ((260*frame.getWidth())/900);
	    int lb12_y = (int) ((55*frame.getHeight())/600);
	    int lb12_width = (int) ((200*frame.getWidth())/900);
	    int lb12_height = (int) ((30*frame.getHeight())/600);
	    int lb12_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab12 = new Custom_Label(lb12_x, lb12_y, lb12_width, lb12_height,"Gender :",
        "Calibri",lb12_font_size,"#b39700");
        additional_panel.add(lab12);
        
        
        // label 13 - nationality
	    int lb13_x = (int) ((480*frame.getWidth())/900);
	    int lb13_y = (int) ((55*frame.getHeight())/600);
	    int lb13_width = (int) ((200*frame.getWidth())/900);
	    int lb13_height = (int) ((30*frame.getHeight())/600);
	    int lb13_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab13 = new Custom_Label(lb13_x, lb13_y, lb13_width, lb13_height,"Nationality :",
        "Calibri",lb13_font_size,"#b39700");
        additional_panel.add(lab13);
        
        
        // label 14 - educational level
	    int lb14_x = (int) ((10*frame.getWidth())/900);
	    int lb14_y = (int) ((95*frame.getHeight())/600);
	    int lb14_width = (int) ((200*frame.getWidth())/900);
	    int lb14_height = (int) ((30*frame.getHeight())/600);
	    int lb14_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab14 = new Custom_Label(lb14_x, lb14_y, lb14_width, lb14_height,"Educational Level :",
        "Calibri",lb14_font_size,"#b39700");
        additional_panel.add(lab14);
        
        

        // label 15 - low income
	    int lb15_x = (int) ((260*frame.getWidth())/900);
	    int lb15_y = (int) ((95*frame.getHeight())/600);
	    int lb15_width = (int) ((200*frame.getWidth())/900);
	    int lb15_height = (int) ((30*frame.getHeight())/600);
	    int lb15_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab15 = new Custom_Label(lb15_x, lb15_y, lb15_width, lb15_height,"Low Income DH :",
        "Calibri",lb15_font_size,"#b39700");
        additional_panel.add(lab15);
        
        
        // label 16 - high income
	    int lb16_x = (int) ((480*frame.getWidth())/900);
	    int lb16_y = (int) ((95*frame.getHeight())/600);
	    int lb16_width = (int) ((200*frame.getWidth())/900);
	    int lb16_height = (int) ((30*frame.getHeight())/600);
	    int lb16_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab16 = new Custom_Label(lb16_x, lb16_y, lb16_width, lb16_height,"Hign Income DH :",
        "Calibri",lb16_font_size,"#b39700");
        additional_panel.add(lab16);
        
        
        // edit button 
	    int bt1_x = (int) ((250*frame.getWidth())/900);
	    int bt1_y = (int) ((11*frame.getHeight())/600);
	    int bt1_width = (int) ((90*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Button edit = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Edit","#000000","Consolas",bt1_font_size,false);
        edit.change_style("#b39700","#000000");
        client_space.space.add(edit);
        
        // label 17 - edit icon
	    int lb17_x = (int) ((250*frame.getWidth())/900);
	    int lb17_y = (int) ((17*frame.getHeight())/600);
	    int lb17_width = (int) ((15*frame.getWidth())/900);
	    int lb17_height = (int) ((20*frame.getHeight())/600);
        Custom_Label lab17 = new Custom_Label(lb17_x, lb17_y, lb17_width, lb17_height,"",
        "Calibri",7,"#b39700");
        lab17.add_background("Needed images\\edit_icon.png");
        client_space.space.add(lab17);
        
        

        // cancel button 
	    int bt2_x = (int) ((400*frame.getWidth())/900);
	    int bt2_y = (int) ((11*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Button cancel = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Cancel","#000000","Consolas",bt2_font_size,false);
        cancel.change_style("#b39700","#000000");
        client_space.space.add(cancel);
        
        // label 18 - cancel icon
	    int lb18_x = (int) ((397*frame.getWidth())/900);
	    int lb18_y = (int) ((18*frame.getHeight())/600);
	    int lb18_width = (int) ((15*frame.getWidth())/900);
	    int lb18_height = (int) ((20*frame.getHeight())/600);
        Custom_Label lab18 = new Custom_Label(lb18_x, lb18_y, lb18_width, lb18_height,"",
        "Calibri",7,"#b39700");
        lab18.add_background("Needed images\\cancel_icon.png");
        client_space.space.add(lab18);
        
        
        
        // save button 
	    int bt3_x = (int) ((547*frame.getWidth())/900);
	    int bt3_y = (int) ((11*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((14*frame.getWidth())/900);
        Custom_Button save = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Save","#000000","Consolas",bt3_font_size,false);
        save.change_style("#b39700","#000000");
        client_space.space.add(save);
        
        // label 19 - save icon
	    int lb19_x = (int) ((550*frame.getWidth())/900);
	    int lb19_y = (int) ((20*frame.getHeight())/600);
	    int lb19_width = (int) ((12*frame.getWidth())/900);
	    int lb19_height = (int) ((15*frame.getHeight())/600);
        Custom_Label lab19 = new Custom_Label(lb19_x, lb19_y, lb19_width, lb19_height,"",
        "Calibri",7,"#b39700");
        lab19.add_background("Needed images\\save_icon.png");
        client_space.space.add(lab19);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	    
	    
	    // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(client_space.space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(personal_panel);
        Custom_Resizing_Manager resize_4 = new Custom_Resizing_Manager(adress_panel);
        Custom_Resizing_Manager resize_5 = new Custom_Resizing_Manager(additional_panel);

		
		
		
		
		
		
		
	}

}
