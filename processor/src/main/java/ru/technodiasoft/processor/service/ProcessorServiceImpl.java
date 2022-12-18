package ru.technodiasoft.processor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.technodiasoft.processor.mapper.ContainerMapper;
import ru.technodiasoft.processor.model.Container;
import ru.technodiasoft.processor.model.Parameter;
import ru.technodiasoft.processor.model.dto.ContainerDto;
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
     * Метод преобразует ContainerDto и сохраняет в БД Container.
     *
     * @param containerDto #{@link ContainerDto}
     * @return ResponseEntity
     */
    public ResponseEntity<String> saveContainer(ContainerDto containerDto) {

        Container currentContainer = ContainerMapper.INSTANCE.toContainer(containerDto, this);
        containerStorage.save(currentContainer);
        log.info("Сохраняем в БД container: {}", currentContainer);

        saveParameters(containerDto.getParameters());

        return ResponseEntity.ok("SAVE OK");
    }

    @Override
    public Container getContainerById(UUID id) {
        return containerStorage.findById(id).orElseThrow(null);
    }

    /**
     * Метод сохраняет в БД все пришедшие Parameter.
     *
     * @param parameters #{@link Parameter}
     */
    private void saveParameters(List<ParameterDto> parameters) {

//        parameterStorage.saveAll(parameters);
        log.info("Сохраняем в БД все parameter: {}", parameters);
    }
}
