package com.fi.exception;

public class ProductExitsEx extends RuntimeException {
    public ProductExitsEx(String message) {
        super(message);
    }
}
