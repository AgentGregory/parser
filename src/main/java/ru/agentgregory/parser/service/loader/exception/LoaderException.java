package ru.agentgregory.parser.service.loader.exception;

public class LoaderException extends Exception{

    public LoaderException() {
    }
    public LoaderException(String message){
        super(message);
    }

    public LoaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
