package com.study.welfare.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private String resourceName;
    private long resourceId;

    public NotFoundException(String resourceName, long resourceId) {
        super(String.format("%s with id %d not found", resourceName, resourceId));
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }

}
