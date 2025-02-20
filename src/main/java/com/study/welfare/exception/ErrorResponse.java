package com.study.welfare.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class ErrorResponse {
    private int status;
    private String message;
    private String resourceName;
    private Long resourceId;

    public static ErrorResponse createMessage(int status, String message, String resourceName, Long resourceId){
        return ErrorResponse.builder()
                .status(status)
                .message(message)
                .resourceName(resourceName)
                .resourceId(resourceId)
                .build();
    }
}
