package ru.technodiasoft.emulator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.technodiasoft.emulator.services.EmulationConfigConverter;
import ru.technodiasoft.emulator.services.EmulationParametersCalculator;
import ru.technodiasoft.emulator.services.Emulator;
import ru.technodiasoft.emulator.services.SensorRequestManagerClient;

@Configuration
public class ServiceConfig {

    /*
    @Bean
    public Emulator getEmulator(
            EmulationParametersCalculator calculator,
            SensorRequestManagerClient client
    ) {
        return new Emulator(calculator, client);
    }

    @Bean
    public EmulationConfigConverter getEmulationConfigConverter() {
        return new EmulationConfigConverter();
    }


    @Bean
    public SensorRequestManagerClient getSensorRequestManagerClient(RestTemplate restTemplate) {
        return new SensorRequestManagerClient(restTemplate);
    }

    @Bean
    public EmulationParametersCalculator getEmulationParametersCalculator() {
        return new EmulationParametersCalculator();
    }
        */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
