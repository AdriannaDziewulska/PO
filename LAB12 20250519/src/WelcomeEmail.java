public class WelcomeEmail implements Email{
    private String content;
    private String subject;
    private String username;

    public WelcomeEmail(String username){
        this.username=username;
        this.subject = "Witamy w naszym serwisie!";
        this.content = "Cześć " + username + ",\nDziękujemy za rejestrację!";
    }


    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
