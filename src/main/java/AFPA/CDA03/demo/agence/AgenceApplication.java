package AFPA.CDA03.demo.agence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*L’annotation @SpringBootApplication est importante :
- elle est équivalente à @Configuration, @EnableAutoConfiguration et @ComponentScan
- elle permet de configurer automatiquement Spring et de scanner automatiquement le projet 
 afin de découvrir des composants Spring (Controller, Bean, Service, etc.).
- ceci exige que ces différents composants soient dans le même package
 que notre classe de démarrage VoyagesApplication
*/

@SpringBootApplication
public class AgenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceApplication.class, args);
	}

}
