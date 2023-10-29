package homework11;

import java.util.ArrayList;
import java.util.Scanner;

class Demo {

    public void addContent(Material content) {
        Library.library.add(content);
    }

    public static void main(String[] args) {

        Demo demo = new Demo();
        Material material1 = new Books("Fight Club", "C. Palahniuk", Genre.THRILLER);
        Material material2 = new Magazines("Study Magazine: She is Back!", "Study Hard Books", Genre.SCIENCE);
        Material material3 = new AudioBooks("Dark Matter", "B. Crouch", Genre.SCIENCE_FICTION, true);
        Material material4 = new Books("Harry Potter and the Chamber of Secrets", "J. K. Rowling", Genre.FANTASY);
        Material material5 = new Books("Harry Potter and the Philosopher's Stone", "J. K. Rowling", Genre.FANTASY);
        Material material6 = new Books("Fantastic Beasts and Where to Find Them", "J. K. Rowling", Genre.FANTASY);
        demo.addContent(material1);
        demo.addContent(material2);
        demo.addContent(material3);
        demo.addContent(material4);
        demo.addContent(material5);
        demo.addContent(material6);

        System.out.println("What book ARE you interested in? Enter a keyword:");
        Scanner scanner = new Scanner(System.in);
        String keywords = scanner.nextLine();

        ArrayList<Integer> indexArr = Library.search(keywords.toLowerCase());

        System.out.println("Are you interesting in some of this books? Enter a number:");
        int materialChoise = scanner.nextInt();

        if (materialChoise > indexArr.size()) {
            System.out.println("There are not such material");
            System.exit(0);
        } else if (!Library.library.get(indexArr.get(materialChoise - 1)).checkedOut) {
            Library.library.get(indexArr.get(materialChoise - 1)).checkoutMaterial();
        } else {
            Library.library.get(indexArr.get(materialChoise - 1)).checkinMaterial();
        }

    }
}


