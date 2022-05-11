package com.venu.eventhub.demo.configuration;

import java.io.IOException;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.azure.eventhubs.EventHubClient;
import com.microsoft.azure.eventhubs.EventHubException;
import com.microsoft.azure.eventprocessorhost.EventProcessorHost;

@Configuration
public class EventHubConfig {

    @Value("${eventHub.connectionString}")
    private String connectionString;

    @Value("${eventHub.name}")
    private String eventHubName;

    @Bean
    public EventHubClient setupEventHubConnection() throws IOException, EventHubException {
        return EventHubClient.createFromConnectionStringSync(connectionString, Executors.newScheduledThreadPool(5));
    }
    
    @Value("${eventHub.storage.consumerGroupName}")
    private String consumerGroupName;

    @Value("${eventHub.storage.hostNamePrefix}")
    private String hostNamePrefix;

    @Value("${eventHub.storage.storageConnectionString}")
    private String storageConnectionString;

    @Value("${eventHub.storage.storageContainerName}")
    private String storageContainerName;
    
    @Bean
    public EventProcessorHost createEventHubProcessorHost() {
        return EventProcessorHost.EventProcessorHostBuilder
                .newBuilder(EventProcessorHost.createHostName(hostNamePrefix), consumerGroupName)
                .useAzureStorageCheckpointLeaseManager(storageConnectionString, storageContainerName,null)
                .useEventHubConnectionString(connectionString, eventHubName)
                .build();
    }

}
