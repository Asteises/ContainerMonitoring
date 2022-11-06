package ru.technodiasoft.emulator.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.technodiasoft.emulator.dto.ContainerParameters;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SensorRequestManagerClient {
    private final RestTemplate template;

    @Value("${service.url}")
    private String serviceURL;

    public String sendData(List<ContainerParameters> request) {
        return template.postForObject(serviceURL + "/container", request, String.class);
    }
}
