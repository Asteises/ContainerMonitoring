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

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-20T19:31:03+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ContainerMapperImpl extends ContainerMapper {

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

    protected ParameterDto parameterToParameterDto(Parameter parameter) {
        if ( parameter == null ) {
            return null;
        }

        ParameterDto.ParameterDtoBuilder parameterDto = ParameterDto.builder();

        parameterDto.name( parameter.getName() );
        parameterDto.value( parameter.getValue() );

        return parameterDto.build();
    }

    protected List<ParameterDto> parameterListToParameterDtoList(List<Parameter> list) {
        if ( list == null ) {
            return null;
        }

        List<ParameterDto> list1 = new ArrayList<ParameterDto>( list.size() );
        for ( Parameter parameter : list ) {
            list1.add( parameterToParameterDto( parameter ) );
        }

        return list1;
    }
}
