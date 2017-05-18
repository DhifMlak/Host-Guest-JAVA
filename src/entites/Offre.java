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
public class Offre {
    private int id;
    private String typeOffre;//logement ou sortie ou randonnée
    private Hote hote;

    public Offre() {
    }
    

    public Offre(int id,String type, Hote hote) {
        this.id = id;
        this.typeOffre = type;
        this.hote = hote;
    }

    public Offre(String type,Hote hote) {
        this.typeOffre=type;
        this.hote = hote;
    }

    public int getId() {
        return id;
    }

    public Hote getHote() {
        return hote;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHote(Hote hote) {
        this.hote = hote;
    }

    public String getTypeOffre() {
        return typeOffre;
    }

    public void setTypeOffre(String typeOffre) {
        this.typeOffre = typeOffre;
    }
    

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", hote=" + hote + '}';
    }
    
    
    
}
