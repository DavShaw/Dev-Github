package org.davshaw.Davank;

import org.davshaw.Controller.CuentaControlador;
import org.davshaw.Controller.DepositoCuentaControlador;
import org.davshaw.Controller.RetiroCuentaControlador;
import org.davshaw.Controller.UsuarioControlador;
import org.davshaw.Model.derivatedentities.RetiroCuenta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DavankApplication
{

		public static final String RESET = "\u001B[0m";
		public static final String RED = "\u001B[31m";
		public static final String GREEN = "\u001B[32m";
		public static final String YELLOW = "\u001B[33m";
		public static final String BLUE = "\u001B[34m";
		public static final String PURPLE = "\u001B[35m";
		public static final String CYAN = "\u001B[36m";
		public static final String WHITE = "\u001B[37m";

		// Códigos de escape ANSI para colores de fondo
		public static final String BG_RED = "\u001B[41m";
		public static final String BG_GREEN = "\u001B[42m";
		public static final String BG_YELLOW = "\u001B[43m";
		public static final String BG_BLUE = "\u001B[44m";
		public static final String BG_PURPLE = "\u001B[45m";
		public static final String BG_CYAN = "\u001B[46m";
		public static final String BG_WHITE = "\u001B[47m";
	public static void main(String[] args)
	{
		SpringApplication.run(DavankApplication.class, args);
		
		//UsuarioControlador.crearUsuario(123, "Juan", "David", "Carrilo", "Torres", "Kibaw3f");
		//UsuarioControlador.crearUsuario(456, "Santiago", "", "Carrillo", "Torres", "Kasf3wfSA");
		//DepositoCuentaControlador.hacerDeposito(123, 1650);
		//DepositoCuentaControlador.hacerDeposito(456, 520);
		//RetiroCuentaControlador.hacerRetiro(123, 500);
		//RetiroCuentaControlador.eliminarRetiro(1);
	}
}