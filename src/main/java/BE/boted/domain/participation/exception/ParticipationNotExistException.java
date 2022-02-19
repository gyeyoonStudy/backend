package BE.boted.domain.participation.exception;

public class ParticipationNotExistException extends RuntimeException{
    public ParticipationNotExistException() {
        super();
    }

    public ParticipationNotExistException(String message) {
        super(message);
    }

    public ParticipationNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParticipationNotExistException(Throwable cause) {
        super(cause);
    }
}
