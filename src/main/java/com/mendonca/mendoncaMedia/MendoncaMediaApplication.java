package com.mendonca.mendoncaMedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mendonca.config.SecurityConfiguration;
import com.mendonca.controller.MusicControler;
import com.mendonca.controller.PageControler;
import com.mendonca.model.Music;
import com.mendonca.model.User;
import com.mendonca.repository.MidiaRepository;
import com.mendonca.repository.UserRepository;
import com.mendonca.service.MidiaServiceImpl;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = {MidiaRepository.class,UserRepository.class})
@EntityScan(basePackageClasses =  {Music.class,User.class})
@ComponentScan( basePackageClasses = { PageControler.class,MusicControler.class,MidiaServiceImpl.class,SecurityConfiguration.class,UserDetailsService.class})
public class MendoncaMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MendoncaMediaApplication.class, args);
	}

}
