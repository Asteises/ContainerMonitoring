package ru.technodiasoft.processor.mapper;

import org.mapstruct.Mapper;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ParameterDto;

import java.util.List;

@Mapper
public interface ParametersMapper {

    List<Parameter> map(List<ParameterDto> parameterDtos);
}
