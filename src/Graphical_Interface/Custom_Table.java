package Graphical_Interface;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;



import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;



public class Custom_Table extends JTable{
    
	// attributes
	int x;
	int y;
	int width;
	int height;
	Object [][] rows_columns_number;
	String[] column_names;
	int[] columns_widths;
	int row_height;
	int header_font_size;
	int cell_font_size;
	public JScrollPane scroll_pane;
	float original_columns_width_sum = 0;
	
	
	// constructor
	public Custom_Table(Custom_Frame frame,int x,int y,int width,int height,Object [][] rows_columns_number,
	String[] column_names,int columns_number,int[] columns_widths,int row_height,int header_font_size,int cell_font_size) {
		
	
		
		// Create the table model with the rows and columns specified number + column names
        DefaultTableModel tableModel = new DefaultTableModel(rows_columns_number, column_names) ;
        
        
        // Set the table model
        this.setModel(tableModel);
        
        
        
        // columns widths
        for(int i=0 ; i<columns_number ; i++) {
        	this.getColumnModel().getColumn(i).setPreferredWidth((int) ((columns_widths[i]*frame.getWidth())/900));}

        

       
		
		
        
        // diseable auto resizing
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setEnabled(true);
        
        
        
        	 	
       
        

        // row height
        this.setRowHeight(row_height);
        
        
       
        
        

        // Align the text of the cells to the left with 2-space indentation
        DefaultTableCellRenderer left_render = new DefaultTableCellRenderer() {
            
        	static final int identation = 16;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
            		                                        boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.LEFT);
                setBorder(BorderFactory.createEmptyBorder(0, identation, 0, 0));
                return this;
            }
        };

        // Set the custom left render to the table
        for (int j = 0; j < this.getColumnCount(); j++) {
            this.getColumnModel().getColumn(j).setCellRenderer(left_render);
        }
        
        
        
        
        // set the font size for the table cells
        Font cell_font = new Font("Calibri", Font.PLAIN, cell_font_size);
        this.setFont(cell_font);
        
        
        
        
        
        
        
        // the style of the table header 
        JTableHeader table_header = this.getTableHeader();
        table_header.setForeground(Color.decode("#b39700"));
        table_header.setBackground(Color.decode("#FFFFFF"));
        table_header.setFont(new Font("Segoe Print", Font.BOLD, header_font_size));
        
        
        
        
        // Set the selection background color 
        this.setSelectionBackground(Color.decode("#DAF0F7"));
        this.setSelectionForeground(Color.decode("#C00000"));
        
        
        // apply the modified UI defaults to the table header
        UIManager.put("TableHeaderUI", "javax.swing.plaf.basic.BasicTableHeaderUI");
        table_header.updateUI();
        
        
        // add the table to a scroll pane
        scroll_pane = new JScrollPane(this);
        scroll_pane.setBackground(Color.white);
        scroll_pane.setBounds(x, y, width, height);
        
        
        
        // the original table length
        for(int i=0 ; i<columns_number ; i++) {
        	original_columns_width_sum += columns_widths[i];
        }
        
        
        
        // Listen for resizing of the scroll pane
        scroll_pane.addComponentListener(new ComponentAdapter() {
        	
        	
        	// before resizing frame width
        	int scrollpane_width_before_resizing = scroll_pane.getWidth();
        	
        	// cells original font size
        	int old_font_size = cell_font_size;
        	
        	// header original font size
        	int old_header_font_size = header_font_size;
        	
        	
        	
            @Override
            public void componentResized(ComponentEvent e) {
            	
            	// the scroll pane width after resizing
            	int scrollpane_new_width = scroll_pane.getWidth();
            	
            	
            	// iterate trough columns
            	for(int i=0 ; i<columns_number ; i++) {
            		
            		// old column width
            		int column_old_width = columns_widths[i];
            		
            		// width ratio
            		float width_ratio = column_old_width/original_columns_width_sum;
                	
            		// column new width
            		int column_new_width = (int)(width_ratio * scrollpane_new_width);
            	    
            		// set the new table's column width
            		getColumnModel().getColumn(i).setPreferredWidth(column_new_width-5);}
            		
            	
            	// cell font size ratio
        		float font_size_ratio = old_font_size/original_columns_width_sum;
        		
        		// new font size
        		int new_font_size = (int) (font_size_ratio * scrollpane_new_width);
        		
        		// set the new font size for all cell in the table
        		Font new_cell_font = new Font("Calibri", Font.PLAIN, new_font_size-5);
                setFont(new_cell_font);
                
                
                
                // header font size ratio
                float header_font_size_ratio = old_header_font_size/original_columns_width_sum;
                
                // new header font size
        		int new_header_font_size = (int) (header_font_size_ratio * scrollpane_new_width);
        		
        		// set the new header font size
        		
        		
        		if (scroll_pane.getWidth() > scrollpane_width_before_resizing) { // maximize
        			//if(new_header_font_size>5) {new_header_font_size = 5;};
        		    table_header.setFont(new Font("Segoe Print", Font.BOLD, new_header_font_size +5));
        		    
        		}

        		if (scroll_pane.getWidth() < scrollpane_width_before_resizing) { // minimize
        			if(new_header_font_size>20) {new_header_font_size = 20;};
        		    table_header.setFont(new Font("Segoe Print", Font.BOLD, new_header_font_size - 7));
        		    
        		    
        		}
        		
        		

        		
        		
        		
        		
        		

                
                
                
                
        		
            
            
            
            }});
        
                
        
        

        
        
        
        
        
        
        
        
                

     
        
		
		
		
	}

}
