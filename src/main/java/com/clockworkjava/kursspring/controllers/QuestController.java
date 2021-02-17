package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.services.KnightService;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    KnightService knightService;
    QuestService questService;
    PlayerInformation playerInformation;

    @Autowired
    void setKnightService(KnightService knightService) {
        this.knightService = knightService;
    }

    @Autowired
    void setQuestService(QuestService questService) {
        this.questService = questService;
    }

    @Autowired
    void setPlayerInformation(PlayerInformation playerInformation) {
        this.playerInformation = playerInformation;
    }

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);

        return "assignQuest";
    }

    @PostMapping("/assignQuest")
    public String assignQuest(Knight knight) {
        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.updateQuest(quest);
        return "redirect:/knights";
    }

    @GetMapping("/checkQuests")
    public String checkQuests() {

        knightService.collectMyGold();

        return "redirect:/knights";
    }

}
