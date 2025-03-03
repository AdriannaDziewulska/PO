public class TemperatureTest {
    public static void main(String[] args) {
        Temperature tempC = Temperature.fromCelsius(20);
        Temperature tempF = Temperature.fromFahrenheit(80);
        Temperature tempK = Temperature.fromKelvin(269);

        System.out.println("Temperatura z C: "+tempC.getCelsius()+ "C, " + tempC.getFahrenheit() + "F, " + tempC.getKelvin() + "K");
        System.out.println("Temperatura z F: " + tempF.getCelsius() + "C, " + tempF.getFahrenheit() + "F, " + tempF.getKelvin() + "K");
        System.out.println("Temperature z K: " + tempK.getCelsius() + "C, " + tempK.getFahrenheit() + "F, " + tempK.getKelvin() + "K");
    }
}
