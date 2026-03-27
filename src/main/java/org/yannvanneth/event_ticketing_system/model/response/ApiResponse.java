package org.yannvanneth.event_ticketing_system.model.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class ApiResponse<T> {
    private String message;
    private String status;
    private T payload;
    private Instant timestamp;

    public static <T> ApiResponse<T> success(String message, T payload) {
        return ApiResponse.<T>builder()
                .message(message)
                .status(String.valueOf(HttpStatus.OK.value()))
                .payload(payload)
                .timestamp(Instant.now())
                .build();
    }

    public static <T> ApiResponse<T> success(String message) {
        return ApiResponse.<T>builder()
                .message(message)
                .status(String.valueOf(HttpStatus.OK.value()))
                .payload(null)
                .timestamp(Instant.now())
                .build();
    }

    public static <T> ApiResponse<T> badRequest(String message) {
        return ApiResponse.<T>builder()
                .message(message)
                .status(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .payload(null)
                .timestamp(Instant.now())
                .build();
    }

}
