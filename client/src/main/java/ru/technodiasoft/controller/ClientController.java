package ru.technodiasoft.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technodiasoft.client.ClientService;
import ru.technodiasoft.dto.ContainerValue;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/container")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("{containerId}")
    public ResponseEntity<ContainerValue> getDataByContainer(@PathVariable String containerId) {
        log.debug("asdasdasd");
        return clientService.get(containerId);
    }
}
