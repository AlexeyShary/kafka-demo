package com.openschool.consumer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "metrics_logs")
public class MetricsLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long id;

    @Column(name = "log_status")
    private String status;

    @Column(name = "log_uptime")
    private Double uptime;

    @Column(name = "log_timestamp")
    private LocalDateTime timestamp;
}