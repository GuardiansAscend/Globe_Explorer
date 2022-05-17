package edu.vanier.pillarmen.weathermodels;
/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 14/11/2019
 */
public class AverageMonthlyPrecipitation {
    private String startingYear;
    private String endingYear;
    private double januaryPre;
    private double februaryPre;
    private double marchPre;
    private double aprilPre;
    private double mayPre;
    private double junePre;
    private double julyPre;
    private double augustPre;
    private double septemberPre;
    private double octoberPre;
    private double novemberPre;
    private double decemberPre;
    
    /**
     * Constructor with all parameters.
     * @param startingYear The starting year.
     * @param endingYear The ending year.
     * @param januaryPre The January precipitation.
     * @param februaryPre The February precipitation.
     * @param marchPre The March precipitation.
     * @param aprilPre The April precipitation.
     * @param mayPre The May precipitation.
     * @param junePre The June precipitation.
     * @param julyPre The July precipitation.
     * @param augustPre The August precipitation.
     * @param septemberPre The September precipitation.
     * @param octoberPre The October precipitation.
     * @param novemberPre The November precipitation.
     * @param decemberPre The December Precipitation.
     */
    public AverageMonthlyPrecipitation(String startingYear, String endingYear, double januaryPre, 
            double februaryPre, double marchPre, double aprilPre, double mayPre,
            double junePre, double julyPre, double augustPre, double septemberPre,
            double octoberPre, double novemberPre, double decemberPre){
        setStartingYear(startingYear);
        setEndingYear(endingYear);
        setJanuaryPre(januaryPre);
        setFebruaryPre(februaryPre);
        setMarchPre(marchPre);
        setAprilPre(aprilPre);
        setMayPre(mayPre);
        setJunePre(junePre);
        setJulyPre(julyPre);
        setAugustPre(augustPre);
        setSeptemberPre(septemberPre);
        setOctoberPre(octoberPre);
        setNovemberPre(novemberPre);
        setDecemberPre(decemberPre);
    }
        
    /**
     * Getter method for the starting year.
     * @return The starting year.
     */
    public String getStartingYear() {
        return startingYear;
    }

    /**
     * Setter method for the starting year.
     * @param startingYear The starting year to be set.
     */
    public void setStartingYear(String startingYear) {
        this.startingYear = startingYear;
    }

    /**
     * Getter method for the ending year.
     * @return The ending year.
     */
    public String getEndingYear() {
        return endingYear;
    }

    /**
     * Setter method for the ending year.
     * @param endingYear The ending year to be set.
     */
    public void setEndingYear(String endingYear) {
        this.endingYear = endingYear;
    }

    /**
     * Getter method for January Precipitation.
     * @return The January Precipitation.
     */
    public double getJanuaryPre() {
        return januaryPre;
    }

    /**
     * Setter method for the January precipitation.
     * @param januaryPre The January precipitation to be set.
     */
    public void setJanuaryPre(double januaryPre) {
        this.januaryPre = januaryPre;
    }

    /**
     * Getter method for the February precipitation.
     * @return The February precipitation.
     */
    public double getFebruaryPre() {
        return februaryPre;
    }

    /**
     * Setter method the February precipitation.
     * @param februaryPre The February precipitation to be set.
     */
    public void setFebruaryPre(double februaryPre) {
        this.februaryPre = februaryPre;
    }

    /**
     * The getter method for the March precipitation.
     * @return The March Precipitation.
     */
    public double getMarchPre() {
        return marchPre;
    }

    /**
     * The setter method for the March precipitation.
     * @param marchPre The March precipitation to be set.
     */
    public void setMarchPre(double marchPre) {
        this.marchPre = marchPre;
    }

    /**
     * Getter method for the April precipitation.
     * @return The April precipitation.
     */
    public double getAprilPre() {
        return aprilPre;
    }

    /**
     * Setter method for the April precipitation.
     * @param aprilPre The April precipitation to be set.
     */
    public void setAprilPre(double aprilPre) {
        this.aprilPre = aprilPre;
    }

    /**
     * Getter method for the May precipitation.
     * @return The May precipitation.
     */
    public double getMayPre() {
        return mayPre;
    }

    /**
     * Setter method for the May precipitation.
     * @param mayPre The May precipitation to be set.
     */
    public void setMayPre(double mayPre) {
        this.mayPre = mayPre;
    }

    /**
     * Getter method for the June precipitation.
     * @return The June precipitation.
     */
    public double getJunePre() {
        return junePre;
    }

    /**
     * Setter method for the June precipitation.
     * @param junePre The June precipitation to be set.
     */
    public void setJunePre(double junePre) {
        this.junePre = junePre;
    }

    /**
     * Getter method for the July precipitation.
     * @return The July precipitation.
     */
    public double getJulyPre() {
        return julyPre;
    }

    /**
     * Setter method for the July precipitation.
     * @param julyPre The July precipitation to be set.
     */
    public void setJulyPre(double julyPre) {
        this.julyPre = julyPre;
    }

    /**
     * Getter method for the August precipitation.
     * @return The August precipitation.
     */
    public double getAugustPre() {
        return augustPre;
    }

    /**
     * Setter method for the August precipitation.
     * @param augustPre The August precipitation to be set.
     */
    public void setAugustPre(double augustPre) {
        this.augustPre = augustPre;
    }

    /**
     * Getter method for the September precipitation.
     * @return The September precipitation.
     */
    public double getSeptemberPre() {
        return septemberPre;
    }

    /**
     * Setter method for the September precipitation.
     * @param septemberPre The September precipitation to be set. 
     */
    public void setSeptemberPre(double septemberPre) {
        this.septemberPre = septemberPre;
    }

    /**
     * Getter method for the October precipitation.
     * @return The October precipitation.
     */
    public double getOctoberPre() {
        return octoberPre;
    }

    /**
     * Setter method for the October precipitation.
     * @param octoberPre The October precipitation to be set.  
     */
    public void setOctoberPre(double octoberPre) {
        this.octoberPre = octoberPre;
    }

    /**
     * Getter method for the November precipitation.
     * @return The November precipitation.
     */
    public double getNovemberPre() {
        return novemberPre;
    }

    /**
     * Setter method for the November precipitation.
     * @param novemberPre The November precipitation to be set.  
     */
    public void setNovemberPre(double novemberPre) {
        this.novemberPre = novemberPre;
    }

    /**
     * Getter method for the December precipitation.
     * @return The December precipitation.
     */
    public double getDecemberPre() {
        return decemberPre;
    }

    /**
     * Setter method for the December precipitation.
     * @param decemberPre The December precipitation to be set.  
     */
    public void setDecemberPre(double decemberPre) {
        this.decemberPre = decemberPre;
    }
    
    @Override
    public String toString(){
        return "Average Monthly Precipitation from " + getStartingYear() + " to " +
                getEndingYear() + " are :\nJanuary : " + getJanuaryPre() + 
                "\nFebruary : " + getFebruaryPre() + "mm" + 
                "\nMarch : " + getMarchPre()  + "mm" + 
                "\nApril : " + getAprilPre()  + "mm" + 
                "\nMay : " + getMayPre() + "mm" + 
                "\nJune : " + getJunePre() + "mm" + 
                "\nJuly : " + getJulyPre() + "mm" + 
                "\nAugust : " + getAugustPre() +"mm" + 
                "\nSeptember : " + getSeptemberPre() + "mm" + 
                "\nOctober : " + getOctoberPre() + "mm" + 
                "\nNovember : " + getNovemberPre() + "mm" + 
                "\nDecember : " + getDecemberPre() + "mm" + "\n";
    }
}