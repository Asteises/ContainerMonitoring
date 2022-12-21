package ru.technodiasoft.sensorrequestmanger.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technodiasoft.sensorrequestmanger.model.ContainerParameters;
import ru.technodiasoft.sensorrequestmanger.service.Producer;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/container")
public class SensorController {

    private final Producer producer;

    @PostMapping
    public ResponseEntity<String> saveContainer(@RequestBody List<ContainerParameters> request) {

        log.debug("Пришла коллекция контейнеров: {}", request);
        producer.sendMessage(request);

        return ResponseEntity.ok("OK");
    }
}
