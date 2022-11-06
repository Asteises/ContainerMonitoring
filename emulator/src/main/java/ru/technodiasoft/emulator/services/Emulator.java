package ru.technodiasoft.emulator.services;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;
import ru.technodiasoft.emulator.dto.ContainerParameters;
import ru.technodiasoft.emulator.dto.config.ContainerConfig;
import ru.technodiasoft.emulator.job.SendDataJob;
import java.sql.Timestamp;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class Emulator {
    private final EmulationParametersCalculator calculator;
    private final SensorRequestManagerClient client;

    public void emulate(ContainerConfig config) throws SchedulerException {
        var emulationParameters = calculator.calculate(config);
        scheduleEmulationJob(emulationParameters, config);
    }

    private void scheduleEmulationJob(List<ContainerParameters> parameters, ContainerConfig config) throws SchedulerException {
        JobDataMap jobParameters = new JobDataMap();
        jobParameters.put("parameters", parameters);
        jobParameters.put("client", client);
        JobDetail job = JobBuilder.newJob(SendDataJob.class)
                .withIdentity("sendDataJob")
                .usingJobData(jobParameters)
                .build();
        var trigger =  TriggerBuilder
                .newTrigger()
                .withIdentity("sendDataTrigger")
                .startAt(Timestamp.valueOf(config.getDatetimeStartEmulation()))
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(config.getIntervalSendingMessages())
                        .repeatForever())
                //.endAt(Timestamp.valueOf(config.getDatetimeStartEmulation()))
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
}
