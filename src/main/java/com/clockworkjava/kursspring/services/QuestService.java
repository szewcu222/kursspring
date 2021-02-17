package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    KnightRepository knightRepository;
    QuestRepository questRepository;

    final static Random rand = new Random();

    @Autowired
    public QuestService(KnightRepository knightRepository, QuestRepository questRepository) {
        this.knightRepository = knightRepository;
        this.questRepository = questRepository;
    }

    public List<Quest> getAllNotStartedQuests() {
        return questRepository.getAllQuests().stream()
                .filter(q -> !q.isStarted())
                .collect(Collectors.toList());
    }

    public void updateQuest(Quest quest) {
        questRepository.updateQuest(quest);
    }

    public boolean isQuestCompleted(Quest quest) {
        return quest.isCompleted();
    }

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = questRepository.getAllQuests();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        randomQuest.setStarted(true);
        knightRepository.getKnight(knightName).ifPresent(k -> k.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }
}
