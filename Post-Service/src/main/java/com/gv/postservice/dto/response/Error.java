package com.gv.postservice.dto.response;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String message;
}
