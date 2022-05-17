package edu.vanier.pillarmen.globemodel;

/**
 * CountryModel class
 * @author Benjamin  Zitella
 */
public class CountryModel {
    private String country;
    private String capital;
    private String iso2Code;
    
    /**
     * Default constructor
     */
    public CountryModel(){
        this.country = "";
        this.capital = "";
    }

    /**
     * Constructor with 2 parameters
     * @param country the country
     * @param capital the capital of the country
     * @param iso2Code
     */
    public CountryModel(String country, String capital, String iso2Code){
        this.country = country;
        this.capital = capital;
        this.iso2Code = iso2Code;
    }

    /**
     * getter method for the country
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * getter method for the capital
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * getter method for the iso2Code
     * @return the iso2Code
     */
    public String getIso2Code() {
        return iso2Code;
    }
    

    /**
     * setter method for the country
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * setter method for the capital
     * @param capital the capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * setter method for iso2Code
     * @param iso2Code
     */
    public void setIso2Code(String iso2Code) {
        this.iso2Code = iso2Code;
    }
    

    @Override
    public String toString() {
        return "CountryModel:" + "/ncountry:" + country + ", /ncapital:" + capital + '}';
    }
    
}
