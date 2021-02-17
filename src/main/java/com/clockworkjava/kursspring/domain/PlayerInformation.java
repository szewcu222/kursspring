package com.clockworkjava.kursspring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Setter
@Getter
@Component()
//@SessionScope
public class PlayerInformation {

    private int gold = 0;

}
