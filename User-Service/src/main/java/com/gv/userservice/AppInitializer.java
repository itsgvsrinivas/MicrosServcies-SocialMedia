package com.gv.userservice;

import com.gv.userservice.util.JSONObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("[AppInitializer run+++++]");
        JSONObjectUtils.ObjectMapperEx1();
        JSONObjectUtils.objectMapper2();
        JSONObjectUtils.objectMapper3();
    }
}
