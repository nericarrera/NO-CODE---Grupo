package com.nocountry.conversafe;

import com.nocountry.conversafe.services.GenerateText;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConversafeApplication {

	public static void main(String[] args) {
		GenerateText generateText = new GenerateText();

		Scanner teclado = new Scanner(System.in);

		System.out.println("Escribe algo: ");

		var texto = teclado.nextLine();

		generateText.pregunta(texto);
	}

}
