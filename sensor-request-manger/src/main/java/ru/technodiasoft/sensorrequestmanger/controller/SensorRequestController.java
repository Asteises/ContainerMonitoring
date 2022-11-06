package ru.technodiasoft.sensorrequestmanger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technodiasoft.sensorrequestmanger.dto.ContainerParameters;

import java.util.List;

@RestController
@RequestMapping("/container")
@Slf4j
public class SensorRequestController {

    @PostMapping
    public ResponseEntity<String> postParameters(@RequestBody List<ContainerParameters> parameters) {
        log.info("Принимаем даныне: {}", parameters);
        // логика
        return ResponseEntity.ok("OK");
    }
}
