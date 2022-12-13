package ru.technodiasoft.sensorrequestmanger.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.technodiasoft.sensorrequestmanger.model.ContainerParameters;
import ru.technodiasoft.sensorrequestmanger.service.Producer;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/container")
@RequiredArgsConstructor
public class SensorController {

    private final Producer producer;

    @PostMapping
    public ResponseEntity<String> saveContainer(@RequestBody List<ContainerParameters> request) {

        log.info("log");
        producer.sendMessage(request);
        return ResponseEntity.ok("OK");
    }
}
