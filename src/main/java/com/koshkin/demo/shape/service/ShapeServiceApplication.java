package com.koshkin.demo.shape.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ShapeServiceApplication implements CommandLineRunner {

	public static final String DEMO_MODE = "demo";
	public static final String CUSTOM_MODE = "custom";

	public static void main(String[] args) {
		SpringApplication.run(ShapeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
