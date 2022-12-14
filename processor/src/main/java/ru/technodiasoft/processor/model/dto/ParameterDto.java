package ru.technodiasoft.processor.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParameterDto {

    private String name;

    private BigDecimal value;

    private UUID containerId;
}
