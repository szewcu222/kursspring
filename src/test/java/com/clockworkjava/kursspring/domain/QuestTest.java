package com.clockworkjava.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestTest {

    @Test
    public void settingStartedFlagToFalseShouldSetStartDate() {
        Quest quest = new Quest(1, "New quest");

        quest.setStarted(true);

        assertNotNull(quest.getStartDate());
    }

    @Test
    public void questShouldBeCompleted() {
        Quest quest = new Quest(1, "New quest");
        quest.setStarted(true);
        quest.setDurationInSeconds(-60);
        assertTrue(quest.isCompleted());
    }

    @Test
    public void questShouldNotBeCompleted() {
        Quest quest = new Quest(1, "New quest");
        quest.setStarted(true);
        quest.setDurationInSeconds(60);
        assertFalse(quest.isCompleted());

    }
}
