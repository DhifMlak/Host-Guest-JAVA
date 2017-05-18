/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import services.ServiceUser;
import entites.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.ScreenController;
import utils.UserConnecte;

/**
 * FXML Controller class
 *
 * @author mehdi
 */
public class LoginController implements Initializable {

    @FXML
    Button login;

    @FXML
    TextField authUser;

    @FXML
    TextField authPsswd;

    @FXML
    Label isConnected;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void loginAction(ActionEvent event) {
        System.out.println("0");
        Utilisateur utilisateur = null;

        ServiceUser serviceUser = new ServiceUser();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        System.out.println("1");
        if (authUser.getText().equals("") || authPsswd.getText().equals("")) {
            System.out.println("2");
            alert.setContentText("Fill all the blanks");
            alert.showAndWait();
        } else {

            try {
                // utilisateur=membreDAO.isLogin(authUser.getText(),CryptageMD5.CrypMd5(authPsswd.getText()));
                // utilisateur=membreDAO.isLogin(authUser.getText(),CryptageMD5.cypterPHP(authPsswd.getText()));
                utilisateur = serviceUser.getUserByPseudo(authUser.getText());
                System.out.println("3");
                if (utilisateur != null) {
                    System.out.println("4");
                    if ((utilisateur.getPseudo().compareTo(authUser.getText()) == 0) && (utilisateur.getMot_de_passe().compareTo(authPsswd.getText()) == 0)) {

                        isConnected.setText("Username or Password is correct");
                        UserConnecte.logIn(utilisateur);
                        System.out.println("5");
                        ///////

//                    Voice voice = null;
//                    VoiceManager vm=VoiceManager.getInstance();
//                    voice=vm.getVoice("kevin");
//                    voice.allocate();
//                    voice.speak("Welcome "+utilisateur.getNom()+" "+utilisateur.getPrenom()+
//                            " to our desktop application");
//                    
//                    
                        //////
                        //((Node)event.getSource()).getScene().getWindow().hide();
                        // if(utilisateur.getRole())
                        /// root = loader.load(getClass().getResource("/AccueilConnecte.fxml"));
                        ScreenController.setScreen(ScreenController.Screen.MENU);

                        System.out.println("7");

                        //else{
                        //    root = loader.load(getClass().getResource("/tn/esprit/crowdrise/presentation/GUI_Accueil.fxml"));
                        // }
                        /* MembreConnecte.setId(utilisateur.getId());
                    MembreConnecte.setNom(utilisateur.getNom());
                    MembreConnecte.setPrenom(utilisateur.getPrenom());
                    MembreConnecte.setUsername(utilisateur.getUsername());
                    MembreConnecte.setMotDePasse(utilisateur.getMotDePasse());
                    MembreConnecte.setEmail(utilisateur.getEmail());
                    MembreConnecte.setImgP(utilisateur.getURL_pic());
                    
                    String[] tabInfos=membreDAO.getInfosProfil(MembreConnecte.getId());
                    MembreConnecte.setCompetences(tabInfos[0]);
                    MembreConnecte.setExperience(tabInfos[1]);
                         */
                    } else {
                        alert.setContentText("Utilisateur bloque");
                        alert.showAndWait();

                    }
                } else {
                    isConnected.setText("Incorrect Username or Password");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public Button getLogin() {
        return login;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

    public TextField getAuthUser() {
        return authUser;
    }

    public void setAuthUser(TextField authUser) {
        this.authUser = authUser;
    }

    public TextField getAuthPsswd() {
        return authPsswd;
    }

    public void setAuthPsswd(TextField authPsswd) {
        this.authPsswd = authPsswd;
    }

    public Label getIsConnected() {
        return isConnected;
    }

    public void setIsConnected(Label isConnected) {
        this.isConnected = isConnected;
    }

}
