package com.gv.userservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gv.userservice.dto.response.APIResponse;
import com.gv.userservice.exception.NoUserFoundException;
import com.gv.userservice.model.Notification;
import com.gv.userservice.model.Post;
import com.gv.userservice.model.User;
import com.gv.userservice.proxy.NotificationProxy;
import com.gv.userservice.proxy.PostProxy;
import com.gv.userservice.service.UserService;
import com.gv.userservice.util.APIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final PostProxy postProxy;

    private final NotificationProxy notificationProxy;

    public UserServiceImpl(PostProxy postProxy, NotificationProxy notificationProxy) {
        this.postProxy = postProxy;
        this.notificationProxy = notificationProxy;
    }

    @Override
    public APIResponse getUserById(long id) {

        int userId = (int) id;

        if (userId == 0) {
            throw new NoUserFoundException("No user found++++");
        }

        ResponseEntity<APIResponse> notificationRE = notificationProxy.getNotificationById(1);
        ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
        Notification notification = mapper.convertValue(notificationRE.getBody().getResult().getData(), Notification.class);

        log.info("notification: " + notification.toString());

        ResponseEntity<APIResponse> postRE = postProxy.getPostById(1);
        Post post = mapper.convertValue(Objects.requireNonNull(postRE.getBody()).getResult().getData(), Post.class);
        log.info("post: " + post.toString());

        User user = new User(id, "Srini", "36", "01135180225", post, notification);
        APIResponse apiResponse = APIUtils.createApiResponse("0000", "Successful", user, null);

        return apiResponse;
    }
}
