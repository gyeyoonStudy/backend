package BE.boted.domain.task.exception;

public class TaskNotExistException extends RuntimeException{
    public TaskNotExistException() {
        super();
    }

    public TaskNotExistException(String message) {
        super(message);
    }

    public TaskNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskNotExistException(Throwable cause) {
        super(cause);
    }
}
