public class FractionTest {
    public static void main(String[] args) {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(3, 4);
        System.out.println(a.add(b));
        System.out.println(a.substract(b));
        System.out.println(a.multiply(b));
        System.out.println(a.divide(b));
        System.out.println(a.reduce());
    }
}
