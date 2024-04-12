package Graphical_Interface;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Custom_Panel extends JPanel {

    // attributes
    String type;
    public int x; 
    public int y;
    public int width;
    public int height;
    public String color;
    public Image backgroundImage;
    public ArrayList<Float> position_size_ratios = new ArrayList();
    public ArrayList<Integer> font_size_ratios = new ArrayList();

    // Constructor 
    public Custom_Panel(int x, int y, int width, int height, String color) {
        // set the attributes
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;  
        this.color = color; 
        

        // Set layout 
        this.setLayout(null);

        // Set background color
        this.setBackground(Color.decode(color));


        // Set panel position
        this.setLocation(x, y);

        // Set panel size
        this.setSize(width, height);

    }
    
    // method to add image background
    public void add_background(String image_path) {
    	
        // Start a new thread to load the image
           new Thread(() -> {
               try { 
            	   backgroundImage = ImageIO.read(new File(image_path));
                   repaint();}
               catch (IOException e) {e.printStackTrace();}
               
           }).start(); 
    }

    // repaint the image to fit the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        repaint();

    }
    
    
    
    
    // method to calculate size and position ratios
    public ArrayList<Float> calculate_position_size_ratios() {
    	
        Component[] components = getComponents(); 
        for (Component component : components) {
            Rectangle bounds = component.getBounds();
            
            // panel parameters before resizing
            float width_fb = getWidth();
            float height_fb = getHeight();
            
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
    
    
    
    
     // method to calculate font size ratios
     public ArrayList<Integer> calculate_font_ratios() {
    	
        // Iterate through components and check if they have a font set
        for (Component component : getComponents()) {
            if (component.getFont() != null) {
            	
            	Rectangle bounds = component.getBounds();
            	
            	int width = bounds.width;
            	float height = bounds.height;
        
            	Font font = component.getFont();
                int font_size = font.getSize();
                                
                font_size_ratios.add(font_size);
                font_size_ratios.add(width);}}
        
        return font_size_ratios;}
        
  
 

    // method to handle resizing
    public void hundle_resizing(ArrayList<Float> array1, ArrayList<Integer> array2) { 
    	 	
    this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
            	
            	// panel parameters after resizing
                float width_fa = getWidth();
                float height_fa = getHeight();
                
                int i = 0;
                int k = 0;

                Component[] components = getComponents();
                for (Component component : components) {
                    
                	// retrieve size and position ratios
                    float cte1 = array1.get(i);
                    float cte2 = array1.get(i+1);
                    float cte3 = array1.get(i+2);
                    float cte4 = array1.get(i+3);
                    
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
                        float font_size = array2.get(k);
                        float old_width = array2.get(k+1);
                        

                        // determine new font size
                        float new_size = (font_size*width_a)/old_width;
                        
                        // set the new font for the component
                        Font currentFont = component.getFont();
                        Font newFont = currentFont.deriveFont((float)new_size); 
                        component.setFont(newFont);

                    }
                    
                    k += 2 ;
                    
                 
                    
                }}});}
}
