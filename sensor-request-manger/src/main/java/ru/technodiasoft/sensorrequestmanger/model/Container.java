package ru.technodiasoft.sensorrequestmanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Container {
    private long id;
    private LocalDateTime time;
    private List<Parameter> parameters;
}
