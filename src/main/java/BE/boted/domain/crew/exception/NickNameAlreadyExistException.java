package BE.boted.domain.crew.exception;

public class NickNameAlreadyExistException extends RuntimeException{
    public NickNameAlreadyExistException() {
        super();
    }

    public NickNameAlreadyExistException(String message) {
        super(message);
    }

    public NickNameAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public NickNameAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
