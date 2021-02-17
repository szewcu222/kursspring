package com.clockworkjava.kursspring.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Quest {

    private int id;
    private String description;
    private int reward = 100;
    private int durationInSeconds = 10;
    private boolean started = false;
    private boolean completed = false;
    private LocalDateTime startDate;

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setStarted(boolean started) {
        if(started){
            this.startDate = LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {
        if(this.completed) {
            return true;
        } else {
            LocalDateTime now = LocalDateTime.now();

            LocalDateTime questEndTime = this.startDate.plusSeconds(this.durationInSeconds);
            boolean isAfter = now.isAfter(questEndTime);
            this.completed = isAfter;

            return isAfter;
        }
    }

    @Override
    public String toString() {
        return description; }
}
