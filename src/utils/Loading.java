package utils;

import javafx.concurrent.Task;


public class Loading {

    public static Task load() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 50; i++) {
                    Thread.sleep(50);
                    updateProgress(i + 1, 50);
                }
                return true;
            }
        };
    }
}
