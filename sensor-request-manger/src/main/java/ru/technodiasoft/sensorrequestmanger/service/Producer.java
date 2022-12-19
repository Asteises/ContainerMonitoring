package ru.technodiasoft.sensorrequestmanger.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import ru.technodiasoft.sensorrequestmanger.model.ContainerParameters;
import ru.technodiasoft.sensorrequestmanger.model.ContainerValue;

import java.util.List;

@Slf4j
@Service
public class Producer {

    private final KafkaTemplate<String, ContainerValue> kafkaTemplate;

    private final static String TOPIC_NAME = "container";

    @Autowired
    public Producer(KafkaTemplate<String, ContainerValue> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(List<ContainerParameters> request) {

        request.forEach(containerParameters -> containerParameters.getContainersParam().forEach(containerValue -> {
            ListenableFuture<SendResult<String, ContainerValue>> future = kafkaTemplate.send(TOPIC_NAME, containerValue);
            future.addCallback(System.out::println, System.err::println);
            log.info("send container: {}, TOPIC_NAME: {}", containerValue, TOPIC_NAME);
        }));

    }
}
