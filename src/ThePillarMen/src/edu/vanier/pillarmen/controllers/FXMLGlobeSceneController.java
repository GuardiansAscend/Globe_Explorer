package edu.vanier.pillarmen.controllers;
import edu.vanier.pillarmen.globemodel.GlobeGenerator;
import edu.vanier.pillarmen.globemodel.GlobeGenerator.EarthGroup;
import edu.vanier.pillarmen.util.Spinner;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Gianni Coladonato
 * @version 1.0
 * @since 12/11/2019
 * Special thanks to Kevin for helping with this scene :D
 */
public class FXMLGlobeSceneController implements Initializable {

    private static final float WIDTH = 1000;
    private static final float HEIGHT = 700;

    /**
     *
     */
    @FXML
    public SubScene subGlobeScene;
    
    @FXML
    private BorderPane firstBorderPane;
    @FXML
    private Button searchBarBtn;
    @FXML
    private Button btnFlatView;
    @FXML
    private VBox vbBottomLayout;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == searchBarBtn) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLSearchBar.fxml"));
            try {
                Parent root = loader.load();
                Scene sceneOne = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(sceneOne);
                window.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLGlobeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(event.getSource() == btnFlatView) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLFlatScene.fxml"));
            try {
                Parent root = loader.load();
                FXMLFlatSceneController controller = loader.getController();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(controller.startFlatMap());
                window.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLGlobeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Method to start the globe.
     * @return the globe scene.
     */
    public Scene startGlobe(){
        GlobeGenerator g1 = new GlobeGenerator();
        Group root = new Group();
        Spinner earthSpinner = new Spinner();
        
        EarthGroup world = g1.createGlobe();
        Slider zoomSlider = g1.prepareSlider();
        
        root.getChildren().addAll(world);
        g1.bindSlider(world, zoomSlider);
        vbBottomLayout.getChildren().add(zoomSlider);
        
        subGlobeScene = new SubScene(root, WIDTH, HEIGHT - 150, true, SceneAntialiasing.BALANCED);
        subGlobeScene.setCamera(g1.cameraConfig()); 
          
        
        firstBorderPane.setCenter(subGlobeScene);
        Scene scene = new Scene(firstBorderPane, WIDTH, HEIGHT);
        earthSpinner.initMouseControl(world, scene);
        return scene;
    }
    
    /**
     * Method to find the coordinates on a globe.
     * @param angleX the x-coordinate.
     * @param angleY the y-coordinate.
     * @return the scene of the globe.
     */
    public Scene findOnGlobe(double angleX, double angleY){
        GlobeGenerator g1 = new GlobeGenerator();
        Group root = new Group();
        Spinner earthSpinner = new Spinner();
        
        EarthGroup world = g1.createGlobe();
        Slider zoomSlider = g1.prepareSlider();
        
        root.getChildren().addAll(world);
        g1.bindSlider(world, zoomSlider);
        vbBottomLayout.getChildren().add(zoomSlider);
        zoomSlider.setValue(zoomSlider.getMin());
        
        subGlobeScene = new SubScene(root, WIDTH, HEIGHT - 150, true, SceneAntialiasing.BALANCED);
        subGlobeScene.setCamera(g1.cameraConfig()); 
         
        
        firstBorderPane.setCenter(subGlobeScene);
        Scene scene = new Scene(firstBorderPane, WIDTH, HEIGHT);
        earthSpinner.initMouseControl(world, scene);
        earthSpinner.angleX.set(angleX);
        earthSpinner.angleY.set(angleY);
        return scene;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }       
}
