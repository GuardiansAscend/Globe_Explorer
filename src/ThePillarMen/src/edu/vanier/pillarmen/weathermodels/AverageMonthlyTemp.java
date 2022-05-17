package edu.vanier.pillarmen.weathermodels;
/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 12/11/2019
 */
public class AverageMonthlyTemp{
    
     private String startingYear;
    private String endingYear;
    private double januaryTemp;
    private double februaryTemp;
    private double marchTemp;
    private double aprilTemp;
    private double mayTemp;
    private double juneTemp;
    private double julyTemp;
    private double augustTemp;
    private double septemberTemp;
    private double octoberTemp;
    private double novemberTemp;
    private double decemberTemp;
    
    /**
     * Constructor with all data members.
     * @param startingYear The Starting year. 
     * @param endingYear The ending year.
     * @param januaryTemp The January Temperature.
     * @param februaryTemp The February Temperature.
     * @param marchTemp The March Temperature.
     * @param aprilTemp The April Temperature.
     * @param mayTemp The May Temperature.
     * @param juneTemp The June Temperature.
     * @param julyTemp The July Temperature.
     * @param augustTemp The August Temperature.
     * @param septemberTemp The September Temperature.
     * @param octoberTemp The October Temperature.
     * @param novemberTemp The November Temperature.
     * @param decemberTemp The December Temperature.
     */
    public AverageMonthlyTemp(String startingYear, String endingYear, double januaryTemp, 
            double februaryTemp, double marchTemp, double aprilTemp, double mayTemp,
            double juneTemp, double julyTemp, double augustTemp, double septemberTemp,
            double octoberTemp, double novemberTemp, double decemberTemp){
        setStartingYear(startingYear);
        setEndingYear(endingYear);
        setJanuaryTemp(januaryTemp);
        setFebruaryTemp(februaryTemp);
        setMarchTemp(marchTemp);
        setAprilTemp(aprilTemp);
        setMayTemp(mayTemp);
        setJuneTemp(juneTemp);
        setJulyTemp(julyTemp);
        setAugustTemp(augustTemp);
        setSeptemberTemp(septemberTemp);
        setOctoberTemp(octoberTemp);
        setNovemberTemp(novemberTemp);
        setDecemberTemp(decemberTemp);
    }
        
    /**
     *
     * @return
     */
    public String getStartingYear() {
        return startingYear;
    }

    /**
     *
     * @param startingYear
     */
    public void setStartingYear(String startingYear) {
        this.startingYear = startingYear;
    }

    /**
     *
     * @return
     */
    public String getEndingYear() {
        return endingYear;
    }

    /**
     *
     * @param endingYear
     */
    public void setEndingYear(String endingYear) {
        this.endingYear = endingYear;
    }

    /**
     *
     * @return
     */
    public double getJanuaryTemp() {
        return januaryTemp;
    }

    /**
     *
     * @param januaryTemp
     */
    public void setJanuaryTemp(double januaryTemp) {
        this.januaryTemp = januaryTemp;
    }

    /**
     *
     * @return
     */
    public double getFebruaryTemp() {
        return februaryTemp;
    }

    /**
     *
     * @param februaryTemp
     */
    public void setFebruaryTemp(double februaryTemp) {
        this.februaryTemp = februaryTemp;
    }

    /**
     *
     * @return
     */
    public double getMarchTemp() {
        return marchTemp;
    }

    /**
     *
     * @param marchTemp
     */
    public void setMarchTemp(double marchTemp) {
        this.marchTemp = marchTemp;
    }

    /**
     *
     * @return
     */
    public double getAprilTemp() {
        return aprilTemp;
    }

    /**
     *
     * @param aprilTemp
     */
    public void setAprilTemp(double aprilTemp) {
        this.aprilTemp = aprilTemp;
    }

    /**
     *
     * @return
     */
    public double getMayTemp() {
        return mayTemp;
    }

    /**
     *
     * @param mayTemp
     */
    public void setMayTemp(double mayTemp) {
        this.mayTemp = mayTemp;
    }

    /**
     *
     * @return
     */
    public double getJuneTemp() {
        return juneTemp;
    }

    /**
     *
     * @param juneTemp
     */
    public void setJuneTemp(double juneTemp) {
        this.juneTemp = juneTemp;
    }

    /**
     *
     * @return
     */
    public double getJulyTemp() {
        return julyTemp;
    }

    /**
     *
     * @param julyTemp
     */
    public void setJulyTemp(double julyTemp) {
        this.julyTemp = julyTemp;
    }

    /**
     *
     * @return
     */
    public double getAugustTemp() {
        return augustTemp;
    }

    /**
     *
     * @param augustTemp
     */
    public void setAugustTemp(double augustTemp) {
        this.augustTemp = augustTemp;
    }

    /**
     *
     * @return
     */
    public double getSeptemberTemp() {
        return septemberTemp;
    }

    /**
     *
     * @param septemberTemp
     */
    public void setSeptemberTemp(double septemberTemp) {
        this.septemberTemp = septemberTemp;
    }

    /**
     *
     * @return
     */
    public double getOctoberTemp() {
        return octoberTemp;
    }

    /**
     *
     * @param octoberTemp
     */
    public void setOctoberTemp(double octoberTemp) {
        this.octoberTemp = octoberTemp;
    }

    /**
     *
     * @return
     */
    public double getNovemberTemp() {
        return novemberTemp;
    }

    /**
     *
     * @param novemberTemp
     */
    public void setNovemberTemp(double novemberTemp) {
        this.novemberTemp = novemberTemp;
    }

    /**
     *
     * @return
     */
    public double getDecemberTemp() {
        return decemberTemp;
    }

    /**
     *
     * @param decemberTemp
     */
    public void setDecemberTemp(double decemberTemp) {
        this.decemberTemp = decemberTemp;
    }
    
    @Override
    public String toString(){
        return "Average Monthly Temperatures from " + getStartingYear() + " to " +
                getEndingYear() + " are :\nJanuary : " + getJanuaryTemp() + 
                "\nFebruary : " + getFebruaryTemp() + 
                "\nMarch : " + getMarchTemp()  + 
                "\nApril : " + getAprilTemp()  + 
                "\nMay : " + getMayTemp() + 
                "\nJune : " + getJuneTemp() + 
                "\nJuly : " + getJulyTemp() + 
                "\nAugust : " + getAugustTemp() +
                "\nSeptember : " + getSeptemberTemp() + 
                "\nOctober : " + getOctoberTemp() + 
                "\nNovember : " + getNovemberTemp() + 
                "\nDecember : " + getDecemberTemp() + "\n";
    }
    
}
