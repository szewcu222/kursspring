package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.IKnightRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KnightService {

    KnightRepository knightRepository;
    PlayerInformation playerInformation;

//    @Autowired
//    public KnightService(@Qualifier("KnightRepo") IKnightRepository knightRepository) {
//        this.knightRepository = knightRepository;
//    }

    @Autowired
    public KnightService(KnightRepository knightRepository) {
        this.knightRepository = knightRepository;
    }

    @Autowired
    public void setPlayerInformation(PlayerInformation playerInformation) {
        this.playerInformation = playerInformation;
    }

    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight.getName(), knight.getAge());
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectMyGold() {
        int sumGold = playerInformation.getGold() + this.collectRewards();
        playerInformation.setGold(sumGold);
        return sumGold;
    }

    private int collectRewards() {
        int sum = this.getAllKnights().stream()
                .filter(k -> Objects.nonNull(k.getQuest()))
                .filter(k -> k.getQuest().isCompleted())
                .mapToInt(k -> k.getQuest().getReward())
                .sum();

            this.getAllKnights().stream()
                .filter(k -> Objects.nonNull(k.getQuest()))
                .filter(k -> k.getQuest().isCompleted())
                .forEach(k -> k.setQuest(null));

        return sum;
    }



}
