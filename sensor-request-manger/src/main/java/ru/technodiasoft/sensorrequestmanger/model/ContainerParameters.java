package ru.technodiasoft.sensorrequestmanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContainerParameters {
    List<Container> containersParam;
}
