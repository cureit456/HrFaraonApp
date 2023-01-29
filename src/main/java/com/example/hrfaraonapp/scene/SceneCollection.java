package com.example.hrfaraonapp.scene;

public enum SceneCollection {
    ADD_WORKER("add-worker.fxml"),
    WORKER_TABLE("workers-view.fxml");


    private String sceneName;

    SceneCollection(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getSceneName() {
        return sceneName;
    }
}
