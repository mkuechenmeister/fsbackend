package at.km.fsbackend.Exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("Angefragter Benutzer nicht vorhanden");
    }
}
