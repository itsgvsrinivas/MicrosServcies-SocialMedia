package com.gv.postservice.controller;

import com.gv.postservice.dto.response.APIResponse;
import com.gv.postservice.model.Post;
import com.gv.postservice.util.APIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private Environment env;

    @GetMapping("/{postId}")
    public ResponseEntity<APIResponse> getPost(@PathVariable("postId") int postId) {
        log.info("[getPost] port" +  env.getProperty("server.port"));
        log.info("[getPost] postId" + postId);
        Post post = new Post(postId, "Post description " + postId);
        APIResponse apiResponse = APIUtils.createApiResponse("0000", "Successful", post, null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/postBy")
    public Post getPostById(@RequestParam("id") String id) {
        log.info("[getPostById] port" +  env.getProperty("server.port"));
        log.info("[getPostById] postId: " + id);
        return new Post(Integer.parseInt(id), "Post description " + id);
    }

}
