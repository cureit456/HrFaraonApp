package com.example.hrfaraonapp;

import com.example.hrfaraonapp.scene.SceneCollection;
import com.example.hrfaraonapp.scene.SceneLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneLoader.getInstance().setStage(stage);
        SceneLoader.getInstance().loadScene(SceneCollection.WORKER_TABLE);
    }

    public static void main(String[] args) {
        launch();
    }
}