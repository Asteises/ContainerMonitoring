package ru.technodiasoft.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.technodiasoft.client.dto.ContainerValue;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final RestTemplate restTemplate;

    @Autowired
    public ClientService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    private final String PATCH = "http://localhost:8080/api/v1/processor";

    public ResponseEntity<ContainerValue> get(String containerId) {

        return restTemplate.exchange(
                PATCH + "/" + containerId,
                HttpMethod.GET,
                null,
                ContainerValue.class);
    }
}
