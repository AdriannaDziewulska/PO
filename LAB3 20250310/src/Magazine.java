public class Magazine extends Item{
    private int issueNumber;
    private int month;
    private String theme;
    private int popularity;

    public Magazine(int id, String title, String author, int year, boolean isAvailable, int WhoId, int issueNumber, int month, String theme, int popularity) {
        super(id, title, author, year, isAvailable, WhoId);
        this.issueNumber=issueNumber;
        this.month=month;
        this.theme=theme;
        this.popularity=popularity;
    }

    public String getInformation(){
        return "Numer magazynu: "+issueNumber+" miesiąc: "+month+" Twmat: "+theme;
    }
}
