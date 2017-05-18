/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Hote;
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
public class ServiceHote {
    Connection cnx;
    Statement stmt;
    public ServiceHote() {
        cnx=MyConnection.GetInstance();
        try {
            stmt=cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceHote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Hote getHoteById(int id) throws SQLException {
        String req="select * from utilisateurs where  id="+id;
        ResultSet rs = stmt.executeQuery(req);
        boolean etat=false;
        if(rs.next()){
        if (rs.getInt(9)==1)
            etat = true;
        }
        Hote hote = new Hote(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11),rs.getString(12));
        return hote;
        
        
    }
    public void AjouterHote(Hote hote) throws SQLException {
        String req="insert into utilisateurs(nom,prenom,date_naissance,cin,email,pseudo,mot_de_passe,etat,role,username,username_canonical) values('"+hote.getNom()+"','"+hote.getPrenom()+"','"+hote.getDate_naissance()+"',"+hote.getCin()+",'"+hote.getEmail()+"','"+hote.getPseudo()+"','"+hote.getMot_de_passe()+"',1,'hote','"+hote.getUsername()+"','"+hote.getUsername_canonical()+")";
        stmt.executeUpdate(req);
    }
    public void ActiverHote(Hote hote) throws SQLException {
        String req="update utilisateurs set etat=1 where id="+hote.getId();
        stmt.executeUpdate(req);
    }
    public void DesactiverHote(Hote hote) throws SQLException {
        String req="update utilisateurs set etat=0 where id="+hote.getId();
        stmt.executeUpdate(req);
    }
    public List<Hote> GetAllHote() throws SQLException {
        String req="select * from utilisateurs ";
        ResultSet rs = stmt.executeQuery(req);
        List<Hote> hotes = new ArrayList<Hote>();
        Hote hote;
        while(rs.next()) {
            boolean etat=false;
            if (rs.getInt(9)==1)
                etat=true;
         hote = new Hote(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11),rs.getString(12));
            hotes.add(hote);
        }
        return hotes;
        
    }
    public void ModifierHote(Hote hote) throws SQLException {
        String req="update utilisateurs set nom='"+hote.getNom()+"',prenom='"+hote.getPrenom()+"',date_naissance='"+hote.getDate_naissance()+"',cin="+hote.getCin()+",email='"+hote.getEmail()+"',pseudo='"+hote.getPseudo()+"',mot_de_passe='"+hote.getMot_de_passe()+"' where id="+hote.getId();
        stmt.executeUpdate(req);
    }
}
