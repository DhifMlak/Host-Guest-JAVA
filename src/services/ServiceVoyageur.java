/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Voyageur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author Firas
 */
public class ServiceVoyageur {

    Connection cnx;
    Statement stmt;

    public ServiceVoyageur() {
        cnx = MyConnection.GetInstance();
        try {
            stmt = cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVoyageur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Voyageur GetVoyageurById(int id) throws SQLException {
     
        String req = "select * from utilisateurs where  id=" + id;
        ResultSet rs = stmt.executeQuery(req);
        boolean etat = false;
        if (rs.next()) {
            if (rs.getInt(9) == 1) {
                etat = true;
            }
        }

        Voyageur voyageur = new Voyageur();//rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), etat);
        
        return voyageur;
    }

}
