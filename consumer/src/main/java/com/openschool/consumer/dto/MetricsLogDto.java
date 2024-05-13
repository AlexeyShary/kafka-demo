package com.openschool.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetricsLogDto {
    private Long id;
    private String status;
    private Double uptime;
    private LocalDateTime timestamp;
}