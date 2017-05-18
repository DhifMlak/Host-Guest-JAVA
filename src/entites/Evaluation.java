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
public class Evaluation {
    private int id;
    private String titre;
    private float note;
    private String commantaire;
    private Voyageur voyageur;
    private Offre offre;

    public Evaluation(int id, String titre, float note, String commantaire, Voyageur voyageur, Offre offre) {
        this.id = id;
        this.titre = titre;
        this.note = note;
        this.commantaire = commantaire;
        this.voyageur = voyageur;
        this.offre = offre;
    }

    public Evaluation(String titre, float note, String commantaire, Voyageur voyageur, Offre offre) {
        this.titre = titre;
        this.note = note;
        this.commantaire = commantaire;
        this.voyageur = voyageur;
        this.offre = offre;
    }

    public Evaluation(int id, String titre, float note, String commantaire, Voyageur voyageur) {
        this.id = id;
        this.titre = titre;
        this.note = note;
        this.commantaire = commantaire;
        this.voyageur = voyageur;
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

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getCommantaire() {
        return commantaire;
    }

    public void setCommantaire(String commantaire) {
        this.commantaire = commantaire;
    }

    public Voyageur getVoyageur() {
        return voyageur;
    }

    public void setVoyageur(Voyageur voyageur) {
        this.voyageur = voyageur;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "id=" + id + ", titre=" + titre + ", note=" + note + ", commantaire=" + commantaire + ", voyageur=" + voyageur + ", offre=" + offre + '}';
    }
    
    
    
}
