package com.example.hrfaraonapp.utils;

import com.example.hrfaraonapp.entity.Person;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {

    public static void exportToCSV(ObservableList<Person> data, String filePath ) {
        try (FileWriter writer = new FileWriter(filePath)) {

            writer.append("Imie, Nazwsiko, Wynagrodzenie, Doswiadczenie");
            writer.append("\n");


            for (Person person : data) {
                writer.append(person.getFirstName());
                writer.append(",");
                writer.append(person.getLastName());
                writer.append(",");
                writer.append(Double.toString(person.getSalary()));
                writer.append(",");
                writer.append((person.getExperience()));
                writer.append("\n");
            }

            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing the CSV file: " + e.getMessage());
        }
    }
}