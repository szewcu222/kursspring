package com.clockworkjava.kursspring.domain;


public class Knight {

    private int id;
    private String name = "Lancelot";
    private int age = 29;
    private int level;

    Quest quest;

    public Knight() {
        System.out.println("Knight default constructor");
    }


    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest) {
        System.out.println("Knight.setQuest(Quest quest " + quest + ")");
        this.quest = quest;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "\nKnight by the name of " + name + "(" + age + "). His quest is: " + quest;
    }
}
