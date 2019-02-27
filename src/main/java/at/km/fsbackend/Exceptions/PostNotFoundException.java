package at.km.fsbackend.Exceptions;

public class PostNotFoundException extends Exception {

        public PostNotFoundException() {
            super("Angefragter Post nicht vorhanden");
        }
    }

