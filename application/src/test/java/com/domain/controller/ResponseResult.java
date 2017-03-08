package com.domain.controller;


public class ResponseResult<T> {

    private T payload;

    private String status;

    private String message;

    public final T getPayload() {
        return payload;
    }

    public final void setPayload(final T payload) {
        this.payload = payload;
    }

    public final String getStatus() {
        return status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

    public final String getMessage() {
        return message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

}
