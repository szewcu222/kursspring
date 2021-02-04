package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.repository.DBKnightRepository;
import com.clockworkjava.kursspring.domain.repository.IKnightRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {

    @Bean("KnightRepo")
    @Profile("dev")
    public IKnightRepository createKnightRepository() {
        return new KnightRepository();
    }

//    @Bean("DBKnightRepo")
//    @Profile("prod")
//    public IKnightRepository createDBKnightRepository() {
//        return new DBKnightRepository();
//    }


}
