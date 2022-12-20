package ru.technodiasoft.processor.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ParameterDto;
import ru.technodiasoft.processor.repository.ContainerStorage;
import ru.technodiasoft.processor.service.ProcessorService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class, LocalDateTime.class, Collections.class},
        uses = {ProcessorService.class})
public abstract class ParameterMapper {

    public static final ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);

    @Autowired
    protected ProcessorService processorService;

    @Mapping(target = "name", source = "name")
    @Mapping(target = "value", source = "value")
    public abstract Parameter toParameter(ParameterDto parameterDto, @Context ContainerStorage containerStorage);

    @InheritInverseConfiguration
    @Mapping(target = "name", source = "name")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "containerId", source = "container.id")
    public abstract ParameterDto toDto(Parameter parameter);
}
