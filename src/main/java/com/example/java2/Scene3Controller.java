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
        result.append("╔═══════════════════════════════════════════════════════════╗\n");
        result.append("║              STUDENT GRADE REPORT                         ║\n");
        result.append("╚═══════════════════════════════════════════════════════════╝\n\n");

        result.append("Course Details:\n");
        result.append("─────────────────────────────────────────────────────────────\n");

        for (Course course : courses) {
            totalPoints += course.getGradePoint() * course.getCourseCredit();
            totalCredits += course.getCourseCredit();

            result.append(String.format("\n📚 Course Name: %s\n", course.getCourseName()));
            result.append(String.format("   Course Code: %s\n", course.getCourseCode()));
            result.append(String.format("   Credits: %d\n", course.getCourseCredit()));
            result.append(String.format("   Teacher 1: %s\n", course.getTeacher1()));
            if (!course.getTeacher2().isEmpty()) {
                result.append(String.format("   Teacher 2: %s\n", course.getTeacher2()));
            }
            result.append(String.format("   Grade: %s (%.2f)\n", course.getGrade(), course.getGradePoint()));
            result.append("─────────────────────────────────────────────────────────────\n");
        }

        double gpa = totalCredits > 0 ? totalPoints / totalCredits : 0.0;

        result.append(String.format("\n\n✓ Total Credits Completed: %d\n", totalCredits));
        result.append(String.format("✓ Total Grade Points: %.2f\n", totalPoints));
        result.append(String.format("\n★ FINAL GPA: %.2f ★\n", gpa));

        result.append("\n╔═══════════════════════════════════════════════════════════╗\n");
        result.append("║             Congratulations on your achievement!          ║\n");
        result.append("╚═══════════════════════════════════════════════════════════╝");

        resultArea.setText(result.toString());
        gpaLabel.setText(String.format("Your GPA: %.2f", gpa));
    }
}