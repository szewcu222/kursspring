package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.IKnightRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    IKnightRepository knightRepository;
    QuestRepository questRepository;

    final static Random rand = new Random();

    @Autowired
    public QuestService(@Qualifier("KnightRepo") IKnightRepository knightRepository, QuestRepository questRepository) {
        this.knightRepository = knightRepository;
        this.questRepository = questRepository;
    }

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).setQuest(randomQuest);
        questRepository.deleteQuest(randomQuest);

    }



}
