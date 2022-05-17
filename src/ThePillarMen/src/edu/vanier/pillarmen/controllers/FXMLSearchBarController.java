package edu.vanier.pillarmen.controllers;

import edu.vanier.pillarmen.controllers.weathercontrollers.AnnualTempParser;
import edu.vanier.pillarmen.controllers.weathercontrollers.MonthlyPrecipitationParser;
import edu.vanier.pillarmen.controllers.weathercontrollers.MonthlyTempParser;
import edu.vanier.pillarmen.globemodel.CountryModel;
import edu.vanier.pillarmen.weathermodels.AverageAnnualTemp;
import edu.vanier.pillarmen.weathermodels.AverageMonthlyPrecipitation;
import edu.vanier.pillarmen.weathermodels.AverageMonthlyTemp;
import edu.vanier.pillarmen.worldmap.World;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class for the search bar engine.
 *
 * @author Benjamin Zitella
 */
public class FXMLSearchBarController implements Initializable {

    @FXML
    private Label searchBarLbl;
    @FXML
    private TextField searchBarField;
    @FXML
    private TableView<CountryModel> searchResults;
    @FXML
    private TableColumn<CountryModel, String> countries;
    @FXML
    private TableColumn<CountryModel, String> capitals;
    @FXML
    private Button searchBtn;
    @FXML
    private Button returnBtn;
    @FXML
    private Button flatViewBtn;
    private String strTargetRegion = "";

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleSearchButton(ActionEvent event) {
        if (event.getSource() == searchBtn) {
            countries.setCellValueFactory(new PropertyValueFactory<>("country"));
            capitals.setCellValueFactory(new PropertyValueFactory<>("capital"));
            switch (searchBarField.getText().toLowerCase()) {
                case "north america": {
                    searchResults.getItems().clear();
                    CountryModel bm = new CountryModel("Bermuda", "Hamilton", "BM");
                    CountryModel ca = new CountryModel("Canada", "Ottawa", "CA");
                    CountryModel gl = new CountryModel("Greenland", "Nuuk", "GL");
                    CountryModel mx = new CountryModel("Mexico", "Mexico City", "MX");
                    CountryModel um = new CountryModel("United States Minor Outlying Islands", "Washington D.C.", "UM");
                    CountryModel us = new CountryModel("United States", "Washington D.C.", "US");
                    searchResults.getItems().addAll(bm, ca, gl, mx, us);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "na";
                    break;
                }
                case "south america": {
                    searchResults.getItems().clear();
                    CountryModel ar = new CountryModel("Argentina", "Buenos Aires", "AR");
                    CountryModel bo = new CountryModel("Bolivia", "Sucre", "BO");
                    CountryModel br = new CountryModel("Brazil", "Brasilia", "BR");
                    CountryModel cl = new CountryModel("Chile", "Santiago", "CL");
                    CountryModel co = new CountryModel("Colombia", "Bogota", "CO");
                    CountryModel ec = new CountryModel("Ecaudor", "Quito", "EC");
                    CountryModel fk = new CountryModel("Falkland Islands", "Stanley", "FK");
                    CountryModel gf = new CountryModel("French Guiana", "Cayenne", "GF");
                    CountryModel gy = new CountryModel("Guyana", "Georgetown", "GY");
                    CountryModel pe = new CountryModel("Peru", "Lima", "PE");
                    CountryModel py = new CountryModel("Paraguay", "Asunción", "PY");
                    CountryModel sr = new CountryModel("Suriname", "Paramaribo", "SR");
                    CountryModel uy = new CountryModel("Uruguay", "Montevideo", "UY");
                    CountryModel ve = new CountryModel("Venezuela", "Caracas", "VE");
                    searchResults.getItems().addAll(ar, bo, br, cl, co, ec, fk, gf, gy, pe, py, sr, uy, ve);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "sa";
                    break;
                }
                case "europe": {
                    searchResults.getItems().clear();
                    CountryModel ad = new CountryModel("Andorra", "Andorra la Vella", "AD");
                    CountryModel al = new CountryModel("Albania", "Tirana", "AL");
                    CountryModel am = new CountryModel("Armenia", "Yerevan", "AM");
                    CountryModel at = new CountryModel("Austria", "Vienna", "AT");
                    CountryModel ba = new CountryModel("Bosnia and Herzegovina", "Sarajevo", "BA");
                    CountryModel be = new CountryModel("Belgium", "Brussels", "BE");
                    CountryModel bg = new CountryModel("Bulgaria", "Sofia", "BG");
                    CountryModel by = new CountryModel("Belarus", "Minsk", "BY");
                    CountryModel ch = new CountryModel("Switzerland", "Zurich", "CH");
                    CountryModel cy = new CountryModel("Cyprus", "Nicosia", "CY");
                    CountryModel cz = new CountryModel("Czech Republic", "Prague", "CZ");
                    CountryModel de = new CountryModel("Germany", "Berlin", "DE");
                    CountryModel dk = new CountryModel("Denmark", "Copenhagen", "DK");
                    CountryModel ee = new CountryModel("Estonia", "Tallinn", "EE");
                    CountryModel es = new CountryModel("Spain", "Madrid", "ES");
                    CountryModel fi = new CountryModel("Finland", "Helsinki", "FI");
                    CountryModel fo = new CountryModel("Faroe Islands", "Torshavn", "FO");
                    CountryModel fr = new CountryModel("France", "Paris", "FR");
                    CountryModel gb = new CountryModel("Great Britain", "London", "GB");
                    CountryModel ge = new CountryModel("Georgia", "Tbilisi", "GE");
                    CountryModel gg = new CountryModel("Guernsey", "Saint Peter Port", "GG");
                    CountryModel gi = new CountryModel("Gibraltar", "Gibraltar", "GI");
                    CountryModel gr = new CountryModel("Greece", "Athens", "GR");
                    CountryModel hr = new CountryModel("Croatia", "Zagreb", "HR");
                    CountryModel hu = new CountryModel("Hungary", "Budapest", "HU");
                    CountryModel ie = new CountryModel("Ireland", "Dublin", "IE");
                    CountryModel im = new CountryModel("Isle of Man", "Douglas", "IM");
                    CountryModel is = new CountryModel("Iceland", "Reykjavík", "IS");
                    CountryModel it = new CountryModel("Italy", "Rome", "IT");
                    CountryModel je = new CountryModel("Jersey", "Saint Helier", "JE");
                    CountryModel li = new CountryModel("Liechtenstein", "Vaduz", "LI");
                    CountryModel lt = new CountryModel("Lithuania", "Vilnius", "LT");
                    CountryModel lu = new CountryModel("Luxembourg", "Luxembourg", "LU");
                    CountryModel lv = new CountryModel("Latvia", "Riga", "LV");
                    CountryModel mc = new CountryModel("Monaco", "Monte Carlo", "MC");
                    CountryModel md = new CountryModel("Moldova", "Chisinau", "MD");
                    CountryModel me = new CountryModel("Montenegro", "Podgorica", "ME");
                    CountryModel mk = new CountryModel("North Macedonia", "Skopje", "MK");
                    CountryModel mt = new CountryModel("Malta", "Valletta", "MT");
                    CountryModel nl = new CountryModel("Netherlands", "Amsterdam", "NL");
                    CountryModel no = new CountryModel("Norway", "Oslo", "NO");
                    CountryModel pl = new CountryModel("Poland", "Warsaw", "PL");
                    CountryModel pt = new CountryModel("Portugal", "Lisbon", "PT");
                    CountryModel ro = new CountryModel("Romania", "Bucharest", "RO");
                    CountryModel rs = new CountryModel("Serbia", "Belgrade", "RS");
                    CountryModel ru = new CountryModel("Russia", "Moscow", "RU");
                    CountryModel se = new CountryModel("Sweden", "Stockholm", "SE");
                    CountryModel si = new CountryModel("Slovenia", "Ljubljana", "SI");
                    CountryModel sj = new CountryModel("Svalbard and Jan Mayen", "Longyearbyen", "SJ");
                    CountryModel sk = new CountryModel("Slovakia", "Bratislava", "SK");
                    CountryModel sm = new CountryModel("San Marino", "San Marino", "SM");
                    CountryModel tr = new CountryModel("Turkey", "Ankara", "TR");
                    CountryModel ua = new CountryModel("Ukraine", "Kyiv", "UA");
                    searchResults.getItems().addAll(ad, al, am, at, ba, be, bg, by, ch, cy, cz, de, 
                            dk, ee, es, fi, fo, fr, gb, ge, gg, gi, gr, hr, hu, ie, im, is, it, je, 
                            li, lt, lu, lv, mc, md, me, mk, mt, nl, no, pl, pt, ro, rs, ru, se, si, 
                            sj, sk, sm, tr, ua);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "eu";
                    break;
                }
                case "asia": {
                    searchResults.getItems().clear();
                    CountryModel az = new CountryModel("Azerbaijan", "Baku", "AZ");
                    CountryModel bd = new CountryModel("Bangladesh", "Dhaka", "BD");
                    CountryModel bn = new CountryModel("Brunei Darussalam", "Bandar Seri Begawan", "BN");
                    CountryModel bt = new CountryModel("Bhutan", "Thimphu", "BT");
                    CountryModel cn = new CountryModel("China", "Beijing", "CN");
                    CountryModel cx = new CountryModel("Christmas Island", "Flying Fish Cove", "CX");
                    CountryModel hk = new CountryModel("Hong Kong", "Hong Kong", "HK");
                    CountryModel id = new CountryModel("Indonesia", "Jakarta", "ID");
                    CountryModel in = new CountryModel("India", "New Delhi", "IN");
                    CountryModel io = new CountryModel("British Indian Ocean Territory", "Camp Justice", "IO");
                    CountryModel jp = new CountryModel("Japan", "Tokyo", "JP");
                    CountryModel kg = new CountryModel("Kyrgyzstan", "Bishkek", "KG");
                    CountryModel kh = new CountryModel("Cambodia", "Phnom Penh", "KH");
                    CountryModel kp = new CountryModel("North Korea", "Pyongyang", "KP");
                    CountryModel kr = new CountryModel("South Korea", "Seoul", "KR");
                    CountryModel kz = new CountryModel("Kazakhstan", "Nur-Sultan", "KZ");
                    CountryModel la = new CountryModel("Laos", "Vientiane", "LA");
                    CountryModel lk = new CountryModel("Sri Lanka", "Colombo", "LK");
                    CountryModel mo = new CountryModel("Macao", "Macao", "MO");
                    CountryModel mm = new CountryModel("Myanmar", "Naypyitaw", "MM");
                    CountryModel mn = new CountryModel("Mongolia", "Ulaanbaatar", "MN");
                    CountryModel mv = new CountryModel("Maldives", "Malé", "MV");
                    CountryModel my = new CountryModel("Malaysia", "Kuala Lumpur", "MY");
                    CountryModel np = new CountryModel("Nepal", "Kathmandu", "NP");
                    CountryModel ph = new CountryModel("Philippines", "Manila", "PH");
                    CountryModel pk = new CountryModel("Pakistan", "Islamabad", "PK");
                    CountryModel sg = new CountryModel("Singapore", "Singapore", "SG");
                    CountryModel th = new CountryModel("Thailand", "Bangkok", "TH");
                    CountryModel tj = new CountryModel("Tajikistan", "Dushanbe", "TJ");
                    CountryModel tl = new CountryModel("Timor-Leste", "Dili", "TL");
                    CountryModel tm = new CountryModel("Turkmenistan", "Ashgabat", "TM");
                    CountryModel tw = new CountryModel("Taiwan", "Taipei", "TW");
                    CountryModel uz = new CountryModel("Uzbekistan", "Tashkent", "UZ");
                    CountryModel vn = new CountryModel("Vietnam", "Hanoi", "VN");
                    searchResults.getItems().addAll(az, bd, bn, bt, cn, cx, hk, id, in, io, jp, kg, kh, kp,
                            kr, kz, la, lk, mo, mm, mn, mv, my, np, ph, pk, sg, th, tj, tl, tm, tw, uz, vn);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "as";
                    break;
                }
                case "africa": {
                    searchResults.getItems().clear();
                    CountryModel af = new CountryModel("Afghanistan", "Kabul","AF");
                    CountryModel ao = new CountryModel("Angola", "Luanda", "AO");
                    CountryModel bf = new CountryModel("Burkina Faso", "Ouagadougou", "BF");
                    CountryModel bi = new CountryModel("Burundi", "Gitega", "BI");
                    CountryModel bj = new CountryModel("Benin", "Porto-Novo", "BJ");
                    CountryModel bw = new CountryModel("Botswana", "Gaborone", "BW");
                    CountryModel cd = new CountryModel("Democratic Republic of Congo", "Kinshasa", "CD");
                    CountryModel cf = new CountryModel("Central African Republic", "Bangui", "CF");
                    CountryModel cg = new CountryModel("Congo", "Brazzaville", "CG");
                    CountryModel ci = new CountryModel("Côte d'Ivoire", "Yamoussoukro", "CI");
                    CountryModel cm = new CountryModel("Cameroon", "Yaounde", "CM");
                    CountryModel cv = new CountryModel("Cabo Verde", "Praia", "CV");
                    CountryModel dj = new CountryModel("Djibouti", "Djibouti City", "DJ");
                    CountryModel dz = new CountryModel("Algeria", "Algiers", "DZ");
                    CountryModel eh = new CountryModel("Western Sahara", "Laayoune", "EH");
                    CountryModel er = new CountryModel("Eritrea", "Asmara", "ER");
                    CountryModel et = new CountryModel("Ethiopia", "Addis Ababa", "ET");
                    CountryModel ga = new CountryModel("Gabon", "Libreville", "GA");
                    CountryModel gh = new CountryModel("Ghana", "Accra", "GH");
                    CountryModel gm = new CountryModel("Gambia", "Banjul", "GM");
                    CountryModel gn = new CountryModel("Guinea", "Conakry", "GN");
                    CountryModel gq = new CountryModel("Equatorial Guinea", "Malabo", "GQ");
                    CountryModel gw = new CountryModel("Guinea-Bissau", "Bissau", "GW");
                    CountryModel ke = new CountryModel("Kenya", "Nairobi", "KE");
                    CountryModel km = new CountryModel("Comoros", "Moroni", "KM");
                    CountryModel lr = new CountryModel("Liberia", "Monrovia", "LR");
                    CountryModel ls = new CountryModel("Lesotho", "Maseru", "LS");
                    CountryModel ly = new CountryModel("Libya", "Tripoli", "LY");
                    CountryModel ma = new CountryModel("Morocco", "Rabat", "MA");
                    CountryModel mg = new CountryModel("Madagascar", "Antananarivo", "MG");
                    CountryModel ml = new CountryModel("Mali", "Bamako", "ML");
                    CountryModel mr = new CountryModel("Mauritiana", "Nouakchott", "MR");
                    CountryModel mu = new CountryModel("Mauritius", "Port Louis", "MU");
                    CountryModel mw = new CountryModel("Malawi", "Lilongwe", "MW");
                    CountryModel mz = new CountryModel("Mozambique", "Maputo", "MZ");
                    CountryModel na = new CountryModel("Namibia", "Maputo", "NA");
                    CountryModel ne = new CountryModel("Niger", "Niamey", "NE");
                    CountryModel ng = new CountryModel("Nigeria", "Abuja", "NG");
                    CountryModel re = new CountryModel("Réunion", "Saint-Denis", "RE");
                    CountryModel rw = new CountryModel("Rwanda", "Kigali", "RW");
                    CountryModel sc = new CountryModel("Seychelles", "Victoria", "SC");
                    CountryModel sh = new CountryModel("Saint Helena, Ascension and Tristan da Cunha", "Jamestown", "SH");
                    CountryModel sl = new CountryModel("Sierra Leone", "Freetown", "SL");
                    CountryModel sn = new CountryModel("Senegal", "Dakar", "SN");
                    CountryModel so = new CountryModel("Somalia", "Mogadishu", "SO");
                    CountryModel st = new CountryModel("São Tomé and Príncipe", "São Tomé", "ST");
                    CountryModel sz = new CountryModel("Eswatini", "Mbabane", "SZ");
                    CountryModel td = new CountryModel("Chad", "N\'Djamena", "TD");
                    CountryModel tg = new CountryModel("Togo", "Lome", "TG");
                    CountryModel tn = new CountryModel("Tunisia", "Tunis", "TN");
                    CountryModel tz = new CountryModel("Tanzania", "Dodoma", "TZ");
                    CountryModel ug = new CountryModel("Uganda", "Kampala", "UG");
                    CountryModel yt = new CountryModel("Mayotte", "Mamoudzou", "YT");
                    CountryModel za = new CountryModel("South Africa", "Cape Town", "ZA");
                    CountryModel zm = new CountryModel("Zambia", "Lusaka", "ZM");
                    CountryModel zw = new CountryModel("Zimbabwe", "Harare", "ZW");
                    searchResults.getItems().addAll(af, ao, bf, bi, bj, bw, cd, cf, cg, ci, cm, cv, dj, 
                            dz, eh, er, et, ga, gh, gm, gn, gq, gw, ke, km, lr, ls, ly, ma, mg, ml, mr, 
                            mu, mw, mz, na, ne, ng, re, rw, sc, sh, sl, sn, so, st, sz, td, tg, tn, tz, 
                            ug, yt, za, zm, zw);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "af";
                    break;
                }
                case "oceania": {
                    searchResults.getItems().clear();
                    CountryModel as = new CountryModel("American Samoa", "Pago Pago", "AS");
                    CountryModel au = new CountryModel("Australia", "Canberra", "AU");
                    CountryModel cc = new CountryModel("Cocos Islands", "West Island", "CC");
                    CountryModel ck = new CountryModel("Cook Islands", "Avarua District", "CK");
                    CountryModel fj = new CountryModel("Fiji", "Suva", "FJ");
                    CountryModel fm = new CountryModel("Micronesia", "Paikir", "FM");
                    CountryModel gu = new CountryModel("Guam", "Hagåtña", "GU");
                    CountryModel ki = new CountryModel("Kiribati", "Tarawa", "KI");
                    CountryModel mh = new CountryModel("Marshall Islands", "Delap-Uliga-Djarrit", "MH");
                    CountryModel mp = new CountryModel("Northern Mariana Islands", "Saipan", "MP");
                    CountryModel nc = new CountryModel("New Caledonia", "Noumea", "NC");
                    CountryModel nf = new CountryModel("Norfolk Island", "Kingston", "NF");
                    CountryModel nr = new CountryModel("Nauru", "Yaren", "NR");
                    CountryModel nu = new CountryModel("Niue", "Alofi", "NU");
                    CountryModel nz = new CountryModel("New Zealand", "Wellington", "NZ");
                    CountryModel pf = new CountryModel("French Polynesia", "Pape\'ete", "PF");
                    CountryModel pg = new CountryModel("Papua New Guinea", "Port Moresby", "PG");
                    CountryModel pn = new CountryModel("Pitcairn Islands", "Adamstown", "PN");
                    CountryModel pw = new CountryModel("Palau", "Ngerulmud", "PW");
                    CountryModel sb = new CountryModel("Solomon Islands", "Honiara", "SB");
                    CountryModel tk = new CountryModel("Tokelau", "Nukunonu", "TK");
                    CountryModel to = new CountryModel("Tonga", "Nuku\'alofa", "TO");
                    CountryModel tv = new CountryModel("Tuvalu", "Funafuti", "TV");
                    CountryModel vu = new CountryModel("Vanuatu", "Port Vila", "VU");
                    CountryModel wf = new CountryModel("Wallis and Futuna", "Matā\'utu", "WF");
                    CountryModel ws = new CountryModel("Samoa", "Apia", "WS");
                    searchResults.getItems().addAll(as, au, cc, ck, fj, fm, gu, ki, mh, mp, nc, nf, nr, nu, 
                            nz, pf, pg, pn, pw, sb, tk, to, tv, vu, wf, ws);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "oc";
                    break;
                }
                case "middle east": {
                    searchResults.getItems().clear();
                    CountryModel ae = new CountryModel("United Arab Emirates", "Abu Dhabi", "AE");
                    CountryModel bh = new CountryModel("Bahrain", "Manama", "BH");
                    CountryModel eg = new CountryModel("Egypt", "Cairo", "EG");
                    CountryModel il = new CountryModel("Israel", "Jerusalem", "IL");
                    CountryModel iq = new CountryModel("Iraq", "Baghdad", "IQ");
                    CountryModel ir = new CountryModel("Iran", "Tehran", "IR");
                    CountryModel jo = new CountryModel("Jordan", "Amman", "JO");
                    CountryModel kw = new CountryModel("Kuwait", "Kuwait City", "KW");
                    CountryModel lb = new CountryModel("Lebanon", "Beirut", "LB");
                    CountryModel om = new CountryModel("Oman", "Muscat", "OM");
                    CountryModel ps = new CountryModel("Palestine", "East Jerusalem", "PS");
                    CountryModel qa = new CountryModel("Qatar", "Doha", "QA");
                    CountryModel sa = new CountryModel("Saudia Arabia", "Riyadh", "SA");
                    CountryModel sd = new CountryModel("Sudan", "Khartoum", "SD");
                    CountryModel sy = new CountryModel("Syria", "Damascus", "SY");
                    CountryModel ye = new CountryModel("Yemen", "Sana\'a", "YE");
                    searchResults.getItems().addAll(ae, bh, eg, il, iq, ir, jo, kw, lb, om, ps, qa, sa, sd, sy, ye);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "me";
                    break;
                }
                case "central america and carribean": {
                    searchResults.getItems().clear();
                    CountryModel ag = new CountryModel("Antigua and Barbuda", "Saint John's", "AG");
                    CountryModel ai = new CountryModel("Anguilla", "The Valley", "AI");
                    CountryModel aw = new CountryModel("Aruba", "Oranjestad", "AW");
                    CountryModel bb = new CountryModel("Barbados", "Bridgetown", "BB");
                    CountryModel bs = new CountryModel("Bahamas", "Nassau", "BS");
                    CountryModel bz = new CountryModel("Belize", "Belmopan", "BZ");
                    CountryModel cr = new CountryModel("Costa Rica", "San José", "CR");
                    CountryModel cu = new CountryModel("Cuba", "Havana", "CU");
                    CountryModel dm = new CountryModel("Dominica", "Roseau", "DM");
                    CountryModel dom = new CountryModel("Dominican Republic", "Santo Domingo", "DO");
                    CountryModel gd = new CountryModel("Grenada", "Saint George's", "GD");
                    CountryModel gp = new CountryModel("Guadeloupe", "Basse Terre", "GP");
                    CountryModel gt = new CountryModel("Guatemala", "Guatemala City", "GT");
                    CountryModel hn = new CountryModel("Honduras", "Tegucigalpa", "HN");
                    CountryModel ht = new CountryModel("Haiti", "Port-au-Prince", "HT");
                    CountryModel jm = new CountryModel("Jamaica", "Kingston", "JM");
                    CountryModel kn = new CountryModel("Saint Kitts and Nevis", "Basseterre", "KN");
                    CountryModel ky = new CountryModel("Cayman Islands", "George Town", "KY");
                    CountryModel lc = new CountryModel("Saint Lucia", "Castries", "LC");
                    CountryModel mf = new CountryModel("Saint Martin", "Marigot", "MF");
                    CountryModel mq = new CountryModel("Martinique", "Fort-de-France Bay", "MQ");
                    CountryModel ms = new CountryModel("Montserrat", "Brades", "MS");
                    CountryModel ni = new CountryModel("Nicaragua", "Managua", "NI");
                    CountryModel pa = new CountryModel("Panama", "Panama City", "PA");
                    CountryModel pr = new CountryModel("Puerto Rico", "San Juan", "PR");
                    CountryModel sv = new CountryModel("El Salvador", "San Salvador", "SV");
                    CountryModel tc = new CountryModel("Turks and Caicos Islands", "Cockburn Town", "TC");
                    CountryModel tt = new CountryModel("Trinidad and Tobago", "Port of Spain", "TT");
                    CountryModel vc = new CountryModel("Saint Vincent and the Grenadines", "Kingstown", "VC");
                    CountryModel vg = new CountryModel("British Virgin Islands", "Road Town", "VG");
                    CountryModel vi = new CountryModel("U.S. Virgin Islands", "Charlotte Amalie", "VI");
                    searchResults.getItems().addAll(ag, ai, aw, bb, bs, bz, cr, cu, dm, dom, gd, gp, gt, hn, ht, jm, 
                            kn, ky, lc, mf, mq, ms, ni, pa, pr, sv, tc, tt, vc, vg, vi);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "cac";
                    break;
                } 
                case "antarctica" : {
                    searchResults.getItems().clear();
                    CountryModel tf = new CountryModel("French Southern Territories", "Saint Pierre", "TF");
                    searchResults.getItems().add(tf);
                    returnBtn.setText("Center on Globe");
                    strTargetRegion = "an";
                    break;
                }
                default:
                    String enteredStr = ("The entered region is invalid, reenter a new region.");
                    searchBarField.setText("");
                    Alert alertBox = new Alert(Alert.AlertType.ERROR);
                    alertBox.setContentText(enteredStr);
                    alertBox.show();
                    returnBtn.setText("Back to Globe");
                    strTargetRegion = "";
                    break;
            }

        }
    }

    @FXML
    private void handleReturnButton(ActionEvent event) throws IOException {
        if (event.getSource() == returnBtn) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLGlobeScene.fxml"));
            Parent root = loader.load();
            FXMLGlobeSceneController controller = loader.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            switch(strTargetRegion) {
                case "na" : {
                    window.setScene(controller.findOnGlobe(45, -95));
                    break;
                }
                case "sa" : {
                    window.setScene(controller.findOnGlobe(-17, -60));
                    break;
                }
                case "eu" : {
                    window.setScene(controller.findOnGlobe(33, 10));
                    break;
                }
                case "as" : {
                    window.setScene(controller.findOnGlobe(30, 110));
                    break;
                }
                case "af" : {
                    window.setScene(controller.findOnGlobe(0, 20));
                    break;
                }
                case "oc" : {
                    window.setScene(controller.findOnGlobe(-10, 148));
                    break;
                }
                case "me" : {
                    window.setScene(controller.findOnGlobe(20, 45));
                    break;
                }
                case "cac" : {
                    window.setScene(controller.findOnGlobe(15, -84));
                    break;
                }
                case "an" : {
                    window.setScene(controller.findOnGlobe(-90, 0));
                    break;
                }
                default:
                    window.setScene(controller.startGlobe());
            }
            
            window.show();
        }
    }

    @FXML
    private void handleListViewClick(MouseEvent event) {
        try {
            World dataWorld = new World();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLDataResults.fxml"));
            Parent root = loader.load();
            FXMLDataResultsController controller = loader.<FXMLDataResultsController>getController();

            TablePosition position = searchResults.getSelectionModel().getSelectedCells().get(0);
            int row = position.getRow();
            Object item = searchResults.getItems().get(row);
            TableColumn column = position.getTableColumn();
            String countryName = (String) column.getCellObservableValue(item).getValue();
            Locale locale = new Locale("", "");
            for(int i = 0; i < searchResults.getItems().size(); i++){
                if(countryName.equals(searchResults.getItems().get(i).getCountry())){
                    CountryModel data = searchResults.getItems().get(i);
                     locale = new Locale("", data.getIso2Code());
                }
            }
            
            AnnualTempParser annualParser = new AnnualTempParser();
            AverageAnnualTemp annualTemp = annualParser.parseAverageAnnualTemp(locale.getISO3Country(), "1980", "1999");
            MonthlyTempParser monthlyParser = new MonthlyTempParser();      //ALL 3 PARSERS AND OBJECTS ARE MADE HERE AND THEN SENT THE THE INITDATA
            AverageMonthlyTemp monthlyTemp = monthlyParser.parseAverageMonthlyTemp(locale.getISO3Country(), "1980", "1999");
            MonthlyPrecipitationParser precipParser = new MonthlyPrecipitationParser();
            AverageMonthlyPrecipitation precip = precipParser.parseAverageMonthlyPre(locale.getISO3Country(), "1980", "1999");
            controller.initData(annualTemp, monthlyTemp, precip);
            
            Scene sceneTwo = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(sceneTwo);
            window.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLSearchBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void handleFlatViewBtn(ActionEvent event) throws IOException{
        if (event.getSource() == flatViewBtn) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/vanier/pillarmen/ui/FXMLFlatScene.fxml"));
            Parent root = loader.load();
            FXMLFlatSceneController controller = loader.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(controller.startFlatMap());
            window.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] autoCompletes = {"North America", "South America", "Europe",
            "Africa", "Asia", "Oceania", "Middle East", "Central America and Carribean", "Antarctica"};
        TextFields.bindAutoCompletion(searchBarField, autoCompletes);
    }

}
