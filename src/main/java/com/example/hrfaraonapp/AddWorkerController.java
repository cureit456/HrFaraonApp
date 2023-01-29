package com.example.hrfaraonapp;

import com.example.hrfaraonapp.entity.Person;
import com.example.hrfaraonapp.scene.SceneLoader;
import com.example.hrfaraonapp.storage.WorkerStorage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddWorkerController {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField secondNameTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField experienceTextField;
    @FXML
    protected void onAddWorkerButtonClick() {


        if(validFields()){
            Person worker = new Person(
                    nameTextField.getText(),
                    secondNameTextField.getText(),
                    Double.parseDouble(salaryTextField.getText()),
                    experienceTextField.getText()
            );
            WorkerStorage.getInstance().getWorkerList().add(worker);
            SceneLoader.getInstance().getCurrentModalStage().close();
        }
    }
    private boolean validFields(){
        boolean isValid = nameTextField.getText().length() > 1
                    && secondNameTextField.getText().length() > 1
                    && experienceTextField.getText().length() > 1;
        try
        {
            Double.parseDouble(salaryTextField.getText());
        }
        catch(NumberFormatException e){
            isValid = false;
        }
        return isValid;
    }
}
