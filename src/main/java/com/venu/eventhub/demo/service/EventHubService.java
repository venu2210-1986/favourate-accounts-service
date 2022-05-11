package com.venu.eventhub.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import com.microsoft.azure.eventhubs.EventData;
import com.microsoft.azure.eventhubs.EventHubClient;
import com.venu.eventhub.demo.model.EventPayload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EventHubService {
    private final EventHubClient eventHubClient;

    @Autowired
    public EventHubService(EventHubClient eventHubClient) {
        this.eventHubClient = eventHubClient;
    }

    public void sendEvent(EventPayload test) {

        byte[] bytes = SerializationUtils.serialize(test);

       // log.info("Sending message to the event hub {}", eventHubClient.getEventHubName());
        eventHubClient.send(EventData.create(Objects.requireNonNull(bytes)), test.toString());
    }
    
    
  
    
}
