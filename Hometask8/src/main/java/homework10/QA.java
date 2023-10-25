package homework10;

public class QA extends Employee {
    public QA(String name, String address, int salary) {
        super(name, address, salary, "QA");
    }

    @Override
    public double calculateBonus() {

        return 0.075 * salary;
    }

    @Override
    public String performanceReport(){
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
}
