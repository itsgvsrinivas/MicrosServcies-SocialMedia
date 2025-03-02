package com.gv.userservice.dto.response;

import lombok.Data;

@Data
public class Result <T>{
    private T data;
    private String statusCode;
    private String statusDesc;
}
