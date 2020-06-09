package org.jetbrains.exceptions;

public class UnknownReturnTypeException extends RuntimeException {

    public UnknownReturnTypeException(Class type) {
        super("Unknown type " + type.getName());
    }
}
