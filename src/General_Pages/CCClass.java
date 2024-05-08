package General_Pages;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CCClass extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Example");

        // Create a ComboBox with tree names
        ComboBox<String> treeComboBox = new ComboBox<>();
        treeComboBox.setItems(FXCollections.observableArrayList("Oak", "Pine", "Maple"));
        treeComboBox.setPromptText("Select a tree");

        // Define action when an item is selected from ComboBox
        treeComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedTree = treeComboBox.getSelectionModel().getSelectedItem();
                if (selectedTree != null) {
                    System.out.println("Selected tree: " + selectedTree);
                }
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(treeComboBox);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
