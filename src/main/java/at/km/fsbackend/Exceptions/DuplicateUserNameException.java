package at.km.fsbackend.Exceptions;

public class DuplicateUserNameException extends Exception{

    public DuplicateUserNameException()
    {
        super("Username bereits in DB vorhanden!");
    }
}
