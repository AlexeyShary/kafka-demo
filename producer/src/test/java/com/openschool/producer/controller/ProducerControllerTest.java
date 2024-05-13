package com.openschool.producer.controller;

import com.openschool.common.dto.HealthDto;
import com.openschool.producer.service.ProducerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProducerController.class)
@DisplayName("Producer Controller tests")
class ProducerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProducerService producerService;

    @Test
    @DisplayName("Send message endpoint")
    void sendMessageTest() throws Exception {
        HealthDto healthDto = generateHealthDto();

        when(producerService.sendMessage()).thenReturn(healthDto);

        mockMvc.perform(post("/metrics"))
                .andExpect(status().isOk());

        verify(producerService, times(1)).sendMessage();
        verifyNoMoreInteractions(producerService);
    }

    private HealthDto generateHealthDto() {
        return HealthDto.builder()
                .status("UP")
                .uptime(100.0)
                .build();
    }
}