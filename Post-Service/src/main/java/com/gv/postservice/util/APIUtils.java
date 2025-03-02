package com.gv.postservice.util;

import com.gv.postservice.dto.response.APIResponse;
import com.gv.postservice.dto.response.Error;
import com.gv.postservice.dto.response.Result;

public class APIUtils {

    public static <T> APIResponse createApiResponse(String statusCode, String statusDesc, T data , Error error){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setSuccess(true);
        apiResponse.setError(error);
        Result result = new Result();
        result.setData(data);

        result.setStatusCode(statusCode);
        result.setStatusDesc(statusDesc);
        apiResponse.setResult(result);
        return apiResponse;
    }
}
