package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class KnightRepository implements IKnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();


    public KnightRepository() {
        System.out.println("Castle default constructor");
    }


    @Override
    public void createKnight(String name, int age) {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(getNewId());
        knights.put(newKnight.getId(), newKnight);
    }

    public void createKnight(Knight knight){
        knights.put(knight.getId(), knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        return knights.values().stream().filter(k -> name.equals(k.getName())).findAny();
    }

    @Override
    public void deleteKnight(Integer id) {
        knights.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    public int getNewId() {
        if(knights.isEmpty()){
            return 0;
        }
        else {
            //return knights.keySet().size()-1;
            return knights.keySet().stream().max(Comparator.naturalOrder()).get()+1;
        }
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }
}
