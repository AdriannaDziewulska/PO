import java.time.LocalDate;

public class EmailFactory {
    public Email create(String type) {
        return switch (type.toLowerCase()) {
            case "welcome" -> new WelcomeEmail("ŁUKASZ");
            case "promo" -> new PromoEmail("promo2025", LocalDate.of(2025, 6, 30));
            case "info" -> new InfoEmail();
            default -> throw new IllegalArgumentException("Nieznany typ wiadomości: " + type);
        };
    }
}
