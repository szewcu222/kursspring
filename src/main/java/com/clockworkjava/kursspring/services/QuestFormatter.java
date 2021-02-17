package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class QuestFormatter implements Formatter<Quest> {

    QuestRepository questRepository;

    @Override
    public Quest parse(String idStr, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(idStr);
        return questRepository.getQuest(id);
    }

    @Override
    public String print(Quest quest, Locale locale) {
        return quest.toString();
    }

    @Autowired
    private void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }
}
