package org.davshaw.Davank;

import org.davshaw.External.Color;
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



		//org.davshaw.Controller.UserController.createUser(106,"Juan", "David", "Carrillo", "Torres", "ASD");
		//org.davshaw.Controller.UserController.createUser(759, "Santiago", "", "Carrillo", "Torres", "DSA");
		System.out.println(org.davshaw.Controller.AccountTransferController.getTransfer(1));


	}
}