package com.example.hrfaraonapp;

import com.example.hrfaraonapp.entity.Person;
import com.example.hrfaraonapp.scene.SceneCollection;
import com.example.hrfaraonapp.scene.SceneLoader;
import com.example.hrfaraonapp.storage.WorkerStorage;
import com.example.hrfaraonapp.utils.CSVExporter;
import com.example.hrfaraonapp.utils.SalaryCalculator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WorkersController implements Initializable {
    @FXML
    private TableView<Person> workerTableView;

    @FXML
    protected void onAddWorkerButtonClick() throws IOException {

        SceneLoader.getInstance().showModalWindow(SceneCollection.ADD_WORKER);
    }
    @FXML
    protected void onExportButtonClick() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );


        File selectedFile = fileChooser.showSaveDialog( SceneLoader.getInstance().getCurrentStage());

        if (selectedFile != null) {
            String fileName = selectedFile.getAbsolutePath();

            CSVExporter.exportToCSV(WorkerStorage.getInstance().getWorkerList(), fileName);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<Person, String> firstNameColumn = new TableColumn<>("Imie");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Nazwisko");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Person, Double> salaryColumn = new TableColumn<>("Wynagrodzenie");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Person, String> experienceColumn = new TableColumn<>("Doświadczenie");
        experienceColumn.setCellValueFactory(new PropertyValueFactory<>("experience"));

        workerTableView.getColumns().setAll(firstNameColumn, lastNameColumn,salaryColumn,experienceColumn);

        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Jan", "Nowak",7000.0,"2 lata w javie")
        );
        WorkerStorage.getInstance().setWorkerList(data);

        workerTableView.setItems(data);
    }
    @FXML
    protected void onRemoveButtonClick(){
        ObservableList<Person> items = workerTableView.getItems();
        Person selectedItem = workerTableView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            items.remove(selectedItem);
        }

    }
    @FXML
    protected void onNettoButtonClick(){
        Person selectedItem = workerTableView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            SalaryCalculator sc = new SalaryCalculator(selectedItem.getSalary());
            selectedItem.setSalary(sc.getNetto());
        }

    }
}