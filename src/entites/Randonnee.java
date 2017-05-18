/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Firas
 */
public class Randonnee extends Offre {
    private String titre;
    private String lieu;
    private int nbMax;
    private String description;

    public Randonnee(String titre, String lieu, int nbMax, String description, int id,String typeOffre, Hote hote) {
        super(id,typeOffre, hote);
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
    }

    public Randonnee(String titre, String lieu, int nbMax, String description,String typeOffre, Hote hote) {
        super(typeOffre,hote);
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNbMax() {
        return nbMax;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Rendonne{" + "titre=" + titre + ", lieu=" + lieu + ", nbMax=" + nbMax + ", description=" + description + '}';
    }
    
    
    
    
}
