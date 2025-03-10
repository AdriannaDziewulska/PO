abstract class Item{
    protected int id;
    protected String title;
    protected String author;
    protected int year;
    protected boolean isAvailable;
    protected int whoId;
    public Item(int id, String title, String author, int year, boolean isAvailable, int whoId){
        this.id=id;
        this.title=title;
        this.author=author;
        this.year=year;
        this.isAvailable=isAvailable;
        this.whoId=whoId;
    }
    public String getInformation(){
        System.out.println("Id: "+id+" Tytuł: "+title+" Autor: "+author+" Rok wydania: "+year+" Czy jest dostępna: "+(isAvailable ? "tak" : "nie")+"\n");
        return "Id: "+id+" Tytuł: "+title+" Autor: "+author+" Rok wydania: "+year+" Czy jest dostępna: "+(isAvailable ? "tak" : "nie")+"\n";
    }
    public boolean borrowItem(int newWhoId){
        if(whoId==0) {
            whoId = newWhoId;
            isAvailable = false;
            System.out.println("Zarezerwowano przez: "+newWhoId+", Tytuł:" + title + "\n");
        }
        else{
            System.out.println("Pozycja niedostępna.");
        }
        return isAvailable;
    }
    public boolean returnItem(int backWhoId){
        whoId=0;
        isAvailable=true;
        System.out.println("Zwrócono przez: "+backWhoId+", Tytuł:"+title+"\n");
        return isAvailable;
    }

}