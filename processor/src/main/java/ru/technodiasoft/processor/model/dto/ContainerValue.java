package ru.technodiasoft.processor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ContainerValue {

    private long id;

    private LocalDateTime time;

    private List<ParameterDto> parameters;

    public ContainerValue() {
    }
}
