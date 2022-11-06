package ru.technodiasoft.sensorrequestmanger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {
    private String name;
    private BigDecimal value;
}
