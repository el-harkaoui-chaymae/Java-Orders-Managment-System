package Spaces;
import javax.swing.*;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Label;


import java.awt.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Run{
	
	
	public static void main(String[] args) {
        
		Custom_Frame frame = new Custom_Frame();
        
		// add new panel
        Custom_Panel pn = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#D0E6F0");
        pn.add_background("logo_background.png");
        
        // add bar menu panel
        Custom_Panel pn1 = new Custom_Panel(0,0,frame.getWidth(),100,"#19566B");
        pn.add(pn1);


        
        
        // add button
        Custom_Button bt = new Custom_Button(1000,40,150,40,"company",23,false);
        bt.change_style();
        pn1.add(bt);

        
        // add button
        Custom_Button bt2 = new Custom_Button(1200,40,150,40,"about us",23,false);
        bt2.change_style();
        pn1.add(bt2);

        
        

        // add company logo labal
        Custom_Label lab1 = new Custom_Label(250, 285, 510, 80,"Vertex Group Solutions","Arial",45,"#b39700"); 
        lab1.create_buttom_border(4, "#19566B");
        pn.add(lab1);
        
        
        // add slogan label
        Custom_Label lab2 = new Custom_Label(290, 365, 500, 50,"Crafting the Foundations of Tomorrow","Consolas",22,"#19566B");
        pn.add(lab2);
        
     
       
        // add panel to the frame
        frame.getContentPane().add(pn);
        frame.setVisible(true);
    
	
	
	
	
	}
	
	
}