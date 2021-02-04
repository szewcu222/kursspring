package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KnightRepository implements IKnightRepository {

    Map<String, Knight> knights = new HashMap<>();


    public KnightRepository() {
        System.out.println("Castle default constructor");
    }


    @Override
    public void createKnight(String name, int age){
        knights.put(name, new Knight(name, age));
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Knight getKnight(String name) {
        return knights.get(name);
    }

    @Override
    public void deleteKnight(String name) {
        knights.remove(name);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }
}
