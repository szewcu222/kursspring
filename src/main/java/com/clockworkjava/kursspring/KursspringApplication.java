package com.clockworkjava.kursspring;

import com.clockworkjava.component.TestComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@ComponentScans({
		@ComponentScan(basePackages = {"com.clockworkjava.kursspring", "com.clockworkjava.component"}),
		@ComponentScan(basePackageClasses = {TestComponent.class, Starter.class})
})
@EnableScheduling
public class KursspringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(KursspringApplication.class, args);
//		Castle castle = (Castle) ctx.getBean("castle");
//		System.out.println(castle);

	}
}
