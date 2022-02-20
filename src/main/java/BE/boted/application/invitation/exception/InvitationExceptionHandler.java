package BE.boted.application.invitation.exception;

import BE.boted.domain.invitation.exception.InviteNotExistException;
import BE.boted.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvitationExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InviteNotExistException.class)
    public ErrorResponse handleInviteNotExistException(InviteNotExistException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}
