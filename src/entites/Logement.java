/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import utils.ScreenController;
import utils.Shared;
import static utils.StageManager.getStage;

/**
 *
 * @author Mehdi ben Aissa
 */
public class Logement extends Offre{
    private String titre;
    private String adresse;
    private String ville;
    private String pays;
    private float prix;
    private String type;
    private int internet ;
    private int parking ;
    private byte cableTv ;
    private byte piscine ;
    

     public Logement() {
        
    }
     
     
    public Logement(String titre, String address, String ville, String paye, float prix, String type, int id, String typeOffre, Hote hote) {
        super(id,typeOffre, hote);
        this.titre = titre;
        this.adresse = address;
        this.ville = ville;
        this.pays = paye;
        this.prix = prix;
        this.type = type;
    }
    public Logement(String titre, String address, String ville, String paye, float prix, String type,String typeOffre, Hote hote) {
        super(typeOffre,hote);
        this.titre = titre;
        this.adresse = address;
        this.ville = ville;
        this.pays = paye;
        this.prix = prix;
        this.type = type;
    }

    public Logement(String titre, String address, String ville, String paye, float prix, String type,int internet,int parking,byte cableTv, byte piscine,String typeOffre, Hote hote) {
        super(typeOffre,hote);
        this.titre = titre;
        this.adresse = address;
        this.ville = ville;
        this.pays = paye;
        this.prix = prix;
        this.type = type;
        this.internet = internet ;
        this.parking = parking ;
        this.cableTv= cableTv ;
        this.piscine= piscine ;
    }
    
      public Logement(int id,String titre, String address, String ville, String paye, float prix, String type,int internet,int parking,byte cableTv, byte piscine,String typeOffre, Hote hote) {
        super(typeOffre,hote);
        this.titre = titre;
        this.adresse = address;
        this.ville = ville;
        this.pays = paye;
        this.prix = prix;
        this.type = type;
        this.internet = internet ;
        this.parking = parking ;
        this.cableTv= cableTv ;
        this.piscine= piscine ;
    }
       public Logement(int id,String titre, String address, String ville, String paye, float prix, String type,int internet,int parking,byte cableTv, byte piscine) {
        
        this.titre = titre;
        this.adresse = address;
        this.ville = ville;
        this.pays = paye;
        this.prix = prix;
        this.type = type;
        this.internet = internet ;
        this.parking = parking ;
        this.cableTv= cableTv ;
        this.piscine= piscine ;
    }
    
    
    public Logement(String titre, String address, String ville, String paye, float prix, String type,int internet,int parking, int id, String typeOffre, Hote hote) {
        super(id,typeOffre, hote);
        this.titre = titre;
        this.adresse = address;
        this.ville = ville;
        this.pays = paye;
        this.prix = prix;
        this.type = type;
        this.internet =internet ;
        this.parking =parking ;
    }

    

   

   

    public String getTitre() {
        return titre;
    }

    public String getAddress() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getPaye() {
        return pays;
    }

    public float getPrix() {
        return prix;
    }

    public String getTypeOffre() {
        return type;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAddress(String address) {
        this.adresse = address;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPaye(String paye) {
        this.pays = paye;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setTypeOffre(String type) {
        this.type = type;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte getCableTv() {
        return cableTv;
    }

    public void setCableTv(byte cableTv) {
        this.cableTv = cableTv;
    }

    public byte getPiscine() {
        return piscine;
    }

    public void setPiscine(byte piscine) {
        this.piscine = piscine;
    }

    @Override
    public String toString() {
        return "logement{" + "titre=" + titre + ", address=" + adresse + ", ville=" + ville + ", paye=" + pays + ", prix=" + prix + ", type=" + type + '}';
    }
    
    
    
      
    
    public HBox getAction() {
        HBox action=new HBox(10);
        action.setAlignment(Pos.CENTER);
/*
        Label delete=new Label("Delete");
        delete.setOnMouseEntered(e->getStage().getScene().setCursor(Cursor.HAND));
        delete.setOnMouseExited(e->getStage().getScene().setCursor(Cursor.DEFAULT));
        delete.setTextFill(Color.web("#0099FF"));
        delete.setFont(Font.font("Segoe UI Semilight", FontWeight.BOLD, 12));
        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (AlertMessage.AlertMessageConfirmation()) {
                    //  ProjectsDB.deleteProject(getJobNumber());
                    //ScreenController.setScreen(Shared.screen);
                }
            }
        */
        Label edit=new Label("Info");
        edit.setOnMouseEntered(e->getStage().getScene().setCursor(Cursor.HAND));
        edit.setOnMouseExited(e->getStage().getScene().setCursor(Cursor.DEFAULT));
        edit.setTextFill(Color.web("#0099FF"));
        edit.setFont(Font.font("Segoe UI Semilight", FontWeight.BOLD, 12));
        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Shared.offre2=Logement.this;
               try {
                    ScreenController.setScreen(ScreenController.Screen.LOGS);
                    System.out.println("3asba");
                } catch (IOException e) {
                    e.printStackTrace();
                }
               
            }
        });

        action.getChildren().addAll(edit);
        return action;
    }
    
    
}
