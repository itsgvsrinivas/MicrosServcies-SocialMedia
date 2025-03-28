package com.gv.userservice.util;

import com.gv.userservice.dto.response.APIResponse;
import com.gv.userservice.dto.response.Error;
import com.gv.userservice.dto.response.Result;

import static java.util.Objects.nonNull;

public class APIUtils {

    public static <T> APIResponse createApiResponse(String statusCode, String statusDesc, T data, Error error) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setSuccess(!nonNull(error));
        apiResponse.setError(error);

        Result result = new Result();
        result.setData(data);

        result.setStatusCode(statusCode);
        result.setStatusDesc(statusDesc);
        apiResponse.setResult(!nonNull(error) ? result : null);
        return apiResponse;
    }
}
