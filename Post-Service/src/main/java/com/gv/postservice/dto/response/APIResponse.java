package com.gv.postservice.dto.response;

import com.gv.postservice.dto.response.Error;
import com.gv.postservice.dto.response.Result;
import lombok.Data;

@Data
public class APIResponse {
    private boolean success;
    private Error error;
    private Result result;
}
