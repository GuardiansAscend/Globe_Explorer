package edu.vanier.pillarmen.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author Gianni Coladonato
 * @version 1.0
 * @since 12/11/2019
 * Original Menu by : Kevin Scanlan
 */
public class FXMLMainMenuController implements Initializable {

    @FXML
    private Button btnLaunch;
    
    @FXML
    private Button btnClose;
    
    /**
     * Method to launch the application.
     * @param event an action event to trigger the application.
     * @throws IOException Possibility of IO Exception.
     */
    @FXML
    public void launchApplication(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLGlobeScene.fxml"));
        Parent root = loader.load();
        FXMLGlobeSceneController controller = loader.getController();
                
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(controller.startGlobe());
        window.show();
    }
    
    /**
     * Method to close the application on the main menu page.
     * @param event action event to close the application.
     */
    @FXML
    public void closeMenu(ActionEvent event){
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}