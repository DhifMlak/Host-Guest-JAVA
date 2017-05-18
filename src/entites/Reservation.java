/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import services.ServiceReservation;
import utils.AlertMessage;
import utils.ScreenController;
import utils.Shared;
import static utils.StageManager.getStage;

/**
 *
 * @author Firas
 */
public class Reservation {
    private int id;
    private int etat; // -1 refusé, 0 en attente , 1 accepté
    private int nbReservation;
    private int type; // 0 offre, 1 pack
    private Voyageur voyageur;
    private Offre offre;
    private Pack pack;
    private String date_Deb;
    private String date_Fin;
    public Reservation(int id, int etat, int nbReservation, int type, Voyageur voyageur, Offre offre, Pack pack , String date_Deb ,String date_Fin) {
        this.id = id;
        this.etat = etat;
        this.nbReservation = nbReservation;
        this.type = type;
        this.voyageur = voyageur;
        this.offre = offre;
        this.pack = pack;
        this.date_Deb =date_Deb;
        this.date_Fin = date_Fin;
    }

    public String getDate_Deb() {
        return date_Deb;
    }

    public void setDate_Deb(String date_Deb) {
        this.date_Deb = date_Deb;
    }

    public String getDate_Fin() {
        return date_Fin;
    }

    public void setDate_Fin(String date_Fin) {
        this.date_Fin = date_Fin;
    }

    public Reservation(int etat, int nbReservation, int type, Voyageur voyageur, Offre offre, Pack pack,String date_Deb ,String date_Fin) {
        this.etat = etat;
        this.nbReservation = nbReservation;
        this.type = type;
        this.voyageur = voyageur;
        this.offre = offre;
        this.pack = pack;
        this.date_Deb =date_Deb;
        this.date_Fin = date_Fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getNbReservation() {
        return nbReservation;
    }

    public void setNbReservation(int nbReservation) {
        this.nbReservation = nbReservation;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    @Override
    public String toString() {
        return "Reservation{" + "etat=" + etat + ", nbReservation=" + nbReservation + ", type=" + type + ", voyageur=" + voyageur + ", offre=" + offre + ", pack=" + pack + ", date_Deb=" + date_Deb + ", date_Fin=" + date_Fin + '}';
    }

  
    
    
public HBox getAction() {
        HBox action=new HBox(10);
        action.setAlignment(Pos.CENTER);

        Label delete=new Label("Annuler");
        delete.setOnMouseEntered(e->getStage().getScene().setCursor(Cursor.HAND));
        delete.setOnMouseExited(e->getStage().getScene().setCursor(Cursor.DEFAULT));
        delete.setTextFill(Color.web("#0099FF"));
        delete.setFont(Font.font("Segoe UI Semilight", FontWeight.BOLD, 12));
        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (AlertMessage.AlertMessageConfirmation()) {
                    try {
                        Shared.reservation=Reservation.this;
                        ServiceReservation SR = new ServiceReservation();
                        SR.SupprimerReservation(Shared.reservation);
                        ScreenController.setScreen(Shared.screen);
                    } catch (IOException ex) {
                        Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        });

        action.getChildren().addAll(delete);
        return action;
    }

    
}
