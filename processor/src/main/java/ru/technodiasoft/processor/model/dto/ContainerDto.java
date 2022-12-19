package ru.technodiasoft.processor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.technodiasoft.processor.model.Parameter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContainerDto {

    private LocalDateTime time;

    private List<Parameter> parameters;
}
