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

    public static String bazaDeDate = "autoNelYFunDa250223";
    public static String backUpbazaDeDate = "autoNelYFunDa250223Bbackup";
    public static String USER=  "aUtONeli";
    public static String PASSWORD=  "pas@NeLy2gynLog23";
    public static String SERVER="10.59.4.8";
//    public static String SERVER="95.214.135.69";
    public static int PORT = 3306;

    public static String CREATEUSERNAME = "CREATE USER IF NOT EXISTS "+USER+"@"+SERVER+" identified by "+PASSWORD+" ";
    public static String URL = String.format( "jdbc:mariadb://"+SERVER+":"+PORT+"/"+bazaDeDate+"" );
    public static String URLbackup = String.format( "jdbc:mariadb://'"+SERVER+"':'"+PORT+"'/'"+backUpbazaDeDate+"'" );

//    public static String CREATEUSERNAME = "CREATE USER IF NOT EXISTS '"+USER+"'@'95.214.135.69' identified by '"+PASSWORD+"' ";
//    public static String URL = String.format( "jdbc:mariadb://95.214.135.69:3306/'"+bazaDeDate+"'" );
//    public static String URLbackup = String.format( "jdbc:mariadb://95.214.135.69:3306/'"+backUpbazaDeDate+"'" );

    public static final String DROP_DATABASE_backup = "DROP DATABASE IF EXISTS "+backUpbazaDeDate+"";
    public static final String CREATE_DATABASE_backup = "CREATE DATABASE IF NOT EXISTS "+backUpbazaDeDate+"";

    public static final String USE_DATABASE = "USE "+bazaDeDate+"";
    public static final String USE_DATABASE_backup = "USE "+backUpbazaDeDate+"";
    public static final String selectUser ="SELECT USER "+USER+" FROM mysql.user";

    public static final String CREATE_AUTO_TBL= "CREATE TABLE IF NOT EXISTS auto (nrCrt INT(4) AUTO_INCREMENT PRIMARY KEY, nrInventar VARCHAR (15), nrInmatriculare VARCHAR (12), marca VARCHAR (30), model VARCHAR (15), tip VARCHAR (50), combustibil VARCHAR (20), anvelopeMarca VARCHAR (30) , anvelopeTip VARCHAR (30), serieSasiu VARCHAR (20), valAchizitie DOUBLE , dataAchizitiei DATE, dataPrimeiInmatr DATE, nrAxe INT(2), kmInitiali INT(7), lungime VARCHAR(6), latime VARCHAR(6), inaltime VARCHAR(4), gabarit VARCHAR(6)    )";
    public static final String CREATE_RCA_ITP_AURORIZARI= "CREATE TABLE IF NOT EXISTS rcaITP (nrCrt INT(4) AUTO_INCREMENT PRIMARY KEY, nrInmatriculare VARCHAR (12), document VARCHAR (50), nrDoc VARCHAR (20), dataDoc DATE, dataExpirare DATE, valoare DOUBLE )";
    public static final String CREATE_LISTA_DOCUMENTE= "CREATE TABLE IF NOT EXISTS listaDocumente (nrCrtLista INT(2), denDoc VARCHAR (50), inactiv VARCHAR (2) )";
    public static final String CREATE_TABLE_FACTURI_CARBURANTI="CREATE TABLE IF NOT EXISTS factCarburant ( nrCrt INT (6) AUTO_INCREMENT PRIMARY KEY, furnizor VARCHAR(70), nrFactura VARCHAR(10), dataFactura DATE, tipCombustibil VARCHAR(12), cantitate VARCHAR(7), pretUnitar VARCHAR(15) )";
    public static final String CREATE_CONSUM_CARBURANTI = "CREATE TABLE IF NOT EXISTS consumCarburant (nrCrtCombust INT(4) AUTO_INCREMENT PRIMARY KEY, nrInmatriculare VARCHAR (12), cantitate  VARCHAR (6), kmLaAlimentare VARCHAR (7), dataAlimentarii DATE  )";
    public static final String CREATE_PIESE= "CREATE TABLE IF NOT EXISTS piese (nrCrtPiese INT(4) AUTO_INCREMENT PRIMARY KEY, nrInmatriculare VARCHAR (12), piesa VARCHAR(50), valoare VARCHAR (10) )";
    public static final String CREATE_TABLE_RESP_PRIVILEGE = "CREATE TABLE IF NOT EXISTS respPrivilege (nrCrt INT (3) AUTO_INCREMENT PRIMARY KEY, respProiect VARCHAR(50), macNr VARCHAR(17), adminu CHAR(10), sex CHAR (1), inactiv VARCHAR (3), rezerva1 VARCHAR (50))";


    public static final String POPULATE_lISTA_DOCUMENTE="INSERT INTO listaDocumente VALUES ('1', 'RCA', 'nu'), ('2', 'CASCO', 'nu'), ('3', 'ITP', 'nu'), ('4', 'Rovinieta', 'nu'), ('5', 'Taxa pod', 'nu'), ('6', 'taxa acces', 'nu')";

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
        statementINV.executeUpdate(CREATE_TABLE_RESP_PRIVILEGE);
        statementINV.executeUpdate(POPULATE_lISTA_DOCUMENTE);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("AI CREAT TABLELE");
        alert.showAndWait();

    }
}