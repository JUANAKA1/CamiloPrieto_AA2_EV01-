package com.tcna.primeraweb;


import com.tcna.primeraweb.service.UsuarioService;
import com.tcna.primeraweb.service.ZapatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PriemeraWebSpringBootApplication {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ZapatoService zapatoService;

	public static void main(String[] args) {
		SpringApplication.run(PriemeraWebSpringBootApplication.class, args);
	}

}















