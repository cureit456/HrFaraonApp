package com.example.hrfaraonapp.storage;

import com.example.hrfaraonapp.entity.Person;
import javafx.collections.ObservableList;

public class WorkerStorage {
    private static WorkerStorage INSTANCE;

    private ObservableList<Person> workerList;
    private WorkerStorage() {
    }

    public static WorkerStorage getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new WorkerStorage();
        }
        return INSTANCE;
    }

    public ObservableList<Person>getWorkerList() {
        return workerList;
    }

    public void setWorkerList(ObservableList<Person> workerList) {
        this.workerList = workerList;
    }
}
