package ru.technodiasoft.processor.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.technodiasoft.processor.model.dto.ContainerDto;

@Service
public interface ProcessorService {

    ResponseEntity<String> saveContainer(ContainerDto containerDto);
}
