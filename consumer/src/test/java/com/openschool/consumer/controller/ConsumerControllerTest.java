package com.openschool.consumer.controller;

import com.openschool.consumer.dto.MetricsLogDto;
import com.openschool.consumer.service.ConsumerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ConsumerController.class)
@DisplayName("Consumer Controller tests")
class ConsumerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsumerService consumerService;

    @Test
    @DisplayName("Get all endpoint")
    void getAllTest() throws Exception {
        List<MetricsLogDto> metricsLogDtoList = Arrays.asList(
                generateMetricsLogDto(1),
                generateMetricsLogDto(2)
        );

        when(consumerService.getAll()).thenReturn(metricsLogDtoList);

        mockMvc.perform(get("/metrics"))
                .andExpect(status().isOk());

        verify(consumerService, times(1)).getAll();
        verifyNoMoreInteractions(consumerService);
    }

    @Test
    @DisplayName("Get by id endpoint")
    void getByIdTest() throws Exception {
        MetricsLogDto metricsLogDto = generateMetricsLogDto(1);

        when(consumerService.getById(eq(metricsLogDto.getId()))).thenReturn(metricsLogDto);

        mockMvc.perform(get("/metrics/" + metricsLogDto.getId()))
                .andExpect(status().isOk());

        verify(consumerService, times(1)).getById(eq(metricsLogDto.getId()));
        verifyNoMoreInteractions(consumerService);
    }

    private MetricsLogDto generateMetricsLogDto(long id) {
        return MetricsLogDto.builder()
                .id(id)
                .status("UP")
                .uptime(100.0 + id)
                .timestamp(LocalDateTime.now())
                .build();
    }
}