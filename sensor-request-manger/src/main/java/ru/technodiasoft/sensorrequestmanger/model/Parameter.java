package ru.technodiasoft.sensorrequestmanger.model;

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
