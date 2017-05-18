/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Hote;
import entites.Offre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;


/**
 *
 * @author Firas
 */
public class ServiceOffre {
    Connection cnx;
    Statement stmt;
    public ServiceOffre() {
        cnx=MyConnection.GetInstance();
        try {
            stmt=cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void AjouterOffre(Offre offre) throws SQLException {
        String req="insert into offres(type_offre,id_hote) values('"+offre.getTypeOffre()+"','"+offre.getHote().getId()+"')";
        stmt.executeUpdate(req);
    }
    public List<Offre> getAllOffres() throws SQLException{
        String req="select * from offres";
        ResultSet rs = stmt.executeQuery(req);
        List<Offre> offres = new ArrayList<Offre>();
        Offre offre;
        ServiceHote serviceHote = new ServiceHote();
        while (rs.next()) {
            offre=new Offre(rs.getInt(1),rs.getString(2),serviceHote.getHoteById(rs.getInt(3)));
            offres.add(offre);
        }
        
        
        
        
        return offres ;
    }
    public List<Offre> getOffreByHote (Hote hote) throws SQLException {
        String req="select * from offres where id_hote="+hote.getId();
        Offre offre ;
        List <Offre> offres = new ArrayList<Offre>();
        ResultSet rs = stmt.executeQuery(req);
        while (rs.next()){
            offre=new Offre(rs.getInt(1),rs.getString(2), hote);
            offres.add(offre);
        }
        return offres;
    }
    public Offre getOffreById(int id) throws SQLException {
        String req="select * from offres where id="+id;
        ResultSet rs = stmt.executeQuery(req);
        Offre offre= new Offre();
        ServiceHote serviceHote = new ServiceHote();
        while (rs.next()) {
            offre= new Offre(id,rs.getString(2), serviceHote.getHoteById(rs.getInt(3)));
        }
        return offre;
    }
    
    
}
