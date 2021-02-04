package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;

import java.util.Collection;

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
    public Knight getKnight(String name) {
        System.out.println("DBRepository.getKnight");
        return null;
    }

    @Override
    public void deleteKnight(String name) {
        System.out.println("DBRepository.deleteKnight");
    }

    @Override
    public void build() {
        System.out.println("DBRepository.build");
    }
}
