package ru.technodiasoft.processor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.technodiasoft.processor.mapper.ContainerMapper;
import ru.technodiasoft.processor.mapper.ParameterMapper;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ContainerValue;
import ru.technodiasoft.processor.model.dto.ParameterDto;
import ru.technodiasoft.processor.repository.ContainerStorage;
import ru.technodiasoft.processor.repository.ParameterStorage;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessorServiceImpl implements ProcessorService {

    private final ContainerStorage containerStorage;
    private final ParameterStorage parameterStorage;

    /**
     * Метод преобразует ContainerValue и сохраняет в БД Container.
     *
     * @param containerValue #{@link ContainerValue}
     * @return ResponseEntity
     */
    public ResponseEntity<String> saveContainer(ContainerValue containerValue) {

        Container currentContainer = ContainerMapper.INSTANCE.toContainer(containerValue);
        containerStorage.save(currentContainer);
        log.info("Сохраняем в БД container: {}", currentContainer);

        saveParameters(containerValue.getParameters(), currentContainer);

        return ResponseEntity.ok("SAVE OK");
    }

    @Override
    public Container getContainerById(Long id) {
        return containerStorage.findById(id).orElseThrow(null);
    }

    /**
     * Метод сохраняет в БД все пришедшие ParameterDto конвертируя их в Parameter.
     *
     * @param parameters #{@link ParameterDto}
     */
    private void saveParameters(List<ParameterDto> parameters, Container container) {

        List<Parameter> result = parameters.stream()
                .map(o -> ParameterMapper.INSTANCE.toParameter(o, container))
                .toList();

        parameterStorage.saveAll(result);
        log.info("Сохраняем в БД все parameter: {}", result);
    }
}
