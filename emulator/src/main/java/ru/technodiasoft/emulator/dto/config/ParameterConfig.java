package ru.technodiasoft.emulator.dto.config;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ParameterConfig {
    private int id;
    private String name;
    private BigDecimal average;
    private BigDecimal maxScatter;
}
