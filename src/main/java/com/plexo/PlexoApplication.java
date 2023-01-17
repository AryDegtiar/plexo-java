package com.plexo;

import com.plexo.actores.Administrador;
import com.plexo.repositorios.RepositorioAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class PlexoApplication {

	@Autowired
	RepositorioAdministrador repositorioAdministrador;

	public static void main(String[] args) {
		SpringApplication.run(PlexoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			if (args.length > 0) {
				System.out.println(args[0]);
			}

			//repositorioAdministrador.save( new Administrador("adminCompasso","Comp@ssoCompostela") );

			Administrador administrador =  new Administrador("admin","123");
			repositorioAdministrador.save(administrador);


		};
	}

}
