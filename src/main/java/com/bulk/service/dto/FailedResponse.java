package com.bulk.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FailedResponse {
    @Builder.Default
    private boolean success = false;
    @Builder.Default
    private int code = 500;
    @Builder.Default
    private String message = "Error Server";
}
