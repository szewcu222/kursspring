package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTest {

    @Mock
    QuestRepository questRepositoryMock;

    @Mock
    KnightRepository knightRepositoryMock;


    @Test
    public void returnsNotStartedQuests() {

        List<Quest> quests = new ArrayList<>();
        Quest q1 = new Quest(1,"Test q 1");
        Quest q2 = new Quest(2,"Test q 2");
        Quest q3 = new Quest(3,"Test q 3");

        q2.setStarted(true);

        quests.add(q1);
        quests.add(q2);
        quests.add(q3);

        when(questRepositoryMock.getAllQuests()).thenReturn(quests);

        QuestService qs = new QuestService(new KnightRepository(), questRepositoryMock);

        List<Quest> allNotStartedQuests = qs.getAllNotStartedQuests();

        assertEquals("Size of returned quests", 2, allNotStartedQuests.size());
        assertThat(allNotStartedQuests, containsInAnyOrder(q1,q3));
    }

    @Test
    public void checkIfGathersGold() {
        Quest quest = new Quest(0, "Testing");
        Knight a = new Knight("Percival - TEST", 33);
        Knight b = new Knight("Percival2 - TEST", 34);

        a.setQuest(quest);
        quest.setStarted(true);
        quest.setDurationInSeconds(-1);

        List<Knight> knights = new ArrayList<>(2);
        knights.add(a);
        knights.add(b);

        KnightService knightService = new KnightService(knightRepositoryMock);

        PlayerInformation playerInformation = new PlayerInformation();
        playerInformation.setGold(100);
        knightService.setPlayerInformation(playerInformation);

        int expectedGold = playerInformation.getGold() + quest.getReward();

        when(knightService.getAllKnights()).thenReturn(knights);

        int collectedGold = knightService.collectMyGold();

        assertEquals(expectedGold, collectedGold);

    }

}
