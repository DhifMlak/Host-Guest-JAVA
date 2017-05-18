/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entites.Utilisateur;

/**
 *
 * @author mehdi
 */
public class UserConnecte {
    
   private static Utilisateur usr;
    
   
    private UserConnecte (Utilisateur user){
        
        usr=user;
        
    }
    
    
    public static Utilisateur getUserConnecté(){
        
       return usr;
    }

     public static void logIn(Utilisateur usr) {
        UserConnecte.usr = usr;
    }

    public static void logOut() {
        UserConnecte.usr = null;
    }
    
    
    
    
}
