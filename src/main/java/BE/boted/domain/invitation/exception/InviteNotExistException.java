package BE.boted.domain.invitation.exception;

public class InviteNotExistException extends RuntimeException{
    public InviteNotExistException() {
        super();
    }

    public InviteNotExistException(String message) {
        super(message);
    }

    public InviteNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public InviteNotExistException(Throwable cause) {
        super(cause);
    }
}
