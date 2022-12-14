package ru.technodiasoft.processor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technodiasoft.processor.model.dto.ContainerDto;
import ru.technodiasoft.processor.service.ProcessorServiceImpl;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/{TOPIC_NAME}")
public class ProcessorController {

    private final ProcessorServiceImpl processorService;

    //TODO Процессор может обрабатывать различные данные (много топиков) или только по одному топику?

    public ResponseEntity<String> saveData(ContainerDto containerDto) {

        log.info("Пришли данные containerDto: {}", containerDto);
        return processorService.saveContainer(containerDto);
    }

}
