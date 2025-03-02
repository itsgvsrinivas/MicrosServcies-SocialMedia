package com.gv.userservice.dto.response;

import com.gv.userservice.dto.response.Result;
import com.gv.userservice.dto.response.Error;
import lombok.Data;

@Data
public class APIResponse {
    private boolean success;
    private Error error;
    private Result result;
}
