package com.example.hrfaraonapp.scene;

import com.example.hrfaraonapp.HelloApplication;
import com.example.hrfaraonapp.storage.WorkerStorage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SceneLoader {
    private static SceneLoader INSTANCE;
    Stage stage;
    Stage modalStage;


    private SceneLoader() {
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public static SceneLoader getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SceneLoader();
        }
        return INSTANCE;
    }
    public Stage getCurrentStage(){
        return stage;
    }
    public Stage getCurrentModalStage(){
        return modalStage;
    }
    public void loadScene(SceneCollection sceneName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneName.getSceneName()));
        Scene scene = new Scene(fxmlLoader.load(), 720, 540);
        stage.setTitle("HrFaraon");
        stage.setScene(scene);


        stage.show();
    }
    public void showModalWindow(SceneCollection sceneName) throws IOException {
         modalStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneName.getSceneName()));
        Scene scene = new Scene(fxmlLoader.load(), 460, 400);
        modalStage.setScene(scene);
        modalStage.initOwner(stage);
        modalStage.initModality(Modality.WINDOW_MODAL);

        modalStage.show();
    }


}
