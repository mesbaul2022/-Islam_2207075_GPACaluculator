package com.example.java2;

public class Course {
    private String courseName;
    private String courseCode;
    private int credit;
    private String teacher1;
    private String teacher2;
    private String grade;

    public Course(String courseName, String courseCode, int credit, String teacher1, String teacher2, String grade) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credit = credit;
        this.teacher1 = teacher1;
        this.teacher2 = teacher2;
        this.grade = grade;
    }

    // Getters
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getCredit() { return credit; }
    public String getTeacher1() { return teacher1; }
    public String getTeacher2() { return teacher2; }
    public String getGrade() { return grade; }

    // Convert grade to grade point
    public double getGradePoint() {
        switch (grade) {
            case "A+": return 4.0;
            case "A": return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B": return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C": return 2.0;
            case "C-": return 1.7;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }
}