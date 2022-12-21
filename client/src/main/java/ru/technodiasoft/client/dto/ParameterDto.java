package ru.technodiasoft.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class ParameterDto {

    private String name;

    private BigDecimal value;

    private long containerId;

    public ParameterDto() {
    }
}
