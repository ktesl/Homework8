package homework12;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Cow> cowMap = new HashMap<>();
        String[] names = {
                "Olya",
                "Yulya",
                "Tanya",
                "Sveta",
                "Zoya",
                "Tamara",
                "Katya",
                "Valya",
                "Vera",
                "Marina"
        };

        for (int i = 0; i < names.length; i++) {
            cowMap.put("Cow" + (i + 1), new Cow(names[i]));
        }

        for (HashMap.Entry<String, Cow> entry : cowMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        }
    }
}

