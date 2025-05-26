import java.time.LocalDate;

public class PromoEmail implements Email {
    private final String promoCode;
    private final LocalDate validUntil;
    private final String subject;
    private final String content;

    public PromoEmail(String promoCode, LocalDate validUntil) {
        this.promoCode = promoCode;
        this.validUntil = validUntil;
        this.subject = "Skorzystaj z kodu rabatowego!";
        this.content = "Oto Twój kod rabatowy: " + promoCode +
                "\nWażny do: " + validUntil.toString();
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}