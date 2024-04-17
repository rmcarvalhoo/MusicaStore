package br.com.ricardo.musicastore.exception;

public class AlbumException extends RuntimeException{
    public AlbumException(Exception e) {
        super(e);
    }

    public AlbumException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlbumException(String message) {
        super(message);
    }
}
