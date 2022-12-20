package ru.technodiasoft.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.technodiasoft.processor.model.Container;

import java.util.UUID;

@Repository
public interface ContainerStorage extends JpaRepository<Container, Long> {
}
