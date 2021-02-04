package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.repository.IKnightRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    IKnightRepository knightRepository;
    QuestRepository questRepository;
    QuestService questService;

    @Autowired
    public Starter(@Qualifier("KnightRepo") IKnightRepository knightRepository, QuestRepository questRepository, QuestService questService) {
        this.knightRepository = knightRepository;
        this.questRepository = questRepository;
        this.questService = questService;
    }

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("run");
        System.out.println(knightRepository);
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        questService.assignRandomQuest("Lancelot");
        questService.assignRandomQuest("Percival");

        System.out.println(knightRepository);
        System.out.println("Starter.run");

    }

}
