package com.mozzart.obuka;

import org.apache.ibatis.type.MappedTypes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import com.mozzart.obuka.domain.Match;
import com.mozzart.obuka.domain.GiveawayStage;
import com.mozzart.obuka.domain.Ticket;
@EnableJms
@MappedTypes({Ticket.class,Match.class,GiveawayStage.class})
@MapperScan ("com.mozzart.obuka.mapper")
@SpringBootApplication
public class ObukaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObukaApplication.class, args);
	}

}
