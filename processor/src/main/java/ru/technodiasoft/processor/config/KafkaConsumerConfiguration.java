package ru.technodiasoft.processor.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.technodiasoft.processor.model.dto.ContainerDto;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfiguration {
//
//    @Value("${kafka.container.groupId}")
//    private String groupId;
//
//    @Value("${kafka.container.enabled}")
//    private String enabled;
//
//    @Value("${kafka.container.bootstrapAddress}")
//    private String bootstrapAddress;
//
//    @Bean
//    public ConsumerFactory<String, ContainerDto> consumerFactory() {
//
//        JsonDeserializer<ContainerDto> deserializer = new JsonDeserializer<>(ContainerDto.class);
//        deserializer.setRemoveTypeHeaders(false);
//        // Указываем доверенные пакеты
//        deserializer.addTrustedPackages("*");
//        deserializer.setUseTypeMapperForKey(true);
//
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
//
//        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, ContainerDto> kafkaListenerContainerFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<String, ContainerDto> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
//
//        containerFactory.setConsumerFactory(consumerFactory());
//        return containerFactory;
//    }

    @Value(value = "${kafka.container.bootstrapAddress}")
    private String address;

    @Value(value = "${kafka.container.groupId}")
    private String groupId;

    @Value(value = "${kafka.container.enabled}")
    private String enabled;

    @Bean
    public ConsumerFactory<String, ContainerDto> consumerFactory() {
        JsonDeserializer<ContainerDto> deserializer = new JsonDeserializer<>(ContainerDto.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, address);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        return new DefaultKafkaConsumerFactory(
                props,
                new StringDeserializer(),
                deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ContainerDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ContainerDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
