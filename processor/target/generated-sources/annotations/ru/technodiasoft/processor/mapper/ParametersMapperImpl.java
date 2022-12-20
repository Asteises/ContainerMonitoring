package ru.technodiasoft.processor.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ParameterDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-20T18:34:50+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParametersMapperImpl implements ParametersMapper {

    @Override
    public List<Parameter> map(List<ParameterDto> parameterDtos) {
        if ( parameterDtos == null ) {
            return null;
        }

        List<Parameter> list = new ArrayList<Parameter>( parameterDtos.size() );
        for ( ParameterDto parameterDto : parameterDtos ) {
            list.add( parameterDtoToParameter( parameterDto ) );
        }

        return list;
    }

    protected Parameter parameterDtoToParameter(ParameterDto parameterDto) {
        if ( parameterDto == null ) {
            return null;
        }

        Parameter parameter = new Parameter();

        parameter.setName( parameterDto.getName() );
        parameter.setValue( parameterDto.getValue() );

        return parameter;
    }
}
