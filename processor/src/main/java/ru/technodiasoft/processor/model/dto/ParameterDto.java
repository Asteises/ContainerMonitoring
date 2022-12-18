package ru.technodiasoft.processor.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ParameterDto {

    private String name;

    private BigDecimal value;

    public ParameterDto() {}
}
