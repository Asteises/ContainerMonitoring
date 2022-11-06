package ru.technodiasoft.emulator.dto.config;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class ContainerConfig {
    private int containersCount;
    private LocalDateTime datetimeStartEmulation;
    private BigDecimal maxTimeShift;
    private BigDecimal samplingStep;
    private int stepEmulationCount;
    private List<ParameterConfig> parameters;
    private int intervalSendingMessages;

    public void setDatetimeStartEmulation(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.datetimeStartEmulation= LocalDateTime.parse(dateTime, formatter);
    }
}


