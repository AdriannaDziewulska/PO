public class ImmediateSend implements SendStrategy {
    @Override
    public void send(Email email) {
        System.out.println("Wysyłanie wiadomości BEZ OPÓŹNIENIA:");
        System.out.println("Temat: " + email.getSubject());
        System.out.println("Treść: " + email.getContent());
    }
}
