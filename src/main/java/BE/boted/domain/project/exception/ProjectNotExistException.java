package BE.boted.domain.project.exception;

public class ProjectNotExistException extends RuntimeException{
    public ProjectNotExistException() {
        super();
    }

    public ProjectNotExistException(String message) {
        super(message);
    }

    public ProjectNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectNotExistException(Throwable cause) {
        super(cause);
    }
}
