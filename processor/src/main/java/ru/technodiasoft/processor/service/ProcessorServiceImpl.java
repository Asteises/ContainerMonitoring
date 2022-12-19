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

import java.lang.reflect.InvocationTargetException;
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
        try {
            Container currentContainer = ContainerMapper.INSTANCE.toContainer(containerValue, this);
            containerStorage.save(currentContainer);
            log.info("Сохраняем в БД container: {}", currentContainer);
        } catch (RuntimeException e) {
            log.debug("oops!", e.getCause());
        }

        saveParameters(containerValue.getParameters());

        return ResponseEntity.ok("SAVE OK");
    }

    @Override
    public Container getContainerById(UUID id) {
        return containerStorage.findById(id).orElseThrow(null);
    }

    /**
     * Метод сохраняет в БД все пришедшие ParameterDto конвертируя их в Parameter.
     *
     * @param parameters #{@link ParameterDto}
     */
    private void saveParameters(List<ParameterDto> parameters) {

        List<Parameter> result = parameters.stream()
                .map(parameterDto -> ParameterMapper.INSTANCE.toParameter(parameterDto, this))
                .toList();

        parameterStorage.saveAll(result);
        log.info("Сохраняем в БД все parameter: {}", result);
    }
}
