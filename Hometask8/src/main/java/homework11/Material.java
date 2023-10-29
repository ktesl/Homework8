package homework11;

abstract class Material implements Content {
    private String title;
    private String author;
    private Genre genre;
    boolean checkedOut;

    public Material(String title, String author, Genre genre, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.checkedOut = checkedOut;
    }

    public Material(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.checkedOut = false;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void checkIn() {
        checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre.toString();
    }

    public String isCheckedOut() {
        return checkedOut ? "not available" : "available";
    }

    public void checkoutMaterial() {
        checkOut();
        System.out.println("You get a material " + title + ". Status: " + isCheckedOut());
    }

    public void checkinMaterial() {
        checkIn();
        System.out.println("You have been checked in a material " + title + ". Status: " + isCheckedOut());
    }
}

