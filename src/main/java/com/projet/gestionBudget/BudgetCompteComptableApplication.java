package com.projet.gestionBudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.projet.gestionBudget.model.ws.required.facade")
public class BudgetCompteComptableApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetCompteComptableApplication.class, args);
	}

}
