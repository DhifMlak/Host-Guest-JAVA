/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Hote;
import entites.Logement;
import entites.Offre;
import entites.Pack;
import entites.Sortie;
import entites.Voyageur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author Bairem Zalleg
 */
public class ServiceSortie {
    Connection cnx;
    Statement stmt;
    public ServiceSortie() {
        cnx=MyConnection.GetInstance();
        try {
            stmt=cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceSortie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AjouterSortie(Sortie sortie) throws SQLException {
        String type="sortie";
        ServiceHote sh = new ServiceHote();
        Hote hote;
        hote = sh.getHoteById(1);
  
       // **** Ajout Offre****// 
        Offre offre = new Offre(type, hote);
        ServiceOffre so = new ServiceOffre();
        so.AjouterOffre(offre);
        
        // **** Ajout Sortie****// 
        
        String req2="select MAX(id) from offres";
        ResultSet rs = stmt.executeQuery(req2);
        if(rs.next()){
   System.out.println(rs.getInt(1));
}
   String req="insert into sorties(id,titre,lieu,description,nbMax,conditions,type_sortie) values('"+rs.getInt(1)+"','"+sortie.getTitre()+"','"+sortie.getLieu()+"','"+sortie.getDescription()+"','"+sortie.getNbMax()+"','"+sortie.getConditions()+"','"+sortie.getTypeSortie()+"')";

        
        stmt.executeUpdate(req);
    }
    
    public List<Sortie> getAllSortie() throws SQLException{
        String req="select * from sorties s, offres o where s.id=o.id";
        ResultSet rs = stmt.executeQuery(req);
        List<Sortie> sorties= new ArrayList<Sortie>();
        Sortie sortie;
        Hote hote;
        ServiceHote serviceHote = new ServiceHote();
        while(rs.next()) {
            hote=serviceHote.getHoteById(rs.getInt("id_hote"));
            //sortie=new Sortie(rs.getString("titre"), rs.getString("lieu"), rs.getString("description"), rs.getInt("nbMax"), hote);
             sortie= new Sortie(rs.getInt("id"),rs.getString("titre"),rs.getString("lieu"), rs.getInt("nbMax"), rs.getString("description"),rs.getString("conditions"),rs.getString("type_sortie"),"sortie", hote);
    
            sorties.add(sortie);
            
        }
        return sorties;
        
    }
    
    
    public List<Sortie> getSortieById(int id) throws SQLException {
        String req="select * from sorties s, offres o where s.id=o.id and s.id="+id;
        ResultSet rs = stmt.executeQuery(req);
        List<Sortie> sorties= new ArrayList<Sortie>();
        Sortie sortie;
        Hote hote;
        ServiceHote serviceHote = new ServiceHote();
        while(rs.next()) {
            hote=serviceHote.getHoteById(rs.getInt("id_hote"));
            sortie=new Sortie(id,rs.getString("titre"),rs.getString("lieu"), rs.getInt("nbMax"), rs.getString("description"),rs.getString("conditions"),rs.getString("type_sortie"),"sortie", hote);
    
            sorties.add(sortie);
            
        }
        return sorties;
    }
     
    
    


       
        public void modifierSortie(Sortie sortie) throws SQLException{
        String req="update sorties set titre='"+sortie.getTitre()+"',lieu='"+sortie.getLieu()+
                "',description='"+sortie.getDescription()+"',nbMax="+sortie.getNbMax()+
                ",conditions='"+sortie.getConditions()+"',type_sortie='"+sortie.getTypeSortie()+"' WHERE id="+sortie.getId();
        stmt.executeUpdate(req);
        }
        
        public void SupprimerSortie(Sortie sortie) throws SQLException {
        String req="delete from offres where id="+sortie.getId();
        stmt.executeUpdate(req);
        System.out.println("deleted");
    }
        
        public void SupprimerSortieById(int id) throws SQLException {
        String req="delete from offres where id="+id;
        stmt.executeUpdate(req);
            System.out.println("deleted");
    }
        
        
        
}
