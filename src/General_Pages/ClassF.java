package General_Pages;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassF extends JFrame {

    public static void main(String[] args) { 
        // frame
        JFrame frame = new JFrame();

        // set the Layout to null for absolute control
        frame.setLayout(null);

        // Disable frame resizing
        frame.setResizable(false);

        // set the position and size
        frame.setBounds(200, 50, 900, 600);

        // create a panel
        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 800, 400);

        // create a JFXPanel
        JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setBounds(50, 450, 800, 100);

        // set background color for JavaFX panel
        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: red");

        // create JavaFX scene and add it to JFXPanel
        Scene scene = new Scene(stackPane, 800, 100);
        jfxPanel.setScene(scene);

        // add splash page-panel to the frame
        frame.getContentPane().add(panel);
        frame.getContentPane().add(jfxPanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
