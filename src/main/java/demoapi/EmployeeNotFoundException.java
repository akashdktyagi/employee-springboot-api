package demoapi;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String text){
        super(text);
    }
}
