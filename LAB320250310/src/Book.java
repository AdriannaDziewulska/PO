public class Book extends Item{
    private int pageCount;
    private String genre;
    private String language;

    public Book(int id, String title, String author, int year, boolean isAvailable, int WhoId, int pageCount, String genre, String language) {
        super(id, title, author, year, isAvailable, WhoId);
        this.pageCount=pageCount;
        this.genre=genre;
        this.language=language;
    }

    public String getInformation(){
        return super.getInformation()+"Liczba stron: "+pageCount+" Gatunek: "+genre+" Język: "+language;
    }

}
