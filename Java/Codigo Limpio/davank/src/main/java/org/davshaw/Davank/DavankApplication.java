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
        org.davshaw.controller.CuentaControlador.eliminarCuenta(1067592686);
	}
}
