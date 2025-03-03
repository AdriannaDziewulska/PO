public class Fraction {
    private int numerator;
    private int denominator;
    public Fraction(int n, int d){
        numerator = n;
        denominator = d;
    }

    public int getNumerator(){return numerator;};
    public int getDenominator(){return denominator;};

    public String toString(){
        return (numerator+"/"+denominator);
    }
    int a, b;
    public String add(Fraction other){
        if(denominator==other.getDenominator()){
            a=numerator+other.getNumerator();
            return ("Suma: "+a+"/"+denominator);
        }
        else{
            b=denominator*other.getDenominator();
            a=numerator* other.getDenominator()+other.getNumerator()*denominator;
            return ("Suma: "+a+"/"+b);
        }
    }
    public String substract(Fraction other){
        if(denominator==other.getDenominator()){
            a=numerator-other.getNumerator();
            return ("Różnica: "+a+"/"+denominator);
        }
        else{
            b=denominator*other.getDenominator();
            a=numerator* other.getDenominator()-other.getNumerator()*denominator;
            return ("Różnica: "+a+"/"+b);
        }
    }
    public String multiply(Fraction other){
            b=denominator*other.getDenominator();
            a=numerator*other.getNumerator();
            return ("Mnożenie: "+a+"/"+b);
    }
    public String divide(Fraction other){
        b=denominator*other.getNumerator();
        a=numerator*other.getDenominator();
        return ("Dzielenie: "+a+"/"+b);
    }
    public String reduce(){
        int NWD=NWD(numerator,denominator);
        numerator/=NWD;
        denominator/=NWD;
        return ("Skrócony: "+numerator+"/"+denominator);
    }
    public int NWD(int c, int d){
        while(d!=0){
            int t=d;
            d=c%d;
            c=t;
        }
        return Math.abs(c);
    }
}
