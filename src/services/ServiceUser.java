/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Utilisateur;
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

/**
 *
 * @author mehdi
 */
public class ServiceUser implements IServiceUtilisateur{

    
  Connection connexion;
    Statement ste;
    public ServiceUser() {
        connexion=MyConnection.GetInstance();
        try {
            ste=connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    @Override
    public void addUser(Utilisateur user) {
  try {
            //String req2 = "insert into utilisateur (nom_utilisateur,prenom_utilisateur,username,password,email,roles) "
                    //+ "values('"+Utilisateur.getNom()+"', '"+membre.getPrenom()+"','"+membre.getUsername()+"','"+membre.getMotDePasse()+"','"+membre.getEmail()+"','a:0:{}')";
            
          // String req1="INSERT INTO `utilisateurs` (`nom`, `prenom`, `date_naissance`, `cin`, `email`, `pseudo`, `mot_de_passe`, `etat`, `roles`) "
                  //  + "VALUES ( '"+user.getNom()+"', '"+user.getPrenom()+"', '"+user.getDateNaissance()+"', '"+user.getCin()+"', '"+user.getEmail()+"', '"+user.getPseudo()+"', '"+user.getMotDePasse()+"', '1', 'voyageur');";
            
            
              String req1="INSERT INTO `utilisateurs` (`nom`, `prenom`, `date_naissance`, `cin`, `email`, `pseudo`, `mot_de_passe`, `etat`, `roles`) "
                    + "VALUES ( '"+user.getNom()+"', '"+user.getPrenom()+"', NULL, '"+user.getCin()+"', '"+user.getEmail()+"', '"+user.getPseudo()+"', '"+user.getMot_de_passe()+"', '1', 'voyageur');";
            
            
            ste.executeUpdate(req1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void updateUser(Utilisateur user) {
        System.out.println("utilisateur update ETAT "+user.getEtat()+"   "+user.getId());
            String req1=" UPDATE `utilisateurs` SET `nom` = '"+ user.getNom()+"', `prenom` = '"+ user.getPrenom()+"', `cin` = '"+ user.getCin()+"', `email` = '"+ user.getEmail()+"', `pseudo` = '"+ user.getPseudo()+"', `mot_de_passe` = '"+ user.getMot_de_passe()+"', `etat` = '"+ user.getEtat()+"' WHERE `utilisateurs`.`id` = "+ user.getId()+";";       
   
      try {
          ste.executeUpdate(req1);
      } catch (SQLException ex) {
          Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }

    
    
    
    
    @Override
    public void deleteUser(Utilisateur user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Utilisateur> getAllUser() {
          List<Utilisateur> membres= new ArrayList<>();
        Utilisateur meb ;
        String req4= "select * from utilisateurs where etat=1";
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               //(int id, String nom, String prenom, Date dateNaissance, String cin, String email, String pseudo, String motDePasse, int etat,String role)
              //meb = new Utilisateur(res.getInt("id"),res.getString("nom"),res.getString("nb_projets"),res.getDate("nb_idees"),res.getString("email"),
                      // res.getString("pse"), res.getString("psw"),res.getInt("username"));
              meb=new Utilisateur(res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getDate("date_naissance"),res.getString("cin"),res.getString("email") , res.getString("pseudo"), res.getString("mot_de_passe"), res.getInt("etat"),res.getString("role"),res.getString("username"),res.getString("username_canonical"));
                       
               membres.add(meb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return membres;  }

    @Override
    public String GetRoleByPseudo(int id) {
      return "";


    }

    @Override
    public Utilisateur getUserByID(int id) {
       Utilisateur meb =null ;
        
       String req="select * from utilisateurs where id="+id+"";
       
         try {
             ResultSet res=ste.executeQuery(req);
             
             while(res.next())
             {
    
              meb=new Utilisateur(res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getDate("date_naissance"),res.getString("cin"),res.getString("email") , res.getString("pseudo"), res.getString("mot_de_passe"), res.getInt("etat"),res.getString("roles"),res.getString("username"),res.getString("username_canonical"));

                 
             }
             
             
         } catch (SQLException ex) {
             Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return meb;
    }

    @Override
    public Utilisateur getUserByPseudo(String pseudo) {
       Utilisateur meb =null ;
        
       String req="select * from utilisateurs where pseudo='"+pseudo+"'";
       
         try {
             ResultSet res=ste.executeQuery(req);
             
             while(res.next())
             {
    
              meb=new Utilisateur(res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getDate("date_naissance"),res.getString("cin"),res.getString("email") , res.getString("pseudo"), res.getString("mot_de_passe"), res.getInt("etat"),res.getString("roles"),res.getString("username"),res.getString("username_canonical"));

                 
             }
             
             
         } catch (SQLException ex) {
             Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return meb;
    }
    
    
    
    
    
}
