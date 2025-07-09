package com.stageb2m.ticketservice.models;

import lombok.Getter;

@Getter
public enum PriorityLevel {
    Low(1),
    Meduim(2),
    High(3),
    Critical(4),
    Blocker(5);

    private final int level;

    PriorityLevel(int level) {
        this.level = level;
    }

}
