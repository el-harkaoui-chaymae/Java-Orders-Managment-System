package Graphical_Interface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Custom_Button extends JButton {
	
	// attributes
	public int x;
	public int y;
	public int width;
	public int height;
	String text ;
    
    // Constructor
    public Custom_Button(int x,int y,int width, int height,String text) {
        
    	// Call the superclass constructor
        super(text);
        
        // set the attributes
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        
        // Remove the default button styles
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(false);        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Set the button text and style
        this.setText(text);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setForeground(new Color(255, 255, 255));
        this.setFont(new Font("consolas", Font.BOLD, 20));
        
        // set the button
        this.setBounds(x,y,width,height);
        
        
        // Add ActionListener for button sound effect
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playButtonSound(); 
            }
        });
        
         
        
    }

    // Method to paint the button with gradient fill
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define the rounded rectangle shape
        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 50, 50);
        
        // Fill the shape with the gradient paint
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#19566B"), getWidth(), getHeight(), Color.decode("#b39700"));
        g2.setPaint(gradient);
        g2.fill(shape);

        // Call superclass method to ensure default painting (including text)   
        super.paintComponent(g);
    }

    
    // Method to play button sound effect
    private void playButtonSound() {
        try {
            File soundFile = new File("click_sound.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}