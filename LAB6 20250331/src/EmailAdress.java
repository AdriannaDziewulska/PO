import java.io.Serializable;

public class EmailAdress implements Serializable {
    private String email;

    public EmailAdress(String email) {
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Niepoprawny adres e-mail. Musi zawierać dokładnie jeden znak '@' i jedną kropkę.");
        }
        this.email = email;
    }

    private boolean isValidEmail(String email) {
        return email.chars().filter(ch -> ch == '@').count() == 1 && email.chars().filter(ch -> ch == '.').count() == 1;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return email;
    }
}
