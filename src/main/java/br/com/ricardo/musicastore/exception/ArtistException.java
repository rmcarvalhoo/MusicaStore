package br.com.ricardo.musicastore.exception;

public class ArtistException extends RuntimeException{
    public ArtistException(Exception e) {
        super(e);
    }

    public ArtistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArtistException(String message) {
        super(message);
    }
}
