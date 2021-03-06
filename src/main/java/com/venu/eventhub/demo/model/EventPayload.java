package com.venu.eventhub.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventPayload implements Serializable {

    private static final long serialVersionUID = -6419160374031553535L;

    private String firstName;
    private String lastName;
    private String email;
    private String favoriteFood;
}
