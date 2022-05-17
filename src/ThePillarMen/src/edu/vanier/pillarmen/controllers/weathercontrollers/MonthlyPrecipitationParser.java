package edu.vanier.pillarmen.controllers.weathercontrollers;
import edu.vanier.pillarmen.weathermodels.AverageMonthlyPrecipitation;
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
 * @since 14/11/2019
 */
public class MonthlyPrecipitationParser {
    
    /**
     * Default constructor with no parameters.
     */
    public MonthlyPrecipitationParser(){
    }
    
    /**
     * Parse method.
     * @param country The country.
     * @param fromYear The starting year.
     * @param toYear The ending year.
     * @return returns an Average Monthly Precipitation object.
     */
    public AverageMonthlyPrecipitation parseAverageMonthlyPre(String country, String fromYear, String toYear) {

        final String MONTHLY_TEMP = "monthVals";

        AverageMonthlyPrecipitation averageMonthlyPre = null;
        String methodURL = "http://climatedataapi.worldbank.org/climateweb/rest/v1/country/mavg/pr/"
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
                double januaryPre = tempdude.getDouble(0);
                double februaryPre = tempdude.getDouble(1);
                double marchPre = tempdude.getDouble(2);
                double aprilPre = tempdude.getDouble(3);
                double mayPre = tempdude.getDouble(4);
                double junePre = tempdude.getDouble(5);
                double julyPre = tempdude.getDouble(6);
                double augustPre = tempdude.getDouble(7);
                double septemberPre = tempdude.getDouble(8);
                double octoberPre = tempdude.getDouble(9);
                double novemberPre = tempdude.getDouble(10);
                double decemberPre = tempdude.getDouble(11);
                averageMonthlyPre = new AverageMonthlyPrecipitation(fromYear, toYear, januaryPre,
                        februaryPre, marchPre, aprilPre, mayPre, junePre, julyPre, augustPre, septemberPre, 
                        octoberPre, novemberPre, decemberPre);
                
            } catch (JSONException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } catch (MalformedURLException me) {
            System.err.println(me.getMessage());

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            parseAverageMonthlyPre(country, fromYear, toYear);
        }
        return averageMonthlyPre;
    }
}