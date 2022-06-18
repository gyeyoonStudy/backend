package BE.boted.domain.project.exception;

public class ProjectNotExistException extends RuntimeException{

    public ProjectNotExistException(String message) {
        super(message);
    }

}
