package net.vinograd.eventradar.client.domain.attendant;

public class Email {

    private final String email;

    public Email(String email) {
        if (isValid(email))
            throw new IllegalArgumentException("Invalid email address");
        this.email = email;
    }

    private boolean isValid(String value) {
        return value != null && value.matches(".+@.+\\..+");
    }

    public String value() {
        return email;
    }

}