package com.example.transport3crearebd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    public HelloController() throws SQLException {
    }

    Connection connectionFirst = DriverManager.getConnection(URL, USER, PASSWORD);
    Statement statementINV = connectionFirst.createStatement();
//
//    public static String bazaDeDate = "auto_1stDemoPublic2304";
//    public static String backUpbazaDeDate = "auto_1stDemoPublic2304Bbackup";
//    public static String USER=  "auto_1stDemoPublic";
//    public static String PASSWORD=  "pas@1stDemoPubliC";

    public static String bazaDeDate = "autoNelYFunDa250223";
    public static String backUpbazaDeDate = "autoNelYFunDa250223Bbackup";
    public static String USER=  "aUtONeli";
    public static String PASSWORD=  "pas@NeLy2gynLog23";
//    public static String SERVER="95.214.135.69";
    public static String SERVER="localhost";
    public static String PORT = "3306";

    public static String CREATEUSERNAME = "CREATE USER IF NOT EXISTS "+USER+"@"+SERVER+" identified by "+PASSWORD+" ";
    public static String URL = String.format( "jdbc:mariadb://"+SERVER+":"+PORT+"/"+bazaDeDate+"" );
//        public static String URL = String.format( "jdbc:mariadb://95.214.135.69:3306/autoNelYFunDa250223" );
//    public static String URLbackup = String.format( "jdbc:mariadb://'"+SERVER+"':'"+PORT+"'/'"+backUpbazaDeDate+"'" );

    public static String URLbackup = String.format( "jdbc:mariadb://"+SERVER+":"+PORT+"/"+backUpbazaDeDate+"" );

    public static final String DROP_DATABASE_backup = "DROP DATABASE IF EXISTS '"+backUpbazaDeDate+"'";
    public static final String CREATE_DATABASE_backup = "CREATE DATABASE IF NOT EXISTS '"+backUpbazaDeDate+"'";

    public static final String USE_DATABASE = "USE "+bazaDeDate+" ";
    public static final String USE_DATABASE_backup = "USE '"+backUpbazaDeDate+"'";
    public static final String selectUser ="SELECT USER '"+USER+"' FROM mysql.user";

    public static final String CREATE_AUTO_TBL= "CREATE TABLE IF NOT EXISTS auto (nrCrt INT(4) AUTO_INCREMENT PRIMARY KEY, nrInventar VARCHAR (15), nrInmatriculare VARCHAR (12), marca VARCHAR (40), model VARCHAR (40), tip VARCHAR (50), combustibil VARCHAR (20), capacitateRezervor INT(4), anvelopeMarca VARCHAR (30), anvelopeTip VARCHAR (30), anvelopeMarcaIarna VARCHAR (30), anvelopeTipIarna VARCHAR (30), serieSasiu VARCHAR (20), valAchizitie VARCHAR (12) , dataAchizitiei DATE, dataPrimeiInmatr DATE, nrAxe INT(2), kmInitiali INT(7), lungime VARCHAR(6), latime VARCHAR(6), inaltime VARCHAR(4), gabarit VARCHAR(6), operare VARCHAR (100)  )";
    public static final String CREATE_RCA_ITP_AURORIZARI= "CREATE TABLE IF NOT EXISTS rcaITP (nrCrt INT(5) AUTO_INCREMENT PRIMARY KEY, document VARCHAR (20), nrInmatriculare VARCHAR (12), tipDocument VARCHAR(70), nrDoc VARCHAR (20), dataDoc DATE, dataExpirare DATE, durataRamasaTemp INT (4), valoare DOUBLE, inlocuita INT (4), operare VARCHAR (100) )";
    public static final String CREATE_LISTA_DOCUMENTE= "CREATE TABLE IF NOT EXISTS listaDocumente (nrCrtLista INT(2), denDoc VARCHAR (50), inactiv VARCHAR (2) )";
    public static final String CREATE_TABLE_FACTURI_CARBURANTI="CREATE TABLE IF NOT EXISTS factCarburant ( nrCrt INT (6) AUTO_INCREMENT PRIMARY KEY, furnizor VARCHAR(70), nrFactura VARCHAR(10), dataFactura DATE, tipCombustibil VARCHAR(12), cantitate VARCHAR(7), pretUnitar VARCHAR(15), operare VARCHAR (100), nrInmatricullare VARCHAR (12) )";
    public static final String CREATE_CONSUM_CARBURANTI= "CREATE TABLE IF NOT EXISTS consumCarburant (nrCrtCombust INT(6) AUTO_INCREMENT PRIMARY KEY, nrInmatriculare VARCHAR (12), tipCombustibil VARCHAR(20), cantitate  VARCHAR (6), kmLaAlimentare VARCHAR (7), consum DOUBLE, dataAlimentarii DATE, operare VARCHAR (100)  )";
    public static final String CREATE_PIESE= "CREATE TABLE IF NOT EXISTS piese (nrCrtPiese INT(5) AUTO_INCREMENT PRIMARY KEY, furnizor VARCHAR (50), nrFactura VARCHAR (20), dataFactura DATE, piesa VARCHAR(50), pret VARCHAR (10), bonConsum VARCHAR(20), dataBonConsum DATE, nrInmatriculare VARCHAR (12), operare VARCHAR (100) )";
    public static final String CREATE_TABLE_RESP_PRIVILEGE = "CREATE TABLE IF NOT EXISTS respPrivilege (nrCrt INT (3) AUTO_INCREMENT PRIMARY KEY, respProiect VARCHAR(50), macNr VARCHAR(17), adminu CHAR(10), sex CHAR (1), inactiv VARCHAR (3), rezerva1 VARCHAR (50))";
    public static final String CREATE_TABLE_AUTORIZARI_AUTO = "CREATE TABLE IF NOT EXISTS autorizariAuto ( nrCrt INT(4) AUTO_INCREMENT PRIMARY KEY, nrInmatriculare VARCHAR (12), tipAutorizatie VARCHAR (30), nrDocumentAutorizare VARCHAR (20), dataAutorizarii DATE, dataExpirariiAutorizarii DATE, valoare VARCHAR (12), operare VARCHAR (100))";
    public static final String CREATE_TABLE_REVIZII="CREATE TABLE IF NOT EXISTS revizii (nrCrt INT(5) AUTO_INCREMENT PRIMARY KEY, nrAuto VARCHAR(12), document VARCHAR (100), dataReviziei DATE, dataExpirarii DATE, durataRamasaTemp INT(4), kmLaRevizie DOUBLE, kmLaUrmRevizie DOUBLE, valoare DOUBLE,  inlocuita INT(4), operare VARCHAR (100) )";
    public static final String CREATE_TABLE_LOG = "CREATE TABLE IF NOT EXISTS logFile (dataLogarii VARCHAR (60), utilizator VARCHAR(50), mesaj VARCHAR (1000), rezervaLog VARCHAR(70))";
    public static final String CREATE_TABLE_ADMINSTRATIV="CREATE TABLE IF NOT EXISTS administrativ (nrCrt INT(4) AUTO_INCREMENT PRIMARY KEY, detaliu VARCHAR(100), data DATE, parametru VARCHAR(20), descriere VARCHAR(200))";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setText("Creaza noul client");
        System.out.println("Conectat la noua baza de date prin noul user");


    }
    @FXML
    protected void onHelloButtonClick() throws SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
        statementINV.executeUpdate(USE_DATABASE);
        statementINV.executeUpdate(CREATE_AUTO_TBL);
        statementINV.executeUpdate(CREATE_RCA_ITP_AURORIZARI);
        statementINV.executeUpdate(CREATE_LISTA_DOCUMENTE);
        statementINV.executeUpdate(CREATE_TABLE_FACTURI_CARBURANTI);
        statementINV.executeUpdate(CREATE_CONSUM_CARBURANTI);
        statementINV.executeUpdate(CREATE_PIESE);
        statementINV.executeUpdate(CREATE_TABLE_LOG);
        statementINV.executeUpdate(CREATE_TABLE_AUTORIZARI_AUTO);
        statementINV.executeUpdate(CREATE_TABLE_RESP_PRIVILEGE);
        statementINV.executeUpdate(CREATE_TABLE_REVIZII);
        statementINV.executeUpdate(CREATE_TABLE_ADMINSTRATIV);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("AI CREAT TABLELE");
        alert.showAndWait();

    }
}