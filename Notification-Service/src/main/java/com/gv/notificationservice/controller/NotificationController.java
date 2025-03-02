package com.gv.notificationservice.controller;

import com.gv.notificationservice.dto.response.APIResponse;
import com.gv.notificationservice.model.Notification;
import com.gv.notificationservice.util.APIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    @Autowired
    private Environment env;

    @GetMapping("/{notId}")
    public ResponseEntity<APIResponse> getNotification(@PathVariable("notId") int notId) {
        log.info("[getNotification] port" +  env.getProperty("server.port"));
        log.info("[getNotification] notId" + notId);
        Notification notification = new Notification(notId, "Notification desc " + notId);
        log.info("[getNotification]: "+ notification.toString());
        APIResponse apiResponse = APIUtils.createApiResponse("0000", "Successful", notification, null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/notBy")
    public Notification getNotificationById(@RequestParam("id") String id) {
        log.info("[getNotification] port" +  env.getProperty("server.port"));
        log.info("[getNotificationById] getNotificationById: " + id);
        return new Notification(Integer.parseInt(id), "Notification description " + id);
    }
}
