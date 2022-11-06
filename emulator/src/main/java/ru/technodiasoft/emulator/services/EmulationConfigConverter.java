package ru.technodiasoft.emulator.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.technodiasoft.emulator.dto.config.ContainerConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmulationConfigConverter {
    private final ObjectMapper mapper;

    public ContainerConfig convert(MultipartFile file) throws IOException {
        File jsonConfig = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream outputStream = new FileOutputStream(jsonConfig)) {
            outputStream.write(file.getBytes());
        }
        return mapper.readValue(jsonConfig, ContainerConfig.class);
    }
}
