package com.venu.eventhub.demo.configuration;

import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsoft.azure.eventprocessorhost.EventProcessorHost;
import com.microsoft.azure.eventprocessorhost.EventProcessorOptions;
import com.venu.eventhub.demo.exception.ErrorNotificationHandler;
import com.venu.eventhub.demo.processor.EventProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventProcessorHostService {

    private final EventProcessorHost eventProcessorHost;

    @Autowired
    public EventProcessorHostService(EventProcessorHost eventProcessorHost) {
        this.eventProcessorHost = eventProcessorHost;
    }

    @PostConstruct
    public void run() throws ExecutionException, InterruptedException {
        EventProcessorOptions options = new EventProcessorOptions();
        options.setExceptionNotification(new ErrorNotificationHandler());
        eventProcessorHost.registerEventProcessor(EventProcessor.class, options).get();
    }
}