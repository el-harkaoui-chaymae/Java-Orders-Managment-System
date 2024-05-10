package Graphical_Interface;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

public class Custom_ComboBox extends JComboBox<String> {

    // attributes
    int x;
    int y;
    int width;
    int height;
    int font_size;
    String[] options;

    // constructor
    public Custom_ComboBox(int x, int y, int width, int height,int font_size, String[] options) {
        
    	// set the comboBox options
        super(options);

        // Set default selected option
        this.setSelectedIndex(0);

        // positionate the comboBox
        this.setBounds(x, y, width, height);
        
        // Set the background color to white
        this.setBackground(Color.WHITE);
        
        // Set custom renderer
        setRenderer(new CustomComboBoxRenderer());

        // Set opaque property to true
        this.setOpaque(true);
        
        // set the font style
        this.setFont(new Font("Segoe Print", Font.BOLD, font_size));
        
        
        // Set look and feel to default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
    }

    // Custom renderer class
    class CustomComboBoxRenderer extends javax.swing.plaf.basic.BasicComboBoxRenderer {
        public java.awt.Component getListCellRendererComponent(javax.swing.JList list, Object value, int index, 
        		                                               boolean isSelected, boolean cellHasFocus) {
            java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (isSelected) {
                this.setBackground(Color.decode("#2F5597"));
                this.setForeground(Color.decode("#FFFFFF"));
                
            } else {
            	this.setBackground(Color.WHITE);
            }
            
            return this;
        }
        
        
    }
}
