package com.revature.fixedfileparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
		"com.revature.fixedfileparser.controller",
		"com.revature.fixedfileparser.service",
		"com.revature.fixedfileparser.repository"},
		exclude = {DataSourceAutoConfiguration.class}
)
public class FixedFileParserApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FixedFileParserApplication.class, args);
	}

}
