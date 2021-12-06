package com.xyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class XyzMovieBrowserApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyzMovieBrowserApplication.class, args);
	}

}
