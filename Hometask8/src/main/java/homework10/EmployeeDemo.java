package homework10;

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee employee1 = new Manager("Adam", "UK, London, 35 Royston Road", 1000);
        Employee employee2 = new Developer("John", "IE, Dublin, 16 The Willow", 4500, "Java");
        Employee employee3 = new QA("Daniel", "IE, Dublin, 16 The Willow", 6500);

        System.out.println(employee1);
        System.out.println(employee1.performanceReport());
        System.out.println(employee1.jobDescription());
        System.out.println("Bonuses for " + employee1.jobTitle + " " + employee1.name + " : " + employee1.calculateBonus());
        System.out.println("---------------------------------------------------------------------");

        System.out.println(employee2);
        System.out.println(employee2.performanceReport());
        System.out.println(employee2.jobDescription());
        System.out.println("Bonuses for " + employee2.jobTitle + " " + employee2.name + " : " + employee2.calculateBonus());
        System.out.println("---------------------------------------------------------------------");

        System.out.println(employee3);
        System.out.println(employee3.performanceReport());
        System.out.println(employee3.jobDescription());
        System.out.println("Bonuses for " + employee3.jobTitle + " " + employee3.name + " : " + employee3.calculateBonus());


    }
}
