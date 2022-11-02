package one.digitalinnovation.padroesprojetodesafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Projeto SSpringBoot gerado via Spring Initializr.
 * Os seguintes módulos foram selecionados
 * - Spring Data JPA
 * - Spring Web
 * - H2  Database
 * - OpenFeign
 * -Lombok

 * - OpenAPI Swagger adicionado manualmente.
 * @author DanielVisicatto
 *
 */

@EnableFeignClients
@SpringBootApplication
public class PadroesProjetoDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoDesafioApplication.class, args);
	}

}
