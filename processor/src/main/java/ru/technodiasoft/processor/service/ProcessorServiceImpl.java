package ru.technodiasoft.processor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.technodiasoft.processor.mapper.ProcessorMapper;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ContainerValue;
import ru.technodiasoft.processor.model.dto.ParameterDto;
import ru.technodiasoft.processor.repository.ContainerStorage;
import ru.technodiasoft.processor.repository.ParameterStorage;

import java.util.List;

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

        Container currentContainer = ProcessorMapper.INSTANCE.toContainer(containerValue);
        containerStorage.save(currentContainer);
        log.debug("Сохраняем в БД container: {}", currentContainer);

        saveParameters(containerValue.getParameters(), currentContainer);

        return ResponseEntity.ok("SAVE OK");
    }

    /**
     * Метод находит в БД Container по id и возвращает его.
     *
     * @param id containerId
     * @return Container #{@link Container}
     */
    @Override
    public Container getContainerById(Long id) {

        Container result = containerStorage.findById(id).orElseThrow(null);
        log.debug("Нашли в БД контейнер и возвращаем: {}", result);

        return result;
    }

    /**
     * Метод сохраняет в БД все пришедшие ParameterDto конвертируя их в Parameter.
     *
     * @param parameters #{@link ParameterDto}
     */
    private void saveParameters(List<ParameterDto> parameters, Container container) {

        List<Parameter> result = parameters.stream()
                .peek(parameterDto -> parameterDto.setContainerId(container.getId()))
                .map(parameterDto -> ProcessorMapper.INSTANCE.toParameter(parameterDto, this))
                .toList();

        parameterStorage.saveAll(result);
        log.debug("Сохраняем в БД все parameter: {}", result);
    }
}
