/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import utils.AlertMessage;
import utils.ScreenController;
import utils.Shared;
import static utils.StageManager.getStage;

/**
 *
 * @author Firas
 */
public class Sortie extends Offre{
   
    private String titre;
    private String lieu;
    private int nbMax;
    private String description;
    private String conditions;
    private String typeSortie;
    
    
    

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public void setTypeSortie(String typeSortie) {
        this.typeSortie = typeSortie;
    }

    public String getConditions() {
        return conditions;
    }

    public String getTypeSortie() {
        return typeSortie;
    }

    public Sortie(int id,String titre, String lieu, int nbMax, String description,String conditions,String typeSortie, String typeOffre, Hote hote) {
        super(id,typeOffre, hote);
       
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
        this.conditions=conditions;
        this.typeSortie=typeSortie;
    }

   

        public Sortie(String titre, String lieu, int nbMax, String description,String conditions,String typeSortie,String typeOffre, Hote hote) {
        super(typeOffre,hote);
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
        this.conditions=conditions;
        this.typeSortie=typeSortie;
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
        Label edit=new Label("Reserver");
        edit.setOnMouseEntered(e->getStage().getScene().setCursor(Cursor.HAND));
        edit.setOnMouseExited(e->getStage().getScene().setCursor(Cursor.DEFAULT));
        edit.setTextFill(Color.web("#0099FF"));
        edit.setFont(Font.font("Segoe UI Semilight", FontWeight.BOLD, 12));
        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Shared.offre=Sortie.this;
                try {
                    ScreenController.setScreen(ScreenController.Screen.SORTIES);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        action.getChildren().addAll(edit);
        return action;
    }
    @Override
    public String toString() {
        return "Sortie{" + "titre=" + titre + ", lieu=" + lieu + ", nbMax=" + nbMax + ", description=" + description + ", conditions=" + conditions + ", typeSortie=" + typeSortie + '}';
    }}

    

    
    
    
    
    


