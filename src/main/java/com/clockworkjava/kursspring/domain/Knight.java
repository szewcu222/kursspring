package com.clockworkjava.kursspring.domain;


import com.sun.istack.internal.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
public class Knight {

    private int id;

    @NotNull
    @Length(min = 5, max = 40)
    private String name;

    @NotNull
    @Range(min = 18, max = 60, message = "Nie spelnia")
    private int age;

    private int level = 1;

    Quest quest;

    public Knight() {
        System.out.println("Knight default constructor");
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest) {
        if(Objects.nonNull(quest)) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "\nKnight by the name of " + name + "(" + age + "). His quest is: " + quest;
    }
}
