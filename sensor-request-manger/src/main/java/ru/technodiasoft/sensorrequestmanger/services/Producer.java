package ru.technodiasoft.sensorrequestmanger.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.technodiasoft.sensorrequestmanger.dto.Container;
import ru.technodiasoft.sensorrequestmanger.dto.ContainerParameters;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class Producer {

    private final String TOPIC_NAME = "container";
    private final KafkaTemplate<String, Container> kafkaTemplate;

    public void stringMessage(List<ContainerParameters> containerParameters) {
        containerParameters.forEach(containerParameter -> containerParameter.getContainersParam()
                .forEach(container -> {
                    kafkaTemplate.send(TOPIC_NAME, container);
                    log.info("Produce message in Topic: {} and value: {}", TOPIC_NAME, container);
                }));
    }
}
