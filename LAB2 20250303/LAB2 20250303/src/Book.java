public class Book{
    private String title;
    private String author;
    private int year;
    public Book(String t, String a, int y){
        title=t;
        author=a;
        year=y;
    }
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public int getYear(){return year;}
    public boolean isOlderThan(Book other){
        return year<other.getYear();
    }
    public String toString(){
        return ("Tytuł: "+title+", Autor: "+author+", Rok: "+year);
    }

}