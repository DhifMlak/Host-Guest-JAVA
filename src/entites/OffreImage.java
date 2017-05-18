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
public class OffreImage {
    private int id;
    private Offre offre;
    private Image image;

    public OffreImage(int id, Offre offre, Image image) {
        this.id = id;
        this.offre = offre;
        this.image = image;
    }

    public OffreImage(Offre offre, Image image) {
        this.offre = offre;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    
}
