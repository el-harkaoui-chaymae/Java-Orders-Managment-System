package Graphical_Interface;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JComponent;
import javax.swing.JButton;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Dimension;



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
	float bf_resizing_columns_width_sum = 0;
	
	
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
                
                // change cell color
                if (row % 2 == 0) { 
                    setBackground(Color.decode("#F5F5F5"));
                    
                } else {
                    setBackground(table.getBackground());
                }
                
                if (isSelected) {
                    setBackground(table.getSelectionBackground());
                    setForeground(table.getSelectionForeground());
                }
                return this;
            }};
       
        // Set the custom left render to the table
        for (int j = 0; j < this.getColumnCount(); j++) {
            this.getColumnModel().getColumn(j).setCellRenderer(left_render);}
        
        
        
       
        
        
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
        

        // Customize the scrollbar appearance using BasicScrollBarUI
        scroll_pane.getVerticalScrollBar().setUI(new Custom_Scroll_Bar(false));
        scroll_pane.getHorizontalScrollBar().setUI(new Custom_Scroll_Bar(true));
        
        
        
        
        // the table before resizing length
        for(int i=0 ; i<columns_number ; i++) {
        	bf_resizing_columns_width_sum += columns_widths[i];}
        

    	// before resizing scroll pane width and height
    	int scrollpane_width_before_resizing = scroll_pane.getWidth();
    	int scrollpane_height_before_resizing = scroll_pane.getHeight();

    	
    	// cells original font size
    	int old_cell_font_size = cell_font_size;
    	
    	// header original font size
    	int old_header_font_size = header_font_size;
        
        
        
        // ---------Listen for resizing of the scroll pane
        scroll_pane.addComponentListener(new ComponentAdapter() {
        	
        
            @Override
            public void componentResized(ComponentEvent e) {
            	
            	// the scroll pane width and height after resizing
            	int scrollpane_new_width = scroll_pane.getWidth();
            	int scrollpane_new_height = scroll_pane.getHeight();

            	
            	
            	// iterate trough columns
            	for(int i=0 ; i<columns_number ; i++) {
            		
            		// old column width
            		float column_old_width = columns_widths[i];
                	
            		// column new width
            		int column_new_width = (int)((column_old_width*(scrollpane_new_width-17))/bf_resizing_columns_width_sum);
            		// set the new table's column width
            		getColumnModel().getColumn(i).setPreferredWidth(column_new_width);
            		
            		// new rows height
            		int row_new_height = (int)((row_height*(scrollpane_new_height))/scrollpane_height_before_resizing);
            		setRowHeight(row_new_height);
            		
            	       }
            	
            	    //---------------------	
            	
        		
        		    // new cells font size
        		    int new_font_size = (int)(old_cell_font_size*scrollpane_new_width)/scrollpane_width_before_resizing;   
        		
        		    // set the new font size for all cell in the table
        		    Font new_cell_font = new Font("Calibri", Font.PLAIN, new_font_size);
                    setFont(new_cell_font);
                
                    
                    //--------------------
                
                    // new header font size
                    int new_header_font_size = (int)(old_header_font_size*scrollpane_new_width)/scrollpane_width_before_resizing;        		
        		
                    // set the new header font size
        		    table_header.setFont(new Font("Segoe Print", Font.BOLD, new_header_font_size));
         
            }});
        
 
		
	}
	

}













//scroll bar class
class Custom_Scroll_Bar extends BasicScrollBarUI{
	
	// attribute
	public boolean horizontal_bar = false;
	
	// constructor
	public Custom_Scroll_Bar(boolean horizontal_bar) {
		this.horizontal_bar = horizontal_bar ;}
	
	
	
	// Set the color of the track
	@Override
  protected void configureScrollBarColors() {
  	this.trackColor = Color.WHITE; }
  
  
  
	
	// change the scroller shape and color
  @Override
  protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
      g.setColor(Color.decode("#b39700")); 
      if(horizontal_bar == false) {
      	g.fillRoundRect(thumbBounds.x+5, thumbBounds.y, thumbBounds.width-10, thumbBounds.height, 0, 0);}
      else {g.fillRoundRect(thumbBounds.x, thumbBounds.y+5, thumbBounds.width, thumbBounds.height-10, 0, 0);}
      
  }
  
  
  
  // set the size of the up bar button to 0
  @Override
  protected JButton createDecreaseButton(int orientation) {
      return new JButton() {
          @Override
          public Dimension getPreferredSize() {
              return new Dimension(0, 0);}};}
    

  
  // set the size of the down bar button to 0
  @Override
  protected JButton createIncreaseButton(int orientation) {
      return new JButton() {
          @Override
          public Dimension getPreferredSize() {
              return new Dimension(0, 0);}};}
  
	
	
	
}


