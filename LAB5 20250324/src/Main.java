import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        TravelAgencyManager manager = new TravelAgencyManager();
        CityBreak cityBreak1 = new CityBreak("C1","Weekend w Warszawie", "Warszawa", BigDecimal.valueOf(400.00), "Wycieczka po najpopularniejszych obiektach stolicy Polski.", 3, Collections.singletonList(5));
        CruiseTrip cruiseTrip1 = new CruiseTrip("CR1", "Kurs Morzem Czerwonym", "Morze Czerwone", BigDecimal.valueOf(2300.00), "Rejs po Morzu Czerwonym z przystankami przy turystycznych miastach.", "MS Sea Explorer", true, Collections.singletonList(5));
        AdventureTrip adventureTrip1 = new AdventureTrip("A1", "Wspinaczki po ścianach górskich", "Skalne Miasto", BigDecimal.valueOf(1500.00), "Wspinaczki po ścianach górskich w pięknym krajobarazie Skalnego Miasta.", "Medium", Collections.singletonList(4));
        try {
            manager.addTrip(cityBreak1);
            manager.addTrip(cruiseTrip1);
            manager.addTrip(adventureTrip1);
        } catch (TripAlreadyExistsException e) {
            System.out.println("Błąd: " + e.getMessage());
        }


        //testowanie
        CityBreak cityBreak2 = new CityBreak("C1","Weekend w Warszawie", "Warszawa", BigDecimal.valueOf(400.00), "Wycieczka po najpopularniejszych obiektach stolicy Polski.", 3, Collections.singletonList(5));
        try {
            manager.addTrip(cityBreak2);
        } catch (TripAlreadyExistsException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        CityBreak cityBreak3 = new CityBreak("","Weekend w Warszawie", "Warszawa", BigDecimal.valueOf(-400.00), "Wycieczka po najpopularniejszych obiektach stolicy Polski.", 3, Collections.singletonList(4));
        try {
            manager.addTrip(cityBreak3);
        } catch (TripAlreadyExistsException e) {
            System.out.println("Błąd: " + e.getMessage());
        }


        try {
            Trip foundTrip = manager.findTripById("C1");
            System.out.println("Znaleziono wycieczkę: " + foundTrip.getClass().getSimpleName());
            System.out.println("Wymagania: " + foundTrip.getTravelRequirements());
        } catch (TripNotFoundException e) {
            System.out.println("Błąd: " + e.getMessage());
        }


        List<Trip> tripsWithFragment = manager.findTripsByTitleFragment("break");
        System.out.println("Wyniki wyszukiwania: ");
        for (Trip trip : tripsWithFragment) {
            System.out.println(trip.getTitle());
        }
        List<Trip> tripsWithFragment1 = manager.findTripsByTitleFragment("xxx");
        System.out.println("Wyniki wyszukiwania: ");
        for (Trip trip : tripsWithFragment1) {
            System.out.println(trip.getTitle());
        }

        System.out.println("Wymagania dla wszystkich wycieczek:");
        manager.displayAllRequirements();

        System.out.println("Usuwanie wycieczki C1:");
        try {
            manager.removeTrip("C1");
            System.out.println("Wycieczka C1 została usunięta.");
        } catch (TripNotFoundException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        System.out.println("Usuwanie wycieczki XYZ:");
        try {
            manager.removeTrip("XYZ");
            System.out.println("Wycieczka XYZ została usunięta.");
        } catch (TripNotFoundException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        manager.bookOneTrip("Jan Kowalski");
        System.out.println("Czy wycieczka CityBreak jest zarezerwowana? " + cityBreak1.isBooked());
        System.out.println("Imię osoby rezerwującej: " + cityBreak1.getBookerName());

        manager.bookOneTrip("Anna Nowak");

        manager.bookOneTrip("");

        try {
            cityBreak1.rate(5);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }
        try {
            cruiseTrip1.rate(3);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }
        try {
            adventureTrip1.rate(4);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }

        try {
            cityBreak1.rate(3);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }
        try {
            cruiseTrip1.rate(4);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }
        try {
            adventureTrip1.rate(5);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Średnia ocena wycieczki CityBreak: " + cityBreak1.getAverageRating());
        System.out.println("Średnia ocena wycieczki CruiseTrip: " + cruiseTrip1.getAverageRating());
        System.out.println("Średnia ocena wycieczki AdventureTrip: " + adventureTrip1.getAverageRating());


        try {
            cityBreak1.rate(10);
        } catch (InvalidRatingException e) {
            System.out.println("Błąd: " + e.getMessage());
        }


        try {
            cityBreak1.rate(5);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }
        try {
            cruiseTrip1.rate(3);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }
        try {
            adventureTrip1.rate(4);
        } catch (InvalidRatingException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Średnia ocena wszystkich wycieczek: " + manager.calculateAverageRatingOfAll());

    }
}
