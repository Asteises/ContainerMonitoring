package ru.technodiasoft.processor.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.technodiasoft.processor.model.dto.ContainerDto;
import ru.technodiasoft.processor.model.dto.ContainerValue;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfiguration {

    @Value("${kafka.container.groupId}")
    private String groupId;

    @Value("${kafka.container.enabled}")
    private String enabled;

    @Value("${kafka.container.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public ConsumerFactory<String, ContainerValue> consumerFactory() {

        JsonDeserializer<ContainerValue> deserializer = new JsonDeserializer<>(ContainerValue.class);
        deserializer.setRemoveTypeHeaders(false);
        // Указываем доверенные пакеты
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ContainerValue> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, ContainerValue> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();

        containerFactory.setConsumerFactory(consumerFactory());
        return containerFactory;
    }

    //TODO
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
