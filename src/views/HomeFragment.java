package views;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import animation.FadeInUpTransition;

import utils.Loading;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;



public class HomeFragment {

    @FXML private ImageView ImageLoading;
    @FXML private ProgressBar ProgressLoading;
    private BarChart<String, Number> ChartHome;
    @FXML private AnchorPane PaneMain;
    @FXML private VBox PaneHome;
    private Task task;
    private XYChart.Series series;


    public void initialize() throws SQLException {

        ImageLoading.setVisible(true);
        ProgressLoading.setProgress(0);
        ProgressLoading.progressProperty().unbind();
         task= Loading.load();
        ProgressLoading.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                ImageLoading.setVisible(false);
                PaneHome.getChildren().add(ChartHome);
                new FadeInUpTransition(ChartHome).play();
            }
        });

    }

    private String getDate(int dayOfWeek) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMMM-yyyy");
        return dateFormatter.format(c.getTime());
    }

}