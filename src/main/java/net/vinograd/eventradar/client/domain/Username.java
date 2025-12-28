package net.vinograd.eventradar.client.domain;

import lombok.Getter;

@Getter
public class Username {

    private String firstName;

    private String lastName;

    public Username(String firstName, String lastName) {
        if (!isValid(firstName) || !isValid(lastName))
            throw new IllegalArgumentException("Invalid username");

        this.firstName = firstName;
        this.lastName = lastName;
    }

    private boolean isValid(String value){
        return value.matches("^[а-яА-ЯёЁ ]+$");
    }

    public void changeUserName(String firstName, String lastName) {
        if (!isValid(firstName) || !isValid(lastName))
            throw new IllegalArgumentException("Invalid username");
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
