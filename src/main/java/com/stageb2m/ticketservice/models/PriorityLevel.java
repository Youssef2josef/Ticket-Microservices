package com.stageb2m.ticketservice.models;

public enum PriorityLevel {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    CRITICAL(4),
    BLOCKER(5);

    private final int level;

    PriorityLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
