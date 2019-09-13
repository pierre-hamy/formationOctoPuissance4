package Exceptions;

public class OutOfTockenException extends Exception {

    public OutOfTockenException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
