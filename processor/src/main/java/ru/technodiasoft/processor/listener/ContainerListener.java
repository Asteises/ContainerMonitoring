package ru.technodiasoft.processor.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.technodiasoft.processor.model.dto.ContainerValue;
import ru.technodiasoft.processor.service.ProcessorService;

@Slf4j
@RequiredArgsConstructor
@EnableKafka
@Service
public class ContainerListener {

    private final ProcessorService processorService;

//    //topic - указали в producer
//    @KafkaListener(topics = "container", groupId = "containerGroup", containerFactory = "kafkaListenerContainerFactory")
//    public void listenerContainer(@Payload ContainerValue containerValue, @Headers MessageHeaders messageHeaders) {
//        log.debug("Получили container: {}", containerValue);
//    }

    @KafkaListener(topics = "container")
    public void containerListener(ConsumerRecord<String, ContainerValue> record) {

        log.debug("Получили record: {}", record);
        processorService.saveContainer(record.value());
    }
}
