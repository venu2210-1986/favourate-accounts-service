package com.venu.eventhub.demo.processor;

import org.springframework.stereotype.Service;

import com.venu.eventhub.demo.model.EventPayload;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@Service
class EventPayloadProcessor {

    void process(EventPayload eventPayload) {
       // log.info("Hello! My name is {} and my favorite food is {}", eventPayload.getFirstName(), eventPayload.getFavoriteFood());
    }
}
