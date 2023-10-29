package homework11;

public class Magazines extends Material {
    public Magazines(String title, String author, Genre genre, boolean checkedOut) {
        super(title, author, genre, checkedOut);
    }

    public Magazines(String title, String author, Genre genre) {
        super(title, author, genre);
    }

}
