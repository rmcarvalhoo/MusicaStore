package br.com.ricardo.musicastore.exception;

public class MusicException extends RuntimeException{
    public MusicException(Exception e) {
        super(e);
    }

    public MusicException(String message, Throwable cause) {
        super(message, cause);
    }

    public MusicException(String message) {
        super(message);
    }
}
