package Client_Pages;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Message;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Data_Base.Delivery;
import Data_Base.Delivery_Destination;
import Data_Base.Invoice;
import Data_Base.Order;
import Data_Base.Product;
import Data_Base.Purchase;




public class Client_Product_Displayer {
	
	
	// attributes     
	int x;
	int y;
	int width; 
	int height;
	
	public int ordered_quantity = 1;
	
	 
	public Custom_Panel panel;
	
	Custom_Button buy ;
	Custom_Button like ;
	Custom_Button increase_items ;
	Custom_Button decrease_items ;
	Custom_Button remove ; 
	
	public static int productId = 0 ;
	 
	
	Custom_Label product_ordered_quantity ;
	
	
	
	
	// constructor
	public Client_Product_Displayer(Custom_Frame frame,Custom_Panel center_panel,
			int x,int y,int width,int height,ByteArrayInputStream photo_1,
			String name,String price,int product_id,int client_id) {
		
		
		 
		
		
		// transparent panel
	    int lf_x = (int) ((x*frame.getWidth())/900);
	    int lf_y = (int) ((y*frame.getHeight())/600);
	    int lf_width = (int) ((width*frame.getWidth())/900);
	    int lf_height = (int) ((height*frame.getHeight())/600);
        Custom_Panel pn = new Custom_Panel(lf_x,lf_y,lf_width,lf_height,"#F9F9F8");
        pn.add_background("Needed images\\transparent_background.png");
        pn.setOpaque(false);
        center_panel.add(pn);
        pn.setVisible(false);
		
		
		
		
		
		// product infos panel - it contains - organize - display product
	    int pn_x = (int) ((x*frame.getWidth())/900);
	    int pn_y = (int) ((y*frame.getHeight())/600);
	    int pn_width = (int) ((width*frame.getWidth())/900);
	    int pn_height = (int) ((height*frame.getHeight())/600);
	    panel = new Custom_Panel(pn_x,pn_y,pn_width,pn_height,"#F9F9F8");
	    panel.setBackground(Color.white);
	    Border border6 = BorderFactory.createLineBorder(Color.decode("#b39700"), 0);
        panel.setBorder(border6);	   
        center_panel.add(panel);
        
        
        

        // buy button 
	    int bt1_x = (int) ((6*frame.getWidth())/900);
	    int bt1_y = (int) ((160*frame.getHeight())/600);
	    int bt1_width = (int) ((63*frame.getWidth())/900);
	    int bt1_height = (int) ((25*frame.getHeight())/600);
	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
        buy = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
        "Buy","#FFFFFF","Segoe Print",bt1_font_size,true);
        buy.setRound_shape_variables(35, 35);
        buy.change_style("#002F5E","#FFFFFF");
        buy.setHorizontalAlignment(SwingConstants.CENTER);
        pn.add(buy);
        
        
        
        // action
        buy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
        	    // create a virtual product
        	    Product virtual_product = new Product(null,null,0,0,null,null,null,null,null);
        	    virtual_product.setId(product_id);
        	    
        	    // get the selcted product details
        	    Object[] product_details = virtual_product.get_details();
            	
            	// if this product is not out of stock
        	    if(Double.valueOf(product_details[3].toString())<= 0) {
        	    	
        	    	// raise a message
            		new Custom_Message(30,140,"Needed Images\\x_icon.png",
            		"Out Of Stock","This Product is Currently out Of Stock");
        	    	
        	    	
        	    }
        	    
            	
        	    else {
        	    	 
        	    	// add an order
                	Order virtual_order = new Order(client_id,product_id);
                	virtual_order.add();
                	
                	// raise a message
            		new Custom_Message(45,140,"Needed Images\\verification_icon.png",
            		"Successful Order","Product successfully added to Cart");
        	    }
            	
            	
            	}});
        
        
        
        
        
        
        
        
        
        
        // like button 
	    int bt2_x = (int) ((79*frame.getWidth())/900);
	    int bt2_y = (int) ((160*frame.getHeight())/600);
	    int bt2_width = (int) ((63*frame.getWidth())/900);
	    int bt2_height = (int) ((25*frame.getHeight())/600);
	    int bt2_font_size = (int) ((12*frame.getWidth())/900);
        like = new Custom_Button(bt2_x,bt2_y,bt2_width,bt2_height,
        "like","#FFFFFF","Segoe Print",bt2_font_size,true);
        like.setRound_shape_variables(35, 35);
        like.change_style("#002F5E","#FFFFFF");
        like.setHorizontalAlignment(SwingConstants.CENTER);
        pn.add(like);
        
        
        
        // the product ordered quantity in the DB
    	Order virtual_order = new Order(client_id,product_id);
    	ordered_quantity = virtual_order.get_product_ordered_quantity();
        
        
        // label - product ordered quantity 
	    int lq_x = (int) ((59*frame.getWidth())/900);
	    int lq_y = (int) ((160*frame.getHeight())/600);
	    int lq_width = (int) ((30*frame.getWidth())/900);
	    int lq_height = (int) ((25*frame.getHeight())/600);
	    int lq_font_size = (int) ((10*frame.getWidth())/900);
        product_ordered_quantity = new Custom_Label(lq_x, lq_y, lq_width, lq_height,
        String.valueOf(ordered_quantity),"Calibri",lq_font_size,"#000000");
        product_ordered_quantity.setHorizontalAlignment(SwingConstants.CENTER);
        pn.add(product_ordered_quantity);
        product_ordered_quantity.setVisible(false);
        
        
        
        
        
        
        
        
        // - item button 
	    int bt3_x = (int) ((14*frame.getWidth())/900);
	    int bt3_y = (int) ((160*frame.getHeight())/600);
	    int bt3_width = (int) ((40*frame.getWidth())/900);
	    int bt3_height = (int) ((25*frame.getHeight())/600);
	    int bt3_font_size = (int) ((14*frame.getWidth())/900);
        decrease_items = new Custom_Button(bt3_x,bt3_y,bt3_width,bt3_height,
        "-","#FFFFFF","Calibri",bt3_font_size,true);
        decrease_items.setRound_shape_variables(0, 0);
        decrease_items.change_style("#002F5E","#FFFFFF");
        decrease_items.setHorizontalAlignment(SwingConstants.CENTER);
        pn.add(decrease_items);
        decrease_items.setVisible(false);
        
         
        // action
        decrease_items.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
                // update the item ordered quantity in the displayer
                ordered_quantity -= 1;
            	if(ordered_quantity == 0) {ordered_quantity = 1;}
            	product_ordered_quantity.setText(String.valueOf(ordered_quantity));
            	
            	
            	// update the product ordered quantity in the DB
            	Order virtual_order = new Order(client_id,product_id);
            	
            	int original_qantity = virtual_order.get_product_ordered_quantity();
            	
            	virtual_order.product_oredered_items = original_qantity - 1 ;
            	
            	
            	if(original_qantity >= 2) {
            		
            		virtual_order.product_oredered_items = original_qantity - 1 ;
            		virtual_order.change_product_ordered_quantity();}
            	
            	
            	// update the value of the total ordered items
            	int original_total_Q = virtual_order.get_total_ordered_items();
            	
            	Client_Orders_Page.total_ordered_items.setText(String.valueOf(original_total_Q ));
            	
            	
            	// update the subtotal price
            	double new_subtotal_price = virtual_order.get_total_orders_price();
            	Client_Orders_Page.subtotal_pr.setText(String.valueOf(new_subtotal_price +" Dhs"));
            	
            	
            	// update the total cost
           	    if(Client_Orders_Page.delivery_fee.getText().equals("Delivery unavailable !") ) {
           		       Client_Orders_Page.total_price.setText("0 Dhs");
           		       Client_Orders_Page.total_price.setForeground(Color.red) ; }
                
                else {
                	
                        String del_fee =  
                        Client_Orders_Page.delivery_fee.getText().substring(0, Client_Orders_Page.delivery_fee.getText().length() - 4);
                       
                        String sub_tot =  
                        Client_Orders_Page.subtotal_pr.getText().substring(0, Client_Orders_Page.subtotal_pr.getText().length() - 4);
                	    
                        double total_cost = Double.valueOf(sub_tot) + Double.valueOf(del_fee) ;
                        Client_Orders_Page.total_price.setText(String.valueOf(total_cost) + " Dhs");}
            	
            	
            }});
        
        
        
        
        
        
        
        // + item button 
	    int bt4_x = (int) ((93*frame.getWidth())/900);
	    int bt4_y = (int) ((160*frame.getHeight())/600);
	    int bt4_width = (int) ((42*frame.getWidth())/900);
	    int bt4_height = (int) ((25*frame.getHeight())/600);
	    int bt4_font_size = (int) ((14*frame.getWidth())/900);
        increase_items = new Custom_Button(bt4_x,bt4_y,bt4_width,bt4_height,
        "+","#FFFFFF","Calibri",bt4_font_size,true);
        increase_items.setRound_shape_variables(0, 0);
        increase_items.change_style("#002F5E","#FFFFFF");
        increase_items.setHorizontalAlignment(SwingConstants.CENTER);
        pn.add(increase_items);
        increase_items.setVisible(false);
        
         
        
        // action
        increase_items.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	// if the original ordered quantity less than the product quantity in the stock by 2
            	
            	
            	// ----------- the product stock quantity
            	
            	// create a virtual product
        	    Product virtual_product = new Product(null,null,0,0,null,null,null,null,null);
        	    virtual_product.setId(product_id);
        	    
        	    // get the selcted product details - stock qunatity
        	    Object[] product_details = virtual_product.get_details();
        	    double product_stock_quantity = Double.valueOf(product_details[3].toString());
        	    
        	    
        	    // ----------- the product original ordered quantity
        	    
        	    // create a virtual order
                Order virtual_order = new Order(client_id,product_id);
                
                // its original ordered quantity
            	int original_ordered_qantity = virtual_order.get_product_ordered_quantity();
            	
        	   
            	// ---------- if the product is still availible in the stock the clients can add items of it
            	
        	    if(original_ordered_qantity + 1 <= product_stock_quantity) {
        	    	
        	    	// change the value of the items number of the product displayer
                	ordered_quantity += 1;
                	product_ordered_quantity.setText(String.valueOf(ordered_quantity));
                	
                	// update the product ordered quantity in the DB            	
                	virtual_order.product_oredered_items = original_ordered_qantity + 1 ;
                	virtual_order.change_product_ordered_quantity();
                	
                	
                	// update the value of the total ordered items
                	int original_Q = virtual_order.get_total_ordered_items();
                	
                	Client_Orders_Page.total_ordered_items.setText(String.valueOf(original_Q));
                	

                	// update the subtotal price
                	double new_subtotal_price = virtual_order.get_total_orders_price();
                	Client_Orders_Page.subtotal_pr.setText(String.valueOf(new_subtotal_price)+" Dhs");
                	
                	
                	
                	// update the total cost
                	 if(Client_Orders_Page.delivery_fee.getText().equals("Delivery unavailable !") ) {
                		 Client_Orders_Page.total_price.setText("0 Dhs");
                		 Client_Orders_Page.total_price.setForeground(Color.red) ; }
                     
                     else {
                     	
                             String del_fee =  
                             Client_Orders_Page.delivery_fee.getText().substring(0, Client_Orders_Page.delivery_fee.getText().length() - 4);
                            
                             String sub_tot =  
                             Client_Orders_Page.subtotal_pr.getText().substring(0, Client_Orders_Page.subtotal_pr.getText().length() - 4);
                     	    
                             double total_cost = Double.valueOf(sub_tot) + Double.valueOf(del_fee) ;
                             Client_Orders_Page.total_price.setText(String.valueOf(total_cost) + " Dhs");}}
            	
            	  
        	    
        	    
        	       // ---------- the product is out of stock
        	    
        	    
        	    else {
        	    	
        	    	// raise a message
            		new Custom_Message(50,140,"Needed Images\\x_icon.png",
            		"Out Of Stock","Insufficient stock for addition");
        	    }
            	
            	
            }});
        
        
        
        
        
        
        
        
        
        
        
        
        // remove product from orders list
	    int bt5_x = (int) ((119*frame.getWidth())/900);
	    int bt5_y = (int) ((3*frame.getHeight())/600);
	    int bt5_width = (int) ((33*frame.getWidth())/900);
	    int bt5_height = (int) ((25*frame.getHeight())/600);
	    int bt5_font_size = (int) ((12*frame.getWidth())/900);
        remove= new Custom_Button(bt5_x,bt5_y,bt5_width,bt5_height,
        "X","#000000","Segoe Print",bt5_font_size,false);
        remove.change_style("#C00000","#000000");
        remove.setHorizontalAlignment(SwingConstants.CENTER);
        pn.add(remove);
        remove.setVisible(false);
        
        
        // action
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// order to be removed
            	Order ord = new Order(client_id,product_id);
            	ord.delete();
            	
            	// hide this product
            	panel.setVisible(false);
            	
            	// --- update the beside infos
            	
            	// update the total number of items
            	Order virtual_order = new Order(client_id,0);
            	int total_items = virtual_order.get_total_ordered_items();
            	Client_Orders_Page.total_ordered_items.setText(String.valueOf(total_items));
            	
            	// update the subtotal cost
                double subtotal_price = virtual_order.get_total_orders_price();
                Client_Orders_Page.subtotal_pr.setText(String.valueOf(subtotal_price) + " Dhs");
                
                // update the total cost
                if(Client_Orders_Page.delivery_fee.getText().equals("Delivery unavailable !") 
                		|| Client_Orders_Page.total_ordered_items.getText().equals("0")) {
                	
                	Client_Orders_Page.total_price.setText("0 Dhs");
                	Client_Orders_Page.total_price.setForeground(Color.red) ; }
                
                else {
                	    
                	    int index_1 = Client_Orders_Page.delivery_fee.getText().lastIndexOf(" Dhs");
                        String del_fee =  
                        Client_Orders_Page.delivery_fee.getText().substring(0, index_1);
                        
                        int index_2 = Client_Orders_Page.subtotal_pr.getText().lastIndexOf(" Dhs");
                        String sub_tot = 
                        Client_Orders_Page.subtotal_pr.getText().substring(0, index_2);
                	    
                        double total_cost = Double.valueOf(sub_tot) + Double.valueOf(del_fee) ;
                        Client_Orders_Page.total_price.setText(String.valueOf(total_cost) + " Dhs");}
            	
            }});
        
        
        
        
        
        
         
        
        
        
        

		// product details button 
	    int b_x = (int) ((6*frame.getWidth())/900); 
	    int b_y = (int) ((6*frame.getHeight())/600);
	    int b_width = (int) ((138*frame.getWidth())/900);
	    int b_height = (int) ((100*frame.getHeight())/600);
        Custom_Button details = new Custom_Button(b_x,b_y,b_width,b_height,
        "","#000000","Consolas",7,false);
        panel.add(details);
        
        // action to perform
        details.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
              // affect the product id
              productId = product_id ;
              
                            
              // remove buy products page
              frame.getContentPane().removeAll();    
              // open products details page 
              new Client_Product_Details (frame);                       
              // refresh the window
              frame.revalidate();
              frame.repaint(); }});
        
        
        
		
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Hoovering
        

        Custom_Button[]  buttons = {buy,like,details,increase_items,decrease_items,remove}; 
        
        for(Custom_Button btn:buttons) {
        	
        	btn.addMouseListener(new java.awt.event.MouseAdapter() {
          	   
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		
            		{pn.setVisible(true);};}
            	
            	 public void mouseExited(java.awt.event.MouseEvent evt) {
            		 
            		 {pn.setVisible(false);};}
                 	
                });
        	
        	
        	
        }
        
        
        
        
        
        
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
      	   
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		
        		{pn.setVisible(true);};}
        	
        	 public void mouseExited(java.awt.event.MouseEvent evt) {
        		 
        		 {pn.setVisible(false);};}
             	
            });
        
        
        
        
        
        
        
        
        
	    
	    // product first photo
	    int l_x = (int) ((6*frame.getWidth())/900);
	    int l_y = (int) ((6*frame.getHeight())/600);
	    int l_width = (int) ((138*frame.getWidth())/900);
	    int l_height = (int) ((100*frame.getHeight())/600);
        Custom_Label lb = new Custom_Label(l_x, l_y, l_width, l_height,"",
        "Calibri",7,"#E5E6E4");
        Border border4 = BorderFactory.createLineBorder(Color.decode("#E5E6E4"), 0);
        lb.setBorder(border4);
        panel.add(lb);
        
        
        // set the photo
        if(photo_1 != null) {
        	
        	try {
                lb.setIcon(new ImageIcon(ImageIO.read(photo_1).getScaledInstance(lb.getWidth(),
                lb.getHeight(), Image.SCALE_SMOOTH)));}
       
   	        catch (Exception ex) { ex.printStackTrace();}}
       
        
        

        // handel the label container of photo_1 resizing to ensure that the image always fit it
	    lb.addComponentListener(new ComponentAdapter() {

	            @Override
	            public void componentResized(ComponentEvent e) {
	            	
	            	// reset photo_1
	            	try { 
	                       // Reset the stream to the beginning
	                       photo_1.reset();
	                       lb.setIcon(new ImageIcon(ImageIO.read(photo_1).getScaledInstance(lb.getWidth(),
	                       lb.getHeight(), Image.SCALE_SMOOTH)));}
	               
	            	catch (Exception ex) {
	                    ex.printStackTrace();}
	            	
	            	}});
        
	    
	    
	    
	    
        
        
        
        
	    
        
        // product name
	    int la_x = (int) ((6*frame.getWidth())/900);
	    int la_y = (int) ((110*frame.getHeight())/600);
	    int la_width = (int) ((138*frame.getWidth())/900);
	    int la_height = (int) ((30*frame.getHeight())/600);
	    int la_font_size = (int) ((10*frame.getWidth())/900);
        Custom_Label la = new Custom_Label(la_x, la_y, la_width, la_height,
        name,"Consolas",la_font_size,"#000000");
        la.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(la); 
        
        
        
        
       
        
        
        
        // product price
	    int lc_x = (int) ((6*frame.getWidth())/900);
	    int lc_y = (int) ((130*frame.getHeight())/600);
	    int lc_width = (int) ((138*frame.getWidth())/900);
	    int lc_height = (int) ((30*frame.getHeight())/600);
	    int lc_font_size = (int) ((10*frame.getWidth())/900);
	    Custom_Label product_price_label = new Custom_Label(lc_x, lc_y, lc_width,lc_height,
        price+" "+"Dhs","Calibri",lc_font_size,"#b39700");
        product_price_label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(product_price_label);
        
        
        
        
        
        
       
        
        
        
        
        
        // handle resizing
        new Custom_Resizing_Manager(panel);
        new Custom_Resizing_Manager(pn);
		
		
		
			
		
	}
	
	
	
	// method to allow the visibility of the [ + - ] buttons
	public void increase_decrease_remove_item() {
		
		buy.setVisible(false);
		like.setVisible(false);
		decrease_items.setVisible(true);
		increase_items.setVisible(true);
		remove.setVisible(true);
		product_ordered_quantity.setVisible(true);     
		
	
	
	
	
	
	
	}  

}
