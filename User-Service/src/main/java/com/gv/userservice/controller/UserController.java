package com.gv.userservice.controller;

import com.gv.userservice.dto.response.APIResponse;
import com.gv.userservice.exception.NoUserFoundException;
import com.gv.userservice.model.Notification;
import com.gv.userservice.model.Post;
import com.gv.userservice.model.User;
import com.gv.userservice.service.UserService;
import com.gv.userservice.util.APIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {

    private final String POST_URL_DIRECT_ID = "http://localhost:8082/api/v1/posts/postBy?id=";
    private final String NOTIFICATION_URL_DIRECT_ID = "http://localhost:8083/api/v1/notifications/notBy?id=";

    private final String POST_URL_SERVICE_NAME_ID = "http://POST-SERVICE/api/v1/posts/";
    private final String NOTIFICATION_URL_SERVICE_NAME_ID = "http://NOTIFICATION-SERVICE/api/v1/notifications/";

    private final RestTemplate restTemplate;
    private UserService userService;

    public UserController(RestTemplate restTemplate, UserService userService) {
        this.restTemplate = restTemplate;
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<APIResponse> getUser(@PathVariable("id") Long id) {
        log.info("[getUser] id:" + id);
        Long userId = Long.valueOf(id);

        Post post = restTemplate.getForObject(POST_URL_DIRECT_ID + id, Post.class);
        Notification notification = restTemplate.getForObject(NOTIFICATION_URL_DIRECT_ID + id, Notification.class);

        User user = new User(userId, "Srini", "36", "01135180225", post, notification);
        APIResponse apiResponse = APIUtils.createApiResponse("0000", "Successful", user, null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(value = "byUserId/{id}")
    public ResponseEntity<APIResponse> getUser1(@PathVariable("id") Long id) {
        log.info("[getUser333333] id:" + id);
        Long userId = Long.valueOf(id);
        APIResponse apiResponse = null;
        try {
            Notification notification = restTemplate.getForObject(NOTIFICATION_URL_SERVICE_NAME_ID + id, Notification.class);
            Post post = restTemplate.getForObject(POST_URL_SERVICE_NAME_ID + id, Post.class);

            User user = new User(userId, "Srini", "36", "01135180225", post, notification);
            apiResponse = APIUtils.createApiResponse("0000", "Successful", user, null);
        } catch (Exception exception) {
            log.error("[getUser1] error: " + exception.getMessage());

            new NoUserFoundException("No user found");
        }
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(value = "byUserIdFeign/{id}")
    public ResponseEntity<APIResponse> getUserByFeign(@PathVariable("id") Long id) {
        log.info("[getUserByFeign 11111] id:" + id);
        APIResponse apiResponse = userService.getUserById(id);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllUsers() {
        log.info("[getAllUsers]");

        Long userId1 = Long.valueOf(1);
        Post post1 = restTemplate.getForObject(POST_URL_DIRECT_ID + userId1, Post.class);
        Notification notification1 = restTemplate.getForObject(NOTIFICATION_URL_DIRECT_ID + userId1, Notification.class);


        Long userId2 = Long.valueOf(1);
        Post post2 = restTemplate.getForObject(POST_URL_DIRECT_ID + userId1, Post.class);
        Notification notification2 = restTemplate.getForObject(NOTIFICATION_URL_DIRECT_ID + userId1, Notification.class);


        User user1 = new User(userId1, "Srini", "36", "01135180225", post1, notification1);
        User user2 = new User(userId2, "Rajesh", "24", "01153745422", post2, notification2);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        APIResponse apiResponse = APIUtils.createApiResponse("0000", "Successful", list, null);
        return ResponseEntity.ok(apiResponse);

    }
}
