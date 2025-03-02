package com.gv.userservice.proxy;

import com.gv.userservice.dto.response.APIResponse;
import com.gv.userservice.model.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "notification-service")
public interface NotificationProxy {

    @GetMapping("/api/v1/notifications/{id}")
    public ResponseEntity<APIResponse> getNotificationById(@PathVariable(name = "id") int id);
}
