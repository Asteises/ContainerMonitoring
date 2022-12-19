package ru.technodiasoft.processor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor

public class ParameterDto {

    private String name;

    private BigDecimal value;

    private UUID containerId;

    public ParameterDto() {
    }
}
