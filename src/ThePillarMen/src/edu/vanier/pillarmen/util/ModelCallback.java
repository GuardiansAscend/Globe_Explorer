package edu.vanier.pillarmen.util;

import edu.vanier.pillarmen.weathermodels.AverageMonthlyTemp;
import java.util.function.Function;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 * Callback class to help with data organization.
 * @author Benjamin Zitella
 */
public class ModelCallback implements Callback<TableColumn.CellDataFeatures<AverageMonthlyTemp, String>, ObservableValue<String>>  {
    
    private Function<AverageMonthlyTemp,Object> extractor;

    public ModelCallback(Function<AverageMonthlyTemp,Object> extractorFunction) {
        extractor = extractorFunction;
    }

    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<AverageMonthlyTemp, String> cellData) {
        return new SimpleObjectProperty(extractor.apply(cellData.getValue()));
    }
}
