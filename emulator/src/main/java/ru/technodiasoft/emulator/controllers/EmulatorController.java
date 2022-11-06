package ru.technodiasoft.emulator.controllers;

import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.technodiasoft.emulator.dto.config.ContainerConfig;
import ru.technodiasoft.emulator.services.EmulationConfigConverter;
import ru.technodiasoft.emulator.services.Emulator;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/emulator")
@RequiredArgsConstructor
public class EmulatorController {
    private final Emulator emulator;
    private final EmulationConfigConverter converter;

    @PostMapping
    public ResponseEntity<String> uploadConfig(@RequestPart(value = "file") MultipartFile file) throws IOException, SchedulerException {
        ContainerConfig config = converter.convert(file);
        emulator.emulate(config);
        return ResponseEntity.ok().build();
    }

    private boolean validateFile(MultipartFile file) {
        return Objects.requireNonNull(file.getOriginalFilename()).endsWith("json");
    }
}
