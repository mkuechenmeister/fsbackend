package at.km.fsbackend.Exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponseEntity {
    private String code;
    private String message;
}
