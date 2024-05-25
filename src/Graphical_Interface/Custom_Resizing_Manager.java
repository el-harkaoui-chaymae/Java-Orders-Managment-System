package Graphical_Interface;

import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;


public class Custom_Resizing_Manager {
	
	// attributes
	ArrayList<Float> position_size_ratios = new ArrayList();
    ArrayList<Integer> font_size_ratios = new ArrayList();
	
	
		
	// constructor
	public Custom_Resizing_Manager(Container container) {
		
		 
		// handle frame resizing
		if (container instanceof JFrame) {
			
			JFrame conTainer = (JFrame) container;
			
	        conTainer.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                Component[] components = conTainer.getContentPane().getComponents();
	                for (Component component : components) {
	                    if (component instanceof JComponent) {
	                        
	                        // frame parameters after resizing
	                        int width_fa = conTainer.getWidth();
	                        int height_fa = conTainer.getHeight();
	                        
	                        // determine new  size
	                        int width_a = (width_fa);
	                        int height_a = (height_fa);

	                        // set new parameters for the component
	                        component.setBounds(0, 0, width_a, height_a);
	                        
	                
	                    }}}});
				
		}
		
		
		// handle panel resizing
		if (container instanceof JPanel ) {
			
			JPanel conTainer = (JPanel) container;
			
			// fill the ArrayLists with ratios
        	calculate_position_size_ratios(conTainer);
        	calculate_font_ratios(conTainer);
		
			
		    conTainer.addComponentListener(new ComponentAdapter() {

		            @Override
		            public void componentResized(ComponentEvent e) {
		            	
		            	
		            	
		            	// panel parameters after resizing
		                float width_fa = conTainer.getWidth();
		                float height_fa = conTainer.getHeight();
		                
		                int i = 0;
		                int k = 0;

		                Component[] components = conTainer.getComponents();
		                for (Component component : components) {
		                    
		                	// retrieve size and position ratios
		                    float cte1 = position_size_ratios.get(i);
		                    float cte2 = position_size_ratios.get(i+1);
		                    float cte3 = position_size_ratios.get(i+2);
		                    float cte4 = position_size_ratios.get(i+3);
		                    
		                    i += 4;
		                	
		                    // determine new position and size
		                	int x_a = (int)(cte1 * width_fa);
		                    int y_a = (int)(cte2 * height_fa);
		                    int width_a = (int)(cte3 * width_fa);
		                    int height_a = (int)(cte4 * height_fa);

		                    // set new parameters for the component
		                    component.setBounds(x_a, y_a, width_a+10, height_a);
		                    
		                    
		                    
		                    // check if the component has a font size
		                    if (component.getFont() != null) {
		                    
		                        // retrieve font size and surface before resizing 
		                        float old_font_size = font_size_ratios.get(k);
		                        float old_width = font_size_ratios.get(k+1);
		                        

		                        // determine new font size
		                        float new_size = (old_font_size*width_a)/old_width;
		                        
		                        // set the new font for the component
		                        Font currentFont = component.getFont();
		                        Font newFont = currentFont.deriveFont((float)new_size); 
		                        component.setFont(newFont);

		                    }
		                    
		                    k += 2 ;
		                    
		                 
		                    
		                }}});}}

			

	
	
	
	// --------- method to calculate size and position ratios
    public ArrayList<Float> calculate_position_size_ratios(JPanel panel) {
    	
        Component[] components = panel.getComponents(); 
        for (Component component : components) {
            Rectangle bounds = component.getBounds();
            
            
            // panel parameters before resizing
            float width_fb = panel.getWidth();
            float height_fb = panel.getHeight();
            
            // component parameter before resizing
            float x_b = bounds.x;
            float y_b = bounds.y;
            float width_b = bounds.width;
            float height_b = bounds.height;
            
            // constants
            float cte1 = x_b / width_fb;
            float cte2 = y_b / height_fb;
            float cte3 = width_b / width_fb;
            float cte4 = height_b / height_fb;
            
 
            position_size_ratios.add(cte1);
            position_size_ratios.add(cte2);
            position_size_ratios.add(cte3);
            position_size_ratios.add(cte4);}


            return position_size_ratios;}
    
    
    
   
    
    
    
    
    // --------- method to calculate font size ratios
    public ArrayList<Integer> calculate_font_ratios(JPanel panel) {
   	
       // Iterate through components and check if they have a font set
       for (Component component : panel.getComponents()) {
           if (component.getFont() != null) {
           	
           	 Rectangle bounds = component.getBounds();
           	
           	 int width = bounds.width;
       
           	 Font font = component.getFont();
             int font_size = font.getSize();
                               
             font_size_ratios.add(font_size);
             font_size_ratios.add(width);}}
       
       return font_size_ratios;}
	

}
