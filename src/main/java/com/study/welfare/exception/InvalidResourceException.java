package com.study.welfare.exception;

import lombok.Getter;

@Getter
public class InvalidResourceException extends IllegalArgumentException {
    private String resourceName;
    private Long resourceId;

    public InvalidResourceException(String resourceName, Long resourceId) {
        super(String.format("Invalid argument for %s with id %d", resourceName, resourceId));
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }

}
