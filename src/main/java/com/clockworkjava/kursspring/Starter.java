package com.clockworkjava.kursspring;

import com.clockworkjava.component.TimeComponent;
import com.clockworkjava.kursspring.domain.repository.IKnightRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Starter implements CommandLineRunner {

    KnightRepository knightRepository;
    QuestRepository questRepository;
    QuestService questService;

    @Autowired
    public Starter(KnightRepository knightRepository, QuestRepository questRepository, QuestService questService) {
        this.knightRepository = knightRepository;
        this.questRepository = questRepository;
        this.questService = questService;
    }

    @Autowired
    TimeComponent timeComponent;

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("run");
        System.out.println(knightRepository);
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        questService.assignRandomQuest("Percival");
//        questService.assignRandomQuest("Lancelot");

        System.out.println(knightRepository);

//        LocalDateTime time = timeComponent.getTime();

        System.out.println("Starter.run");

    }

}
