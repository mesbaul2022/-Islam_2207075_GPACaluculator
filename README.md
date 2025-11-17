# GPA Calculator - JavaFX Application

A simple Student Grading System that helps students calculate their GPA by adding courses and grades.

##  Project Description

This is a beginner-friendly JavaFX application that allows students to:
- Add multiple courses with details (name, code, credits, teachers, grade)
- Track total credits entered
- Calculate overall GPA based on weighted grades
- View results in a formatted report

##  Features

- **Home Screen**: Welcome page with a start button
- **Course Entry**: Form to add course information
- **GPA Result**: Displays final GPA and detailed course report
- **Credit Tracking**: Shows progress toward required credits (default: 12)
- **Grade System**: Supports grades from A+ to F with grade points
- **Input Validation**: Alerts for missing or invalid data

##  Technologies Used

- **Java** - Programming Language
- **JavaFX** - GUI Framework
- **FXML** - UI Layout
- **SceneBuilder** - Visual FXML Editor

##  Project Structure

```
src/
  main/
    java/
      com/example/java2/
        ├── HelloApplication.java    # Main application launcher
        ├── Launcher.java            # Entry point
        ├── HelloController.java     # Main controller (Scene 1 & 2)
        ├── Scene3Controller.java    # Result screen controller
        └── Course.java              # Course model class
    resources/
      com/example/java2/
        ├── scene1.fxml              # Home screen layout
        ├── scene2.fxml              # Course entry layout
        └── scene3.fxml              # Result screen layout
```

##  Application Interfaces

### Interface 1: Home Screen (scene1.fxml)

The welcome screen where the application starts.

**Components:**
- Welcome message label
- Description label
- "Start GPA Calculator" button

**Functionality:**
- Click the button to navigate to the course entry screen

**Home Screen**
```
┌─────────────────────────────────────┐
│                                     │
│   Welcome to GPA Calculator         │
│   Calculate your Grade Point        │
│          Average                    │
│                                     │
│   [Start GPA Calculator]            │
│                                     │
└─────────────────────────────────────┘
```

---

### Interface 2: Course Entry Screen (scene2.fxml)

The main screen where users input course information.

**Components:**
- Title label: "GPA Calculator - Add Courses"
- Credit counter: "Total Credits: 0/12"
- Input form with 6 fields:
  - Course Name (TextField)
  - Course Code (TextField)
  - Course Credit (TextField)
  - Teacher 1 Name (TextField)
  - Teacher 2 Name (TextField - Optional)
  - Grade (ComboBox: A+, A, A-, B+, B, B-, C+, C, C-, D, F)
- Two buttons: "Add Course" and "Calculate GPA"
- Text area showing list of added courses

**Functionality:**
- Enter course details and click "Add Course" to add to list
- Credit counter updates automatically
- When total credits reach 12, click "Calculate GPA" to see results
- Shows error alerts for missing fields or credit overflow

**Course Entry Screen**
```
┌─────────────────────────────────────────────────────────┐
│ GPA Calculator - Add Courses                            │
│ Total Credits: 6/12                                     │
│                                                         │
│ Course Name:     [_____________________]                │
│ Course Code:     [_____________________]                │
│ Course Credit:   [_____________________]                │
│ Teacher 1 Name:  [_____________________]                │
│ Teacher 2 Name:  [_____________________]                │
│ Grade:           [▼ Select Grade  ]                     │
│                                                         │
│      [Add Course]  [Calculate GPA]                      │
│                                                         │
│ Added Courses:                                          │
│ ┌────────────────────────────────────────────────────┐  │
│ │ Algorithm Analysis Design Lab- CSE 2202- 1.5credits│  │
│ │ Grade: A-                                          │  │
│ │ Algorithm Analysis and Design- CSE 2201- 3 credits │  │
│ │ Grade: B+                                          │  │
│ └────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────┘
```

---

### Interface 3: GPA Result Screen (scene3.fxml)

Shows the calculated GPA and detailed course report.

**Components:**
- Title label: "GPA Calculation Result"
- GPA display label: "Your GPA: X.XX"
- Large text area showing:
  - Header: "STUDENT GRADE REPORT"
  - Each course details (name, code, credits, teachers, grade)
  - Summary: Total credits, total grade points
  - Final GPA

**Functionality:**
- Displays all entered courses with complete information
- Shows weighted GPA calculation
- Read-only display (cannot edit)

**GPA Result Screen**
```
┌──────────────────────────────────────────────┐
│ GPA Calculation Result                       │
│ Your GPA: 3.45                               │
│                                              │
│ ┌─────────────────────────────────────────┐  │
│ │ STUDENT GRADE REPORT                    │  │
│ │                                         │  │
│ │ Course Details:                         │  │
│ │ ------------------------------------    │  │
│ │                                         │  │
│ │ Course Name: TOC                        │  │
│ │ Course Code: CSE2209                    │  │
│ │ Credits: 3                              │  │
│ │ Teacher 1: Md Nazirulhasan Shawon       │  │
│ │ Grade: A- (3.50)                        │  │
│ │ ------------------------------------    │  │
│ │                                         │  │
│ │ Course Name: Algorithms Design Lab      │  │
│ │ Course Code: CSE2202                    │  │
│ │ Credits: 1.5                            │  │
│ │ Teacher 1: Dr. Sk. Imran Hossain        │  │
│ │ Teacher 2: Ehsanul Karim Talha          │  │
│ │ Grade: B+ (3.25)                        │  │
│ │ ------------------------------------    │  │
│ │                                         │  │
│ │ Total Credits: 12                       │  │
│ │ Total Grade Points: 42.00               │  │
│ │                                         │  │
│ │ FINAL GPA: 3.50                         │  │
│ └─────────────────────────────────────────┘  │
└──────────────────────────────────────────────┘
```

##  Grade Point System

| Grade | Grade Point |
|-------|-------------|
| A+    | 4.00        |
| A     | 3.75        |
| A-    | 3.50        |
| B+    | 3.25        |
| B     | 3.00        |
| B-    | 2.75        |
| C+    | 2.50        |
| C     | 2.25        |
| C-    | 2.00        |
| D     | 1.00        |
| F     | 0.00        |



##  How to Use

1. **Start Application**
   - Run the program
   - Click "Start GPA Calculator" on home screen

2. **Add Courses**
   - Fill in all course details
   - Select grade from dropdown
   - Click "Add Course"
   - Repeat until you reach required credits (12)

3. **Calculate GPA**
   - When credits are complete, click "Calculate GPA"
   - View your results and detailed report


##  Author

Mesbaul Islam - [https://github.com/mesbaul2022](https://github.com/mesbaul2022)
