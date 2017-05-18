package utils;

import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class ScreenController {

    public static enum Screen {
        SPLASH,
        LOGIN,
        MENU,
        HOME,
        SORTIES,
        LOGS,
        RANDOS,
        MES_RESEVATIONS,
        ADMINISTRATION,
        ABOUT
    }

    public ScreenController() {
    }

    public static void setScreen(Screen screen) throws IOException {
        switch (screen) {
            /*  case SPLASH:
                StageManager.setRoot(FXMLLoader.load(ScreenController.class.getResource("../layout/splash_fragment.fxml")));
                Shared.screen=Screen.SPLASH;
                break;
            case LOGIN:
                StageManager.setRoot(FXMLLoader.load(ScreenController.class.getResource("views/login.fxml")));
                Shared.screen=Screen.LOGIN;
                break;*/
            case MENU:
                StageManager.setRoot(FXMLLoader.load(ScreenController.class.getClassLoader().getResource("views/menu_fragment.fxml")));
                Shared.screen = Screen.MENU;
                break;
            case HOME:
                StageManager.setPaneFragment(FXMLLoader.load(ScreenController.class.getClassLoader().getResource("views/home_fragment.fxml")));
                Shared.screen = Screen.HOME;
                break;
            case SORTIES:
                StageManager.setPaneFragment(FXMLLoader.load(ScreenController.class.getClassLoader().getResource("views/sortie_fragment.fxml")));
                Shared.screen = Screen.SORTIES;
                break;
            case LOGS:
                StageManager.setPaneFragment(FXMLLoader.load(ScreenController.class.getClassLoader().getResource("views/logements.fxml")));
                Shared.screen = Screen.LOGS;
                break;
            case RANDOS:
                StageManager.setPaneFragment(FXMLLoader.load(ScreenController.class.getClassLoader().getResource("views/home_fragment.fxml")));
                Shared.screen = Screen.RANDOS;
                break;

            case MES_RESEVATIONS:
                StageManager.setPaneFragment(FXMLLoader.load(ScreenController.class.getClassLoader().getResource("views/MesReservations_fragment.fxml")));
                Shared.screen = Screen.MES_RESEVATIONS;
                break;/*
            case ADMINISTRATION:
                StageManager.setPaneFragment(FXMLLoader.load(ScreenController.class.getResource("../layout/administration_fragment.fxml")));
                Shared.screen=Screen.ADMINISTRATION;
                break;
            case ABOUT:
                StageManager.setPaneFragment(FXMLLoader.load(ScreenController.class.getResource("../layout/about_fragment.fxml")));
                Shared.screen=Screen.ABOUT;
                break;*/
            default:
                break;
        }
    }
}
