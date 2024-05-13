package com.openschool.producer.service;

import com.openschool.common.dto.HealthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final SampleKafkaProducer sampleKafkaProducer;

    private final HealthEndpoint healthEndpoint;
    private final MetricsEndpoint metricsEndpoint;

    public HealthDto sendMessage() {
        HealthDto healthDto = HealthDto.builder()
                .status(healthEndpoint.health().getStatus().toString())
                .uptime(metricsEndpoint.metric("process.uptime", null).getMeasurements().get(0).getValue())
                .build();

        sampleKafkaProducer.sendMessage(healthDto);

        return healthDto;
    }
}
