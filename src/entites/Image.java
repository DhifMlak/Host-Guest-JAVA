/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Blob;

/**
 *
 * @author Firas
 */
public class Image {
    private int id;
    private Blob src;//private Byte[] src;
    private String titre;

    public Image(int id, Blob src, String titre) {
        this.id = id;
        this.src = src;
        this.titre = titre;
    }

    public Image(Blob src, String titre) {
        this.src = src;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getSrc() {
        return src;
    }

    public void setSrc(Blob src) {
        this.src = src;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    
    
}
