package ru.technodiasoft.processor.mapper;

import java.time.LocalDateTime;
import java.util.Collections;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ParameterDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-20T19:12:41+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ParameterMapperImpl extends ParameterMapper {

    @Override
    public Parameter toParameter(ParameterDto parameterDto, Container container) {
        if ( parameterDto == null ) {
            return null;
        }

        Parameter.ParameterBuilder parameter = Parameter.builder();

        parameter.name( parameterDto.getName() );
        parameter.value( parameterDto.getValue() );
        parameter.container( parameterDtoToContainer( parameterDto, container ) );

        return parameter.build();
    }

    @Override
    public ParameterDto toDto(Parameter parameter) {
        if ( parameter == null ) {
            return null;
        }

        ParameterDto.ParameterDtoBuilder parameterDto = ParameterDto.builder();

        parameterDto.name( parameter.getName() );
        parameterDto.value( parameter.getValue() );
        Long id = parameterContainerId( parameter );
        if ( id != null ) {
            parameterDto.containerId( id );
        }

        return parameterDto.build();
    }

    protected Container parameterDtoToContainer(ParameterDto parameterDto, Container container) {
        if ( parameterDto == null ) {
            return null;
        }

        Container.ContainerBuilder container1 = Container.builder();

        container1.id( container.getId() );

        return container1.build();
    }

    private Long parameterContainerId(Parameter parameter) {
        if ( parameter == null ) {
            return null;
        }
        Container container = parameter.getContainer();
        if ( container == null ) {
            return null;
        }
        Long id = container.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
