package ru.technodiasoft.processor.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.dto.ContainerValue;

import java.util.UUID;

@Service
public interface ProcessorService {

    ResponseEntity<String> saveContainer(ContainerValue containerValue);

    Container getContainerById(Long id);
}
