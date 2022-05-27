package com.mendonca.mendoncaMedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mendonca.controller.MusicControler;
import com.mendonca.controller.PageControler;
import com.mendonca.model.Music;
import com.mendonca.repository.MidiaRepository;
import com.mendonca.service.MidiaServiceImpl;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = {MidiaRepository.class})
@EntityScan(basePackageClasses =  {Music.class})
@ComponentScan( basePackageClasses = { PageControler.class,MusicControler.class,MidiaServiceImpl.class})
public class MendoncaMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MendoncaMediaApplication.class, args);
	}

}
