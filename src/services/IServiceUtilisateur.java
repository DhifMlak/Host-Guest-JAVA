/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Utilisateur;
import java.util.List;

/**
 *
 * @author mehdi
 */
public interface IServiceUtilisateur {
    
   public void addUser(Utilisateur user);
	public void updateUser(Utilisateur user);
	public void deleteUser(Utilisateur user);
	public Utilisateur getUserByID(int id);
	public Utilisateur getUserByPseudo(String pseudo);
	public List<Utilisateur> getAllUser();
	public String GetRoleByPseudo(int id);
        
    
    
}
