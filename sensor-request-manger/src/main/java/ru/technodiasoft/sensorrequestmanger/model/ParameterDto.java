package ru.technodiasoft.sensorrequestmanger.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDto {
    private String name;
    private BigDecimal value;
}
