package edu.vanier.pillarmen.globemodel;
import edu.vanier.pillarmen.AppMain;
import edu.vanier.pillarmen.util.FileHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

/**
 * The model/generator for the 3D Globe as well as the model for the zoom slider
 * and camera.
 * 
 * @author Benjamin Zitella
 * @version 1.0
 * @since 22/10/2019
 * 
 * Edited by Gianni Coladonato 27/10/2019
 * Last Edited by Kevin Scanlan 03/11/2019
 */
public class GlobeGenerator {
    
    private final String EARTH_IMAGE_FILE = "resources/images/earth.png";
     
    /**
     * Default constructor for the Globe Generator.
     */
    public GlobeGenerator(){
        
    }

    /**
     * Method that puts all the components of the globe together.
     * @return An EarthGroup with a completed globe in it.
     */
    public EarthGroup createGlobe(){
        EarthGroup world = new EarthGroup();
        world.getChildren().add(formulateEarth());
        return world;
    }
    
    //Bind the slider to the translate Z property of the 3D Globe

    /**
     * Method that binds the slider to the globe, so that we can zoom in and out.
     * @param world Our globe
     * @param zoomSlider The slider for zooming
     */
    public void bindSlider(EarthGroup world, Slider zoomSlider) {
        world.translateZProperty().bind(zoomSlider.valueProperty());
    }
    
    /**
     * Method that configurates the camera for our globe.
     * @return The camera used to observe our globe.
     */
    public Camera cameraConfig() {
        Camera mainCamera = new PerspectiveCamera(true);
        mainCamera.setNearClip(1);
        mainCamera.setFarClip(10000);
        mainCamera.translateZProperty().set(-1000);
        return mainCamera;
    }

    /**
     * Method where sphere is made with the map of the earth on it.
     * @return A sphere that looks like an earth
     */
    public Node formulateEarth() { //this is where we make our sphere
        PhongMaterial earthMaterial = new PhongMaterial();
        File earthImageFile = FileHelper.getAbsolutePath(EARTH_IMAGE_FILE);
        // For logging purposes.        
        String absolutePath = earthImageFile.getAbsolutePath();        
        System.out.println(""+ absolutePath);
        try { 
            earthMaterial.setDiffuseMap(new Image(new FileInputStream(earthImageFile)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sphere sphere = new Sphere(150);
        sphere.setMaterial(earthMaterial);
        return sphere;
    }

    /**
     * Class were we define the properties of our globe.
     */
    public class EarthGroup extends Group { //bundles everything up into an observablelist

        Rotate r;
        Transform t = new Rotate();

        /**
         * Method where we create X-axis rotation for the globe.
         * @param angle The angle of our rotation in degrees
         */
        public void rotationX(int angle) {
            r = new Rotate(angle, Rotate.X_AXIS);
            t = t.createConcatenation(r); //learn this
            this.getTransforms().clear();
            this.getTransforms().addAll(t); //get transforms defines the ObservableList
        }

        /**
         * Method where we create Y-axis rotation for the globe.
         * @param angle The angle of our rotation in degrees
         */
        public void rotationY(int angle) {
            r = new Rotate(angle, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }

    /**
     * Method where we make a slider so we can implement a zoom feature.
     * @return The slider for the zoom feature.
     */
    public Slider prepareSlider() {
        Slider zoomSlider = new Slider();
        zoomSlider.setMax(350);
        zoomSlider.setMin(-350);
        zoomSlider.setPrefWidth(350);
        zoomSlider.setLayoutX(-300);
        zoomSlider.setLayoutY(200);
        return zoomSlider;
    }
}