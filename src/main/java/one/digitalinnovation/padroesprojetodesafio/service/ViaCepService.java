package one.digitalinnovation.padroesprojetodesafio.service;

import one.digitalinnovation.padroesprojetodesafio.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Client HTTP criado via <b>OpenFeign</b>, para o consumo da API do <b>ViaCEP</b>.
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Clould OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author DanielVisicatto
 */

@FeignClient(name = "viacep", url = "https://viacep.com")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Address searchZipCode(@PathVariable("zipCode") String zipCode);
}
