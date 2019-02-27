package at.km.fsbackend.Controller;

import at.km.fsbackend.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@CrossOrigin(origins = "http://localhost:4200")
public class ExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponseEntity> handleUserNotFound (UserNotFoundException ex) {
        ExceptionResponseEntity exre = new ExceptionResponseEntity("1000",ex.getMessage());
        return new ResponseEntity<>(exre, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateUserNameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ExceptionResponseEntity> handleDuplicateUsername (DuplicateUserNameException ex) {
        ExceptionResponseEntity exre = new ExceptionResponseEntity("1001",ex.getMessage());
        return new ResponseEntity<>(exre, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PostNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponseEntity> handlePostNotValid(PostNotValidException ex)
    {
        ExceptionResponseEntity exre = new ExceptionResponseEntity("2001", ex.getMessage() );
        return new ResponseEntity<>(exre, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponseEntity> handlePostNotFound(PostNotFoundException ex)
    {
        ExceptionResponseEntity exre = new ExceptionResponseEntity("3001", ex.getMessage() );
        return new ResponseEntity<>(exre, HttpStatus.BAD_REQUEST);
    }
}