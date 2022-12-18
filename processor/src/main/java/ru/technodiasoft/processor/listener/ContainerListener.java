package ru.technodiasoft.processor.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.technodiasoft.processor.model.dto.ContainerDto;

@Slf4j
@Component
public class ContainerListener {

//    @Value("${kafka.container.topic}")
//    private String topic;
//
//    //topic - указали в producer
//    @KafkaListener(topics = "container", groupId = "fGroup", containerFactory = "kafkaListenerContainerFactory")
//    public void listenerContainer(@Payload ContainerDto containerDto, @Headers MessageHeaders messageHeaders) {
//        log.debug("container: {}", containerDto);
//        log.debug("messageHeaders: {}", messageHeaders);
//    }

    @KafkaListener(topics = "container", groupId = "firstGroup", containerFactory = "kafkaListenerContainerFactory")
    public void listenContainer(@Payload ContainerDto containerValue, @Headers MessageHeaders headers) {
        log.debug("Received container: {}", containerValue.toString());
    }
}
