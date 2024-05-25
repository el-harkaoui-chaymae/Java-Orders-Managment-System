package Staff_Pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Data_Base.Delivery_Destination;
import Data_Base.Purchase;
import Graphical_Interface.Custom_Button;
import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Panel;
import Graphical_Interface.Custom_Resizing_Manager;
import Graphical_Interface.Custom_Table;


public class Staff_Clients_Page {

	// constructor
	public Staff_Clients_Page(Custom_Frame frame) {

		// create the staff space elements
		Staff_Space staff_space = new Staff_Space(frame);

		// change client button background to show that it's clicked
		staff_space.client.setBackground(Color.decode("#2F5597"));
		staff_space.labr.setBackground(Color.decode("#2F5597"));
		staff_space.client.change_style("#b39700", "#b39700");
		staff_space.client.change_color_background("#2F5597", "#2F5597", staff_space.labr);

		// center page panel
		int pn1_x = (int) ((140 * frame.getWidth()) / 900);
		int pn1_y = (int) ((70 * frame.getHeight()) / 600);
		int pn1_width = (int) ((800 * frame.getWidth()) / 900);
		int pn1_height = (int) ((580 * frame.getHeight()) / 600);
		Custom_Panel center_panel = new Custom_Panel(pn1_x, pn1_y, pn1_width, pn1_height, "#FFFFFF");
		staff_space.space.add(center_panel);
		
		
		
		
		
		
		
		
		
		 
        // ---- purchases table
        
        
        
        // Define table data
        Object[][] row_column_number =  new Object[52][5];
      

        // Define column names
        String[] columns_names = {"Purchase Id", "Date", "Time","Purchase State", "Client Id"};

        // Define column widths
        int[] columns_widths = {90, 170, 170,160, 80};

        // Define row height
	    int r_height = (int) ((30*frame.getHeight())/600);
        int row_height = r_height;

        // Define header font size
	    int font_size_h = (int) ((13*frame.getWidth())/900);
        int header_font_size = font_size_h;

        // Create the custom product table
        int x_t = (int) ((25*frame.getWidth())/900);
	    int y_t = (int) ((160*frame.getHeight())/600);
	    int width_t = (int) ((682*frame.getWidth())/900);
	    int height_t = (int) ((295*frame.getHeight())/600);
	    int cell_font_size = (int) ((12*frame.getWidth())/900);
        Custom_Table table = new Custom_Table(frame,x_t, y_t, width_t, height_t, row_column_number, columns_names, 
        columns_names.length, columns_widths, row_height,header_font_size,cell_font_size);
                
     
        // Add the scroll pane holding the view of the table to the center panel
        center_panel.add(table.scroll_pane);
        
        

        // the table rows and columns number
        int rows_number = 52;
        int columns_number = 5;
        
        
        
        
        
        // fill the table
        
        
        
        
        // get all available purchases in the DB
        ArrayList<Object[]> all_purchases = Purchase.get_purchases_infos();
        
        
        

        // Iterate through the purchases` array and set values to the table
        for (int i = 0; i < all_purchases.size(); i++) {
            
                table.setValueAt(all_purchases.get(i)[0], i, 0);
                table.setValueAt(all_purchases.get(i)[1], i, 1);
                table.setValueAt(all_purchases.get(i)[2], i, 2);
                table.setValueAt(all_purchases.get(i)[3], i, 3);
                table.setValueAt(all_purchases.get(i)[4], i, 4);
                
            }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // --- top bar buttons
        
        
        String color = "#C00000"; 
        String font_color = "#2F5597";
         
         
         // select button 
 	    int bt1_x = (int) ((140*frame.getWidth())/900);
 	    int bt1_y = (int) ((13*frame.getHeight())/600);
 	    int bt1_width = (int) ((90*frame.getWidth())/900);
 	    int bt1_height = (int) ((40*frame.getHeight())/600);
 	    int bt1_font_size = (int) ((12*frame.getWidth())/900);
         Custom_Button select = new Custom_Button(bt1_x,bt1_y,bt1_width,bt1_height,
         "Select",font_color,"Consolas",bt1_font_size,false);
         select.change_style(color,font_color);
         select.add_buttom_border(162, 50, 46, color, frame, staff_space.space);
         staff_space.space.add(select);
         
         // select button action
         select.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
             	
             	 table.setEnabled(true);
             	 table.getTableHeader().setForeground(Color.decode("#56AE57"));
             	
                
             	}});
         
         
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(staff_space.space);
        Custom_Resizing_Manager resize_3 = new Custom_Resizing_Manager(center_panel);

	}

}
 