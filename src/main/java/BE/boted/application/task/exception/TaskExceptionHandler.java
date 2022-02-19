package BE.boted.application.task.exception;

import BE.boted.domain.task.exception.TaskNotExistException;
import BE.boted.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskNotExistException.class)
    public ErrorResponse findTaskNotExistException(TaskNotExistException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}
