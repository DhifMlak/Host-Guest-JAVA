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
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private java.util.Date date_naissance;
    private String cin;
    private String email;
    private String pseudo;
    private String mot_de_passe;
    private int etat;
    private String role;
    private String username;
    private String username_canonical;
    private String email_canonical;
    private String salt;
    private String password;
    private String confirmation_token;
    private java.util.Date Datefinban;

    public Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public java.util.Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(java.util.Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public java.util.Date getDatefinban() {
        return Datefinban;
    }

    

    /*
    public Utilisateur(int id, String nom, String prenom, Date dateNaissance, int cin, String email, String pseudo, String motDePasse, boolean etat) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.email = email;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.etat = etat;
    }

    public Utilisateur(String nom, String prenom, Date dateNaissance, int cin, String email, String pseudo, String motDePasse, boolean etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.email = email;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.etat = etat;
    }
     */

    public Utilisateur(int id,String nom, String prenom, Date date_naissance, String cin, String email, String pseudo, String mot_de_passe, int etat, String role, String username, String username_canonical) {
        
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.cin = cin;
        this.email = email;
        this.pseudo = pseudo;
        this.mot_de_passe = mot_de_passe;
        this.etat = etat;
        this.role = role;
        this.username = username;
        this.username_canonical = username_canonical;
        
    }


}
