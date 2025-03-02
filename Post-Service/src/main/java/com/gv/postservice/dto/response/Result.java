package com.gv.postservice.dto.response;

import lombok.Data;

@Data
public class Result <T>{
    private T data;
    private String statusCode;
    private String statusDesc;
}
