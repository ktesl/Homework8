package homework;

import java.util.ArrayList;

public class Bank {
    static int accountLimit = 3;
    int topOfAccountList = -1;
    static InnerAccount[] accountsStorage = new InnerAccount[accountLimit];

    static ArrayList<InnerTransactions> transactionsStorage = new ArrayList<InnerTransactions>();

    void push(InnerAccount item) {
        if (topOfAccountList == accountLimit - 1) System.out.println("The storage of account numbers is full");
        else accountsStorage[++topOfAccountList] = item;
    }

    public static class InnerAccount {
        int accountNumber;
        double balance;

        InnerAccount(int accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public static int findAccountIndex(int accountNumber) {
            int index = -1;

            for (int i = 0; i < accountLimit; i++) {
                if (accountsStorage[i] == null) continue;
                else if (accountsStorage[i].accountNumber == accountNumber) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("There is no such account");
                return index;
            }

            return index;
        }
    }

    public static class InnerTransactions {
        String type;
        int accountNumber;
        String amount;

        InnerTransactions(String type, int accountNumber, String amount) {
            this.type = type;
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public void income(int index, double amount) {
        accountsStorage[index].balance += amount;
        transactionsStorage.add(new InnerTransactions(
                "income",
                accountsStorage[index].accountNumber,
                "+" + Double.toString(amount)
        ));
    }

    public void expense(int index, double amount) {
        accountsStorage[index].balance -= amount;
        transactionsStorage.add(new InnerTransactions(
                "expense",
                accountsStorage[index].accountNumber,
                "-" + Double.toString(amount)
        ));
    }

    public void createAccount(int accountNumber, double balance) {
        if (topOfAccountList != accountLimit) {
            this.push(new InnerAccount(accountNumber, balance));
        } else System.out.println("The number of accounts has been exhausted");
    }


}
