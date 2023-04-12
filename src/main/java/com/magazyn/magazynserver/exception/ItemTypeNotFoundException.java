package com.magazyn.magazynserver.exception;

public class ItemTypeNotFoundException extends RuntimeException {
    public ItemTypeNotFoundException(String message) {
        super(message);
    }
}
