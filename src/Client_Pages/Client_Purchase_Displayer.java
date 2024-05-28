package Client_Pages;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;

public class Client_Purchase_Displayer {

	
	
	// constructor
	public Client_Purchase_Displayer(Custom_Frame frame, Custom_Panel center_panel, int x, int y, int width,
			int height) {

		
		
		
		// Purchase information panel - it contains - organizes - displays a purchase
		int pn2_x = (int) ((x * frame.getWidth()) / 900);
		int pn2_y = (int) ((y * frame.getHeight()) / 600);
		int pn2_width = (int) ((width * frame.getWidth()) / 900);
		int pn2_height = (int) ((height * frame.getHeight()) / 600);
		Custom_Panel purchase_displayer = new Custom_Panel(pn2_x, pn2_y, pn2_width, pn2_height, "#FFFFFF");
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#B4B4B4")); // Top-left-bottom-right
		purchase_displayer.setBorder(border);
		center_panel.add(purchase_displayer);
		
		
		
		
		
		
		
		
		
		// label - Purchase 
	    int lp_x = (int) ((20*frame.getWidth())/900);
	    int lp_y = (int) ((15*frame.getHeight())/600);
	    int lp_width = (int) ((100*frame.getWidth())/900);
	    int lp_height = (int) ((25*frame.getHeight())/600);
	    int lp_font_size = (int) ((14*frame.getWidth())/900);
	    Custom_Label lp = new Custom_Label(lp_x, lp_y, lp_width, lp_height,
        "Purchase","Segoe Print",lp_font_size,"#2F5597");
        lp.setHorizontalAlignment(SwingConstants.LEFT);
        purchase_displayer.add(lp);
        
        
        
        // label - date 
	    int ld_x = (int) ((130*frame.getWidth())/900);
	    int ld_y = (int) ((18*frame.getHeight())/600);
	    int ld_width = (int) ((250*frame.getWidth())/900);
	    int ld_height = (int) ((25*frame.getHeight())/600);
	    int ld_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label ld = new Custom_Label(ld_x, ld_y, ld_width, ld_height,
        "2024-05-26 -- 15:25:45","Consolas",ld_font_size,"#000000");
        ld.setHorizontalAlignment(SwingConstants.LEFT);
        purchase_displayer.add(ld);
        
        
        
        
        // label - total cost 
	    int lc_x = (int) ((350*frame.getWidth())/900);
	    int lc_y = (int) ((18*frame.getHeight())/600);
	    int lc_width = (int) ((250*frame.getWidth())/900);
	    int lc_height = (int) ((25*frame.getHeight())/600);
	    int lc_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label lc = new Custom_Label(lc_x, lc_y, lc_width, lc_height,
        "1093 Dhs","Consolas",lc_font_size,"#C00000");
        lc.setHorizontalAlignment(SwingConstants.LEFT);
        purchase_displayer.add(lc);
        
        
        
        
        // label - total items 
	    int li_x = (int) ((20*frame.getWidth())/900);
	    int li_y = (int) ((50*frame.getHeight())/600);
	    int li_width = (int) ((250*frame.getWidth())/900);
	    int li_height = (int) ((25*frame.getHeight())/600);
	    int li_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label li = new Custom_Label(li_x, li_y, li_width, li_height,
        "Total Items :","Consolas",li_font_size,"#b39700");
        li.setHorizontalAlignment(SwingConstants.LEFT);
        purchase_displayer.add(li);
        
        

        // label - total items number
	    int lt_x = (int) ((130*frame.getWidth())/900);
	    int lt_y = (int) ((50*frame.getHeight())/600);
	    int lt_width = (int) ((250*frame.getWidth())/900);
	    int lt_height = (int) ((25*frame.getHeight())/600);
	    int lt_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label lt = new Custom_Label(lt_x, lt_y, lt_width, lt_height,
        "20","Consolas",lt_font_size,"#000000");
        lt.setHorizontalAlignment(SwingConstants.LEFT);
        purchase_displayer.add(lt);
		
	    
	   
        
        // label - satus 
	    int ls_x = (int) ((20*frame.getWidth())/900);
	    int ls_y = (int) ((75*frame.getHeight())/600);
	    int ls_width = (int) ((250*frame.getWidth())/900);
	    int ls_height = (int) ((25*frame.getHeight())/600);
	    int ls_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label ls = new Custom_Label(ls_x, ls_y, ls_width, ls_height,
        "Status :","Consolas",ls_font_size,"#b39700");
        ls.setHorizontalAlignment(SwingConstants.LEFT);
        purchase_displayer.add(ls);
	    
	    
	    

        // label - purchase status
	    int lss_x = (int) ((130*frame.getWidth())/900);
	    int lss_y = (int) ((75*frame.getHeight())/600);
	    int lss_width = (int) ((250*frame.getWidth())/900);
	    int lss_height = (int) ((25*frame.getHeight())/600);
	    int lss_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label lss = new Custom_Label(lss_x, lss_y, lss_width, lss_height,
        "not shipped","Consolas",lss_font_size,"#000000");
        lss.setHorizontalAlignment(SwingConstants.LEFT);
        purchase_displayer.add(lss);
	    
	    
	    
	    

        // cancel purchase button 
	    int bt2_x = (int) ((150*frame.getWidth())/900);
	    int bt2_y = (int) ((120*frame.getHeight())/600);
	    int bt2_width = (int) ((200*frame.getWidth())/900);
	    int bt2_height = (int) ((25*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button cancel = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Cancel Purchase","#2F5597","Segoe Print",bt2_font_size,false);
        cancel.setHorizontalAlignment(SwingConstants.LEFT);
        cancel.change_style("#C00000","#2F5597");
        purchase_displayer.add(cancel);
        
        
        
        // purchase details button 
	    int bt1_x = (int) ((20*frame.getWidth())/900);
	    int bt1_y = (int) ((120*frame.getHeight())/600);
	    int bt1_width = (int) ((100*frame.getWidth())/900);
	    int bt1_height = (int) ((25*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button details = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Details","#2F5597","Segoe Print",bt1_font_size,false);
        details.setHorizontalAlignment(SwingConstants.LEFT);
        details.change_style("#0e9bdd","#2F5597");
        purchase_displayer.add(details);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

		// handle resizing
        new Custom_Resizing_Manager(purchase_displayer);
	    

	}

}