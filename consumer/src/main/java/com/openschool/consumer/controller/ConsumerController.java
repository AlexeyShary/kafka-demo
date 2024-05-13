package com.openschool.consumer.controller;

import com.openschool.consumer.dto.MetricsLogDto;
import com.openschool.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/metrics")
@RequiredArgsConstructor
public class ConsumerController {
    private final ConsumerService consumerService;

    @GetMapping()
    public List<MetricsLogDto> getAll() {
        return consumerService.getAll();
    }

    @GetMapping("/{id}")
    public MetricsLogDto getById(@PathVariable long id) {
        return consumerService.getById(id);
    }
}
