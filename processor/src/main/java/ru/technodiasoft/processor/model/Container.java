package ru.technodiasoft.processor.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "container")
public class Container {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private LocalDateTime time;

    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    private List<Parameter> parameters;
}
