package com.shopflow.common.error;

public class ErrorMessage {
    private final String error;
    private final String message;

    public ErrorMessage(Exception e) {
        this.error = e.getClass().getSimpleName();
        this.message = e.getMessage();
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "error='" + error + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
