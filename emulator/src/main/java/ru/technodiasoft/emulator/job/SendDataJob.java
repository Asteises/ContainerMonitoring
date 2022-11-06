package ru.technodiasoft.emulator.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import ru.technodiasoft.emulator.dto.ContainerParameters;
import ru.technodiasoft.emulator.services.SensorRequestManagerClient;
import java.util.List;

@SuppressWarnings("all")
public class SendDataJob implements Job {
    public void execute(JobExecutionContext context){
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        List<ContainerParameters> parameters = (List<ContainerParameters>) dataMap.get("parameters");
        SensorRequestManagerClient client = (SensorRequestManagerClient) dataMap.get("client");
        client.sendData(parameters);
    }
}
