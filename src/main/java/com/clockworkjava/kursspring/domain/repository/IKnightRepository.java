package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

public interface IKnightRepository {
    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    @PostConstruct
    void build();

    Knight getKnightById(Integer id);

    void createKnight(Knight knight);

    default void updateKnight(int id, Knight knight) { throw new NotImplementedException();}

}
