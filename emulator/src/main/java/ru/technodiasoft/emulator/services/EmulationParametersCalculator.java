package ru.technodiasoft.emulator.services;

import org.springframework.stereotype.Service;
import ru.technodiasoft.emulator.dto.Container;
import ru.technodiasoft.emulator.dto.ContainerParameters;
import ru.technodiasoft.emulator.dto.Parameter;
import ru.technodiasoft.emulator.dto.config.ContainerConfig;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmulationParametersCalculator {

    public List<ContainerParameters> calculate(ContainerConfig config) {
        List<LocalDateTime> listTime = getSensorTimeValues(config);
        return IntStream.range(0, config.getContainersCount())
                .mapToObj(container -> new ContainerParameters(getContainers(listTime, config)))
                .collect(Collectors.toList());
    }

    private List<Container> getContainers(List<LocalDateTime> listTime, ContainerConfig config) {
        return listTime.stream()
                .map(dateTime -> new Container((long) (Math.random()*10000), dateTime, getContainerParameters(config)))
                .collect(Collectors.toList());
    }

    private List<LocalDateTime> getSensorTimeValues(ContainerConfig config) {
        BigDecimal datetimeStartEmulation = BigDecimal.valueOf(config.getDatetimeStartEmulation()
                .toEpochSecond(ZoneOffset.UTC));

        return IntStream.range(0, config.getContainersCount())
                .mapToObj(count -> {
                    BigDecimal currentSamplingStep = BigDecimal.valueOf(count).multiply(config.getSamplingStep());
                    BigDecimal randomTimeShift = getRandomNumberInRange(BigDecimal.ZERO, config.getMaxTimeShift());
                    BigDecimal result = currentSamplingStep.add(randomTimeShift).add(datetimeStartEmulation);

                    return LocalDateTime.from(Instant.ofEpochSecond(result.longValue()).atOffset(ZoneOffset.UTC));
                }).collect(Collectors.toList());
    }

    private List<Parameter> getContainerParameters(ContainerConfig config) {
        return config.getParameters()
                .stream()
                .map(param -> new Parameter(
                        param.getName(),
                        param.getAverage().add(getRandomNumberInRange(param.getMaxScatter().negate(), param.getMaxScatter()))))
                .collect(Collectors.toList());
    }

    private static BigDecimal getRandomNumberInRange(BigDecimal from, BigDecimal to) {
        BigDecimal result = from.add(BigDecimal.valueOf(Math.random()).multiply(to.subtract(from)));
        return result.setScale(0, RoundingMode.HALF_UP);
    }
}
