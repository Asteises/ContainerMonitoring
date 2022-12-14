package ru.technodiasoft.processor.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ParameterDto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class, LocalDateTime.class, Collections.class},
        uses = {Container.class})
public abstract class ParameterMapper {

    public static final ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);

    //TODO Нужно писать код для маппинга String, BigDecimal ?

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "name", expression = "java()")
    @Mapping(target = "value", expression = "java()")
    @Mapping(target = "container", expression = "java(processorService.getContainerById(parameterDto.getContainerId))")
    public abstract Parameter toParameter(ParameterDto parameterDto);

    @InheritInverseConfiguration
    @Mapping(target = "name", source = "parameter.name")
    @Mapping(target = "value", source = "parameter.value")
    @Mapping(target = "containerId", source = "parameter.container.id")
    public abstract ParameterDto toDto(Parameter parameter);
}
