package one.digitalinnovation.padroesprojetodesafio.controller;

import one.digitalinnovation.padroesprojetodesafio.model.Client;
import one.digitalinnovation.padroesprojetodesafio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, sendo qua abstrai toda a complexidade de
 * integrações (Banco de Dados H2 e API do ViaCEP) em uma interface simples e coesa (API REST).
 *
 * @author DanielVisicatto
 */

@RequestMapping("clients")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> getAll(){
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping
    public ResponseEntity<Client> putClient(@RequestBody Client client){
        clientService.putClient(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping
    public ResponseEntity<Client> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

}
