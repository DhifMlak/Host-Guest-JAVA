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
public class PackOffre {
    private int id;
    private Pack pack;
    private Offre offre;

    public PackOffre(Pack pack, Offre offre) {
        this.pack = pack;
        this.offre = offre;
    }

    public PackOffre(int id, Pack pack, Offre offre) {
        this.id = id;
        this.pack = pack;
        this.offre = offre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }
    
    
    
}
