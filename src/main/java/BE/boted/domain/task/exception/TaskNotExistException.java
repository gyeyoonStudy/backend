package BE.boted.domain.task.exception;

public class TaskNotExistException extends RuntimeException{
    public TaskNotExistException(String message) {
        super(message);
    }

}
