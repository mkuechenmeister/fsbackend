package at.km.fsbackend.Exceptions;

public class PostNotValidException extends Exception {

    public PostNotValidException(String errorMessage)
    {
        super("Post Daten nicht korrekt. Folgende Fehler sind aufgetreten: || " + errorMessage + " ||");
    }
}
