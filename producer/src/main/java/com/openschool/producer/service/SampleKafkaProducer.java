package com.openschool.producer.service;

import com.openschool.common.dto.HealthDto;
import com.openschool.common.util.TopicUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleKafkaProducer {
    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendMessage(HealthDto healthDto) {
        log.info("Send kafka message: {}", healthDto);
        kafkaTemplate.send(TopicUtil.METRICS_TOPIC, healthDto);
    }
}
