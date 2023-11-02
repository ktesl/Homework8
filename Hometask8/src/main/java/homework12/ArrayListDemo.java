package homework12;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<Integer> newList = new ArrayList<>();
        for (Integer number : list) {
            if (number % 2 == 0) {
                newList.add(number);
            }
        }

        System.out.println("Even numbers:");
        for (Integer number : newList) {
            System.out.println(number);
        }
    }
}
