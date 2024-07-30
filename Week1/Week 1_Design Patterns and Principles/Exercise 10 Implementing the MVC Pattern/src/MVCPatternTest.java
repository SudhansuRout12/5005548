// Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for Grade
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// View Class
class StudentView {
    public void displayStudentDetails(String studentName, int studentId, String studentGrade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

// Controller Class
class StudentController {
    private Student student;
    private StudentView studentView;

    public StudentController(Student student, StudentView studentView) {
        this.student = student;
        this.studentView = studentView;
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public String getStudentName() {
        return student.getName();
    }

    public void setStudentId(int id) {
        student.setId(id);
    }

    public int getStudentId() {
        return student.getId();
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    public String getStudentGrade() {
        return student.getGrade();
    }

    public void updateView() {
        studentView.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
    }
}

// Main Class
public class MVCPatternTest {
    public static void main(String[] args) {
        // Create a Student object (Model)
        Student student = new Student("John Doe", 12345, "A");

        // Create a StudentView object (View)
        StudentView studentView = new StudentView();

        // Create a StudentController object (Controller)
        StudentController studentController = new StudentController(student, studentView);

        // Display initial student details
        studentController.updateView();

        // Update student details using the controller
        studentController.setStudentName("Jane Smith");
        studentController.setStudentId(67890);
        studentController.setStudentGrade("B");

        // Display updated student details
        studentController.updateView();
    }
}
