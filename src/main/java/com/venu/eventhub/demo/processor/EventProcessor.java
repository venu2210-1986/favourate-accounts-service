package com.venu.eventhub.demo.processor;

import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import com.microsoft.azure.eventhubs.EventData;
import com.microsoft.azure.eventprocessorhost.CloseReason;
import com.microsoft.azure.eventprocessorhost.IEventProcessor;
import com.microsoft.azure.eventprocessorhost.PartitionContext;
import com.venu.eventhub.demo.model.EventPayload;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@Service
public class EventProcessor implements IEventProcessor {

    private EventPayloadProcessor eventPayloadProcessor;

    @Override
    public void onOpen(PartitionContext partitionContext) {
        eventPayloadProcessor = new EventPayloadProcessor();
    }

    @Override
    public void onClose(PartitionContext partitionContext, CloseReason closeReason) {

    }

    @Override
    public void onEvents(PartitionContext partitionContext, Iterable<EventData> iterable) {
        for(EventData event: iterable) {
            try{
                EventPayload eventPayload = (EventPayload) SerializationUtils.deserialize(event.getBytes());
                eventPayloadProcessor.process(eventPayload);
                partitionContext.checkpoint(event);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void onError(PartitionContext partitionContext, Throwable throwable) {
    }
}