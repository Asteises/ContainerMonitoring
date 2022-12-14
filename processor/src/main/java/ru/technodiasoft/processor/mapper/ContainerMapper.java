package ru.technodiasoft.processor.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ContainerDto;
import ru.technodiasoft.processor.service.ProcessorServiceImpl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

//TODO Почему для  импортируется другой класс?

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class, LocalDateTime.class, Collections.class},
        uses = {Parameter.class})
public abstract class ContainerMapper {

    public static final ContainerMapper INSTANCE = Mappers.getMapper(ContainerMapper.class);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "time", expression = "java(LocalDateTime.now())")
    public abstract Container toContainer(ContainerDto containerDto,
                                          @Context ProcessorServiceImpl processorService);

    @InheritInverseConfiguration
    @Mapping(target = "time", source = "container.time")
    public abstract ContainerDto toDto(Container container);
}


