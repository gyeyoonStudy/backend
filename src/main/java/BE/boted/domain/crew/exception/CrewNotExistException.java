package BE.boted.domain.crew.exception;

public class CrewNotExistException extends RuntimeException{
    public CrewNotExistException() {
        super();
    }

    public CrewNotExistException(String message) {
        super(message);
    }

    public CrewNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrewNotExistException(Throwable cause) {
        super(cause);
    }
}
