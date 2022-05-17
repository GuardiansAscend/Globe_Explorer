package edu.vanier.pillarmen;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author Benjamin Zitella
 * @version 1.0
 * @since 22/10/2019
 * Last Edited by: Gianni Coladonato, 12/11/2019
 */
public class AppMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {   
        Parent root = FXMLLoader.load(getClass().getResource("ui/FXMLMainMenu.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Region Explorer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
