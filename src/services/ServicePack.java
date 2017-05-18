/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Hote;
import entites.Offre;
import entites.Pack;
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
public class ServicePack {
    Connection cnx;
    Statement stmt;
    public ServicePack() {
        cnx=MyConnection.GetInstance();
        try {
            stmt=cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Pack> getAllPack() throws SQLException{
        String req="select * from packs";
        ResultSet rs = stmt.executeQuery(req);
        List<Pack> packs = new ArrayList<Pack>();
        Pack pack;
        ServiceHote serviceHote = new ServiceHote();
        Hote hote;
        while (rs.next()) {
            hote = serviceHote.getHoteById(rs.getInt(6));
            pack =new Pack(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),rs.getInt(5), hote);
            packs.add(pack);
        }
        return packs ;
    }
    public Pack getPackById (int id) throws SQLException {
        String req="select * from packs where id="+id;
        ResultSet rs = stmt.executeQuery(req);
        Pack pack=new Pack();
        Hote hote;
        ServiceHote serviceHote = new ServiceHote();
        while (rs.next()) {
            hote = serviceHote.getHoteById(rs.getInt(6));
            pack=new Pack(id, rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), hote);
        }
        return pack;
        
    }
    
    public Pack getPackByHote(Hote hote) throws SQLException {
        String req="select * from packs where id_hote="+hote.getId();
        ResultSet rs = stmt.executeQuery(req);
        Pack pack=new Pack();
        while (rs.next()) {
            pack=new Pack(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), hote);
        }
        return pack;
    }
    public void AjouterPack(Pack pack) throws SQLException {
        String req="insert into Packs(titre,description,prix,nbOffre,id_hote) values('"+pack.getTitre()+"','"+pack.getDescription()+"',"+pack.getPrix()+",0,"+pack.getHote().getId()+")";
        stmt.executeUpdate(req);
    }
    public void SupprimerPack(Pack pack) throws SQLException {
        String req="delete from packs where id="+pack.getId();
        stmt.executeUpdate(req);
    }
    
}
