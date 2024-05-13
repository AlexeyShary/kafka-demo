package com.openschool.producer.controller;

import com.openschool.common.dto.HealthDto;
import com.openschool.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/metrics")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public HealthDto sendMessage() {
        return producerService.sendMessage();
    }
}
