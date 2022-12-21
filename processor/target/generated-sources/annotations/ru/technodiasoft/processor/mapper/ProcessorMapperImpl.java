package ru.technodiasoft.processor.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ContainerValue;
import ru.technodiasoft.processor.model.dto.ParameterDto;
import ru.technodiasoft.processor.service.ProcessorService;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T15:00:53+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ProcessorMapperImpl extends ProcessorMapper {

    @Override
    public Container toContainer(ContainerValue containerValue) {
        if ( containerValue == null ) {
            return null;
        }

        Container.ContainerBuilder container = Container.builder();

        container.id( containerValue.getId() );

        container.time( LocalDateTime.now() );

        return container.build();
    }

    @Override
    public ContainerValue toDto(Container container) {
        if ( container == null ) {
            return null;
        }

        ContainerValue.ContainerValueBuilder containerValue = ContainerValue.builder();

        if ( container.getId() != null ) {
            containerValue.id( container.getId() );
        }
        containerValue.time( container.getTime() );
        containerValue.parameters( parameterListToParameterDtoList( container.getParameters() ) );

        return containerValue.build();
    }

    @Override
    public Parameter toParameter(ParameterDto parameterDto, ProcessorService processorService) {
        if ( parameterDto == null ) {
            return null;
        }

        Parameter.ParameterBuilder parameter = Parameter.builder();

        parameter.name( parameterDto.getName() );
        parameter.value( parameterDto.getValue() );

        parameter.container( processorService.getContainerById(parameterDto.getContainerId()) );

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

    protected List<ParameterDto> parameterListToParameterDtoList(List<Parameter> list) {
        if ( list == null ) {
            return null;
        }

        List<ParameterDto> list1 = new ArrayList<ParameterDto>( list.size() );
        for ( Parameter parameter : list ) {
            list1.add( toDto( parameter ) );
        }

        return list1;
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
