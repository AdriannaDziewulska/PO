public class EmailSender {
    private Email email;
    private SendStrategy strategy;

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setSendStrategy(SendStrategy strategy) {
        this.strategy = strategy;
    }

    public void send() {
        if (email == null || strategy == null) {
            System.out.println("Nie ustawiono wiadomości lub strategii wysyłki.");
            return;
        }
        strategy.send(email);
    }
}
