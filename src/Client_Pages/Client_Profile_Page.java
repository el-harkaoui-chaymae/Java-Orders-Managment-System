package Client_Pages;

import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Text_Field;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Data_Base.Client;

import java.util.ArrayList;

import java.time.LocalDate;


public class Client_Profile_Page {
	
	// attributes 
	boolean saving = false; 
	public static boolean delete;
	
	
	// constructor 
	public Client_Profile_Page(Custom_Frame frame) {
		 
       		
 
		// create the client space elements
		Client_Space client_space = new Client_Space(frame);
		 
		// change profile button background to show that it's clicked
    	client_space.profile.setBackground(Color.decode("#002F5E"));
    	client_space.labp.setBackground(Color.decode("#002F5E"));
    	client_space.profile.change_color_background("#002F5E","#002F5E",client_space.labp);
    	client_space.profile.change_style("#b39700","#b39700");
    	
		
		  
    	
    	// get the client informations
        
        // create a virtual client with the same valid entered mail in the sign in page
        Client client = new Client(null,null,null,null,null,Client_Sign_In_Page.mail,null);
        // use this mail to get client infos
        String[] informations = client.get_informations();
        // retrieve infos 
        String first_Name = informations[0];
        String second_Name = informations[1];
        String City = informations[2];
        String Adress = informations[3];
        String Number = informations[4];
        String Mail = informations[5];
        String Password = informations[6];
        String Birth_date = informations[7];
        String Gender = informations[8];
        String Nationality = informations[9];
        String Education_level = informations[10];
        String Low_income = informations[11];
        String High_income = informations[12];
        

    	
    	
    	
    	
		// personal information panel
		int pn1_x = (int) ((160*frame.getWidth())/900);
	    int pn1_y = (int) ((100*frame.getHeight())/600);
	    int pn1_width = (int) ((330*frame.getWidth())/900);
	    int pn1_height = (int) ((200*frame.getHeight())/600);
	    Custom_Panel personal_panel = new Custom_Panel(pn1_x,pn1_y,pn1_width,pn1_height,"#FFFFFF");
	    Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2F5597")); // Top-left-bottom-right
	    personal_panel.setBorder(border);
	    client_space.space.add(personal_panel);
	    
	    
	    // label 1 - personal information
	    int lb1_x = (int) ((10*frame.getWidth())/900);
	    int lb1_y = (int) ((10*frame.getHeight())/600);
	    int lb1_width = (int) ((200*frame.getWidth())/900);
	    int lb1_height = (int) ((30*frame.getHeight())/600);
	    int lb1_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,"Personal Information",
        "Segoe Print",lb1_font_size,"#2F5597");
        personal_panel.add(lab1);
        
        
        
        
        
        
        // label 2 - first name
	    int lb2_x = (int) ((10*frame.getWidth())/900);
	    int lb2_y = (int) ((65*frame.getHeight())/600);
	    int lb2_width = (int) ((200*frame.getWidth())/900);
	    int lb2_height = (int) ((30*frame.getHeight())/600);
	    int lb2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab2 = new Custom_Label(lb2_x, lb2_y, lb2_width, lb2_height,"First Name :",
        "Calibri",lb2_font_size,"#b39700");
        personal_panel.add(lab2);
        
        
        // first name text field
        int x_f = (int) ((100*frame.getWidth())/900);
	    int y_f = (int) ((68*frame.getHeight())/600);
	    int width_f = (int) ((200*frame.getWidth())/900);
	    int height_f = (int) ((23*frame.getHeight())/600);
	    int font_size_f = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field first_name = new Custom_Text_Field(x_f,y_f,width_f,height_f,"Calibri",font_size_f,"#000000");
	    first_name.setBorder(new EmptyBorder(0, 0, 0, 0));
	    first_name.setText(first_Name);
	    first_name.setEditable(false);
	    first_name.setBackground(Color.WHITE);
	    personal_panel.add(first_name);
        
        
       
	    
	    
	    
	    
	    // label 3 - second name
	    int lb3_x = (int) ((10*frame.getWidth())/900);
	    int lb3_y = (int) ((95*frame.getHeight())/600);
	    int lb3_width = (int) ((200*frame.getWidth())/900);
	    int lb3_height = (int) ((30*frame.getHeight())/600);
	    int lb3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,"Second Name :",
        "Calibri",lb3_font_size,"#b39700");
        personal_panel.add(lab3);
        
        
        // second name text field
        int x_s = (int) ((100*frame.getWidth())/900);
	    int y_s = (int) ((98*frame.getHeight())/600);
	    int width_s = (int) ((200*frame.getWidth())/900);
	    int height_s = (int) ((23*frame.getHeight())/600);
	    int font_size_s = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field second_name = new Custom_Text_Field(x_s,y_s,width_s,height_s,"Calibri",font_size_s,"#000000");
	    second_name.setBorder(new EmptyBorder(0, 0, 0, 0));
	    second_name.setText(second_Name);
	    second_name.setEditable(false);
	    second_name.setBackground(Color.WHITE);
	    personal_panel.add(second_name);
        
        
        
       
	    
	    
	    
	    
	    // label 4 - mail
	    int lb4_x = (int) ((10*frame.getWidth())/900);
	    int lb4_y = (int) ((125*frame.getHeight())/600);
	    int lb4_width = (int) ((200*frame.getWidth())/900);
	    int lb4_height = (int) ((30*frame.getHeight())/600);
	    int lb4_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,"Mail Adress :",
        "Calibri",lb4_font_size,"#b39700");
        personal_panel.add(lab4);
        
        
        // mail adress text field
        int x_m = (int) ((100*frame.getWidth())/900);
	    int y_m = (int) ((128*frame.getHeight())/600);
	    int width_m = (int) ((200*frame.getWidth())/900);
	    int height_m = (int) ((23*frame.getHeight())/600);
	    int font_size_m = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field mail = new Custom_Text_Field(x_m,y_m,width_m,height_m,"Calibri",font_size_m,"#000000");
	    mail.setBorder(new EmptyBorder(0, 0, 0, 0));
	    mail.setText(Mail);
	    mail.setEditable(false);
	    mail.setBackground(Color.WHITE);
	    personal_panel.add(mail);
        
        
        
       
	    
	    
	    
	    // label 5 - password
	    int lb5_x = (int) ((10*frame.getWidth())/900);
	    int lb5_y = (int) ((155*frame.getHeight())/600);
	    int lb5_width = (int) ((200*frame.getWidth())/900);
	    int lb5_height = (int) ((30*frame.getHeight())/600);
	    int lb5_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,"Password :",
        "Calibri",lb5_font_size,"#b39700");
        personal_panel.add(lab5);
        
        
        // password text field
        int x_p = (int) ((100*frame.getWidth())/900);
	    int y_p = (int) ((158*frame.getHeight())/600);
	    int width_p = (int) ((200*frame.getWidth())/900);
	    int height_p = (int) ((23*frame.getHeight())/600);
	    int font_size_p = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field password = new Custom_Text_Field(x_p,y_p,width_p,height_p,"Calibri",font_size_p,"#000000");
	    password.setBorder(new EmptyBorder(0, 0, 0, 0));
	    password.setText(Password);
	    password.setEditable(false);
	    password.setBackground(Color.WHITE);
	    personal_panel.add(password);
        
        
        
        
        
	    
	    
	    
	    // default adress information panel
     	int pn2_x = (int) ((520*frame.getWidth())/900);
     	int pn2_y = (int) ((100*frame.getHeight())/600);
     	int pn2_width = (int) ((330*frame.getWidth())/900);
     	int pn2_height = (int) ((200*frame.getHeight())/600);
     	Custom_Panel adress_panel = new Custom_Panel(pn2_x,pn2_y,pn2_width,pn2_height,"#FFFFFF");
     	adress_panel.setBorder(border);
     	client_space.space.add(adress_panel);
     	
     	
     	// label 6 - default adress
	    int lb6_x = (int) ((10*frame.getWidth())/900);
	    int lb6_y = (int) ((10*frame.getHeight())/600);
	    int lb6_width = (int) ((200*frame.getWidth())/900);
	    int lb6_height = (int) ((30*frame.getHeight())/600);
	    int lb6_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,"Default Adress",
        "Segoe Print",lb6_font_size,"#2F5597");
        adress_panel.add(lab6);
        
        
        
        
        
        
        
        
        
        // label 7 - phone number
	    int lb7_x = (int) ((10*frame.getWidth())/900);
	    int lb7_y = (int) ((65*frame.getHeight())/600);
	    int lb7_width = (int) ((200*frame.getWidth())/900);
	    int lb7_height = (int) ((30*frame.getHeight())/600);
	    int lb7_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab7 = new Custom_Label(lb7_x, lb7_y, lb7_width, lb7_height,"Phone Number :",
        "Calibri",lb7_font_size,"#b39700");
        adress_panel.add(lab7);
        
        // phone number text field
        int x_n = (int) ((110*frame.getWidth())/900);
	    int y_n = (int) ((68*frame.getHeight())/600);
	    int width_n = (int) ((200*frame.getWidth())/900);
	    int height_n = (int) ((23*frame.getHeight())/600);
	    int font_size_n = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field number = new Custom_Text_Field(x_n,y_n,width_n,height_n,"Calibri",font_size_n,"#000000");
	    number.setBorder(new EmptyBorder(0, 0, 0, 0));
	    number.setText(Number);
	    number.setEditable(false);
	    number.setBackground(Color.WHITE);
	    adress_panel.add(number);
        
        
        
	    
	    
	    
	    
	    // label 8 - city
	    int lb8_x = (int) ((10*frame.getWidth())/900);
	    int lb8_y = (int) ((95*frame.getHeight())/600);
	    int lb8_width = (int) ((200*frame.getWidth())/900);
	    int lb8_height = (int) ((30*frame.getHeight())/600);
	    int lb8_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab8 = new Custom_Label(lb8_x, lb8_y, lb8_width, lb8_height,"City :",
        "Calibri",lb8_font_size,"#b39700");
        adress_panel.add(lab8);
        
        // city text field
        int x_c = (int) ((110*frame.getWidth())/900);
	    int y_c = (int) ((98*frame.getHeight())/600);
	    int width_c = (int) ((200*frame.getWidth())/900);
	    int height_c = (int) ((23*frame.getHeight())/600);
	    int font_size_c = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field city = new Custom_Text_Field(x_c,y_c,width_c,height_c,"Calibri",font_size_c,"#000000");
	    city.setBorder(new EmptyBorder(0, 0, 0, 0));
	    city.setText(City);
	    city.setEditable(false);
	    city.setBackground(Color.WHITE);
	    adress_panel.add(city);
        
        
        
	    
	    
	    
	    
	    // label 9 - adress
	    int lb9_x = (int) ((10*frame.getWidth())/900);
	    int lb9_y = (int) ((125*frame.getHeight())/600);
	    int lb9_width = (int) ((200*frame.getWidth())/900);
	    int lb9_height = (int) ((30*frame.getHeight())/600);
	    int lb9_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab9 = new Custom_Label(lb9_x, lb9_y, lb9_width, lb9_height,"Adress :",
        "Calibri",lb9_font_size,"#b39700");
        adress_panel.add(lab9);
        
        
        // adress text field
        int x_a = (int) ((110*frame.getWidth())/900);
	    int y_a = (int) ((128*frame.getHeight())/600);
	    int width_a = (int) ((200*frame.getWidth())/900);
	    int height_a = (int) ((23*frame.getHeight())/600);
	    int font_size_a = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field adress = new Custom_Text_Field(x_a,y_a,width_a,height_a,"Calibri",font_size_a,"#000000");
	    adress.setBorder(new EmptyBorder(0, 0, 0, 0));
	    adress.setText(Adress);
	    adress.setEditable(false);
	    adress.setBackground(Color.WHITE);
	    adress_panel.add(adress);
        
        
        
        
	    
	    
	    
	    
	    // additional details panel
     	int pn3_x = (int) ((160*frame.getWidth())/900);
     	int pn3_y = (int) ((330*frame.getHeight())/600);
     	int pn3_width = (int) ((690*frame.getWidth())/900);
     	int pn3_height = (int) ((190*frame.getHeight())/600);
     	Custom_Panel additional_panel = new Custom_Panel(pn3_x,pn3_y,pn3_width,pn3_height,"#FFFFFF");
     	additional_panel.setBorder(border);
     	client_space.space.add(additional_panel);
     	
     	
        // label 10 - additional details
	    int lb10_x = (int) ((10*frame.getWidth())/900);
	    int lb10_y = (int) ((10*frame.getHeight())/600);
	    int lb10_width = (int) ((200*frame.getWidth())/900);
	    int lb10_height = (int) ((30*frame.getHeight())/600);
	    int lb10_font_size = (int) ((16*frame.getWidth())/900);
        Custom_Label lab10 = new Custom_Label(lb10_x, lb10_y, lb10_width, lb10_height,"Additional Details",
        "Segoe Print",lb10_font_size,"#2F5597");
        additional_panel.add(lab10);
        
        
        
        
        
        
        
        
        // label 11 - birth date
	    int lb11_x = (int) ((10*frame.getWidth())/900);
	    int lb11_y = (int) ((75*frame.getHeight())/600);
	    int lb11_width = (int) ((200*frame.getWidth())/900);
	    int lb11_height = (int) ((30*frame.getHeight())/600);
	    int lb11_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab11 = new Custom_Label(lb11_x, lb11_y, lb11_width, lb11_height,"Birth Date :",
        "Calibri",lb11_font_size,"#b39700");
        additional_panel.add(lab11);
        
        
        // birth date text field
        int x_b = (int) ((120*frame.getWidth())/900);
	    int y_b = (int) ((78*frame.getHeight())/600);
	    int width_b = (int) ((100*frame.getWidth())/900);
	    int height_b = (int) ((23*frame.getHeight())/600);
	    int font_size_b = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field birth_date = new Custom_Text_Field(x_b,y_b,width_b,height_b,"Calibri",font_size_b,"#000000");
	    birth_date.setBorder(new EmptyBorder(0, 0, 0, 0));
	    birth_date.setText(Birth_date);
	    birth_date.setEditable(false);
	    birth_date.setBackground(Color.WHITE);
	    additional_panel.add(birth_date);
        
        
        
	    
	    
	    
	    
	    
	    // label 12 - gender
	    int lb12_x = (int) ((255*frame.getWidth())/900);
	    int lb12_y = (int) ((75*frame.getHeight())/600);
	    int lb12_width = (int) ((200*frame.getWidth())/900);
	    int lb12_height = (int) ((30*frame.getHeight())/600);
	    int lb12_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab12 = new Custom_Label(lb12_x, lb12_y, lb12_width, lb12_height,"Gender :",
        "Calibri",lb12_font_size,"#b39700");
        additional_panel.add(lab12);
        
        
        // gender text field
        int x_g = (int) ((360*frame.getWidth())/900);
	    int y_g = (int) ((78*frame.getHeight())/600);
	    int width_g = (int) ((100*frame.getWidth())/900);
	    int height_g = (int) ((23*frame.getHeight())/600);
	    int font_size_g = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field gender = new Custom_Text_Field(x_g,y_g,width_g,height_g,"Calibri",font_size_g,"#000000");
	    gender.setBorder(new EmptyBorder(0, 0, 0, 0));
	    gender.setText(Gender);
	    gender.setEditable(false);
	    gender.setBackground(Color.WHITE);
	    additional_panel.add(gender);
        
        
       
	    
	    
	    
	    
	    // label 13 - nationality
	    int lb13_x = (int) ((480*frame.getWidth())/900);
	    int lb13_y = (int) ((75*frame.getHeight())/600);
	    int lb13_width = (int) ((200*frame.getWidth())/900);
	    int lb13_height = (int) ((30*frame.getHeight())/600);
	    int lb13_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab13 = new Custom_Label(lb13_x, lb13_y, lb13_width, lb13_height,"Nationality :",
        "Calibri",lb13_font_size,"#b39700");
        additional_panel.add(lab13);
        
        // nationality text field
        int x_t = (int) ((590*frame.getWidth())/900);
	    int y_t = (int) ((78*frame.getHeight())/600);
	    int width_t = (int) ((100*frame.getWidth())/900);
	    int height_t = (int) ((23*frame.getHeight())/600);
	    int font_size_t = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field nationality = new Custom_Text_Field(x_t,y_t,width_t,height_t,"Calibri",font_size_t,"#000000");
	    nationality.setBorder(new EmptyBorder(0, 0, 0, 0));
	    nationality.setText(Nationality);
	    nationality.setEditable(false);
	    nationality.setBackground(Color.WHITE);
	    additional_panel.add(nationality);
        
        
       
	    
	    
	    
	    
	    // label 14 - educational level
	    int lb14_x = (int) ((10*frame.getWidth())/900);
	    int lb14_y = (int) ((115*frame.getHeight())/600);
	    int lb14_width = (int) ((200*frame.getWidth())/900);
	    int lb14_height = (int) ((30*frame.getHeight())/600);
	    int lb14_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab14 = new Custom_Label(lb14_x, lb14_y, lb14_width, lb14_height,"Educational Level :",
        "Calibri",lb14_font_size,"#b39700");
        additional_panel.add(lab14);
         
        // education level text field
        int x_e = (int) ((120*frame.getWidth())/900);
	    int y_e = (int) ((118*frame.getHeight())/600);
	    int width_e = (int) ((100*frame.getWidth())/900);
	    int height_e = (int) ((23*frame.getHeight())/600);
	    int font_size_e = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field education = new Custom_Text_Field(x_e,y_e,width_e,height_e,"Calibri",font_size_e,"#000000");
	    education.setBorder(new EmptyBorder(0, 0, 0, 0));
	    education.setText(Education_level);
	    education.setEditable(false);
	    education.setBackground(Color.WHITE);
	    additional_panel.add(education);
        

       
	    
	    
	    
	    
	    
	    // label 15 - low income
	    int lb15_x = (int) ((255*frame.getWidth())/900);
	    int lb15_y = (int) ((115*frame.getHeight())/600);
	    int lb15_width = (int) ((200*frame.getWidth())/900);
	    int lb15_height = (int) ((30*frame.getHeight())/600);
	    int lb15_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab15 = new Custom_Label(lb15_x, lb15_y, lb15_width, lb15_height,"Low Income DH :",
        "Calibri",lb15_font_size,"#b39700");
        additional_panel.add(lab15);
        
        // low income text field
        int x_l = (int) ((360*frame.getWidth())/900);
	    int y_l = (int) ((118*frame.getHeight())/600);
	    int width_l = (int) ((100*frame.getWidth())/900);
	    int height_l = (int) ((23*frame.getHeight())/600);
	    int font_size_l = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field low_income = new Custom_Text_Field(x_l,y_l,width_l,height_l,"Calibri",font_size_l,"#000000");
	    low_income.setBorder(new EmptyBorder(0, 0, 0, 0));
	    low_income.setText(Low_income);
	    low_income.setEditable(false);
	    low_income.setBackground(Color.WHITE);
	    additional_panel.add(low_income);
        
        
        
	    
	    
	    
	    
	    
	    
	    // label 16 - high income
	    int lb16_x = (int) ((480*frame.getWidth())/900);
	    int lb16_y = (int) ((115*frame.getHeight())/600);
	    int lb16_width = (int) ((200*frame.getWidth())/900);
	    int lb16_height = (int) ((30*frame.getHeight())/600);
	    int lb16_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Label lab16 = new Custom_Label(lb16_x, lb16_y, lb16_width, lb16_height,"Hign Income DH :",
        "Calibri",lb16_font_size,"#b39700");
        additional_panel.add(lab16);
        
        
        // high income text field
        int x_h = (int) ((590*frame.getWidth())/900);
	    int y_h = (int) ((118*frame.getHeight())/600);
	    int width_h = (int) ((100*frame.getWidth())/900);
	    int height_h = (int) ((23*frame.getHeight())/600);
	    int font_size_h = (int) ((11*frame.getWidth())/900);
	    Custom_Text_Field high_income = new Custom_Text_Field(x_h,y_h,width_h,height_h,"Calibri",font_size_h,"#000000");
	    high_income.setBorder(new EmptyBorder(0, 0, 0, 0));
	    high_income.setText(High_income);
	    high_income.setEditable(false);
	    high_income.setBackground(Color.WHITE);
	    additional_panel.add(high_income);
        
        
       
	    
	    
	    
	    
	    
	    // ----  top bar buttons
	    
	    
	    
	    String btn_color = "#0496C7" ;
	    
	    // edit button 
	    int bt1_x = (int) ((170*frame.getWidth())/900);
	    int bt1_y = (int) ((11*frame.getHeight())/600);
	    int bt1_width = (int) ((90*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button edit = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Edit","#2F5597","Consolas",bt1_font_size,false);
        edit.change_style(btn_color,"#2F5597");
        edit.add_buttom_border(190, 50, 47, btn_color, frame, client_space.space);
        client_space.space.add(edit);
        
        String color = "#56AE57";
               
        // action
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// change labels color
                lab2.setForeground(Color.decode(color));
                lab3.setForeground(Color.decode(color));
                lab4.setForeground(Color.decode(color));
                lab5.setForeground(Color.decode(color));
                lab7.setForeground(Color.decode(color));
                lab8.setForeground(Color.decode(color));
                lab9.setForeground(Color.decode(color));
                lab11.setForeground(Color.decode(color));
                lab12.setForeground(Color.decode(color));
                lab13.setForeground(Color.decode(color));
                lab14.setForeground(Color.decode(color));
                lab15.setForeground(Color.decode(color));
                lab16.setForeground(Color.decode(color));
                
                // allow text editting
        	    first_name.setEditable(true);
        	    second_name.setEditable(true);
        	    mail.setEditable(true);
        	    password.setEditable(true);
        	    number.setEditable(true);
        	    city.setEditable(true);
        	    adress.setEditable(true);
        	    birth_date.setEditable(true);
        	    gender.setEditable(true);
        	    nationality.setEditable(true);
        	    education.setEditable(true);
        	    low_income.setEditable(true);
        	    high_income.setEditable(true);


            	           		
            	}});

        
        
        

       
        
        

        
        
        
        
        
        
        
        // cancel button 
	    int bt2_x = (int) ((280*frame.getWidth())/900);
	    int bt2_y = (int) ((11*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button cancel = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Cancel","#2F5597","Consolas",bt2_font_size,false);
        cancel.change_style(btn_color,"#2F5597");
        cancel.add_buttom_border(300, 50, 52, btn_color, frame, client_space.space);
        client_space.space.add(cancel);
        
        String original_color = "#b39700";

        // action
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if (saving == false) {
            		
            		// labels original color
                    lab2.setForeground(Color.decode(original_color));
                    lab3.setForeground(Color.decode(original_color));
                    lab4.setForeground(Color.decode(original_color));
                    lab5.setForeground(Color.decode(original_color));
                    lab7.setForeground(Color.decode(original_color));
                    lab8.setForeground(Color.decode(original_color));
                    lab9.setForeground(Color.decode(original_color));
                    lab11.setForeground(Color.decode(original_color));
                    lab12.setForeground(Color.decode(original_color));
                    lab13.setForeground(Color.decode(original_color));
                    lab14.setForeground(Color.decode(original_color));
                    lab15.setForeground(Color.decode(original_color));
                    lab16.setForeground(Color.decode(original_color));
                    
                    // original text fields values
                    first_name.setText(first_Name);
            	    second_name.setText(second_Name);
            	    mail.setText(Mail);
            	    password.setText(Password);
            	    number.setText(Number);
            	    city.setText(City);
            	    adress.setText(Adress);
            	    
            	    birth_date.setText(Birth_date);
            	    if(Birth_date==null) {birth_date.setText("----");}
            	    
            	    gender.setText(Gender);
            	    if(Gender==null) {gender.setText("----");}
            	    
            	    nationality.setText(Nationality);
            	    if(Nationality==null) {nationality.setText("----");}
            	    
            	    education.setText(Education_level);
            	    if(Education_level==null) {education.setText("----");}
            	    
            	    low_income.setText(Low_income);
            	    if(Low_income==null) {low_income.setText("----");}
            	    
            	    high_income.setText(High_income);
            	    if(High_income==null) {high_income.setText("----");}
                    
                    // forbid text editting
            	    first_name.setEditable(false);
            	    second_name.setEditable(false);
            	    mail.setEditable(false);
            	    password.setEditable(false);
            	    number.setEditable(false);
            	    city.setEditable(false);
            	    adress.setEditable(false);
            	    birth_date.setEditable(false);
            	    gender.setEditable(false);
            	    nationality.setEditable(false);
            	    education.setEditable(false);
            	    low_income.setEditable(false);
            	    high_income.setEditable(false);
            	}
            	           		
            	}});
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        // save button 
	    int bt3_x = (int) ((392*frame.getWidth())/900);
	    int bt3_y = (int) ((11*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button save = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Save","#2F5597","Consolas",bt3_font_size,false);
        save.change_style(btn_color,"#2F5597");
        save.add_buttom_border(413, 50, 47, btn_color, frame, client_space.space);
        client_space.space.add(save);
        
        // action
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// the button save is clicked
            	saving = true;
            	
            	// labels original color
                lab2.setForeground(Color.decode(original_color));
                lab3.setForeground(Color.decode(original_color));
                lab4.setForeground(Color.decode(original_color));
                lab5.setForeground(Color.decode(original_color));
                lab7.setForeground(Color.decode(original_color));
                lab8.setForeground(Color.decode(original_color));
                lab9.setForeground(Color.decode(original_color));
                lab11.setForeground(Color.decode(original_color));
                lab12.setForeground(Color.decode(original_color));
                lab13.setForeground(Color.decode(original_color));
                lab14.setForeground(Color.decode(original_color));
                lab15.setForeground(Color.decode(original_color));
                lab16.setForeground(Color.decode(original_color));
                
                // forbid text editting
        	    first_name.setEditable(false);
        	    second_name.setEditable(false);
        	    mail.setEditable(false);
        	    password.setEditable(false);
        	    number.setEditable(false);
        	    city.setEditable(false);
        	    adress.setEditable(false);
        	    birth_date.setEditable(false);
        	    gender.setEditable(false);
        	    nationality.setEditable(false);
        	    education.setEditable(false);
        	    low_income.setEditable(false);
        	    high_income.setEditable(false);
        	    
        	    // get the new edited values
        	    String new_first_name = first_name.getText();
        	    String new_second_name = second_name.getText();
        	    String new_mail = mail.getText();
        	    String new_password = password.getText();
        	    String new_number = number.getText();
        	    String new_city = city.getText();
        	    String new_adress = adress.getText();
        	    
        	    LocalDate new_birth_date = null;
        	    
        	    if(!(birth_date.getText().equals("----"))) {
        	    	new_birth_date = LocalDate.parse(birth_date.getText());}
    		    
        	    String new_gender = gender.getText();
        	    String new_nationality = nationality.getText();
        	    String new_educational_level = education.getText();
    		    
    		    double new_low_income;
        	    
    		    if(low_income.getText().equals("----")) {
    		    	new_low_income = 0;}	
    		    else { new_low_income = Double.parseDouble(low_income.getText());}
    		    
    		    double new_high_income;
    		    
    		    if(high_income.getText().equals("----")) {
    		    	new_high_income = 0;}	
    		    else { new_high_income = Double.parseDouble(high_income.getText());}
        	    
        	    
        	    // the original client
        	    Client original_client = new Client(null,null,null,null,null,Mail,null);
        	    
        	    // get this client id
        	    int original_client_id = original_client.get_client_id();
        	    
        	    // create a new virtual client with the new edited values and the same original client id
        	    Client edited_client = new Client(new_first_name,new_second_name,new_city,new_adress,new_number,
        	    		                          new_mail,new_password);
        	    // set the virtual client id to the exact value as the original one
        	    edited_client.setClientId(original_client_id);
        	    // set the additional client attributes
        	    edited_client.set_additional_attributes(new_birth_date, new_gender, new_nationality, 
        	    		                                new_educational_level, new_low_income, new_high_income);
        	    
        	    
        	    // update the original client proprities with the new edited virtual client attributes
        	    edited_client.modify();
        	    
        	    
        	   // raise a message
			   new Custom_Message(90, 140, "Needed Images\\verification_icon.png", "Update Done",
						"Your changes are saved");
            	           		
            	}});
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // delete account button 
	    int bt4_x = (int) ((510*frame.getWidth())/900);
	    int bt4_y = (int) ((11*frame.getHeight())/600);
	    int bt4_width = (int) ((125*frame.getWidth())/900);
	    int bt4_height = (int) ((40*frame.getHeight())/600);
	    int bt4_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button delete = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "Delete Account","#2F5597","Consolas",bt4_font_size,false);
        delete.change_style(btn_color,"#2F5597");
        delete.add_buttom_border(517, 50, 112, btn_color, frame, client_space.space);
        client_space.space.add(delete);
        
        // action
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                
 				   // delete the account
 				   client.delete();
 				   
 				   // raise a message
 	               new Custom_Message(90, 140, "Needed Images\\verification_icon.png", 
 	               "Deletion Done","Your account is deleted");
 				   
 	                // remove client profile page 
 	                frame.getContentPane().removeAll();    
 	                
 	            	// open the client sign in page panel
 	                new Client_Sign_In_Page(frame);
 	                // refresh the window
 	                frame.revalidate();
 	                frame.repaint();
 			   }});
        
        
        
        
        
        
        
       
        
        
        
        // set --- as default text for null attributes 
        
        // text fields array
        ArrayList<Custom_Text_Field> text_fields = new ArrayList<>();
        text_fields.add(birth_date);
        text_fields.add(gender);
        text_fields.add(nationality);
        text_fields.add(education);
        text_fields.add(low_income);
        text_fields.add(high_income);
        // attributes array
        ArrayList<String> attributes = new ArrayList<>();
        attributes.add(Birth_date);
        attributes.add(Gender);
        attributes.add(Nationality);
        attributes.add(Education_level);
        attributes.add(Low_income);
        attributes.add(High_income);
        // iterate through the attributes array to look for null values
        for (int i = 0; i < attributes.size(); i++) {
            String value = attributes.get(i);
            if (value == null) {
                text_fields.get(i).setText("----");
            }
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	    
	    
	    // handle resizing
        new Custom_Resizing_Manager(frame);
        new Custom_Resizing_Manager(client_space.space);
        new Custom_Resizing_Manager(personal_panel);
        new Custom_Resizing_Manager(adress_panel);
        new Custom_Resizing_Manager(additional_panel);

		
		
		
		
		
		
		
	}

}
