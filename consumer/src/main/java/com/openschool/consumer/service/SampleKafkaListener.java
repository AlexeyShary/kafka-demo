package com.openschool.consumer.service;

import com.openschool.common.dto.HealthDto;
import com.openschool.common.util.TopicUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleKafkaListener {
    private final ConsumerService consumerService;

    @KafkaListener(groupId = "healthGroup", topics = TopicUtil.METRICS_TOPIC)
    public void listenHealth(HealthDto healthDto) {
        log.info("Got kafka message: {}", healthDto);
        consumerService.saveMetricsLog(healthDto);
    }
}
