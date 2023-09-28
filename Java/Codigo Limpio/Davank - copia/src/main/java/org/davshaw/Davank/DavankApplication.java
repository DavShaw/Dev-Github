package org.davshaw.Davank;

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


		//AccountController.obtenerCuenta(1067592686);
        org.davshaw.controller.UserController
        .crearUsuario
        (1759275915,
        "Manolo",
        "Alfonso",
        "Martinez",
        "Goméz",
        "AsgjqngNOasdAO");

	}

}
