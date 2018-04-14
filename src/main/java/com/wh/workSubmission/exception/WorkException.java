package com.wh.workSubmission.exception;


public class WorkException extends RuntimeException {

    private String message;

    public WorkException(String message) {
        super(message);
        this.message = message;
    }

    public WorkException() {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
