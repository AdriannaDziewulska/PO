public class Dzban {
    private int id;
    private String nazwa;
    private String opis;
    private int pojemnosc;
    private int wysokosc;

    public Dzban(String nazwa, String opis, int pojemnosc, int wysokosc) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.pojemnosc = pojemnosc;
        this.wysokosc = wysokosc;
    }

    public Dzban(int id, String nazwa, String opis, int pojemnosc, int wysokosc) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.pojemnosc = pojemnosc;
        this.wysokosc = wysokosc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    @Override
    public String toString() {
        return "Dzban{" + "id=" + id + ", nazwa='" + nazwa + '\'' + ", opis='" + opis + '\'' + ", pojemnosc=" + pojemnosc + ", wysokosc=" + wysokosc + '}';}
}
