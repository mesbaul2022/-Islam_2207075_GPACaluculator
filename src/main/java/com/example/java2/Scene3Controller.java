package com.example.java2;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Scene3Controller {

    @FXML private Label gpaLabel;
    @FXML private TextArea resultArea;

    public void displayResults(ObservableList<Course> courses) {
        double totalPoints = 0;
        int totalCredits = 0;

        StringBuilder result = new StringBuilder();
        result.append("STUDENT GRADE REPORT\n\n");
        result.append("Course Details:\n");
        result.append("----------------------------------------\n\n");

        for (Course course : courses) {
            totalPoints += course.getGradePoint() * course.getCourseCredit();
            totalCredits += course.getCourseCredit();

            result.append("Course Name: " + course.getCourseName() + "\n");
            result.append("Course Code: " + course.getCourseCode() + "\n");
            result.append("Credits: " + course.getCourseCredit() + "\n");
            result.append("Teacher 1: " + course.getTeacher1() + "\n");
            if (!course.getTeacher2().isEmpty()) {
                result.append("Teacher 2: " + course.getTeacher2() + "\n");
            }
            result.append("Grade: " + course.getGrade() + " (" + course.getGradePoint() + ")\n");
            result.append("----------------------------------------\n\n");
        }

        double gpa = totalPoints / totalCredits;

        result.append("\nTotal Credits: " + totalCredits + "\n");
        result.append("Total Grade Points: " + totalPoints + "\n");
        result.append("\nFINAL GPA: " + String.format("%.2f", gpa) + "\n");

        resultArea.setText(result.toString());
        gpaLabel.setText("Your GPA: " + String.format("%.2f", gpa));
    }
}