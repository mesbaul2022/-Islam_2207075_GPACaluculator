package com.example.java2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private TextField courseNameField;
    @FXML private TextField courseCodeField;
    @FXML private TextField creditField;
    @FXML private TextField teacher1Field;
    @FXML private TextField teacher2Field;
    @FXML private ComboBox<String> gradeCombo;
    @FXML private Label totalCreditsLabel;
    @FXML private Button calculateButton;
    @FXML private TextArea coursesDisplayArea;

    @FXML private Label gpaLabel;
    @FXML private TextArea resultArea;

    private ArrayList<Course> courses = new ArrayList<>();
    private int totalCreditsEntered = 0;
    private final int REQUIRED_CREDITS = 12;

    // Initialize method for Scene 2
    @FXML
    public void initialize() {
        if (gradeCombo != null) {
            gradeCombo.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F");
            calculateButton.setDisable(true);
            updateTotalCredits();
        }
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void addCourse(ActionEvent event) {
        try {
            String name = courseNameField.getText();
            String code = courseCodeField.getText();
            int credit = Integer.parseInt(creditField.getText());
            String teacher1 = teacher1Field.getText();
            String teacher2 = teacher2Field.getText();
            String grade = gradeCombo.getValue();

            if (name.isEmpty() || code.isEmpty() || teacher1.isEmpty() || teacher2.isEmpty() || grade == null) {
                showAlert("Error", "Please fill all fields!");
                return;
            }

            Course course = new Course(name, code, credit, teacher1, teacher2, grade);
            courses.add(course);
            totalCreditsEntered += credit;

            updateCourseDisplay();
            updateTotalCredits();
            clearFields();

            showAlert("Success", "Course added successfully!");

        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter valid credit number!");
        }
    }

    private void updateCourseDisplay() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            sb.append((i + 1) + ". " + c.getCourseName() + " (" + c.getCourseCode() + ") - " +
                    c.getCredit() + " credits - Grade: " + c.getGrade() + "\n");
        }
        coursesDisplayArea.setText(sb.toString());
    }

    // Update total credits label and enable/disable calculate button
    private void updateTotalCredits() {
        totalCreditsLabel.setText("Total Credits: " + totalCreditsEntered + " / " + REQUIRED_CREDITS);
        if (totalCreditsEntered >= REQUIRED_CREDITS) {
            calculateButton.setDisable(false);
        }
    }

    // Clear input fields
    private void clearFields() {
        courseNameField.clear();
        courseCodeField.clear();
        creditField.clear();
        teacher1Field.clear();
        teacher2Field.clear();
        gradeCombo.setValue(null);
    }

    // Calculate GPA and switch to Scene 3
    @FXML
    public void calculateGPA(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene3.fxml"));
        root = loader.load();

        HelloController controller = loader.getController();
        controller.displayResults(courses, calculateGPAValue());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Calculate GPA value
    private double calculateGPAValue() {
        double totalPoints = 0;
        int totalCredits = 0;

        for (Course course : courses) {
            totalPoints += course.getGradePoint() * course.getCredit();
            totalCredits += course.getCredit();
        }

        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    // Display results in Scene 3
    public void displayResults(ArrayList<Course> courseList, double gpa) {
        gpaLabel.setText(String.format("%.2f", gpa));

        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("       STUDENT GPA REPORT CARD          \n");
        sb.append("========================================\n\n");

        for (int i = 0; i < courseList.size(); i++) {
            Course c = courseList.get(i);
            sb.append("Course " + (i + 1) + ":\n");
            sb.append("  Name: " + c.getCourseName() + "\n");
            sb.append("  Code: " + c.getCourseCode() + "\n");
            sb.append("  Credits: " + c.getCredit() + "\n");
            sb.append("  Teacher 1: " + c.getTeacher1() + "\n");
            sb.append("  Teacher 2: " + c.getTeacher2() + "\n");
            sb.append("  Grade: " + c.getGrade() + "\n");
            sb.append("----------------------------------------\n");
        }

        sb.append("\nFinal GPA: " + String.format("%.2f", gpa) + "\n");
        sb.append("========================================");

        resultArea.setText(sb.toString());
    }

    // Show alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}