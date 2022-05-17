package edu.vanier.pillarmen.weathermodels;
/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 12/11/2019
 */
public class AverageAnnualTemp {
    
    private String startingYear;
    private String endingYear;
    private double averageTemp;
    
    /**
     * Constructor with 3 parameters.
     * @param startingYear The starting year.
     * @param endingYear The ending year.
     * @param averageTemp The average temperature.
     */
    public AverageAnnualTemp(String startingYear, String endingYear, double averageTemp){
        setStartingYear(startingYear);
        setEndingYear(endingYear);
        setAverageAnnualTemp(averageTemp);
    }

    /**
     * Getter method for the starting year.
     * @return the starting year.
     */
    public String getStartingYear() {
        return startingYear;
    }

    /**
     * Setter method for the starting year.
     * @param startingYear the starting year to be set.
     */
    public void setStartingYear(String startingYear) {
        this.startingYear = startingYear;
    }

    /**
     * Getter method for the ending year.
     * @return the ending year.
     */
    public String getEndingYear() {
        return endingYear;
    }

    /**
     * Setter method for the ending year.
     * @param endingYear the ending year to be set.
     */
    public void setEndingYear(String endingYear) {
        this.endingYear = endingYear;
    }

    /**
     * Getter method for the average annual temperature.
     * @return the average annual temperature.
     */
    public double getAverageAnnualTemp() {
        return averageTemp;
    }

    /**
     * setter method for the average annual temperature.
     * @param averageTemp the average annual temperature to be set.
     */
    public void setAverageAnnualTemp(double averageTemp) {
        this.averageTemp = averageTemp;
    }
    @Override
    public String toString(){
        return "Average Annual Temperature from " + getStartingYear() + " to " + 
                getEndingYear() + " is " + getAverageAnnualTemp() + " degrees.";
    }
}