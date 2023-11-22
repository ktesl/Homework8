package homework;

import java.util.Scanner;

public class BankTest {
    static Bank bank1 = new Bank();
    static Scanner scan = new Scanner(System.in);
    static int accountNumber;
    static double amountIncome;
    static double amountExpense;

    public static void main(String[] args) {
        displayInit();
    }

    public static void displayInit() {

        int select = -1;

        do {
            System.out.println(
                    "Make your choice:\n" +
                            "1. Add an account.\n" +
                            "2. Add income.\n" +
                            "3. Add expense.\n" +
                            "4. View account info\n" +
                            "0. Exit."
            );
            select = scan.nextInt();
            System.out.println("-----------------------------------------------------------------");

            switch (select) {
                case 1:
                    displayAddAccount();
                    select = -1;
                    break;
                case 2:
                    displayIncome();
                    select = -1;
                    break;
                case 3:
                    displayExpense();
                    select = -1;
                    break;
                case 4:
                    displayAccountInfo();
                    select = -1;
                    break;
                case 0:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Choose the number from 0 till 4");
                    break;
            }
        } while (select < 0 || select > 4);

    }

    public static void displayAddAccount() {
        boolean isExist;

        do {
            isExist = false;
            System.out.println("Enter the number of your account:");
            accountNumber = checkIntScan(scan);

            for (int i = 0; i < Bank.accountLimit; i++) {
                if (Bank.accountsStorage[i] != null && Bank.accountsStorage[i].accountNumber == accountNumber) {
                    System.out.println("This account number is already exist in system");
                    isExist = true;
                }
            }
        } while (isExist);

        System.out.println("Enter the balance");
        double accountBalance = mathFloor(scan.nextDouble());

        bank1.createAccount(accountNumber, accountBalance);
        int index = Bank.InnerAccount.findAccountIndex(accountNumber);
        System.out.println(
                "Your new account " +
                        Bank.accountsStorage[index].accountNumber +
                        " | balance: " + Bank.accountsStorage[index].balance
        );
        System.out.println("-----------------------------------------------------------------");
    }

    public static void displayIncome() {
        int index;

        do {
            System.out.println("Enter the number of account: ");
            accountNumber = checkIntScan(scan);
            index = Bank.InnerAccount.findAccountIndex(accountNumber);
            if (index == -1) return;

            System.out.println("Enter the amount of income: ");
            amountIncome = mathFloor(scan.nextDouble());

            if (amountIncome <= 0) System.out.println("The amount must be more than 0");
        } while (amountIncome <= 0);

        bank1.income(index, amountIncome);
        System.out.println(
                "Your new account " +
                        Bank.accountsStorage[index].accountNumber +
                        " | balance: " + Bank.accountsStorage[index].balance
        );
        System.out.println("-----------------------------------------------------------------");
    }

    public static void displayExpense() {
        int index;

        do {
            System.out.println("Enter the number of account: ");
            accountNumber = checkIntScan(scan);
            index = Bank.InnerAccount.findAccountIndex(accountNumber);
            if (index == -1) return;

            System.out.println("Enter the amount of expense: ");
            amountExpense = mathFloor(scan.nextDouble());

            if (amountExpense <= 0 || amountExpense > Bank.accountsStorage[index].balance)
                System.out.println(
                        "The amount must be more than 0 and more than account balance: " + Bank.accountsStorage[index].balance
                );
        } while (amountExpense <= 0 || amountExpense > Bank.accountsStorage[index].balance);

        bank1.expense(index, amountExpense);
        System.out.println(
                "Your new account " +
                        Bank.accountsStorage[index].accountNumber +
                        " | balance: " + Bank.accountsStorage[index].balance
        );
        System.out.println("-----------------------------------------------------------------");
    }

    public static void displayAccountInfo() {
        int index;
        int transactionsCount = 0;

        System.out.println("Enter the number of account: ");
        accountNumber = checkIntScan(scan);
        index = Bank.InnerAccount.findAccountIndex(accountNumber);

        if (index == -1) return;

        System.out.println(
                "Your account " +
                        Bank.accountsStorage[index].accountNumber +
                        " | balance: " + Bank.accountsStorage[index].balance
        );
        System.out.println("Account transactions:");

        for (int i = 0; i < Bank.transactionsStorage.size(); i++) {
            Bank.InnerTransactions transaction = Bank.transactionsStorage.get(i);

            if (transaction.accountNumber == Bank.accountsStorage[index].accountNumber) {
                System.out.println(
                        "Transaction-" + (i + 1) + " details: " + transaction.type +
                                " | №" + transaction.accountNumber + " | " + transaction.amount + "$");
                transactionsCount++;
            }
        }

        if (transactionsCount == 0)
            System.out.println("There are no transactions on this account " + accountNumber + " yet...");

        System.out.println("-----------------------------------------------------------------");
    }

    public static double mathFloor(double number) {
        return Math.floor(number * 100.0) / 100.0;
    }

    public static int checkIntScan(Scanner scan) {
        while (true) {
            if (scan.hasNextInt()) {
                return scan.nextInt();
            } else {
                System.out.println("Please enter a valid integer:");
                scan.next();
            }
        }
    }
}
