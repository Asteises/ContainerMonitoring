package ru.technodiasoft.processor.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.technodiasoft.processor.model.dto.ContainerDto;

@Slf4j
@Service
public class ContainerListener {

    //topic - указали в producer
    @KafkaListener(topics = "container", groupId = "containerGroup", containerFactory = "kafkaListenerContainerFactory")
    public void listenerContainer(@Payload ContainerDto containerDto, @Headers MessageHeaders messageHeaders) {
        log.debug("container: {}", containerDto);
    }
}
