/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.List;

/**
 *
 * @author Firas
 */
public class Pack {
    private int id;
    private String titre;
    private String description;
    private float prix;
    private int nbOffre;
    private Hote hote;

    public Pack() {
    }
    
    
    

    public Pack(int id, String titre, String description, float prix,int nbOffre, Hote hote) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.nbOffre = nbOffre;
        this.prix = prix;
        this.hote = hote;
        
    }

    public Pack(String titre, String description, float prix, int nbOffre, Hote hote) {
        this.titre = titre;
        this.description = description;
        this.nbOffre = nbOffre;
        this.prix = prix;
        this.hote = hote;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbOffre() {
        return nbOffre;
    }

    public void setNbOffre(int nbOffre) {
        this.nbOffre = nbOffre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Hote getHote() {
        return hote;
    }

    public void setHote(Hote hote) {
        this.hote = hote;
    }

  
    @Override
    public String toString() {
        return "Pack{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", nbOffre=" + nbOffre + ", prix=" + prix + ", hote=" + hote + '}';
    }
    
    
    
}
