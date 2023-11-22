package homework;

import org.testng.annotations.Test;

public class StudentTest {
    @Test
    public void displayStudentInfoTest() {
        Student student = new Student();
        student.displayStudentInfo();
    }

    @Test
    public void updateStudentInfoTest() {
        Student student = new Student(null, 22);
        student.displayStudentInfo();
    }

    @Test
    public void assignStudentByNullTest() {
        Student student = null;
        if (student != null)
            student.displayStudentInfo();
        else System.out.println("No data available");
    }

    ;
}