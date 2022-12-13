package ru.technodiasoft.sensorrequestmanger.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.technodiasoft.sensorrequestmanger.model.Container;
import ru.technodiasoft.sensorrequestmanger.model.ContainerParameters;

import java.util.List;

//TODO Подготовить модуль Процессор, добавить БД и тд.
@Slf4j
@Service
public class Producer {

    private KafkaTemplate<String, Container> kafkaTemplate;

    private final String TOPIC_NAME = "container";

    @Autowired
    public Producer(KafkaTemplate<String, Container> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(List<ContainerParameters> request) {

        request.forEach(containerParameters -> containerParameters.getContainersParam().forEach(container -> {
            kafkaTemplate.send(TOPIC_NAME, container);
            log.info("send container: {}, TOPIC_NAME: {}", container, TOPIC_NAME);
        }));

    }
}
