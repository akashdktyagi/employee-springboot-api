package demoapi;

public class EmployeeDoesNotExistException extends RuntimeException{
    public EmployeeDoesNotExistException(String message){
        super(message);
    }
}
