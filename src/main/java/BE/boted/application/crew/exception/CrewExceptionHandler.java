package BE.boted.application.crew.exception;

import BE.boted.domain.crew.exception.CrewNotExistException;
import BE.boted.domain.crew.exception.NickNameAlreadyExistException;
import BE.boted.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CrewExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CrewNotExistException.class)
    public ErrorResponse handleCrewNotExistException(CrewNotExistException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NickNameAlreadyExistException.class)
    public ErrorResponse handleNickNameAlreadyExistException(NickNameAlreadyExistException exception) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
