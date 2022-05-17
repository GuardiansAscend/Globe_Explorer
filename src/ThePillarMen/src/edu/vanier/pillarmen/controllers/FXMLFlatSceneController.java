package edu.vanier.pillarmen.controllers;

import edu.vanier.pillarmen.controllers.weathercontrollers.AnnualTempParser;
import edu.vanier.pillarmen.controllers.weathercontrollers.MonthlyPrecipitationParser;
import edu.vanier.pillarmen.controllers.weathercontrollers.MonthlyTempParser;
import edu.vanier.pillarmen.weathermodels.AverageAnnualTemp;
import edu.vanier.pillarmen.weathermodels.AverageMonthlyPrecipitation;
import edu.vanier.pillarmen.weathermodels.AverageMonthlyTemp;
import edu.vanier.pillarmen.worldmap.Country;
import edu.vanier.pillarmen.worldmap.CountryPath;
import edu.vanier.pillarmen.worldmap.World;
import edu.vanier.pillarmen.worldmap.WorldBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kevin Scanlan
 */
public class FXMLFlatSceneController implements Initializable {

    @FXML
    private BorderPane secondBorderPane;
    @FXML
    private Button searchBarBtn;
    @FXML
    private Button btnGlobeScene;
    @FXML
    private RadioButton rdbCountryHighlight;
    @FXML
    private SubScene subSceneMap;
    private World world;
    private final String[] noInfoCountries = new String[]{"AX", "BL", "BQ", "BV", 
        "CW", "GO", "GS", "HM", "JU", "XK", "PM", "SS", "SX", "VA"};

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == searchBarBtn) {
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
        
        if(event.getSource() == btnGlobeScene) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLGlobeScene.fxml"));
            try {
                Parent root = loader.load();
                FXMLGlobeSceneController controller = loader.getController();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(controller.startGlobe());
                window.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLGlobeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(event.getSource() == rdbCountryHighlight) {
            if(rdbCountryHighlight.isSelected()) {
                for(Country country : Country.values()) {
                    boolean isBlacklist = false;
                    for(String noInfoCountry : noInfoCountries) {
                        if(noInfoCountry.equals(country.getName()))
                            isBlacklist = true;
                    }
                    if(isBlacklist) continue;
                    country.setColor(Color.YELLOW);
                    List<CountryPath> countryPaths = world.getCountryPaths().get(country.getName());
                    for(CountryPath path : countryPaths) {
                        path.setFill(Color.YELLOW);
                    }
                }
            }
            else {
                for(Country country : Country.values()) {
                    country.setColor(Color.rgb(217, 217, 220));
                    List<CountryPath> countryPaths = world.getCountryPaths().get(country.getName());
                    for(CountryPath path : countryPaths) {
                        path.setFill(Color.rgb(217, 217, 220));
                    }
                }
            }
        }
    }
    
    /**
     * Method to start the flat map where regions can be accessed.
     * @return the flat map scene.
     * @throws FileNotFoundException Exception where the file isn't found.
     */
    public Scene startFlatMap() throws FileNotFoundException{
        world = WorldBuilder.create()
                            .resolution(World.Resolution.HI_RES)
                            .mousePressHandler(evt -> {
                                boolean isBlacklist = false;
                                CountryPath countryPath = (CountryPath) evt.getSource();
                                Locale      locale      = countryPath.getLocale();
                                try {
                                    System.out.println(locale.getDisplayCountry() + " (" + locale.getISO3Country() + ")");
                                } catch (MissingResourceException e) {
                                    System.out.println("Kosovo (RKS)");
                                }
                                
                                for(String noInfoCountry : noInfoCountries) {
                                    if(noInfoCountry.equals(countryPath.getName())) {
                                        isBlacklist = true;
                                    }
                                }
                                if(!isBlacklist){
                                    //example of API call, printed to console
                                    MonthlyPrecipitationParser precipitation = new MonthlyPrecipitationParser();
                                    AverageMonthlyPrecipitation monthlyPre = precipitation.parseAverageMonthlyPre(locale.getISO3Country(), "1980", "1999");
                                    MonthlyTempParser temperatureMonthly = new MonthlyTempParser();
                                    AverageMonthlyTemp monthlyTemp = temperatureMonthly.parseAverageMonthlyTemp(locale.getISO3Country(), "1980", "1999");
                                    AnnualTempParser temperatureAnnual = new AnnualTempParser();
                                    AverageAnnualTemp annualTemp = temperatureAnnual.parseAverageAnnualTemp(locale.getISO3Country(), "1980", "1999");
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLDataResults.fxml"));
                                    try {
                                        Parent root = loader.load();
                                        FXMLDataResultsController controller = loader.<FXMLDataResultsController>getController();
                                        controller.initData(annualTemp, monthlyTemp, monthlyPre);
                                        Scene sceneTwo = new Scene(root);
                                        Stage window = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                                        window.setScene(sceneTwo);
                                        window.show();
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLFlatSceneController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                }
                            })
                            .zoomEnabled(true)
                            .selectionEnabled(true)
                            .build();
        
        for (Country country : Country.values()) {
            try {
                String iso3Key = new Locale("", country.name()).getISO3Country();
            } catch (MissingResourceException e) {}
        }
        
        StackPane pane = new StackPane(world);
        pane.setBackground(new Background(new BackgroundFill(world.getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        subSceneMap = new SubScene(pane, 1000, 550);
        
        secondBorderPane.setCenter(subSceneMap);
        Scene scene = new Scene(secondBorderPane, 1000, 700);
        
        return scene;
    }
}
