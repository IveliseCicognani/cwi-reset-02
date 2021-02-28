package br.com.cwi.reset.exemploreset;

import javax.xml.ws.Service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Application {

	@Autowired
	private NomeController nomeController;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
