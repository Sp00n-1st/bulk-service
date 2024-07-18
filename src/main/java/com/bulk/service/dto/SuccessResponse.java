package com.bulk.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {
    @Builder.Default
    private int code = 200;
    @Builder.Default
    private boolean success = true;
    @Builder.Default
    private String message = "";
}
