package Staff_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;


public class Staff_Space {
	
	// attributes
	
	public Custom_Panel space;

	public Custom_Button stock;
	public Custom_Button new_product;
	public Custom_Button client;
	public Custom_Button delivery;
	public Custom_Button report;
	public Custom_Button quit;



	public Custom_Label labs;
	public Custom_Label labn;
	public Custom_Label labr;
	public Custom_Label labpr;
	public Custom_Label labre;
	public Custom_Label labq;



	

	

     
	// constructor
	public Staff_Space(Custom_Frame frame) {
		
		
		// page panel
		space = new Custom_Panel(0,0,frame.getWidth(),frame.getHeight(),"#FFFFFF");
		space.add_background("Needed images\\client_space.png");
		
		// menu bar panel
		int pn1_x = (int) ((0*frame.getWidth())/900);
	    int pn1_width = (int) ((120*frame.getWidth())/900);
		Custom_Panel menu = new Custom_Panel(pn1_x,0,pn1_width,frame.getHeight(),"#002F5E");
		space.add(menu);
		
		// label  - menu icon
	    int lbm_x = (int) ((0*frame.getWidth())/900);
	    int lbm_y = (int) ((15*frame.getHeight())/600);
	    int lbm_width = (int) ((30*frame.getWidth())/900);
	    int lbm_height = (int) ((41*frame.getHeight())/600);
        Custom_Label labm = new Custom_Label(lbm_x, lbm_y, lbm_width, lbm_height,
        "","Segoe Print",7,"#2F5597");
        labm.setBackground(Color.decode("#002F5E"));
        labm.setOpaque(true);
        labm.add_background("Needed images\\menu_icon.png");
        menu.add(labm);
        
        
        // label 2 - menu
	    int lb1_x = (int) ((30*frame.getWidth())/900);
	    int lb1_y = (int) ((15*frame.getHeight())/600);
	    int lb1_width = (int) ((90*frame.getWidth())/900);
	    int lb1_height = (int) ((41*frame.getHeight())/600);
	    int lb1_font_size = (int) ((18*frame.getWidth())/900);
        Custom_Label lab1 = new Custom_Label(lb1_x, lb1_y, lb1_width, lb1_height,
        "Board","Segoe Print",lb1_font_size,"#FFFFFF");
        lab1.setHorizontalAlignment(SwingConstants.CENTER);
        lab1.setBackground(Color.decode("#002F5E"));
        lab1.setOpaque(true);
        menu.add(lab1);
        
        
        // label - above menu
	    int lb_x = (int) ((0*frame.getWidth())/900);
	    int lb_y = (int) ((0*frame.getHeight())/600);
	    int lb_width = (int) ((120*frame.getWidth())/900);
	    int lb_height = (int) ((15*frame.getHeight())/600);
        Custom_Label lab = new Custom_Label(lb_x, lb_y, lb_width, lb_height,
        "","Segoe Print",7,"#2F5597");
        lab.setBackground(Color.decode("#002F5E"));
        lab.setOpaque(true);
        menu.add(lab);
        
        
        
        

        // label 4 - -------
	    int lb4_x = (int) ((120*frame.getWidth())/900);
	    int lb4_y = (int) ((46*frame.getHeight())/600);
	    int lb4_width = (int) ((780*frame.getWidth())/900);
	    int lb4_height = (int) ((10*frame.getHeight())/600);
        Custom_Label lab4 = new Custom_Label(lb4_x, lb4_y, lb4_width, lb4_height,"","Consolas",7,"#808080");
        lab4.create_bottom_border(1,"#B4B4B4");
        space.add(lab4);
        
        
        
        // label 5 - user icon
	    int lb5_x = (int) ((850*frame.getWidth())/900);
	    int lb5_y = (int) ((20*frame.getHeight())/600);
	    int lb5_width = (int) ((16*frame.getWidth())/900);
	    int lb5_height = (int) ((20*frame.getHeight())/600);
        Custom_Label lab5 = new Custom_Label(lb5_x, lb5_y, lb5_width, lb5_height,"","Consolas",7,"#808080");
        lab5.add_background("Needed images\\user_on.png");
        space.add(lab5);
        
        
        
        // label 6 - administration
	    int lb6_x = (int) ((633*frame.getWidth())/900);
	    int lb6_y = (int) ((21*frame.getHeight())/600);
	    int lb6_width = (int) ((200*frame.getWidth())/900);
	    int lb6_height = (int) ((20*frame.getHeight())/600);
	    int lb6_font_size = (int) ((11*frame.getWidth())/900);
        Custom_Label lab6 = new Custom_Label(lb6_x, lb6_y, lb6_width, lb6_height,"Administrative Staff",
        "Segoe Print",lb6_font_size,"#C00000");
        lab6.setHorizontalAlignment(SwingConstants.RIGHT);
        space.add(lab6);
        
        
        
        
        // color
        String color = "#2F5597";
        // font
        String font = "calibri";
        
        
        
        
        
        
        
        
        
        // label  - stock icon
	    int lbs_x = (int) ((0*frame.getWidth())/900);
	    int lbs_y = (int) ((97*frame.getHeight())/600);
	    int lbs_width = (int) ((30*frame.getWidth())/900);
	    int lbs_height = (int) ((40*frame.getHeight())/600);
        labs = new Custom_Label(lbs_x, lbs_y, lbs_width, lbs_height,
        "","Segoe Print",7,"#2F5597");
        labs.setBackground(Color.decode("#002F5E"));
        labs.setOpaque(true);
        labs.add_background("Needed images\\product_icon.png");
        menu.add(labs);
        
        
        // stock button 
	    int bt1_x = (int) ((30*frame.getWidth())/900);
	    int bt1_y = (int) ((97*frame.getHeight())/600);
	    int bt1_width = (int) ((90*frame.getWidth())/900);
	    int bt1_height = (int) ((40*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        stock = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Stock","#FFFFFF",font,bt1_font_size,false);
        stock.setBackground(Color.decode("#002F5E"));
        stock.setOpaque(true);
        stock.change_style("#b39700","#FFFFFF");
        stock.change_color_background(color,"#002F5E",labs);
        stock.setHorizontalAlignment(SwingConstants.LEFT);
        menu.add(stock);
        
        
        // action
        stock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// remove staff space page 
                frame.getContentPane().removeAll();    
                
                // open staff stock page 
                Staff_Stock_Page client_page = new Staff_Stock_Page (frame);                       
                
                // refresh the window
                frame.revalidate();
                frame.repaint();            		
            	}});

        
       
        
        
        
        
        
        
        
        
        
        
        // label  - new product icon
	    int lbn_x = (int) ((0*frame.getWidth())/900);
	    int lbn_y = (int) ((160*frame.getHeight())/600);
	    int lbn_width = (int) ((30*frame.getWidth())/900);
	    int lbn_height = (int) ((40*frame.getHeight())/600);
        labn = new Custom_Label(lbn_x, lbn_y, lbn_width, lbn_height,
        "","Segoe Print",7,"#FFFFFF");;
        labn.setBackground(Color.decode("#002F5E"));
        labn.setOpaque(true);
        labn.add_background("Needed images\\new_product_icon.png");
        menu.add(labn);
        
        

        // new product button 
	    int bt4_x = (int) ((30*frame.getWidth())/900);
	    int bt4_y = (int) ((160*frame.getHeight())/600);
	    int bt4_width = (int) ((90*frame.getWidth())/900);
	    int bt4_height = (int) ((40*frame.getHeight())/600);
	    int bt4_font_size = (int) ((12*frame.getWidth())/900);
        new_product = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "New Product","#FFFFFF",font,bt4_font_size,false);
        new_product.setBackground(Color.decode("#002F5E"));
        new_product.setOpaque(true);
        new_product.change_style("#b39700","#FFFFFF");
        new_product.change_color_background(color,"#002F5E",labn);
        new_product.setHorizontalAlignment(SwingConstants.LEFT);
        menu.add(new_product);
        
        // new_product action
        new_product.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove staff space  page
              frame.getContentPane().removeAll();    
              // open staff new product page  
              Staff_New_Product_Page new_product__page = new Staff_New_Product_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
        
        
        
        
        
        
        
        
        
        
        // label  - client icon
	    int lbr_x = (int) ((0*frame.getWidth())/900);
	    int lbr_y = (int) ((223*frame.getHeight())/600);
	    int lbr_width = (int) ((30*frame.getWidth())/900);
	    int lbr_height = (int) ((40*frame.getHeight())/600);
        labr = new Custom_Label(lbr_x, lbr_y, lbr_width, lbr_height,
        "","Segoe Print",7,"#2F5597");
        labr.setBackground(Color.decode("#002F5E"));
        labr.setOpaque(true);
        labr.add_background("Needed images\\user_icon.png");
        menu.add(labr);
        
        

        // client button 
	    int bt2_x = (int) ((30*frame.getWidth())/900);
	    int bt2_y = (int) ((223*frame.getHeight())/600);
	    int bt2_width = (int) ((90*frame.getWidth())/900);
	    int bt2_height = (int) ((40*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        client = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "Clients","#FFFFFF",font,bt2_font_size,false);
        client.setBackground(Color.decode("#002F5E"));
        client.setOpaque(true);
        client.change_style("#b39700","#FFFFFF");
        client.change_color_background(color,"#002F5E",labr);
        client.setHorizontalAlignment(SwingConstants.LEFT);
        menu.add(client);
        
        // client action
        client.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove staff space  page
              frame.getContentPane().removeAll();    
              // open staff client page  
              Staff_Clients_Page clients_page = new Staff_Clients_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
        
        
        
        
        
       
        
        
        
        // label  - delivery icon
	    int lbpr_x = (int) ((0*frame.getWidth())/900);
	    int lbpr_y = (int) ((286*frame.getHeight())/600);
	    int lbpr_width = (int) ((30*frame.getWidth())/900);
	    int lbpr_height = (int) ((40*frame.getHeight())/600);
        labpr = new Custom_Label(lbpr_x, lbpr_y, lbpr_width, lbpr_height,
        "","Segoe Print",7,"#2F5597");
        labpr.setBackground(Color.decode("#002F5E"));
        labpr.setOpaque(true);
        labpr.add_background("Needed images\\delivery_icon.png");
        menu.add(labpr);
        
        
        
        // delivery button 
	    int bt3_x = (int) ((30*frame.getWidth())/900);
	    int bt3_y = (int) ((286*frame.getHeight())/600);
	    int bt3_width = (int) ((90*frame.getWidth())/900);
	    int bt3_height = (int) ((40*frame.getHeight())/600);
	    int bt3_font_size = (int) ((12*frame.getWidth())/900);
        delivery = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "Deliveries","#FFFFFF",font,bt3_font_size,false);
        delivery.setBackground(Color.decode("#002F5E"));
        delivery.setOpaque(true);
        delivery.change_style("#b39700","#FFFFFF");
        delivery.change_color_background(color,"#002F5E",labpr);
        delivery.setHorizontalAlignment(SwingConstants.LEFT);
        menu.add(delivery);
        
        // delivery action
        delivery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove staff space  page
              frame.getContentPane().removeAll();    
              // open staff delivery page  
              Staff_Deliveries_Page clients_page = new Staff_Deliveries_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        

        
        
        
        
        
        
        
        
        // label  - reports icon
	    int lbre_x = (int) ((0*frame.getWidth())/900);
	    int lbre_y = (int) ((349*frame.getHeight())/600);
	    int lbre_width = (int) ((30*frame.getWidth())/900);
	    int lbre_height = (int) ((40*frame.getHeight())/600);
        labre = new Custom_Label(lbre_x, lbre_y, lbre_width, lbre_height,
        "","Segoe Print",7,"#2F5597");
        labre.setBackground(Color.decode("#002F5E"));
        labre.setOpaque(true);
        labre.add_background("Needed images\\report_icon.png");
        menu.add(labre);
        
        
        
        // reports button 
	    int bt5_x = (int) ((30*frame.getWidth())/900);
	    int bt5_y = (int) ((349*frame.getHeight())/600);
	    int bt5_width = (int) ((90*frame.getWidth())/900);
	    int bt5_height = (int) ((40*frame.getHeight())/600);
	    int bt5_font_size = (int) ((12*frame.getWidth())/900);
        report = new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "Reports","#FFFFFF",font,bt5_font_size,false);
        report.setBackground(Color.decode("#002F5E"));
        report.setOpaque(true);
        report.change_style("#b39700","#FFFFFF");
        report.change_color_background(color,"#002F5E",labre);
        report.setHorizontalAlignment(SwingConstants.LEFT);
        menu.add(report);

        // report action
        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove staff space  page
              frame.getContentPane().removeAll();    
              // open staff report page  
              Staff_Reports_Page reports_page = new Staff_Reports_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
       
        
        
        
        
        
        
        
        // label  - quit icon
	    int lbq_x = (int) ((0*frame.getWidth())/900);
	    int lbq_y = (int) ((412*frame.getHeight())/600);
	    int lbq_width = (int) ((30*frame.getWidth())/900);
	    int lbq_height = (int) ((40*frame.getHeight())/600);
        labq = new Custom_Label(lbq_x, lbq_y, lbq_width, lbq_height,
        "","Segoe Print",7,"#2F5597");
        labq.setBackground(Color.decode("#002F5E"));
        labq.setOpaque(true);
        labq.add_background("Needed images\\logout_icon.png");
        menu.add(labq);
        
        
        
        // quit button 
	    int bt6_x = (int) ((30*frame.getWidth())/900);
	    int bt6_y = (int) ((412*frame.getHeight())/600);
	    int bt6_width = (int) ((90*frame.getWidth())/900);
	    int bt6_height = (int) ((40*frame.getHeight())/600);
	    int bt6_font_size = (int) ((12*frame.getWidth())/900);
        quit = new Custom_Button(bt6_x,bt6_y,bt6_width,bt6_height,
        "Quit","#FFFFFF",font,bt6_font_size,false);
        quit.setBackground(Color.decode("#002F5E"));
        quit.setOpaque(true);
        quit.change_style("#b39700","#FFFFFF");
        quit.change_color_background(color,"#002F5E",labq);
        quit.setHorizontalAlignment(SwingConstants.LEFT);
        menu.add(quit);
        
        // quit action
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // remove staff space  page
              frame.getContentPane().removeAll();    
              // create an instance of splash page 
              Staff_Sign_In_Page sign_in__page = new Staff_Sign_In_Page (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
        
        
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// add space panel to the frame 
        frame.getContentPane().add(space);
        
        
        // handle resizing
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(menu);
	}

}