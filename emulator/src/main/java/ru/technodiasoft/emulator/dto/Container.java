package ru.technodiasoft.emulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Container {

    long id;

    private LocalDateTime time;

    private List<Parameter> parameters;
}
