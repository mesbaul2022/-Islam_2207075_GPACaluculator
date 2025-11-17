package com.example.java2;

public class Course {
    private String courseName;
    private String courseCode;
    private int courseCredit;
    private String teacher1;
    private String teacher2;
    private String grade;
    private double gradePoint;

    public Course(String courseName, String courseCode, int courseCredit,
                  String teacher1, String teacher2, String grade) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
        this.teacher1 = teacher1;
        this.teacher2 = teacher2;
        this.grade = grade;
        this.gradePoint = calculateGradePoint(grade);
    }

    private double calculateGradePoint(String grade) {
        switch (grade) {
            case "A+": return 4.0;
            case "A": return 3.75;
            case "A-": return 3.5;
            case "B+": return 3.25;
            case "B": return 3.0;
            case "B-": return 2.75;
            case "C+": return 2.5;
            case "C": return 2.25;
            case "C-": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }

    // Getters
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getCourseCredit() { return courseCredit; }
    public String getTeacher1() { return teacher1; }
    public String getTeacher2() { return teacher2; }
    public String getGrade() { return grade; }
    public double getGradePoint() { return gradePoint; }
}