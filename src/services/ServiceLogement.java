/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Hote;
import entites.Logement;
import entites.Offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;
import utils.UserConnecte;

/**
 *
 * @author Mehdi ben Aissa
 */
public class ServiceLogement {

    
    Connection cnx;
    Statement stmt;
    public ServiceLogement() {
        cnx=MyConnection.GetInstance();
        try {
            stmt=cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceLogement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int AjouterLogement(Logement logement) throws SQLException {
       String type="log";
        ServiceHote sh = new ServiceHote();
        Hote hote;
       
        hote = sh.getHoteById(UserConnecte.getUserConnecté().getId());
        System.out.println("jdud"+hote);
  
       // **** Ajout Offre****// 
        Offre offre = new Offre(type, hote);
        ServiceOffre so = new ServiceOffre();
        so.AjouterOffre(offre);
       
        // **** Ajout Sortie****// 
        
        String req = "select MAX(id) from offres";
        ResultSet rs = stmt.executeQuery(req);
        rs.next();
          
   

   String req1="insert into logements(id,titre,adresse,ville,paye,prix,type,internet,parking,cableTv,piscine) values('"+rs.getInt(1)+"','"+logement.getTitre()+"','"+logement.getAddress()+"','"+logement.getVille()+"','"+logement.getPaye()+"','"+logement.getPrix()+"','"+logement.getTypeOffre()+"','"+logement.getInternet()+"','"+logement.getParking()+"','"+logement.getCableTv()+"','"+logement.getPiscine()+"')";
 int a= stmt.executeUpdate(req1);
         
         
          return(a);
    }
     
    
    
    
   
    public List<Logement> getLogementByHote(Hote hote) throws SQLException {
        List <Logement> logements = new ArrayList<>();
        String req="select * from logements l, offres o where l.id=o.id and o.id_hote="+hote.getId();
        ResultSet rs = stmt.executeQuery(req);
        Logement logement;
        while(rs.next()) {
            logement = new Logement(rs.getString("titre"), rs.getString("adresse"), rs.getString("ville"), rs.getString("paye"), rs.getFloat("prix"), rs.getString("type"),rs.getInt("id"),rs.getString("type_offre"), hote);
            logements.add(logement);
        }
        return logements;
    }
    public List<Logement> getLogementByPays(String paye) throws SQLException {
        String req="select * from logements l, offres o where l.paye='"+paye+ "' and l.id=o.id";
        ResultSet rs = stmt.executeQuery(req);
        List<Logement> logements= new ArrayList<Logement>();
        Logement logement;
        Hote hote;
        ServiceHote serviceHote = new ServiceHote();
        while(rs.next()) {
            hote=serviceHote.getHoteById(rs.getInt("id_hote"));
            logement=new Logement(rs.getString("titre"), rs.getString("adresse"), rs.getString("ville"), rs.getString("paye"), rs.getFloat("prix"), rs.getString("type"), rs.getInt("id"),rs.getString("type_Offre"), hote);
            logements.add(logement);
            
        }
        return logements;
    }
    public List<Logement> getAllLogement() throws SQLException{
        
        
        System.out.println("getAllLogement");
        String req="select * from logements l, offres o where l.id=o.id";
        ResultSet rs = stmt.executeQuery(req);
        List<Logement> logements= new ArrayList<Logement>();
        Logement logement;
        Hote hote;
        ServiceHote serviceHote = new ServiceHote();
        while(rs.next()) {
            ////14
            hote=serviceHote.getHoteById(rs.getInt("id_hote"));
            System.out.println("00000000000"+rs.getInt("id_hote"));
            System.out.println("hote"+hote);
            logement=new Logement(rs.getString("titre"), rs.getString("adresse"), rs.getString("ville"), rs.getString("paye"), rs.getFloat("prix"), rs.getString("type"), rs.getInt("id"),rs.getString("type_offre"), hote);
            logements.add(logement);
            
        }
        System.out.println("service liste logement"+logements);
        
                
        return logements;
        
    }
     public List<Logement> getLogementByVille(String ville) throws SQLException {
        String req="select * from logements l, offres o where l.id=o.id and l.ville like '%"+ville+"%'";
        ResultSet rs = stmt.executeQuery(req);
        List<Logement> logements= new ArrayList<Logement>();
        Logement logement;
        Hote hote;
        ServiceHote serviceHote = new ServiceHote();
        int nb=0;
         System.out.println("Inside Service Before nb="+nb);
        while(rs.next()) {
            hote=serviceHote.getHoteById(rs.getInt("id_hote"));
            logement=new Logement(rs.getString("titre"), rs.getString("adresse"), rs.getString("ville"), rs.getString("paye"), rs.getFloat("prix"), rs.getString("type"), rs.getInt("id"),rs.getString("type_Offre"), hote);
            logements.add(logement);
            nb=nb+1;
            
        }
        System.out.println("Inside Service After nb="+nb);
        return logements;
    }
     
       public void supprimerlogement(int ID_logement) throws SQLException {
        String requete = "delete from logements where id="+ID_logement;
        stmt.executeUpdate(requete);
    
//            PreparedStatement ps = cnx.prepareStatement(requete);
//            ps.setInt(1, ID_logement);
//            ps.executeUpdate();
//            System.out.println("oki");
        
        //return false;
    }
    public void modifierLogement(Logement log) {
      //  System.out.println("utilisateur update ETAT "+log.getEtat()+"   "+log.getId());
            String req1=" UPDATE `Logements` SET `titre` = '"+ log.getTitre()+"', `adresse` = '"+ log.getAddress()+"', `ville` = '"+ log.getVille()+"', `paye` = '"+ log.getPaye()+"', `prix` = "+ log.getPrix()+" where id="+log.getId();       
   
      try {
          stmt.executeUpdate(req1);
      } catch (SQLException ex) {
          Logger.getLogger(ServiceLogement.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }
       public List<Logement> rechercheAvancee(boolean a,boolean b,boolean c,boolean d) throws SQLException{
          String req="select * from logements ";
          
            ResultSet rs = stmt.executeQuery(req);
        List<Logement> logements= new ArrayList<Logement>();
        Logement logement1=new Logement();
        Hote hote;
        ServiceHote serviceHote = new ServiceHote();
        
        
        while(rs.next()) {
            
            logement1=new Logement(rs.getInt("id"),rs.getString("titre"), rs.getString("adresse"), rs.getString("ville"), rs.getString("paye"), rs.getFloat("prix"), rs.getString("type"),rs.getByte("internet"),rs.getByte("parking"),rs.getByte("cableTv"),rs.getByte("piscine"));
            if((a==(logement1.getInternet()==1))&&(b==(logement1.getParking()==1))&&(c==(logement1.getCableTv()==1))&&(d==(logement1.getPiscine()==1))){
                
            logements.add(logement1);
            }
        }
        System.out.println("list resultat///////"+logements);
        
        return logements;
       }
}
