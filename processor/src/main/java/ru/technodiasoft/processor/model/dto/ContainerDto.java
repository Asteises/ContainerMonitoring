package ru.technodiasoft.processor.model.dto;

import lombok.*;
import ru.technodiasoft.processor.model.Parameter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContainerDto {

    // TODO
    private long id;

    private LocalDateTime time;

    private List<Parameter> parameters;
}
