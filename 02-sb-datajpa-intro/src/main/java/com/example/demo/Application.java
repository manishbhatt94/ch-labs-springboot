package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.app.MySpringDataJpaDemo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final MySpringDataJpaDemo demo;

	public Application(MySpringDataJpaDemo demo) {
		this.demo = demo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		demo.doCrudRepositoryDemo();
		demo.doJpaRepositoryDemo();
	}

}
