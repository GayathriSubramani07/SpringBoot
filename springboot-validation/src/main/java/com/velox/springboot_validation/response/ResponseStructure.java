package com.velox.springboot_validation.response;

public class ResponseStructure<T> {

    private String message;
    private T data;
    private int status;

    // Constructors
    public ResponseStructure() {}

    public ResponseStructure(String message, T data, int status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
