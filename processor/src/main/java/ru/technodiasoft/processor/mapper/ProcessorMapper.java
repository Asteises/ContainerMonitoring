package ru.technodiasoft.processor.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ContainerValue;
import ru.technodiasoft.processor.model.dto.ParameterDto;
import ru.technodiasoft.processor.service.ProcessorService;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {Long.class, LocalDateTime.class}
)
public abstract class ProcessorMapper {

    public static final ProcessorMapper INSTANCE = Mappers.getMapper(ProcessorMapper.class);

    @Autowired
    protected ProcessorService processorService;

    @Mapping(target = "time", expression = "java(LocalDateTime.now())")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "parameters", ignore = true)
    public abstract Container toContainer(ContainerValue containerValue);

    @InheritInverseConfiguration
    public abstract ContainerValue toDto(Container container);

    @Mapping(target = "name", source = "parameterDto.name")
    @Mapping(target = "value", source = "parameterDto.value")
//    @Mapping(target = "container.id", expression = "java(container.getId())") тоже работает
    @Mapping(target = "container", expression = "java(processorService.getContainerById(parameterDto.getContainerId()))")
    public abstract Parameter toParameter(ParameterDto parameterDto, @Context ProcessorService processorService);


    @InheritInverseConfiguration
    @Mapping(target = "name", source = "name")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "containerId", source = "parameter.container.id")
    public abstract ParameterDto toDto(Parameter parameter);
}


