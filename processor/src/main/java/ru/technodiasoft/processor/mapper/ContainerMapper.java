package ru.technodiasoft.processor.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.dto.ContainerValue;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {Long.class, LocalDateTime.class}
)
public abstract class ContainerMapper {

    public static final ContainerMapper INSTANCE = Mappers.getMapper(ContainerMapper.class);

    @Mapping(target = "time", expression = "java(LocalDateTime.now())")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "parameters", ignore = true)
    public abstract Container toContainer(ContainerValue containerValue);

    @InheritInverseConfiguration
    public abstract ContainerValue toDto(Container container);
}


