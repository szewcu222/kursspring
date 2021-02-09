package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @GetMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> knights = new ArrayList<>(knightService.getAllKnights());
        model.addAttribute("knights", knights);
        model.addAttribute("hello", "Hello world");
        return "knights";
//        return new ResponseEntity<>(knights.toString(), HttpStatus.OK);
    }

    @GetMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        return "knight-details";
    }

//    @RequestMapping("createKnight")
    @GetMapping("newKnight")
    public String newKnight(Model model) {
        model.addAttribute("knight", new Knight());
        return "knight-form";
    }

    @PostMapping("knights")
    public String saveKnight(Knight knight) {
        knightService.saveKnight(knight);
        return "redirect:/knights";
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights";

    }
}
