package ru.technodiasoft.client.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technodiasoft.client.service.ClientService;
import ru.technodiasoft.client.dto.ContainerValue;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/container")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("{containerId}")
    public ResponseEntity<ContainerValue> getDataByContainer(@PathVariable String containerId) {

        log.debug("Пользователь запрашивает данные по контейнеру: {}", containerId);
        return clientService.get(containerId);
    }
}
