package ru.technodiasoft.processor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technodiasoft.processor.mapper.ContainerMapper;
import ru.technodiasoft.processor.model.dto.ContainerValue;
import ru.technodiasoft.processor.service.ProcessorServiceImpl;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/processor")
public class ProcessorController {

    private final ProcessorServiceImpl processorService;

    @GetMapping("/{containerId}")
    public ContainerValue asd(@PathVariable long containerId) {

        ContainerValue result = ContainerMapper.INSTANCE.toDto(processorService.getContainerById(containerId));
        log.info("Возвращаем пользователю ContainerValue: {}", result);

        return result;
    }
}
