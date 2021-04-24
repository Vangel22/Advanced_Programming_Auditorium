package auditoriska4.zadaca2;

public class UnknownOperatorException extends Exception{
    public UnknownOperatorException(char operator) {
        super(String.format("unknown operator: %c", operator));
    }
}
