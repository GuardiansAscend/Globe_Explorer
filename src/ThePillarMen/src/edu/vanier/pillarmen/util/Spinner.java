package edu.vanier.pillarmen.util;
import edu.vanier.pillarmen.globemodel.GlobeGenerator;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.transform.Rotate;
/**
 * This class gives a sphere the ability to rotate upon mouse drag.
 * @author Gianni Coladonato
 * @version 1.0
 * @since 31/10/2019
 * Javadoc by Kevin Scanlan on 03/11/2019
 */
public class Spinner {
    
    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    public final DoubleProperty angleX = new SimpleDoubleProperty(0);
    public final DoubleProperty angleY = new SimpleDoubleProperty(0);

    /**
     * Default constructor for the Spinner object
     */
    public Spinner(){
    
    }
    
    /**
     * Method that initiates the spinning of the sphere with mouse drags.
     * @param group The group that contains the sphere to be rotated
     * @param scene The scene that the sphere is located in
     */
    public void initMouseControl(GlobeGenerator.EarthGroup group, Scene scene){
        Rotate xRotate;
        Rotate yRotate;

        group.getTransforms().addAll(
            xRotate = new Rotate(0, Rotate.X_AXIS),
            yRotate = new Rotate(0, Rotate.Y_AXIS)
        );

    xRotate.angleProperty().bind(angleX);
    yRotate.angleProperty().bind(angleY);  

    scene.setOnMousePressed(event -> {
        anchorX = event.getSceneX();
        anchorY = event.getSceneY();
        anchorAngleX = angleX.get();
        anchorAngleY = angleY.get();
    });

    scene.setOnMouseDragged(event -> {
       angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
	   angleY.set(anchorAngleY - (anchorX + event.getSceneX()));
    });
   }
}