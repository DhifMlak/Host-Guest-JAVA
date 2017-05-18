package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import animation.FadeInLeftTransition;
import animation.FadeInUpTransition;
import entites.Reservation;
import utils.Loading;
import java.sql.SQLException;
import services.ServiceReservation;



/**
 * Created by Mlak .
 */
public class MesReservations {

    @FXML private ImageView ImageLoading;
    @FXML private ProgressBar ProgressLoading;
    @FXML private GridPane PaneTabel;
    @FXML private HBox PaneTop;
    @FXML private AnchorPane PaneMain;
    @FXML private TableView<Reservation> TableProjects;
    @FXML private TableColumn<Reservation, String> ColumnStatus;
    @FXML private TableColumn<Reservation, String> ColumnAssignDate;
    @FXML private TableColumn<Reservation, String> ColumnDP_RO;
    @FXML private TableColumn<Reservation, String> ColumnDP_NA;
    @FXML private TableColumn<Reservation, String> ColumnJobNumber;
    @FXML private TableColumn<Reservation, String> ColumnJobTitle;
    @FXML private TableColumn<Reservation, String> ColumnClient;
       @FXML private TableColumn<Reservation, HBox> ColumnJobType;

    private ObservableList<Reservation> listProjects;
    @FXML private Text TextEmptyTable;
    
    public void initialize() throws SQLException {
       
        ServiceReservation SS = new ServiceReservation();
        listProjects = FXCollections.observableArrayList(SS.getAllReservation());

       
        ImageLoading.setVisible(true);
        ProgressLoading.setProgress(0);
        ProgressLoading.progressProperty().unbind();
        Task task= Loading.load();
        ProgressLoading.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                ImageLoading.setVisible(false);
                PaneTop.setVisible(true);
                if (listProjects.isEmpty()) {
                    TextEmptyTable.setVisible(true);
                } else {
                    initializeTable();
                }
                new FadeInLeftTransition(PaneTop).play();
                new FadeInUpTransition(PaneTabel).play();
            }
        });

    }

    public void initializeTable() {
     
        PaneTabel.setVisible(true);
        TableProjects.setItems(listProjects);
        ColumnStatus.setCellValueFactory(new PropertyValueFactory<Reservation, String>("id"));
        ColumnAssignDate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("etat"));
       // ColumnDP_RO.setCellValueFactory(new PropertyValueFactory<Reservation, String>("date_Deb"));
        //ColumnDP_NA.setCellValueFactory(new PropertyValueFactory<Reservation, String>("date_Fin"));
        ColumnJobNumber.setCellValueFactory(new PropertyValueFactory<Reservation, String>("hote"));
        ColumnJobTitle.setCellValueFactory(new PropertyValueFactory<Reservation, String>("nbMax"));
//        ColumnJobType.setCellValueFactory(new PropertyValueFactory<Reservation, String>("lieu"));
        ColumnJobType.setCellValueFactory(new PropertyValueFactory<Reservation, HBox>("action"));
       
ColumnClient.setCellValueFactory(new PropertyValueFactory<Reservation, String>("description"));
        }

   
    

   
     }
