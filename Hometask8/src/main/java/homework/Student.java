package homework;

public class Student {
    String name;
    int age;

    Student() {
        name = "John";
        age = 22;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayStudentInfo() {
        if (name == null || age == 0)
            System.out.println("No data available");
        else System.out.println("Name: " + name + ", age: " + age);
    }
}


