package com.clockworkjava.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted() {
        Knight knight = new Knight("Lancelot", 29);
        Quest quest = new Quest(1,"Kill the dragoon");

        knight.setQuest(quest);

        assertTrue(quest.isStarted());
    }

}
