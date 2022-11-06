package ru.technodiasoft.sensorrequestmanger;

//TODO Подготовить модуль Processor с DTO и подключением к базе, миграциями...

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SensorRequestMangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensorRequestMangerApplication.class, args);
    }

}
