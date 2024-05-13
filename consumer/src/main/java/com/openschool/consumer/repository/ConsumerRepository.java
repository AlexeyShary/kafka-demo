package com.openschool.consumer.repository;

import com.openschool.consumer.model.MetricsLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<MetricsLog, Long> {
}
