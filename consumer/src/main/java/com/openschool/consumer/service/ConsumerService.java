package com.openschool.consumer.service;

import com.openschool.common.dto.HealthDto;
import com.openschool.consumer.dto.MetricsLogDto;
import com.openschool.consumer.model.MetricsLog;
import com.openschool.consumer.repository.ConsumerRepository;
import com.openschool.consumer.util.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final ConsumerRepository consumerRepository;

    @Transactional(readOnly = true)
    public List<MetricsLogDto> getAll() {
        return consumerRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MetricsLogDto getById(long id) {
        return toDto(findById(id));
    }

    @Transactional
    public void saveMetricsLog(HealthDto healthDto) {
        MetricsLog entity = new MetricsLog();

        entity.setStatus(healthDto.getStatus());
        entity.setUptime(healthDto.getUptime());
        entity.setTimestamp(LocalDateTime.now());

        consumerRepository.save(entity);
    }

    private MetricsLog findById(long id) {
        return consumerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Metrics log with id=" + id + " was not found"));
    }

    private MetricsLogDto toDto(MetricsLog entity) {
        return MetricsLogDto.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .uptime(entity.getUptime())
                .timestamp(entity.getTimestamp())
                .build();
    }
}
