package homework10;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, String address, int salary, String programmingLanguage) {
        super(name, address, salary, "Developer");
        this.programmingLanguage = programmingLanguage;
    }

@Override
    public String jobDescription() {
        return "Developer is coding in " + programmingLanguage;
    }

    @Override
    public double calculateBonus() {

        return 0.1 * salary;
    }
}
