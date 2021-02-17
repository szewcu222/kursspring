package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.utils.Ids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
@PropertySource("classpath:knightRepository.properties")
public class QuestRepository {

    @Value("#{'${my.quest.quests}'.split(',')}")
    List<String> descriptions;
    Random rand = new Random();
    Map<Integer, Quest> quests = new HashMap<>();


    public void createQuest(String description) {
        int newId = Ids.generateNewId(quests.keySet());
        Quest newQuest = new Quest(newId, description);
        quests.put(newId, newQuest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }

    public List<Quest> getAllQuests() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest delQuest) {
        quests.remove(delQuest.getId());
    }

    public void updateQuest(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + quests.values() +
                '}';
    }

    @Scheduled(fixedDelayString = "${my.quest.creationDelay}")
    public void createRandomQuest() {
        String description = descriptions.get(rand.nextInt(descriptions.size()));
        System.out.println("Zadanie: " + description + quests.size());
        createQuest(description);
    }


}
