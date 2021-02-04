package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@PropertySource("classpath:knightRepository.properties")
public class QuestRepository {
    List<Quest> questList = new ArrayList<>();

    @Value("#{'${my.quest.quests}'.split(',')}")
    List<String> descriptions;
    Random rand = new Random();


    public void createQuest(String description) {
        questList.add(new Quest(description));
    }

    public void deleteQuest(Quest delQuest) {
        questList.remove(delQuest);
    }

    public List<Quest> getAll() {
        return questList;
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }

    @Scheduled(fixedDelayString = "${my.quest.creationDelay}")
    public void createRandomQuest() {
        String description = descriptions.get(rand.nextInt(descriptions.size()));
        System.out.println("Zadanie: " + description + questList.size());
        createQuest(description);
    }

}
