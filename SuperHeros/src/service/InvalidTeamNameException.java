package service;

public class InvalidTeamNameException extends RuntimeException {

    public InvalidTeamNameException(String message) {
        super(message);
    }

    public InvalidTeamNameException(String message, Throwable cause) {
        super(message, cause);
    }

}
