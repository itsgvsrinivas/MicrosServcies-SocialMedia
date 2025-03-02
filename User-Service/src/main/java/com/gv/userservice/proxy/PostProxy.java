package com.gv.userservice.proxy;

import com.gv.userservice.dto.response.APIResponse;
import com.gv.userservice.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "post-service")
public interface PostProxy {

    @GetMapping("/api/v1/posts/{id}")
    public ResponseEntity<APIResponse> getPostById(@PathVariable(name = "id") int id);
}
