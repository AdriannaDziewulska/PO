import static java.lang.Math.sqrt;

public class Zad2 {
    public static void main(String[] args) {
        int li=50;
        int er=0;
        for (int i=2; i<sqrt(li); i++){
            if(li%i==0) er++;
        }
        if(er==0) System.out.println("Liczba jest pierwsza.");
        else System.out.println("Liczba nie jest pierwsza.");
    }
}
