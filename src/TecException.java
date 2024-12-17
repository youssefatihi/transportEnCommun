package tec;

public class TecException extends Exception {
    public TecException(String message) {
        super(message);
    }

    public TecException(String message, Throwable cause) {
        super(message, cause);
    }

    // Ajoutez d'autres constructeurs ou méthodes si nécessaire
}