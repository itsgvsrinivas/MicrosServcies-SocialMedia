package com.gv.userservice.service;


import com.gv.userservice.dto.response.APIResponse;

public interface UserService {
    APIResponse getUserById(long id);
}
