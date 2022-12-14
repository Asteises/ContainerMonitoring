package ru.technodiasoft.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.technodiasoft.processor.model.Parameter;

import java.util.UUID;

@Repository
public interface ParameterStorage extends JpaRepository<Parameter, UUID> {
}
