package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import animation.FadeInLeftTransition;
import animation.FadeInUpTransition;
import entites.Logement;
import entites.Pack;
import entites.Reservation;
import entites.Voyageur;
import utils.ScreenController;
import utils.Shared;

import utils.AlertMessage;
import utils.Loading;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.util.Duration;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;
import services.ServiceLogement;
import services.ServicePack;
import services.ServiceReservation;
import services.ServiceVoyageur;

import static utils.StageManager.getStage;

public class Logements {

    @FXML
    private ImageView ImageLoading;
    @FXML
    private ProgressBar ProgressLoading;
    @FXML
    private GridPane PaneAdd;
    @FXML
    private GridPane PaneTabel;
    @FXML
    private HBox PaneTop;

    @FXML
    private Button ButtonBack;
   
    @FXML
    private Button ButtonSave;
    @FXML
    private AnchorPane PaneMain;
    @FXML
    private TableView<Logement> TableProjects;
    @FXML
    private TableColumn<Logement, HBox> ColumnAction;
    @FXML
    private TableColumn<Logement, String> ColumnStatus;
    @FXML
    private TableColumn<Logement, String> ColumnDP_RO;
    @FXML
    private TableColumn<Logement, String> ColumnDP_NA;
    @FXML
    private TableColumn<Logement, String> ColumnJobNumber;
    private TableColumn<Logement, String> ColumnJobType;
    @FXML
    private TableColumn<Logement, String> ColumnClient;
    @FXML
    private TableColumn<Logement, String> ColumnCS;

    @FXML
    private Text TextEmptyTable;
    
    private ObservableList<Logement> listProjects;
    private String old_jobNumber;
    @FXML
    private GridPane PaneReserverLog;
    @FXML
    private Button ButtonBack1;
    @FXML
    private TextField FieldJobNumber1;
    private TextField FieldJobTitle1;
    @FXML
    private TextField FieldClient1;
    @FXML
    private DatePicker DateFieldStart1;
    @FXML
    private DatePicker DateCheckCS1;
    @FXML
    private TextArea FieldAnalyticsToCS1;
    @FXML
    private Button ButtonSave1;
    @FXML
    private Label erreurnbp;
    @FXML
    private Label erreurDate1;
    @FXML
    private Label erreurDate2;

    public void initialize() throws SQLException {
  

        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter
                    = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        /*   DateAssignDate.setConverter(converter);
        DateFieldEnd.setConverter(converter);
        DateFieldStart.setConverter(converter);
        DateFinalCheckCS.setConverter(converter);
        DateFinalCheckIpsos.setConverter(converter);
         */
        ButtonBack.setOnMouseEntered(e -> getStage().getScene().setCursor(Cursor.HAND));
        ButtonBack.setOnMouseExited(e -> getStage().getScene().setCursor(Cursor.DEFAULT));

        ButtonBack1.setOnMouseEntered(e -> getStage().getScene().setCursor(Cursor.HAND));
        ButtonBack1.setOnMouseExited(e -> getStage().getScene().setCursor(Cursor.DEFAULT));

        PaneMain.getChildren().remove(PaneAdd);
        PaneMain.getChildren().remove(PaneReserverLog);
        PaneMain.getChildren().remove(PaneTabel);
       
// ServiceSortie SS = new ServiceSortie();
ServiceLogement SL = new ServiceLogement();
listProjects = FXCollections.observableArrayList(SL.getAllLogement());

        ImageLoading.setVisible(true);
        ProgressLoading.setProgress(0);
        ProgressLoading.progressProperty().unbind();
        Task task = Loading.load();
        ProgressLoading.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                ImageLoading.setVisible(false);
                if (Shared.offre2 != null) {
                    editProject();
                } else {
                    PaneTop.setVisible(true);
                    PaneMain.getChildren().add(PaneTabel);
                    if (listProjects.isEmpty()) {
                        TextEmptyTable.setVisible(true);
                    } else {
                        initializeTable();
                    }
                    new FadeInLeftTransition(PaneTop).play();
                    new FadeInUpTransition(PaneTabel).play();
                }
            }
        });

    }

    public void initializeTable() {
        PaneTabel.setVisible(true);

        TableProjects.setItems(listProjects);
        ColumnAction.setCellValueFactory(new PropertyValueFactory<Logement, HBox>("action"));
        ColumnStatus.setCellValueFactory(new PropertyValueFactory<Logement, String>("id"));
//        ColumnAssignDate.setCellValueFactory(new PropertyValueFactory<Sortie, String>("assignDate"));
        ColumnDP_RO.setCellValueFactory(new PropertyValueFactory<Logement, String>("Titre"));
        ColumnDP_NA.setCellValueFactory(new PropertyValueFactory<Logement, String>("description"));
        ColumnJobNumber.setCellValueFactory(new PropertyValueFactory<Logement, String>("lieu"));
//        ColumnJobTitle.setCellValueFactory(new PropertyValueFactory<Sortie, String>("type"));
//        ColumnJobType.setCellValueFactory(new PropertyValueFactory<Sortie, String>("type_sortie"));
        //      ColumnClient.setCellValueFactory(new PropertyValueFactory<Sortie, String>("nbMax"));
        ColumnCS.setCellValueFactory(new PropertyValueFactory<Logement, String>("nbMax"));

    }

    @FXML
    public void saveAdd() {

        new AlertMessage("Success", "Your project is added into database!", Alert.AlertType.INFORMATION);
        // back();
    }

    @FXML
    public void ajoutReservation() throws SQLException, MessagingException {
        ServiceVoyageur SV = new ServiceVoyageur();
        ServicePack SP = new ServicePack();
        System.out.println(DateFieldStart1.toString());
        Voyageur v = SV.GetVoyageurById(5);
        Pack p = SP.getPackById(0);
        Logement log = Shared.offre2;
        ServiceReservation SR = new ServiceReservation();
        if (checkValues()) {
            Image img = new Image("/img/img.png");
            //converDate(DateFinalCheckIpsos.getValue()
            Notifications notificationBuilder = Notifications.create()
                    .title("Reservation")
                    .text("Votre demande de reservation a éte bien envoyé")
                    .graphic(new ImageView(img))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT).onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Notification");
                }
            })
                
            ;
            //notificationBuilder.darkStyle();
            notificationBuilder.show();
            
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
            notificationBuilder.show();                }
            });
            Reservation reservation = new Reservation(0, Integer.parseInt(FieldClient1.getText()), 0, v, log, p, converDate(DateFieldStart1.getValue()), converDate(DateCheckCS1.getValue()));
            SR.AjouterReservation(reservation);
            Shared S = new Shared();
            S.sendmail(log.getHote().getEmail(), FieldAnalyticsToCS1.getText());
            back();
        }
    }

    public void saveEdit() {/*
        new AlertMessage("Success","Your project is added into database!", Alert.AlertType.INFORMATION);
        back();*/

        Logement sortie = Shared.offre2;
        old_jobNumber = sortie.getTitre();

        PaneTabel.setVisible(false);
        PaneAdd.setVisible(false);
        new FadeInUpTransition(PaneReserverLog).play();
        PaneMain.getChildren().remove(PaneAdd);
        PaneMain.getChildren().add(PaneReserverLog);
        FieldJobNumber1.setText(sortie.getTitre());
//        FieldDP_NA1.setText(sortie.getLieu());

        FieldJobTitle1.setEditable(false);
      //  FieldClient1.setText(Integer.toString(sortie.getCableTv()));

        ButtonSave1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ajoutReservation();
                } catch (SQLException ex) {
                    Logger.getLogger(Logements.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(Logements.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void editProject() {
        Logement sortie = Shared.offre2;
        old_jobNumber = sortie.getTitre();
//           Shared.offre=null;
        PaneTop.setVisible(false);
        new FadeInUpTransition(PaneAdd).play();
        PaneMain.getChildren().remove(PaneTabel);
        PaneMain.getChildren().add(PaneAdd);

        ButtonSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveEdit();
            }
        });
    }

    @FXML
    public void back() {
        try{ 
            Shared.offre = null;
            Shared.offre2 = null;
            ScreenController.setScreen(ScreenController.Screen.LOGS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Annuler() {
        try {
            Shared.offre2 = null;
            Shared.offre = null;
            ScreenController.setScreen(ScreenController.Screen.LOGS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void newProject() {
        TextEmptyTable.setVisible(false);
        PaneTop.setVisible(false);
        new FadeInUpTransition(PaneAdd).play();
        PaneMain.getChildren().remove(PaneTabel);
        PaneMain.getChildren().add(PaneAdd);
    }

   

    public String converDate(LocalDate dateToConvert) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return dateFormatter.format(dateToConvert);
    }

    public LocalDate converDateBack(String dateToConvert) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return LocalDate.parse(dateToConvert, dateFormatter);
    }

   
    private boolean checkValues() {
        erreurnbp.setText("");
        erreurDate1.setText("");
        erreurDate2.setText("");
        if (FieldClient1.getText().trim().isEmpty()) {
            erreurnbp.setText("Ce champ est obligatoire");
            return false;
        }

        if (Integer.parseInt(FieldClient1.getText()) == 0) {
            erreurnbp.setText("Ce champ ne doit pas etre egale a 0");
            return false;

        }
        if (Integer.parseInt(FieldClient1.getText()) > Shared.offre.getNbMax()) {
            erreurnbp.setText("Ce champ ne doit pas depasser " + Shared.offre.getNbMax());

            return false;

        }
        if (DateFieldStart1.getValue() == null) {
            erreurDate1.setText("Ce champ est obligatoire");
            return false;

        }
        if (DateCheckCS1.getValue() == null) {
            erreurDate2.setText("Ce champ est obligatoire");
            return false;

        }

        if (DateFieldStart1.getValue().compareTo(DateCheckCS1.getValue()) > 0) {
            erreurDate1.setText("Vous devez Choisir une date valide");
            return false;

        }
        return true;
    }

}
