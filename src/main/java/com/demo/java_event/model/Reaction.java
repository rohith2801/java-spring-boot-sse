package com.demo.java_event.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Reaction implements Serializable {
    private Long id;
    private String eventId;
    private String emoji;
    private String userId;
    private LocalDateTime ts;
}
