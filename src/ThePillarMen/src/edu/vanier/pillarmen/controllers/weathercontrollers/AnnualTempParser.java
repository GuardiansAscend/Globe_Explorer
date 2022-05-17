package edu.vanier.pillarmen.controllers.weathercontrollers;
import edu.vanier.pillarmen.weathermodels.AverageAnnualTemp;
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
public class AnnualTempParser {

    /**
     * Default Constructor.
     */
    public AnnualTempParser() {
    }

    /**
     * Parse method.
     * @param country The country.
     * @param fromYear The starting year.
     * @param toYear The ending year.
     * @return Returns an average annual temperature object.
     */
    public AverageAnnualTemp parseAverageAnnualTemp(String country, String fromYear, String toYear) {

        final String ANNUAL_TEMP = "annualData";

        AverageAnnualTemp averageAnnualTemp = null;
        String methodURL = "http://climatedataapi.worldbank.org/climateweb/rest/v1/country/annualavg/tas/"
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
                /*
                for (int i = 0; i < liveaArray.length(); i++) {
                    JSONObject object = liveaArray.getJSONObject(i);
                    JSONArray tempdude = object.getJSONArray(ANNUAL_TEMP);
                    double annualTemp = tempdude.getDouble(0);
                    System.out.println(annualTemp);
                }
                */
                liveaArray = new JSONArray(response);
                JSONObject object = liveaArray.getJSONObject(0);
                JSONArray tempdude = object.getJSONArray(ANNUAL_TEMP);
                double annualTemp = tempdude.getDouble(0);
                averageAnnualTemp = new AverageAnnualTemp(fromYear, toYear, annualTemp);

            } catch (JSONException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } catch (MalformedURLException me) {
            System.err.println(me.getMessage());

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            parseAverageAnnualTemp(country, fromYear, toYear);
        }
        return averageAnnualTemp;
    }
}