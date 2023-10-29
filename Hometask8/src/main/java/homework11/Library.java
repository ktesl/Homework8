package homework11;

import java.util.ArrayList;

public class Library {
    public static ArrayList<Material> library = new ArrayList<>();

    public static ArrayList<Integer> search(String keywords) {
        int index = 0;
        ArrayList<Material> result = new ArrayList<>();
        ArrayList<Integer> indexArr = new ArrayList<>();
        for (Material material : library) {
            if (
                    material.getTitle().toLowerCase().contains(keywords) ||
                            material.getAuthor().toLowerCase().contains(keywords) ||
                            material.getGenre().toLowerCase().contains(keywords)
            ) {
                result.add(material);
                indexArr.add(index);
            }
            index++;
        }
        if (indexArr.size() == 0) {
            System.out.println("No materials found");
            System.exit(0);
        }
        int index1 = 0;
        for (Material material : result) {
            System.out.println((index1 + 1) + ". " + "title: " + material.getTitle() + " | author: " + material.getAuthor() + " | genre: " + material.getGenre() + " | " + material.isCheckedOut());
            index1++;
        }
        return indexArr;
    }
}
