import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        EmailFactory factory = new EmailFactory();
        Email email = factory.create("promo");

        Email decoratedEmail = new UnsubscribeDecorator(new FooterDecorator(email));

        EmailSender sender = new EmailSender();
        sender.setEmail(decoratedEmail);

        System.out.println("\n\n\n");
        sender.setSendStrategy(new TestSend());
        sender.send();

        System.out.println("\n\n\n");
        sender.setSendStrategy(new ImmediateSend());
        sender.send();

        System.out.println("\n\n\n");
        sender.setSendStrategy(new DelayedSend(3));
        sender.send();

        System.out.println("\n\n\n");
    }
}
