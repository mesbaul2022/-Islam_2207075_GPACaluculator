package com.example.java2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Scene 2 controls
    @FXML private TextField courseNameField;
    @FXML private TextField courseCodeField;
    @FXML private TextField courseCreditField;
    @FXML private TextField teacher1Field;
    @FXML private TextField teacher2Field;
    @FXML private ComboBox<String> gradeComboBox;
    @FXML private Label totalCreditsLabel;
    @FXML private TextArea courseListArea;

    private ObservableList<Course> courses = FXCollections.observableArrayList();
    private int totalCredits = 0;
    private final int REQUIRED_CREDITS = 12;

    // Scene 1: Switch to Course Entry screen
    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Initialize
    @FXML
    public void initialize() {
        if (gradeComboBox != null) {
            gradeComboBox.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F");
            updateTotalCreditsLabel();
        }
    }

    // Add course
    @FXML
    public void addCourse(ActionEvent event) {
        String name = courseNameField.getText();
        String code = courseCodeField.getText();
        String creditText = courseCreditField.getText();
        String teacher1 = teacher1Field.getText();
        String teacher2 = teacher2Field.getText();
        String grade = gradeComboBox.getValue();

        if (name.isEmpty() || code.isEmpty() || creditText.isEmpty() || teacher1.isEmpty() || grade == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all required fields!");
            alert.show();
            return;
        }

        int credit = Integer.parseInt(creditText);

        if (totalCredits + credit > REQUIRED_CREDITS) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Total credits exceed " + REQUIRED_CREDITS);
            alert.show();
            return;
        }

        Course course = new Course(name, code, credit, teacher1, teacher2, grade);
        courses.add(course);
        totalCredits += credit;

        courseListArea.appendText(name + " - " + code + " - " + credit + " credits - Grade: " + grade + "\n");

        courseNameField.clear();
        courseCodeField.clear();
        courseCreditField.clear();
        teacher1Field.clear();
        teacher2Field.clear();
        gradeComboBox.setValue(null);

        updateTotalCreditsLabel();
    }

    // Calculate GPA
    @FXML
    public void calculateGPA(ActionEvent event) throws IOException {
        if (totalCredits < REQUIRED_CREDITS) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please add " + REQUIRED_CREDITS + " credits first!");
            alert.show();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene3.fxml"));
        root = loader.load();

        Scene3Controller controller = loader.getController();
        controller.displayResults(courses);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void updateTotalCreditsLabel() {
        if (totalCreditsLabel != null) {
            totalCreditsLabel.setText("Total Credits: " + totalCredits + "/" + REQUIRED_CREDITS);
        }
    }
}