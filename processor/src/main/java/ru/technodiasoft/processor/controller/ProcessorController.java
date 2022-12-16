package ru.technodiasoft.processor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technodiasoft.processor.service.ProcessorServiceImpl;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/processor")
public class ProcessorController {

    private final ProcessorServiceImpl processorService;

    @GetMapping
    public String asd() {
        return "qwe";
    }
}
