package Client_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;

import Data_Base.Purchase;

public class Client_Purchase_Displayer {
	
	
	
	// attributes
	public Custom_Panel panel ;
	
	
	public LocalDate purchase_date ;
	public LocalTime purchase_time;
	public int client_id ;
	
	

	
	
	// constructor
	public Client_Purchase_Displayer(Custom_Frame frame, Custom_Panel center_panel, int x, int y, int width,
			int height,String date_time,String total_cost,String total_items,String status) {

		
		
		
		// Purchase information panel - it contains - organizes - displays a purchase
		int pn2_x = (int) ((x * frame.getWidth()) / 900);
		int pn2_y = (int) ((y * frame.getHeight()) / 600);
		int pn2_width = (int) ((width * frame.getWidth()) / 900);
		int pn2_height = (int) ((height * frame.getHeight()) / 600);
		panel = new Custom_Panel(pn2_x, pn2_y, pn2_width, pn2_height, "#FFFFFF");
		Border border = BorderFactory.createMatteBorder(0, 4, 1, 0, Color.decode("#B4B4B4")); // Top-left-bottom-right
		panel.setBorder(border);
		center_panel.add(panel);
		
		
		
		
		
		
		
		
		
		// label - Purchase 
	    int lp_x = (int) ((50*frame.getWidth())/900);
	    int lp_y = (int) ((15*frame.getHeight())/600);
	    int lp_width = (int) ((100*frame.getWidth())/900);
	    int lp_height = (int) ((25*frame.getHeight())/600);
	    int lp_font_size = (int) ((14*frame.getWidth())/900);
	    Custom_Label lp = new Custom_Label(lp_x, lp_y, lp_width, lp_height,
        "Purchase","Segoe Print",lp_font_size,"#2F5597");
        lp.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lp);
        
        
        
        // label - date 
	    int ld_x = (int) ((160*frame.getWidth())/900);
	    int ld_y = (int) ((18*frame.getHeight())/600);
	    int ld_width = (int) ((250*frame.getWidth())/900);
	    int ld_height = (int) ((25*frame.getHeight())/600);
	    int ld_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label ld = new Custom_Label(ld_x, ld_y, ld_width, ld_height,
        date_time,"Consolas",ld_font_size,"#000000");
        ld.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(ld);
        
        
        
        
        // label - total cost 
	    int lc_x = (int) ((380*frame.getWidth())/900);
	    int lc_y = (int) ((18*frame.getHeight())/600);
	    int lc_width = (int) ((250*frame.getWidth())/900);
	    int lc_height = (int) ((25*frame.getHeight())/600);
	    int lc_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label lc = new Custom_Label(lc_x, lc_y, lc_width, lc_height,
        "Cost: " + total_cost + " Dhs","Consolas",lc_font_size,"#C00000");
        lc.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lc);
        
        
        
        
        // label - total items 
	    int li_x = (int) ((50*frame.getWidth())/900);
	    int li_y = (int) ((50*frame.getHeight())/600);
	    int li_width = (int) ((250*frame.getWidth())/900);
	    int li_height = (int) ((25*frame.getHeight())/600);
	    int li_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label li = new Custom_Label(li_x, li_y, li_width, li_height,
        "Total Items :","Consolas",li_font_size,"#b39700");
        li.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(li);
        
        

        // label - total items number
	    int lt_x = (int) ((160*frame.getWidth())/900);
	    int lt_y = (int) ((50*frame.getHeight())/600);
	    int lt_width = (int) ((250*frame.getWidth())/900);
	    int lt_height = (int) ((25*frame.getHeight())/600);
	    int lt_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label lt = new Custom_Label(lt_x, lt_y, lt_width, lt_height,
        total_items,"Consolas",lt_font_size,"#000000");
        lt.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lt);
		
	    
	   
        
        // label - satatus 
	    int ls_x = (int) ((50*frame.getWidth())/900);
	    int ls_y = (int) ((75*frame.getHeight())/600);
	    int ls_width = (int) ((250*frame.getWidth())/900);
	    int ls_height = (int) ((25*frame.getHeight())/600);
	    int ls_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label ls = new Custom_Label(ls_x, ls_y, ls_width, ls_height,
        "Status :","Consolas",ls_font_size,"#b39700");
        ls.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(ls);
	    
	    
	    

        // label - purchase status
	    int lss_x = (int) ((160*frame.getWidth())/900);
	    int lss_y = (int) ((75*frame.getHeight())/600);
	    int lss_width = (int) ((250*frame.getWidth())/900);
	    int lss_height = (int) ((25*frame.getHeight())/600);
	    int lss_font_size = (int) ((12*frame.getWidth())/900);
	    Custom_Label lss = new Custom_Label(lss_x, lss_y, lss_width, lss_height,
        status,"Consolas",lss_font_size,"#000000");
        lss.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lss);
	    
	    
	    
	    

        // cancel purchase button 
	    int bt2_x = (int) ((170*frame.getWidth())/900);
	    int bt2_y = (int) ((120*frame.getHeight())/600);
	    int bt2_width = (int) ((200*frame.getWidth())/900);
	    int bt2_height = (int) ((25*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button cancel = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Cancel Purchase","#2F5597","Arial Rounded MT Bold",bt2_font_size,false);
        cancel.setHorizontalAlignment(SwingConstants.LEFT);
        cancel.change_style("#C00000","#2F5597");
        panel.add(cancel);
        
        //action
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// deleting purchases is possible only if they are still not shipped
            	if(status.equals("not shipped")) {
            		

                	// virtual purchase
                	Purchase purchase = new Purchase(purchase_date,purchase_time,client_id);
                	purchase.purchase_state = status;
                	
                	purchase.delete();
                	
                	panel.setVisible(false);
                	
                	// raise a message
					new Custom_Message(70, 140, "Needed Images\\verification_icon.png", "Cancellation done",
					"This purchase is cancelled");
            		
            		
            	} 
            	
            	else {
            		

					// raise a message
					new Custom_Message(45, 140, "Needed Images\\x_icon.png", "Cancellation Unavailable",
					"Cancellation is no longer possible");
            	}
              
            
            
            
            }});
        
        
        
        
        
        
        
        
        
        
        // purchase details button 
	    int bt1_x = (int) ((40*frame.getWidth())/900);
	    int bt1_y = (int) ((120*frame.getHeight())/600);
	    int bt1_width = (int) ((100*frame.getWidth())/900);
	    int bt1_height = (int) ((25*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Button details = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Details","#2F5597","Arial Rounded MT Bold",bt1_font_size,false);
        details.setHorizontalAlignment(SwingConstants.LEFT);
        details.change_style("#0e9bdd","#2F5597");
        panel.add(details);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

		// handle resizing
        new Custom_Resizing_Manager(panel);
	    

	}

}
