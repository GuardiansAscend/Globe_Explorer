package edu.vanier.pillarmen.controllers;

import edu.vanier.pillarmen.weathermodels.AverageAnnualTemp;
import edu.vanier.pillarmen.weathermodels.AverageMonthlyPrecipitation;
import edu.vanier.pillarmen.weathermodels.AverageMonthlyTemp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Data Results Controller class
 *
 * @author Benjamin Zitella
 */
public class FXMLDataResultsController implements Initializable {
    @FXML
    private Button returnBtn; 
    @FXML
    private Button returnFlatBtn;
    @FXML
    private Label valueLbl;
    @FXML
    private Label monthlyTempLbl;
    @FXML
    private Label monthlyPrecipLbl;
    @FXML
    private ListView<String> monthlyTempListView;
    @FXML
    private ListView<String> monthlyPrecipListView;
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleReturnButton(ActionEvent event) throws IOException {
        if (event.getSource() == returnBtn) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLSearchBar.fxml"));
            try {
                Parent root = loader.load();
                Scene sceneOne = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(sceneOne);
                window.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDataResultsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (event.getSource() == returnFlatBtn){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLFlatScene.fxml"));
            Parent root = loader.load();
            FXMLFlatSceneController controller = loader.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(controller.startFlatMap());
            window.show();
        }
    }

    /**
     * method to transfer data from the previous controller into this one.
     * @param annualTemp The average annual temperature.
     * @param monthlyTemp The monthly temperature.
     * @param precip The monthly precipitation.
     */
    public void initData(AverageAnnualTemp annualTemp, AverageMonthlyTemp monthlyTemp, AverageMonthlyPrecipitation precip) {
        valueLbl.setText(annualTemp.toString());
        ObservableList<String> list = FXCollections.observableArrayList(monthlyTemp.toString());
        ObservableList<String> precipList = FXCollections.observableArrayList(precip.toString());
        monthlyTempListView.setItems(list);
        monthlyPrecipListView.setItems(precipList);
    }

}
