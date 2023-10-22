package homework10;

public class QA extends Employee {
    public QA(String name, String address, int salary) {
        super(name, address, salary, "QA");
    }

    @Override
    public double calculateBonus() {

        return 0.075 * salary;
    }
}
