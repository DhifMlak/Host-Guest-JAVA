/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author Firas
 */
public class Voyageur extends Utilisateur{

    public Voyageur() {
    }

    public Voyageur(int id, String nom, String prenom, Date date_naissance, String cin, String email, String pseudo, String mot_de_passe, int etat, String role, String username, String username_canonical) {
        super(id, nom, prenom, date_naissance, cin, email, pseudo, mot_de_passe, etat, role, username, username_canonical);
    }

  
   
    
    
    
}
