public class InfoEmail implements Email {
    private final String subject = "Ważna informacja";
    private final String content = "To jest email informacyjny.";

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}