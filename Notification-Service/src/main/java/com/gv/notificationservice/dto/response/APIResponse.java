package com.gv.notificationservice.dto.response;

import lombok.Data;

@Data
public class APIResponse {
    private boolean success;
    private Error error;
    private Result result;
}
