package edu.vanier.pillarmen.controllers.weathercontrollers;
import edu.vanier.pillarmen.weathermodels.AverageMonthlyTemp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 12/11/2019
 */
public class MonthlyTempParser {
    
    /**
     * Default constructor.
     */
    public MonthlyTempParser(){
    }
    
    /**
     * Parse method.
     * @param country The country.
     * @param fromYear The starting year.
     * @param toYear The ending year.
     * @return Returns an average monthly temperature object.
     */
    public AverageMonthlyTemp parseAverageMonthlyTemp(String country, String fromYear, String toYear) {

        final String MONTHLY_TEMP = "monthVals";

        AverageMonthlyTemp averageMonthlyTemp = null;
        String methodURL = "http://climatedataapi.worldbank.org/climateweb/rest/v1/country/mavg/tas/"
                + fromYear + "/" + toYear + "/" + country;
        try {
            String response;
            URL url = new URL(methodURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            InputStream in = conn.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            response = stringBuilder.toString();

            JSONArray liveaArray = null;
            try {
                liveaArray = new JSONArray(response);
                JSONObject object = liveaArray.getJSONObject(0);
                JSONArray tempdude = object.getJSONArray(MONTHLY_TEMP);
                double january = tempdude.getDouble(0);
                double february = tempdude.getDouble(1);
                double march = tempdude.getDouble(2);
                double april = tempdude.getDouble(3);
                double may = tempdude.getDouble(4);
                double june = tempdude.getDouble(5);
                double july = tempdude.getDouble(6);
                double august = tempdude.getDouble(7);
                double september = tempdude.getDouble(8);
                double october = tempdude.getDouble(9);
                double november = tempdude.getDouble(10);
                double december = tempdude.getDouble(11);
                averageMonthlyTemp = new AverageMonthlyTemp(fromYear, toYear, january,
                        february, march, april, may, june, july, august, september, 
                        october, november, december);
                
            } catch (JSONException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } catch (MalformedURLException me) {
            System.err.println(me.getMessage());

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            parseAverageMonthlyTemp(country, fromYear, toYear);
        }
        return averageMonthlyTemp;
    }
}