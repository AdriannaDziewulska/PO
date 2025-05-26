public class TestSend implements SendStrategy {
    @Override
    public void send(Email email) {
        System.out.println("TESTOWA - nie zostanie wysłana:");
        System.out.println("Temat: " + email.getSubject());
        System.out.println("Treść: " + email.getContent());
    }
}
