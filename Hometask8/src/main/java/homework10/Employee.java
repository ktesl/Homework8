package homework10;

import java.util.Objects;

public class Employee {
    protected String name;
    private String address;
    protected int salary;
    protected String jobTitle;

    public Employee(String name, String address, int salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(address, employee.address) && Objects.equals(jobTitle, employee.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, salary, jobTitle);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    public double calculateBonus() {

        return 0.05 * salary;
    }

    public String performanceReport() {
            if (salary < 1500) {
                return "Performance report for " + jobTitle + " " + name + " -> Bad";
            }
            if (salary >= 1500 && salary <= 3000) {
                return "Performance report for " + jobTitle + " " + name + " -> Good";
            }
            if (salary > 3000) {
                return "Performance report for " + jobTitle + " " + name + " -> Very good";
            }
        return null;
    }

    public String jobDescription() {
        return "Employee is working as a " + jobTitle;
    }
}
