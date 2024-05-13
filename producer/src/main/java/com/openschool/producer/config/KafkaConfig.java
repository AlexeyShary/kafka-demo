package com.openschool.producer.config;

import com.openschool.common.util.TopicUtil;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic metricsTopic() {
        return new NewTopic(TopicUtil.METRICS_TOPIC, 1, (short) 1);
    }

    @Bean
    public NewTopic metricsTopicDlt() {
        return new NewTopic(TopicUtil.METRICS_TOPIC_DLT, 1, (short) 1);
    }
}
