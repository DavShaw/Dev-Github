package org.davshaw.Davank;

import org.davshaw.Controller.AccountController;
import org.davshaw.Controller.TeamController;
import org.davshaw.Controller.TeamDepositController;
import org.davshaw.Controller.TeamLoanController;
import org.davshaw.External.Color;
import org.davshaw.External.RequestResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DavankApplication
{
	
	public static void main(String[] args)
	{
		SpringApplication.run(DavankApplication.class, args);
		System.out.println(Color.color("RED","El servidor local del proyecto Spring Boot está encendido. Todo lo que veas depués de este mensaje son los request"));



		RequestResult<Boolean> result = TeamLoanController.deleteLoan(2);

		System.out.println("--------------------------------");
		System.out.println("Executed successfully -> " + result.getOkay().toString());
		System.out.println("Result type -> " + result.getResult());
		System.out.println("Message -> " + result.getMessage());


	}
}