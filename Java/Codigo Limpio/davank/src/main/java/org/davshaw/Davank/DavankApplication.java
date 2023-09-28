package org.davshaw.Davank;

import org.davshaw.Controller.CuentaControlador;
import org.davshaw.Controller.DepositoCuentaControlador;
import org.davshaw.Controller.UsuarioControlador;
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
		
		//UsuarioControlador.crearUsuario(123, "Juan", "David", "Carrilo", "Torres", "Kibaw3f");
		//UsuarioControlador.crearUsuario(456, "Santiago", "", "Carrillo", "Torres", "Kasf3wfSA");
		//DepositoCuentaControlador.hacerDeposito(123, 1650);
		DepositoCuentaControlador.eliminarDeposito(52);

	}
}
