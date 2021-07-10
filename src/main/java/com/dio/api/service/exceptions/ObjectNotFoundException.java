package com.dio.api.service.exceptions;

public class ObjectNotFoundException extends  RuntimeException {

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
