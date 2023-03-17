package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// SpringBootApplication為一組合註解
// 包括 SpringBootConfiguration, 
// EnableAutoConfiguration,
// ComponentScan

// ! EnableAutoConfiguration
// 包括 AutoConfigurationPackage 和 Import(AutoConfigurationImportSelector.class)
// 
@SpringBootApplication
public class MvcTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcTestApplication.class, args);
	}

}
