package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.component.TimeComponent;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    TimeComponent timeComponent;
    PlayerInformation playerInformation;
    KnightService knightService;

    @Autowired
    public void setTimeComponent(TimeComponent timeComponent) {
        this.timeComponent = timeComponent;
    }

    @Autowired
    public void setPlayerInformation(PlayerInformation playerInformation) {
        this.playerInformation = playerInformation;
    }

    @Autowired
    public void setKnightService(KnightService knightService) {
        this.knightService = knightService;
    }

    @GetMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> knights = new ArrayList<>(knightService.getAllKnights());
        model.addAttribute("knights", knights);
        model.addAttribute("hello", "Hello world");
        model.addAttribute("timeComponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @GetMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timeComponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knight-details";
    }

    @GetMapping("newKnight")
    public String newKnight(Model model) {
        Knight knight = new Knight();
        model.addAttribute("knight", knight);
        model.addAttribute("timeComponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knight-form";
    }

    @PostMapping("knights")
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> System.out.println(e.getObjectName() + " " + e.getDefaultMessage()));
            return "knight-form";
        } else {
            knightService.saveKnight(knight);
            return "redirect:/knights";
        }

    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights";

    }
}
