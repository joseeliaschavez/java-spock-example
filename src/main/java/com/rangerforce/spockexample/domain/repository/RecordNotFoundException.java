/* (C) 2024 */
package com.rangerforce.spockexample.domain.repository;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
