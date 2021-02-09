package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;

import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements IKnightRepository{
    @Override
    public void createKnight(String name, int age) {
        System.out.println("DBRepository.createKnight");
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("DBRepository.getAllKnights");
        return null;
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        System.out.println("DBRepository.getKnight");
        return Optional.empty();
    }

    @Override
    public void deleteKnight(Integer id) {
        System.out.println("DBRepository.deleteKnight");
    }

    @Override
    public void build() {
        System.out.println("DBRepository.build");
    }

    @Override
    public Knight getKnightById(Integer id) {
        System.out.println("DBKnightRepository.getKnightById");
        return null;
    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("DBKnightRepository.createKnight");
    }
}
