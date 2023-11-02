package homework12;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet1 = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet1.add("A");
        hashSet2.add("B");

        HashSet<String> hashSet3 = new HashSet<>(hashSet1);
        hashSet3.addAll(hashSet2);

        System.out.println(hashSet3);

    }
}
